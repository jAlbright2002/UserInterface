package ie.atu.userinterface.Hardware;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MotherboardHardware", url = "http://localhost:8080")
public interface MotherboardHardwareClient {
    @GetMapping("/motherboards/{id}")
    ResponseEntity<Motherboard> getMotherboardById(@PathVariable("id") Long id);

}
