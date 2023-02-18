package com.onlineshop.shopstore.domain;


import com.onlineshop.shopstore.annotations.FieldsValueMatch;
import com.onlineshop.shopstore.annotations.PasswordValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldsValueMatch.List({
        @FieldsValueMatch(field = "pwd", fieldMatch = "confirmPwd", message = "Passwords do not match!"),
        @FieldsValueMatch(field = "email", fieldMatch = "confirmEmail", message = "Email addresses do not match!")
})
public class User extends BaseEntity{


    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String name;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please provide a valid email address")
    @Transient
    private String confirmEmail;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 5, message = "Password must be at least 5 characters long")
    @PasswordValidator
    private String password;

    @NotBlank(message = "Confirm Password must not be blank")
    @Size(min = 5, message = "Confirm Password must be at least 5 characters long")
    @Transient
    private String confirmPassword;

    private String address;

    @NotBlank(message = "Mobile number must not be blank")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be at least 3 characters long")
    private String phone;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, targetEntity = Roles.class)
    @JoinColumn(name = "role_id", nullable = false, referencedColumnName = "id")
    private Roles roles;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders;
}
