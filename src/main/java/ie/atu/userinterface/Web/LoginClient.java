package ie.atu.userinterface.Web;

import ie.atu.userinterface.Admin.Admin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Web", url = "http://localhost:8082")
public interface LoginClient {
    @PostMapping("/login")
    ResponseEntity<String> login(@RequestBody Admin admin);
}
