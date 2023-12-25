package ie.atu.userinterface;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ComponentDisplay {
    private List<String> header;
    private List<?> components;
}
