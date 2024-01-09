package ie.atu.userinterface.Motherboard;

import ie.atu.userinterface.Compatibility.CompatibilityRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "Motherboard", url = "${feign.url2}")
public interface MotherboardClient {
    @PostMapping("/motherboards")
    List<Motherboard> getMotherboards(@RequestBody(required = false) CompatibilityRequest compatibilityRequest);
}
