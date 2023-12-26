package ie.atu.userinterface;

import ie.atu.userinterface.Hardware.CPU;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public CPU getCPUById(Long id) {
        CPU cpu = (CPU) hardwareClientNew.getCPUById(id).getBody();
        return  cpu;
    }

    public void deleteCPU(Long id) {hardwareClientNew.deleteCPU(id);}
}
