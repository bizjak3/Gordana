package si.fri.tpo.pasjehodec.backend.database.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="payment_type")
@Getter
@Setter
@NoArgsConstructor
public class PaymentTypeEntity {

    @Id
    @GeneratedValue
    private Integer id;

    String cardNumber;
    String cw;
    LocalDateTime expirationDate;
    boolean defaultPaymentType;

    @ManyToOne
    @JoinColumn
    private UserEntity cardOwner;
}
