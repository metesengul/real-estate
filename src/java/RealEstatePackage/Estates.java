package RealEstatePackage;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;


@ManagedBean
@SessionScoped
public class Estates implements Serializable {

    
    @ManagedProperty(value="#{database}")
    private Database database;

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }
        
    private String filterLocation;
    private String filterSize;
    private String filterAge;
    private String[] filterFeatures;
    private String filterOrderBy;
    private String filterSaleType;
    private String filterType;
    
    private String fromNavigation;
    
    private String query;

    public String getQuery() {
        return query;
    }
    
    public void search(ActionEvent event){
        
        this.fromNavigation = (String) event.getComponent().getAttributes().get("fromNavigation");
        
        if(fromNavigation.equals("true")){
            this.filterType = (String) event.getComponent().getAttributes().get("filterType");
            this.filterSaleType = (String) event.getComponent().getAttributes().get("filterSaleType");
            query = "SELECT * FROM ESTATES_" + filterType + " WHERE SALETYPE = '" + filterSaleType + "' AND TYPE = '" + filterType + "'";
            database.query(query);
        }
        else{
            String featureSelection = " AND ";
            if (filterFeatures.length == 0){
                featureSelection = "";
            }
            for(int i = 0; i < filterFeatures.length; i++){
                featureSelection = featureSelection + " FEATURES LIKE '%" + filterFeatures[i] + "%'";
                if(i != filterFeatures.length - 1){
                    featureSelection = featureSelection + " AND";
                }
            }

            query = 
                "SELECT * FROM ESTATES_" + filterType + " WHERE" +
                " LOCATION = '" + filterLocation + "'" +
                " AND AGE BETWEEN " + filterAge.split(" - ")[0] + " AND " + filterAge.split(" - ")[1] +
                " AND SIZE BETWEEN " + filterSize.split(" - ")[0] + " AND " + filterSize.split(" - ")[1] +
                featureSelection + 
                " AND SALETYPE = '" + filterSaleType + "'" +
                " AND TYPE = '" + filterType + "'" +
                " ORDER BY " + filterOrderBy;

            database.query(query);
        }
    }

    public void setFilterLocation(String filterLocation) {
        this.filterLocation = filterLocation;
    }

    public void setFilterSize(String filterSize) {
        this.filterSize = filterSize;
    }

    public void setFilterAge(String filterAge) {
        this.filterAge = filterAge;
    }

    public void setFilterFeatures(String[] filterFeatures) {
        this.filterFeatures = filterFeatures;
    }

    public void setFilterOrderBy(String filterOrderBy) {
        this.filterOrderBy = filterOrderBy;
    }

    public String getFilterLocation() {
        return filterLocation;
    }

    public String getFilterSize() {
        return filterSize;
    }

    public String getFilterAge() {
        return filterAge;
    }

    public String[] getFilterFeatures() {
        return filterFeatures;
    }

    public String getFilterOrderBy() {
        return filterOrderBy;
    }

    public String getFilterSaleType() {
        return filterSaleType;
    }

    public void setFilterSaleType(String filterSaleType) {
        this.filterSaleType = filterSaleType;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

}
