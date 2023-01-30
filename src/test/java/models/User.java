package models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class User {
    private String name;
    private String lastName;
    private String zipCode;
    private String username;
    private String password;
}