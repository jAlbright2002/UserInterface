package ie.atu.userinterface.GPU;

import ie.atu.userinterface.CPU.CPU;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GPUService {
    private final GPUHardwareClient gpuHardwareClient;

    public GPUService(GPUHardwareClient gpuHardwareClient) {
        this.gpuHardwareClient = gpuHardwareClient;
    }

    //    GET METHODS

    //    GET METHODS
    public List<GPU> getGPU(String name, String brand, Float price) {
        return gpuHardwareClient.getGPUs(name, brand, price).getBody();
    }

    List<GPU> getGPUs(String name, String brand, Float price) {
        return gpuHardwareClient.getGPUs(name, brand, price).getBody();
    }

    public List<GPU> getGpuById(Long id) {
        return gpuHardwareClient.getGPUById(id).getBody();
    }


    // POST METHODS
    public void saveGPU(GPU gpu) {
        gpuHardwareClient.saveGPU(gpu);
    }

    // DELETE METHODS
    public void deleteGPU(Long id) {
        gpuHardwareClient.deleteGPU(id);
    }

    public GPU editGPU(Long id, GPU gpu) {return gpuHardwareClient.editGPU(id, gpu).getBody();}
}
