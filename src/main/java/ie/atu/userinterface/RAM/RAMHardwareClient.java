package ie.atu.userinterface.RAM;

import ie.atu.userinterface.CPU.CPU;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "RAMHardware", url = "http://localhost:8080")
public interface RAMHardwareClient {
    @GetMapping("/rams")
    ResponseEntity<List<RAM>> getRamById(@RequestParam("id") Long id);

    @GetMapping("/rams")
    ResponseEntity<List<RAM>> getRAM(@RequestParam(required = false) String name, @RequestParam(required = false) String brand, @RequestParam(required = false) Float price);


    //    POST MAPPINGS
    @PostMapping("/rams")
    ResponseEntity<String> saveRAM(@RequestBody RAM ram);


    //    DELETE MAPPINGS
    @DeleteMapping("/rams/{id}")
    ResponseEntity<RAM> deleteRAM(@PathVariable("id") Long id);

    //    PUT MAPPINGS
    @PutMapping("/rams/{id}")
    ResponseEntity<RAM> editRAM(@PathVariable("id") Long id, @RequestBody RAM ram);
}
