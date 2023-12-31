package ie.atu.userinterface.Web;

import ie.atu.userinterface.User.HardwareComponent;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final WebService webService;

    public WebController(WebService webService) {
        this.webService = webService;
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

    // For testing
    @GetMapping("/log")
    public String sendTestDataToLogin() {
        Admin adminMock = new Admin("James", "myPassword");
        return webService.sendMock(adminMock);
    }
}