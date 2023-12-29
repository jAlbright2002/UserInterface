package ie.atu.userinterface.GPU;

import ie.atu.userinterface.RAM.RAM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "GPUHardware", url = "http://localhost:8080")
public interface GPUHardwareClient {
    @GetMapping("/gpus")
    ResponseEntity<List<GPU>> getGPUById(@RequestParam("id") Long id);

    @GetMapping("/gpus")
    ResponseEntity<List<GPU>> getGPUs();
}
