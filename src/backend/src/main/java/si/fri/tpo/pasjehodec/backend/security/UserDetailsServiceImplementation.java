package si.fri.tpo.pasjehodec.backend.security;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import si.fri.tpo.pasjehodec.backend.database.repositories.UserRepository;
import si.fri.tpo.pasjehodec.backend.exceptions.ForbiddenOperationException;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImplementation implements UserDetailsService {

    private final UserRepository userRepository;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByEmail(s)
                .orElseThrow(() -> new ForbiddenOperationException("Uporabnik s podanim epoštnim naslovom ne obstaja."));
    }
}
