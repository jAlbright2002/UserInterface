package ie.atu.userinterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HardwareService {

    private final HardwareClient hardwareClient;

    @Autowired
    public HardwareService(HardwareClient hardwareClient) {
        this.hardwareClient = hardwareClient;
    }

    public void addCPU(CPU cpu) {
        String response = hardwareClient.addCpu(cpu);
        System.out.println("Works: " + response);
    }

}
