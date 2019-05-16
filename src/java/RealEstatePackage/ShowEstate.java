package RealEstatePackage;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@RequestScoped
public class ShowEstate implements Serializable {

    @ManagedProperty(value="#{database}")
    private Database database;

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }
    private String estateId;
    private String userId;
    
    
    public void showEstate(ActionEvent event){
        estateId =  (String) event.getComponent().getAttributes().get("estateId");
        userId = (String) event.getComponent().getAttributes().get("userId");
        String estateType = (String) event.getComponent().getAttributes().get("estateType");
        
        database.singleQuery("SELECT * FROM USERS WHERE ID = " + userId);
        database.singleQuery("SELECT * FROM ESTATES_" + estateType + " WHERE ID = " + estateId);
                
    }

    public String getEstateId() {
        return estateId;
    }

    public String getUserId() {
        return userId;
    }


}
