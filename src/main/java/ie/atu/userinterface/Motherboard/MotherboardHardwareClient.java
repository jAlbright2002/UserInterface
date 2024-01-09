package ie.atu.userinterface.Motherboard;

import ie.atu.userinterface.CPU.CPU;
import ie.atu.userinterface.GPU.GPU;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "MotherboardHardware", url="${feign.url}")
public interface MotherboardHardwareClient {
    @GetMapping("/motherboards")
    ResponseEntity<List<Motherboard>> getMotherboardById(@RequestParam("id") Long id);

    @GetMapping("/motherboards")
    ResponseEntity<List<Motherboard>> getMotherboards(@RequestParam(required = false) String name, @RequestParam(required = false) String brand, @RequestParam(required = false) Float price);

    //    POST MAPPINGS
    @PostMapping("/motherboards")
    ResponseEntity<String> saveMotherboard(@RequestBody Motherboard motherboard);


    //    DELETE MAPPINGS
    @DeleteMapping("/motherboards/{id}")
    ResponseEntity<Motherboard> deleteMotherboard(@PathVariable("id") Long id);

    //    PUT MAPPINGS
    @PutMapping("/motherboards/{id}")
    ResponseEntity<Motherboard> editMotherboard(@PathVariable("id") Long id, @RequestBody Motherboard motherboard);

}
