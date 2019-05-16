package RealEstatePackage;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;


@ManagedBean
@SessionScoped
public class Users implements Serializable {

    private String enteredEmail;
    private String enteredPassword;
    private Boolean loggedIn = false;
    private Boolean error = false;
    private Boolean registerError = false;
    
    private String registerEmail;
    private String registerFirstName;
    private String registerLastName;
    private String registerTelephone;
    private String registerPassword;
    
    private User currentUser;
    
    
    @ManagedProperty(value="#{database}")
    private Database database;

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }
    
    public String login(){
        database.query("SELECT * FROM MANAGERS");
        for(User user : database.getManagers()){
            if (user.getEmail().equals(this.enteredEmail) && user.getPassword().equals(this.enteredPassword)){
                this.currentUser = user;
                loggedIn = true;
                error = false;
                return "manage";
            }
	}
        database.query("SELECT * FROM USERS");
        for(User user : database.getUsers()){
            if (user.getEmail().equals(this.enteredEmail) && user.getPassword().equals(this.enteredPassword)){
                this.currentUser = user;
                loggedIn = true;
                error = false;
                return "index";
            }
	}
        this.error = true;
        return "login";
    }
    
    public void logout(ActionEvent event){
        this.loggedIn = false;
    }
    
    public String register(){
        database.query("SELECT * FROM USERS");
        for(User user : database.getUsers()){
            if (user.getEmail().equals(this.registerEmail)){
                registerError = true;
                return "register";
            }
	}
        
        registerError = false;
        
        String query = "INSERT INTO USERS (EMAIL,PASSWORD,FIRSTNAME,LASTNAME,TELEPHONE) VALUES ("
            + "'" + this.registerEmail + "',"
            + "'" + this.registerPassword + "',"
            + "'" + this.registerFirstName + "',"
            + "'" + this.registerLastName + "',"
            + "'" + this.registerTelephone + "')";
        
        database.query(query);
        
        return "index";
    }
    
    

    public String getEnteredEmail() {
        return enteredEmail;
    }

    public void setEnteredEmail(String enteredEmail) {
        this.enteredEmail = enteredEmail;
    }

    public String getEnteredPassword() {
        return enteredPassword;
    }

    public void setEnteredPassword(String enteredPassword) {
        this.enteredPassword = enteredPassword;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getRegisterEmail() {
        return registerEmail;
    }

    public void setRegisterEmail(String registerEmail) {
        this.registerEmail = registerEmail;
    }

    public String getRegisterFirstName() {
        return registerFirstName;
    }

    public void setRegisterFirstName(String registerFirstName) {
        this.registerFirstName = registerFirstName;
    }

    public String getRegisterLastName() {
        return registerLastName;
    }

    public void setRegisterLastName(String registerLastName) {
        this.registerLastName = registerLastName;
    }

    public String getRegisterTelephone() {
        return registerTelephone;
    }

    public void setRegisterTelephone(String registerTelephone) {
        this.registerTelephone = registerTelephone;
    }

    public String getRegisterPassword() {
        return registerPassword;
    }

    public void setRegisterPassword(String registerPassword) {
        this.registerPassword = registerPassword;
    }

    public Boolean getRegisterError() {
        return registerError;
    }
    
    
    
    


}
