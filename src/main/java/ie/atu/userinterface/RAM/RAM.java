package ie.atu.userinterface.RAM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RAM {
    private Long id;

    private String name;
    private Float price;
    private Integer capacity;
    private String ramtype;
    private String ebaylink;
}