package models;

public class UserGUI {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class Builder{
        private UserGUI newUser;

        public Builder(){
            newUser = new UserGUI();
        }

        public Builder withEmail(String value){
            newUser.email = value;
            return this;
        }
        public Builder withFirstName(String value){
            newUser.firstName = value;
            return this;
        }
        public Builder withLastName(String value){
            newUser.lastName = value;
            return this;
        }
        public Builder withPassword(String value){
            newUser.password = value;
            return this;
        }

        public UserGUI build(){
            return newUser;
        }


    }
}
