package models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerBuilder {
    private  int id;
    private String lastname;
    private String firstname;
    private String email;
    private int age;

}
