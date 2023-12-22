package ie.atu.userinterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class AdminController {
// test
    private final HardwareService hardwareService;

    @Autowired
    public AdminController(HardwareService hardwareService) {
        this.hardwareService = hardwareService;
    }

    @GetMapping("/admin")
    public String home() {
        return "admin";
    }

    @PostMapping("/cpus")
    public String addCPU(@RequestBody CPU cpu) {
        hardwareService.addCPU(cpu);
        return "admin";
    }

    @GetMapping("/cpus")
    public ResponseEntity<List<String>> getCpuNames() {
        List<String> cpuNames = hardwareService.getCpus();
        if (!cpuNames.isEmpty()) {
            return new ResponseEntity<>(cpuNames, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
