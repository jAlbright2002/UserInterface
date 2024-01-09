package ie.atu.userinterface.GPU;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GPU {
    private Long id;

    private String name;
    private Float price;
    private String brand;
    private Float vram;
    private String ebaylink;
}