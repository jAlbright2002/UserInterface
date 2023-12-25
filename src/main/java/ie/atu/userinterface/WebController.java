package ie.atu.userinterface;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    private final HardwareServiceNew hardwareServiceNew;

    public WebController(HardwareServiceNew hardwareServiceNew) {
        this.hardwareServiceNew = hardwareServiceNew;
    }

    @GetMapping("/")
    public String index(Model model, HttpSession httpSession) {
        List<HardwareComponent> components = new ArrayList<>();
        components.add(new HardwareComponent("CPU", httpSession.getAttribute("selectedCPU"), "/cpus"));
        components.add(new HardwareComponent("Motherboard", httpSession.getAttribute("selectedMotherboard"), "/motherboards"));
        components.add(new HardwareComponent("RAM", httpSession.getAttribute("selectedRAM"), "/rams"));
        components.add(new HardwareComponent("GPU", httpSession.getAttribute("selectedGPU"), "/gpus"));
        components.add(new HardwareComponent("Storage", httpSession.getAttribute("selectedStorage"), "/storages"));

        model.addAttribute("components", components);
        return "index";
    }

    @GetMapping("/cpus")
    public String getCPUs(Model model) {
        List<CPU> cpus = hardwareServiceNew.getCPU(null, null, null);
        model.addAttribute("hardwareComponent", cpus);
        return "componentSelection";
    }
}
