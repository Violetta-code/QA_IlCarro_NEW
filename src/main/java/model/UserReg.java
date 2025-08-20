package model;

public class UserReg {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserReg setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserReg setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserReg setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserReg setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
