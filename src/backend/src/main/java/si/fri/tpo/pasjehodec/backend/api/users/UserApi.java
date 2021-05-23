package si.fri.tpo.pasjehodec.backend.api.users;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.dtos.mappers.UserEntityMapper;
import si.fri.tpo.pasjehodec.backend.dtos.models.user.UserDto;
import si.fri.tpo.pasjehodec.backend.services.UserServices;

import javax.transaction.Transactional;
import java.util.Arrays;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserApi {
    private final UserServices userServices;
    private final UserEntityMapper userEntityMapper;

    @GetMapping("/me")
    @Operation(
            summary = "Get information about currently logged in user"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Information about user",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    }
            )
    })
    public ResponseEntity<UserDto> getInfoAboutLoggedInUser(@Parameter(hidden = true) @AuthenticationPrincipal UserEntity userEntity) {
        return ResponseEntity.ok(userEntityMapper.mapUserDtoFromEntity(userEntity));
    }

    @GetMapping("/get-all")
//    @Secured({"ADMIN"})
    public ResponseEntity<UserDto[]> getUsers() {
        return ResponseEntity.ok(
                Arrays.stream(userServices.usersOverview())
                        .map(userEntityMapper::mapUserDtoFromEntity)
                        .toArray(UserDto[]::new)
        );
    }


    @PutMapping("/put")
    public ResponseEntity<UserDto> putUser(@RequestBody UserDto user, @AuthenticationPrincipal UserEntity userEntity) {
        var entity = userEntityMapper.mapUserEntityFromDto(user);

        if(entity.getPassword() == null)
            entity.setPassword(userEntity.getPassword());

        return ResponseEntity.ok(
                userEntityMapper.mapUserDtoFromEntity(userServices.saveData(entity))
        );
    }
}
