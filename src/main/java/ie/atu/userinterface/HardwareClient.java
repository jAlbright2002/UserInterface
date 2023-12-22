package ie.atu.userinterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name="hardware", url="http://localhost:8081/hardware/")
public interface HardwareClient {

    @PostMapping("/cpus")
    String addCpu(CPU cpu);

    @GetMapping("/cpus")
    List<CPU> getCpus();
}
