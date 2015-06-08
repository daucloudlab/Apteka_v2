package kz.abcsoft.apteka.model;


import java.util.ArrayList;

public class Apteka {
    private int id ;
    private String title ;
    private String phone ;
    private ArrayList<String> addresses ;

    public Apteka(){}

    public Apteka(int id, String title, String phone, ArrayList<String> addresses){
        this.id = id ;
        this.title = title ;
        this.phone = phone ;
        this.addresses = addresses ;
    }

    public int getId(){
        return id ;
    }

    public void setTitle(String title){
        this.title = title ;
    }

    public String getTitle(){
        return title ;
    }

    public void setPhone(String phone){
        this.phone = phone ;
    }

    public String getPhone(){
        return phone ;
    }

    public void setAddress(ArrayList<String> addresses) {
        this.addresses = addresses ;
    }

    public ArrayList<String> getAddresses(){
        return addresses ;
    }


}
