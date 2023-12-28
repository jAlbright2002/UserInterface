package ie.atu.userinterface.RAM;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "RAMHardware", url = "http://localhost:8080")
public interface RAMHardwareClient {
    @GetMapping("/rams")
    ResponseEntity<List<RAM>> getRamById(@RequestParam("id") Long id);

}
