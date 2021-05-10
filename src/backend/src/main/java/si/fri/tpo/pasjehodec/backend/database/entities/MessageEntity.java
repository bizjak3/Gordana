package si.fri.tpo.pasjehodec.backend.database.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="message")
@Getter
@Setter
@NoArgsConstructor
public class MessageEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String text;
    private LocalDateTime created;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private UserEntity sender;
}
