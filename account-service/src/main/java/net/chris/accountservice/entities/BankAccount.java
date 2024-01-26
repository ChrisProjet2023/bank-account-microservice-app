package net.chris.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.chris.accountservice.enums.AccountType;
import net.chris.accountservice.model.Customer;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Transient //ignorer cet attribut , n'est pas représenté au niveau de base de données
    private Customer customer;
    //relation entre les 2 microservices
    private Long customerId;
}
