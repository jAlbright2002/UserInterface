package ie.atu.userinterface.RAM;

import ie.atu.userinterface.Compatibility.CompatibilityRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "RAM", url = "${feign.url2}")
public interface RAMClient {
    @PostMapping("/rams")
    List<RAM> getRams(@RequestBody(required = false) CompatibilityRequest compatibilityRequest);
}
