package ie.atu.userinterface.CPU;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CPU {
    private Long id;
    private String name;
    private float price;
    private String socket;
    private String frequency;
    private String brand;
    private List<String> compatibleRAMTypes;
    private String ebaylink;
}
