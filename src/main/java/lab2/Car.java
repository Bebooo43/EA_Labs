package lab2;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "MY_CAR")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
    @Id
    @GeneratedValue
    @Column(name = "CAR_ID")
    private long id;
    @Column(name = "BRAND")
    private String brand;
    @Column(name = "YEAR")
    private int year;
    @Column(name = "PRICE")
    private double price;

    public Car(String brand, int year, double price) {
        this.brand = brand;
        this.year = year;
        this.price = price;
    }
}
