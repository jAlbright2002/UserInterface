package ie.atu.userinterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HardwareServiceNew {

    private final HardwareClientNew hardwareClientNew;

    public HardwareServiceNew(HardwareClientNew hardwareClientNew) {
        this.hardwareClientNew = hardwareClientNew;
    }

    // Communicates with the other service through the Client interface
    public ResponseEntity<String> saveCPU(CPU cpu) {
        return hardwareClientNew.saveCPU(cpu);
    }

    public List<CPU> getCPU(String name, String brand, Float price) {
        List<CPU> CPUs = hardwareClientNew.getCPUs(name, brand, price);
        return CPUs;
    }
    public void deleteCPU(Long id) {hardwareClientNew.deleteCPU(id);}


    public List<String> determineHeadersForComponent(String component) {
        List<String> headers = new ArrayList<>();

        if (component.equals("CPU")) {
            Field[] fields = CPU.class.getDeclaredFields();
            for (Field field : fields) {
                headers.add(field.getName());
            }
        }
        return headers;
    }

}