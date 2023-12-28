package ie.atu.userinterface.CPU;

import ie.atu.userinterface.User.HardwareComponent;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CPUController {
    private final CPUService cpuService;

    public CPUController(CPUService cpuService) {
        this.cpuService = cpuService;
    }

    //    GET MAPPINGS
    @GetMapping("/cpus")
    public String getCPUs(Model model) {
        List<CPU> cpus = cpuService.getCPU(null, null, null);
        model.addAttribute("cpus", cpus);
        return "cpuSelection";
    }


    //    POST MAPPINGS
    @PostMapping("/select-cpu")
    public String selectCPU(Long cpuId, Model model, HttpSession httpSession) {
        System.out.println("The id is: " + cpuId);
        CPU selectedCPU = cpuService.getCPUById(cpuId);
        httpSession.setAttribute("selectedCPU", selectedCPU);
        System.out.println("This ran. The selected attribute is: " + httpSession.getAttribute("selectedCPU"));
        return "redirect:/";
    }

//    DELETE MAPPINGS


//    PUT MAPPINGS


}
