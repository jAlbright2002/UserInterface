package ie.atu.userinterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String createCPU(@ModelAttribute CPU cpu) {
        hardwareServiceNew.saveCPU(cpu);
        return "redirect:/admin";
    }

    @GetMapping("/cpus")
    public String getCPUs(@RequestParam String name, @RequestParam String brand, @RequestParam Float price) {
        List<CPU> CPUs = hardwareServiceNew.getCPU(name, brand, price);
        return "redirect:/admin";
    }

    @DeleteMapping("/cpus/{id}")
    public String deleteCPU(@PathVariable("id") Long id) {
        hardwareServiceNew.deleteCPU(id);
        return "redirect:/admin";
    }

}
