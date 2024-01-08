package ie.atu.userinterface.Storage;

import ie.atu.userinterface.Motherboard.Motherboard;
import ie.atu.userinterface.RAM.RAM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="StorageHardware", url="http://localhost:8080")
public interface StorageHardwareClient {
    @GetMapping("/storages")
    ResponseEntity<List<Storage>> getStorageById(@RequestParam("id") Long id);

    @GetMapping("/storages")
    ResponseEntity<List<Storage>> getStorage(@RequestParam(required = false) String name, @RequestParam(required = false) String brand, @RequestParam(required = false) Float price);

    //    POST MAPPINGS
    @PostMapping("/storages")
    ResponseEntity<String> saveStorage(@RequestBody Storage storage);


    //    DELETE MAPPINGS
    @DeleteMapping("/storages/{id}")
    ResponseEntity<Storage> deleteStorage(@PathVariable("id") Long id);

    //    PUT MAPPINGS
    @PutMapping("/storages/{id}")
    ResponseEntity<Storage> editStorage(@PathVariable("id") Long id);

}
