package uz.hamkorbank.appschoolmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    private Role role;

    @OneToOne
    private Address address;

    @ManyToOne
    private School school;

    public User(String name, String email, Role role, Address address, School school) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.address = address;
        this.school = school;
    }
}
