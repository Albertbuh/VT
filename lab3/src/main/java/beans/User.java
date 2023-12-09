package org.education.beans;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

/**
 * @author nstah
 * @version 0.5
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    private String username;
    private String login;
    private String token;
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role = Role.ROLE_USER;

}

