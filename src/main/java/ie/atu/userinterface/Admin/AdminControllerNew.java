package ie.atu.userinterface.Admin;

import ie.atu.userinterface.CPU.CPU;
import ie.atu.userinterface.CPU.CPUService;
import ie.atu.userinterface.GPU.GPU;
import ie.atu.userinterface.GPU.GPUService;
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
    private final GPUService gpuService;

    @Autowired
    public AdminControllerNew(CPUService cpuService, GPUService gpuService) {
        this.cpuService = cpuService;
        this.gpuService = gpuService;
    }

    @GetMapping
    public String admin(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        model.addAttribute("CPUs", cpuService.getCPU(null, null, null));
        return "admin";
    }

    //CPU ADMIN FUNCTIONS

    @GetMapping("/cpus")
    public String getCPUs(@RequestParam String name, @RequestParam String brand, @RequestParam Float price, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        List<CPU> CPUs = cpuService.getCPU(name, brand, price);
        return "redirect:/admin";
    }

    @PostMapping("/cpus")
    public String createCPU(@ModelAttribute CPU cpu, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        cpuService.saveCPU(cpu);
        return "redirect:/admin";
    }

    @DeleteMapping("/cpus/{id}")
    public String deleteCPU(@PathVariable("id") Long id, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        cpuService.deleteCPU(id);
        return "redirect:/admin";
    }

    @PutMapping("/cpus/{id}")
    public String editCPU(@PathVariable("id") Long id, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        cpuService.editCPU(id);
        return "redirect:/admin";
    }

    //GPU ADMIN FUNCTIONS

    @GetMapping("/gpus")
    public String getGPUs(HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        List<GPU> GPUs = gpuService.getGPU();
        return "redirect:/admin";
    }

    @PostMapping("/cpus")
    public String createGPU(@ModelAttribute GPU gpu, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        gpuService.saveGPU(gpu);
        return "redirect:/admin";
    }

    @DeleteMapping("/cpus/{id}")
    public String deleteGPU(@PathVariable("id") Long id, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        gpuService.deleteGPU(id);
        return "redirect:/admin";
    }

    @PutMapping("/cpus/{id}")
    public String editGPU(@PathVariable("id") Long id, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        gpuService.editGPU(id);
        return "redirect:/admin";
    }

}
