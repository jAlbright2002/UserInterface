package ie.atu.userinterface.Storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Storage {
    private Long id;

    private String name;
    private Float price;
    private Integer capacity;
    private String brand;
    private String storageType;
    private String ebaylink;
}