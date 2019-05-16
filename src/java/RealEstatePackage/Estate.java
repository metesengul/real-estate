package RealEstatePackage;


import java.io.Serializable;


public class Estate implements Serializable {

    private String id;
    private String title;
    private String location;
    private String features;
    private String age;
    private String size;
    private String image;
    private String price;
    private String userId;
    private String saleType;
    private String type;
    

    public Estate(String  id, String title, String location, String features, String  age, String  size, String image, String  price, String userId, String saleType, String type) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.features = features;
        this.age = age;
        this.size = size;
        this.image = image;
        this.price = price;
        this.userId = userId;
        this.saleType = saleType;
        this.type = type;
    }
    
 

    public String  getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getFeatures() {
        return features;
    }

    public String  getAge() {
        return age;
    }

    public String  getSize() {
        return size;
    }

    public String getImage() {
        return image;
    }
    
    public String getPrice() {
        return price;
    }
    
    public String getUserId() {
        return userId;
    }

    public String getSaleType() {
        return saleType;
    }

    public String getType() {
        return type;
    }
    
    

}
