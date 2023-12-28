package ie.atu.userinterface.CPU;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "CPU", url = "http://localhost:8080")
public interface CPUClient {

    //    GET MAPPINGS
    @GetMapping("/cpus")
    List<CPU> getCPUs(@RequestParam String name, @RequestParam String brand, @RequestParam Float price);

    @GetMapping("/cpus/{id}")
    ResponseEntity<CPU> getCPUById(@PathVariable("id") Long id);

    //    POST MAPPINGS
    @PostMapping("/cpus")
    ResponseEntity<String> saveCPU(@RequestBody CPU cpu);


    //    DELETE MAPPINGS
    @DeleteMapping("/cpus/{id}")
    ResponseEntity<CPU> deleteCPU(@PathVariable("id") Long id);

//    PUT MAPPINGS

}
