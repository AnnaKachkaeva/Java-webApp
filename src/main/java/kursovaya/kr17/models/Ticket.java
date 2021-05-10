package kursovaya.kr17.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String townA, townB, image;
    private Integer cost;


    public Ticket() {
    }

    public Ticket(String townA, String townB, Integer cost, String image) {
        this.townA = townA;
        this.townB = townB;
        this.image = image;
        this.cost = cost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTownA() {
        return townA;
    }

    public void setTownA(String townA) {
        this.townA = townA;
    }

    public String getTownB() {
        return townB;
    }

    public void setTownB(String townB) {
        this.townB = townB;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
