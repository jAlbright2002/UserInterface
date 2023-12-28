package ie.atu.userinterface.Motherboard;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "MotherboardHardware", url = "http://localhost:8080")
public interface MotherboardHardwareClient {
    @GetMapping("/motherboards")
    ResponseEntity<List<Motherboard>> getMotherboardById(@RequestParam("id") Long id);

}
