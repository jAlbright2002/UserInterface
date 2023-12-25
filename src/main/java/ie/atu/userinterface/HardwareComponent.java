package ie.atu.userinterface;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HardwareComponent {
    private String componentName;
    private Object component;
    private String urlSelect;
}
