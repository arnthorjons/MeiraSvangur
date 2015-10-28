package project.model;

/**
 * Created by Arnthor on 6.10.2015.
 */
public class Restaurant {
    private String name;
    private String address;
    private Integer zip;
    private String city;
    private Integer id;
    private Double horizontal;
    private Double vertical;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAddress(String address){ this.address = address; }

    public String getAddress(){
        return address;
    }

    public void setZip(Integer zip){
        this.zip = zip;
    }

    public Integer getZip(){
        return zip;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getCity(){
        return city;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public  void setHorizontal(Double horizontal){
        this.horizontal = horizontal;
    }

    public Double getHorizontal(){
        return horizontal;
    }

    public void setVertical(Double vertical){
        this.vertical = vertical;
    }

    public Double getVertical(){
        return vertical;
    }
}
