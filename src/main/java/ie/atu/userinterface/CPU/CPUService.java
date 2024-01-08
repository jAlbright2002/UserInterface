package ie.atu.userinterface.CPU;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CPUService {

    private final CPUHardwareClient cpuHardwareClient;

    public CPUService(CPUHardwareClient cpuHardwareClient) {
        this.cpuHardwareClient = cpuHardwareClient;
    }


    // GET METHODS
    public List<CPU> getCPU(String name, String brand, Float price) {
        return cpuHardwareClient.getCPUs(name, brand, price).getBody();
    }

    public List<CPU> getCPUById(Long id) {
        return cpuHardwareClient.getCPUById(id).getBody();
    }

    // POST METHODS
    public void saveCPU(CPU cpu) {
        cpuHardwareClient.saveCPU(cpu);
    }

    // DELETE METHODS
    public void deleteCPU(Long id) {
        cpuHardwareClient.deleteCPU(id);
    }

    public void editCPU(Long id) {cpuHardwareClient.editCPU(id);}

}
