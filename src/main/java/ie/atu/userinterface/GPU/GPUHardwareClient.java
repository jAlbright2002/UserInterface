package ie.atu.userinterface.GPU;

import ie.atu.userinterface.CPU.CPU;
import ie.atu.userinterface.RAM.RAM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "GPUHardware", url = "http://localhost:8080")
public interface GPUHardwareClient {
    @GetMapping("/gpus")
    ResponseEntity<List<GPU>> getGPUById(@RequestParam("id") Long id);

    @GetMapping("/gpus")
    ResponseEntity<List<GPU>> getGPUs(@RequestParam(required = false) String name, @RequestParam(required = false) String brand, @RequestParam(required = false) Float price);

    @PostMapping("/gpus")
    ResponseEntity<String> saveGPU(@RequestBody GPU gpu);


    //    DELETE MAPPINGS
    @DeleteMapping("/gpus/{id}")
    ResponseEntity<GPU> deleteGPU(@PathVariable("id") Long id);

    //    PUT MAPPINGS
    @PutMapping("/gpus/{id}")
    ResponseEntity<GPU> editGPU(@PathVariable("id") Long id);
}
