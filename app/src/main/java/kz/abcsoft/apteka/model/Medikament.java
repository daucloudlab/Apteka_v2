package kz.abcsoft.apteka.model;

public class Medikament {
    private int mid ;
    private int aid ; // apteka id
    private int cid ; // category id
    private String title ;
    private String description ;
    private double price ;

    public Medikament(){}

    public Medikament(int mid, int aid, int cid, String title, String description, double price){
        this.mid = mid ;
        this.cid = cid ;
        this.aid = aid ;
        this.title = title ;
        this.description = description ;
        this.price = price ;
    }

    public int getMid(){
        return mid ;
    }

    public int getAid(){
        return aid ;
    }

    public int getCid(){
        return cid ;
    }

    public String getTitle(){
        return title ;
    }

    public void setTitle(String title){
        this.title = title ;
    }

    public String getDescription(){
        return description ;
    }

    public void setDescription(String description){
        this.description = description ;
    }

    public double getPrice(){
        return price ;
    }

    public void setPrice(double price){
        this.price = price ;
    }
}
