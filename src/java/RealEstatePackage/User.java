package RealEstatePackage;

import java.io.Serializable;



public class User implements Serializable{
    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String telephone;

    public User(String id, String email, String password, String firstName, String lastName, String telephone) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelephone() {
        return telephone;
    }
    
    
    
    
}
