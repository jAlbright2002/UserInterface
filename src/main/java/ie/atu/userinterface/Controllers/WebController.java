package ie.atu.userinterface.Controllers;

import ie.atu.userinterface.CPU.CPU;
import ie.atu.userinterface.BusinessLogic.HardwareServiceNew;
import ie.atu.userinterface.User.HardwareComponent;
import jakarta.servlet.http.HttpSession;
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

        model.addAttribute("cpus", cpus);
        return "componentSelection";
    }

    @PostMapping("/select-cpu")
    public String selectCPU(Long cpuId, Model model, HttpSession httpSession) {
        //CPU selectedCPU = hardwareServiceNew.getCPUById(cpuId) // Havent implemented the getById here yet
        //CPU selectedCPU = new CPU(cpuId, "cpuname", 200, "lga", "54ghz", "intel", Arrays.asList("DDR3"), "link.com");
        System.out.println("The id is: " + cpuId);
        CPU selectedCPU = hardwareServiceNew.getCPUById(cpuId);
        httpSession.setAttribute("selectedCPU", selectedCPU);
        System.out.println("This ran. The selected attribute is: " + httpSession.getAttribute("selectedCPU"));
//        CPU cpu = (CPU) httpSession.getAttribute("selectedCPU");
//        System.out.println("ebay url for cpu: " + cpu.getEbaylink());

        return "redirect:/";
    }

}
