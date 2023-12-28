package ie.atu.userinterface.RAM;

import ie.atu.userinterface.CPU.CPU;
import ie.atu.userinterface.CompatibilityRequest;
import ie.atu.userinterface.Motherboard.Motherboard;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RAMController {
    private final RAMService ramService;

    public RAMController(RAMService ramService) {
        this.ramService = ramService;
    }

    //    GET MAPPING
    @GetMapping("/rams")
    public String getRams(Model model, HttpSession httpSession) {
        // Try to get the attributes, some could have been set]
        CompatibilityRequest compatibilityRequest = new CompatibilityRequest(
                (CPU) httpSession.getAttribute("selectedCPU"),
                (Motherboard) httpSession.getAttribute("selectedMotherboard")
        );


        List<RAM> rams = ramService.getRams(compatibilityRequest);
        rams.forEach(ram -> {
            System.out.println(ram.getName());
        });
        model.addAttribute("rams", rams);
        return "ramSelection";
    }


    //    POST MAPPING
    @PostMapping("/select-ram")
    public String selectRam(Long ramId, Model model, HttpSession httpSession) {
        RAM selectedRAM = ramService.getRamById(ramId).getFirst();
        httpSession.setAttribute("selectedRAM", selectedRAM);
        return "redirect:/";
    }
//    DELETE MAPPING
//    PUT MAPPING
}
