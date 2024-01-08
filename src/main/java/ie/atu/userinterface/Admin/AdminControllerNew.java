package ie.atu.userinterface.Admin;

import ie.atu.userinterface.CPU.CPU;
import ie.atu.userinterface.CPU.CPUService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminControllerNew {
// test
    private final CPUService cpuService;

    @Autowired
    public AdminControllerNew(CPUService cpuService) {
        this.cpuService = cpuService;
    }

    @GetMapping
    public String admin(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        model.addAttribute("CPUs", cpuService.getCPU(null, null, null));
        return "admin";
    }

    @GetMapping("/cpus")
    public String getCPUs(@RequestParam String name, @RequestParam String brand, @RequestParam Float price) {
        List<CPU> CPUs = cpuService.getCPU(name, brand, price);
        return "redirect:/admin";
    }

    @PostMapping("/cpus")
    public String createCPU(@ModelAttribute CPU cpu) {
        cpuService.saveCPU(cpu);
        return "redirect:/admin";
    }

    @DeleteMapping("/cpus/{id}")
    public String deleteCPU(@PathVariable("id") Long id) {
        cpuService.deleteCPU(id);
        return "redirect:/admin";
    }

}
