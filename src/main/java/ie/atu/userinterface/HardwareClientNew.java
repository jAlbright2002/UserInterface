package ie.atu.userinterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name="hardware", url="http://localhost:8081/hardware")
public interface HardwareClientNew {
    // This communicates with other services and uses the methods below
    @PostMapping("/cpus")
    CPU saveCPU(CPU cpu);

    @GetMapping("/cpus")
    List<CPU> getCPUs(String name, String brand, Float price);

    //delete
    //put

    // We will add the same 4 functions for the other components
}
