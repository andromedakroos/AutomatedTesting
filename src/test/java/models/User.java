package models;

import java.util.function.BiConsumer;

public class User {
    private String name;
    private String lastName;
    private String zipCode;
    private String username;
    private String password;

    public static class Builder{
        private User newUser;

        public Builder(){
            newUser = new User();
        }

        public Builder withName(String value){
            newUser.name = value;
            return this;
        }
        public Builder withLastName(String value){
            newUser.lastName = value;
            return this;
        }
        public Builder withZipCode(String value){
            newUser.zipCode = value;
            return this;
        }
        public Builder withUsername(String value){
            newUser.username = value;
            return this;
        }
        public Builder withPassword(String value){
            newUser.password = value;
            return this;
        }
        public User build(){
            return newUser;
        }
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
