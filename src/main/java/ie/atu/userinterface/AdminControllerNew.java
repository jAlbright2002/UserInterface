package ie.atu.userinterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class AdminControllerNew {
// test
    private final HardwareServiceNew hardwareServiceNew;

    @Autowired
    public AdminControllerNew(HardwareServiceNew hardwareServiceNew) {
        this.hardwareServiceNew = hardwareServiceNew;
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("CPUs", hardwareServiceNew.getCPU(null, null, null));
        return "adminNew";
    }

    @PostMapping("/cpus")
    public String addCPU(@RequestBody CPU cpu) {
        hardwareServiceNew.saveCPU(cpu);
        return "admin";
    }

    @GetMapping("/cpus")
    public ResponseEntity<?> getCpuNames() {
        List<CPU> cpuNames = hardwareServiceNew.getCPU(null, null, null);

        return ResponseEntity.ok("awsd");

    }

}
