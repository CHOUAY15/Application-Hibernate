package ensaj.business;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_Articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArticle;

    private String description;
    private String brand;

    @Column(name = "UnitaryPrice")
    private double price;

    public Article() {
        this("unknown", "unknown", 0.0);
    }

    public Article(String description, String brand, double price) {
        this.description = description;
        this.brand = brand;
        this.price = price;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Article {" +
               "idArticle=" + idArticle +
               ", description='" + description + '\'' +
               ", brand='" + brand + '\'' +
               ", price=" + price +
               '}';
    }
}