package ie.atu.userinterface.Motherboard;

import ie.atu.userinterface.CompatibilityRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "Motherboard", url = "http://localhost:8081")
public interface MotherboardClient {
    @PostMapping("/motherboards")
    List<Motherboard> getMotherboards(@RequestBody(required = false) CompatibilityRequest compatibilityRequest);
}
