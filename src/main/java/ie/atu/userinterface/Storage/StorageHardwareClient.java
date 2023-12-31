package ie.atu.userinterface.Storage;

import ie.atu.userinterface.Motherboard.Motherboard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="StorageHardware", url="http://localhost:8080")
public interface StorageHardwareClient {
    @GetMapping("/storages")
    ResponseEntity<List<Storage>> getStorageById(@RequestParam("id") Long id);
}
