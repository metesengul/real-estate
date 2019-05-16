package RealEstatePackage;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@ManagedBean
@SessionScoped
public class Database implements Serializable {
    
    private Estate estate;
    private List<Estate> estates;
    private User user;
    private List<User> users;
    private List<User> managers;

    DataSource dataSource;

    @PostConstruct
    public void init() {
        
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource)ctx.lookup("jdbc/sample");
        } 
        catch (NamingException e) {
            e.printStackTrace();
            return;
        }        
    }
    
    public void query(String q){
        
        try{
            Connection connection = dataSource.getConnection();
             
            if (q.contains("SELECT * FROM ESTATES")){
                
                PreparedStatement ps = connection.prepareStatement(q); 
                ResultSet result =  ps.executeQuery();

                estates = new ArrayList<Estate>();


                while(result.next()){
                    Estate newEstate = new Estate(
                        result.getString("ID"),
                        result.getString("TITLE"),
                        result.getString("LOCATION"),
                        result.getString("FEATURES"),
                        result.getString("AGE"),
                        result.getString("SIZE"),
                        result.getString("IMAGE"),
                        result.getString("PRICE"),
                        result.getString("USERID"),
                        result.getString("SALETYPE"),
                        result.getString("TYPE")
                    );
                    estates.add(newEstate);
                }
                
                connection.close();
            }
            
            else if (q.contains("SELECT * FROM USERS")){
                
                PreparedStatement ps = connection.prepareStatement(q); 
                ResultSet result =  ps.executeQuery();

                users = new ArrayList<User>();

                
                while(result.next()){
                    User newUser = new User(
                        result.getString("ID"),
                        result.getString("EMAIL"),
                        result.getString("PASSWORD"),
                        result.getString("FIRSTNAME"),
                        result.getString("LASTNAME"),
                        result.getString("TELEPHONE")
                    );
                    users.add(newUser);
                }
                
                connection.close();
            }
            
            else if (q.contains("SELECT * FROM MANAGERS")){
                
                PreparedStatement ps = connection.prepareStatement(q); 
                ResultSet result =  ps.executeQuery();

                managers = new ArrayList<User>();

                
                while(result.next()){
                    User newUser = new User(
                        result.getString("ID"),
                        result.getString("EMAIL"),
                        result.getString("PASSWORD"),
                        result.getString("FIRSTNAME"),
                        result.getString("LASTNAME"),
                        result.getString("TELEPHONE")
                    );
                    managers.add(newUser);
                }
                
                connection.close();
            }
            
            else{
                PreparedStatement ps = connection.prepareStatement(q); 
                ps.executeUpdate();
            }
            
        }
        
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public List<Estate> getEstates() {
        return estates;
    }

    public void setEstates(List<Estate> estates) {
        this.estates = estates;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    public void singleQuery(String q){
        
        try{
            Connection connection = dataSource.getConnection();
             
            if (q.contains("SELECT * FROM ESTATES")){
                
                PreparedStatement ps = connection.prepareStatement(q); 
                ResultSet result =  ps.executeQuery();

                while(result.next()){
                    Estate newEstate = new Estate(
                        result.getString("ID"),
                        result.getString("TITLE"),
                        result.getString("LOCATION"),
                        result.getString("FEATURES"),
                        result.getString("AGE"),
                        result.getString("SIZE"),
                        result.getString("IMAGE"),
                        result.getString("PRICE"),
                        result.getString("USERID"),
                        result.getString("SALETYPE"),
                        result.getString("TYPE")
                    );
                    this.estate = newEstate;
                }
                
                connection.close();
            }
            
            else if (q.contains("SELECT * FROM USERS")){
                
                PreparedStatement ps = connection.prepareStatement(q); 
                ResultSet result =  ps.executeQuery();

                users = new ArrayList<User>();


                while(result.next()){
                    User newUser = new User(
                        result.getString("ID"),
                        result.getString("EMAIL"),
                        result.getString("PASSWORD"),
                        result.getString("FIRSTNAME"),
                        result.getString("LASTNAME"),
                        result.getString("TELEPHONE")
                    );
                   this.user = newUser;
                }
                
                connection.close();
            }
            
            
        }
        
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getManagers() {
        return managers;
    }

    public void setManagers(List<User> managers) {
        this.managers = managers;
    }
    
    
    
    
}
