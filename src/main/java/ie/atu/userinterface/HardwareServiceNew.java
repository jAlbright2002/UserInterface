package ie.atu.userinterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HardwareServiceNew {

    private final HardwareClientNew hardwareClientNew;

    public HardwareServiceNew(HardwareClientNew hardwareClientNew) {
        this.hardwareClientNew = hardwareClientNew;
    }

    // Communicates with the other service through the Client interface
    public CPU saveCPU(CPU cpu) {
        return hardwareClientNew.saveCPU(cpu);
    }

    public List<CPU> getCPU(String name, String brand, Float price) {
        List<CPU> CPUs = hardwareClientNew.getCPUs(name, brand, price);
        return CPUs;
    }

}
