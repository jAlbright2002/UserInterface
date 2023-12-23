package ie.atu.userinterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="hardware", url="http://localhost:8080")
public interface HardwareClientNew {
    // This communicates with other services and uses the methods below
    @PostMapping("/cpus")
    ResponseEntity<String> saveCPU(@RequestBody CPU cpu);

    @GetMapping("/cpus")
    List<CPU> getCPUs(@RequestParam String name, @RequestParam String brand, @RequestParam Float price);

    //delete
    @DeleteMapping("/cpus/{id}")
    ResponseEntity<?> deleteCPU(@PathVariable("id") Long id);

    //put

    // We will add the same 4 functions for the other components
}
