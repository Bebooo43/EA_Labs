package lab2;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="MY_BOOK")
@NoArgsConstructor @Getter @Setter
@ToString
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "BOOK_ID")
    private int id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "ISBN")
    private String ISBN;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "PRICE")
    private double price;
    @Column(name = "PUBLISH_DATE")
    private Date publish_date;

    public Book(String title, String ISBN, String author,  double price, Date publish_date){
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.price = price;
        this.publish_date = publish_date;
    }

}