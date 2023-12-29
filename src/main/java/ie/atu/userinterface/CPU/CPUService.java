package ie.atu.userinterface.CPU;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CPUService {
    private final CPUClient cpuClient;
    private final CPUHardwareClient cpuHardwareClient;

    public CPUService(CPUClient cpuClient, CPUHardwareClient cpuHardwareClient) {
        this.cpuClient = cpuClient;
        this.cpuHardwareClient = cpuHardwareClient;
    }


    // GET METHODS
    public List<CPU> getCPU(String name, String brand, Float price) {
        List<CPU> CPUs = cpuHardwareClient.getCPUs(name, brand, price).getBody();
        return CPUs;
    }

    public List<CPU> getCPUById(Long id) {
        return cpuHardwareClient.getCPUById(id).getBody();
    }

//    // POST METHODS
//    public ResponseEntity<String> saveCPU(CPU cpu) {
//        return cpuClient.saveCPU(cpu);
//    }
//
//    // DELETE METHODS
//    public void deleteCPU(Long id) {
//        cpuClient.deleteCPU(id);
//    }

}
