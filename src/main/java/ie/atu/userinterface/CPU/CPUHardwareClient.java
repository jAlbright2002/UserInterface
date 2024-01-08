package ie.atu.userinterface.CPU;

import ie.atu.userinterface.RAM.RAM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "CPUHardware", url = "http://localhost:8080")
public interface CPUHardwareClient {

    @GetMapping("/cpus")
    ResponseEntity<List<CPU>> getCPUs(@RequestParam String name, @RequestParam String brand, @RequestParam Float price);

    @GetMapping("/cpus")
    ResponseEntity<List<CPU>> getCPUById(@RequestParam("id") Long id);

    //    POST MAPPINGS
    @PostMapping("/cpus")
    ResponseEntity<String> saveCPU(@RequestBody CPU cpu);


    //    DELETE MAPPINGS
    @DeleteMapping("/cpus/{id}")
    ResponseEntity<CPU> deleteCPU(@PathVariable("id") Long id);

    //    PUT MAPPINGS
    @PutMapping("/cpus/{id}")
    ResponseEntity<CPU> editCPU(@PathVariable("id") Long id);


}
