package com.example.exerciserepository.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should be not Empty")
    @Min(4)
    private String name;
    @NotEmpty(message = "username should be not Empty")
    @Min(4)
    @Column(columnDefinition = "varchar(20) not null unique ")
    private String username;
    @NotNull(message = "password should be not null ")
    private Integer password;
    @NotEmpty(message = "Email should be not Empty")
    @Email
    @Column(columnDefinition = "varchar(15) not null unique ")
    private String email;
    @NotEmpty(message = "Role should be not Empty")
    @Column(columnDefinition = "varchar(5) not null check('user' or 'admin') ")
    private String  role;
    @NotNull(message = "Age should be not null")
//    @Column(columnDefinition = "int not null check('age'>=0)")
    private Integer age;
}