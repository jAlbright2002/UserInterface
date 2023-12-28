package ie.atu.userinterface.CPU;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CPUService {
    private final CPUClient cpuClient;

    public CPUService(CPUClient cpuClient) {
        this.cpuClient = cpuClient;
    }


    // GET METHODS
    public List<CPU> getCPU(String name, String brand, Float price) {
        List<CPU> CPUs = cpuClient.getCPUs(name, brand, price);
        return CPUs;
    }

    public CPU getCPUById(Long id) {
        return cpuClient.getCPUById(id).getBody();
    }

    // POST METHODS
    public ResponseEntity<String> saveCPU(CPU cpu) {
        return cpuClient.saveCPU(cpu);
    }

    // DELETE METHODS
    public void deleteCPU(Long id) {
        cpuClient.deleteCPU(id);
    }

}
