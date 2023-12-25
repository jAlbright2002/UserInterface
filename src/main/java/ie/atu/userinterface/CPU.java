package ie.atu.userinterface;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class CPU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique Key

    private String name;
    private float price;
    private String socket;
    private String frequency;
    private String brand;
    private String ebaylink;

    public CPU(String name, float price, String socket, String frequency, String brand, String ebaylink) {
        this.name = name;
        this.price = price;
        this.socket = socket;
        this.frequency = frequency;
        this.brand = brand;
        this.ebaylink = ebaylink;
    }
}
