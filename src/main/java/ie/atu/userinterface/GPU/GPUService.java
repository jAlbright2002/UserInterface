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
    List<GPU> getGPUs() {
        return gpuHardwareClient.getGPUs().getBody();
    }

    public List<GPU> getGpuById(Long id) {
        return gpuHardwareClient.getGPUById(id).getBody();
    }


//    POST METHODS

//    DELETE METHODS


//    PUT METHODS
}
