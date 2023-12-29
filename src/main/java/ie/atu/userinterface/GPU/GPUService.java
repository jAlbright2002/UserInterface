package ie.atu.userinterface.GPU;

import ie.atu.userinterface.CPU.CPU;
import ie.atu.userinterface.CompatibilityRequest;
import ie.atu.userinterface.RAM.RAM;
import ie.atu.userinterface.RAM.RAMClient;
import ie.atu.userinterface.RAM.RAMHardwareClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
