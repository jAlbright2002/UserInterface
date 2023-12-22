package ie.atu.userinterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AdminController {

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

}
