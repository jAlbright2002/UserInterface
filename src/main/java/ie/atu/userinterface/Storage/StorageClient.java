package ie.atu.userinterface.Storage;

import ie.atu.userinterface.Compatibility.CompatibilityRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="Storage", url="http://localhost:8081")
public interface StorageClient {
    @PostMapping("/storages")
    List<Storage> getStorages(@RequestBody(required = false) CompatibilityRequest compatibilityRequest);
}
