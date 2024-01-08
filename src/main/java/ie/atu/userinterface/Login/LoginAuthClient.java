package ie.atu.userinterface.Login;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="authentication", url="http://localhost:8082")
public interface LoginAuthClient {

    @PostMapping("/login")
    ResponseEntity<String> authenticate(@RequestBody User user);
}
