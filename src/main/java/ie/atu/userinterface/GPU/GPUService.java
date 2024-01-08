package ie.atu.userinterface.GPU;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GPUService {
    private final GPUHardwareClient gpuHardwareClient;

    public GPUService(GPUHardwareClient gpuHardwareClient) {
        this.gpuHardwareClient = gpuHardwareClient;
    }

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


//    POST METHODS

//    DELETE METHODS


//    PUT METHODS
}
