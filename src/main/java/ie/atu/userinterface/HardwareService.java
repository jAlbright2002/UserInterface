package ie.atu.userinterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> getCpus() {
        List<CPU> cpus = hardwareClient.getCpus();

        // Extract CPU names
        List<String> cpuNames = cpus.stream()
                .map(CPU::getName)
                .collect(Collectors.toList());

        return cpuNames;
    }

}
