package RealEstatePackage;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@RequestScoped
public class PostEstate implements Serializable {
    private String title;
    private String location;
    private String[] features;
    private String age;
    private String size;
    private String image;
    private String price;
    private String userId;
    private String saleType;
    private String type;
    
    private String query;

    public String getQuery() {
        return query;
    }
    
    @ManagedProperty(value="#{database}")
    private Database database;

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }
    
    
    @ManagedProperty(value="#{users}")
    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    
    public void postEstate(ActionEvent event){
        userId =  getUsers().getCurrentUser().getId();
        
        String featureString = "";
        for(int i = 0; i < features.length; i++){
            featureString = featureString + features[i];
            if(i != features.length - 1){
                featureString = featureString + ", ";
            }
        }
        
        query = "INSERT INTO ESTATES_" + type + " (TITLE,LOCATION,FEATURES,AGE,SIZE,IMAGE,PRICE,USERID,SALETYPE,TYPE) VALUES ("
                + "'" + title + "',"
                + "'" + location + "',"
                + "'" + featureString + "',"
                + "" + age + ","
                + "" + size + ","
                + "'" + image + "',"
                + "" + price + ","
                + "" + userId + ","
                + "'" + saleType + "',"
                + "'" + type + "')";
        
        database.query(query);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String[] getFeatures() {
        return features;
    }

    public void setFeatures(String[] features) {
        this.features = features;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
