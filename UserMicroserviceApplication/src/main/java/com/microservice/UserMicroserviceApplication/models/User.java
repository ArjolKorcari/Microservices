package com.microservice.UserMicroserviceApplication.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")  // 👈 Change table name to avoid conflicts

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String surname;

    @Column(unique = true, nullable = false)  // Ensures email is unique and cannot be null
    private String email;

    private String password;



    public User(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password=password;
    }
}
