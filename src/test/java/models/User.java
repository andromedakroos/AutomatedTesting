package models;

import lombok.*;

@Builder
@Getter
@ToString
@EqualsAndHashCode

public class User {
    private String name;
    private String lastName;
    private String email;
    private String zipCode;
    private String password;
    private String username;
}
