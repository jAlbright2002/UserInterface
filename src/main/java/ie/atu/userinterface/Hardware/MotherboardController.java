package ie.atu.userinterface.Hardware;

import ie.atu.userinterface.CPU.CPU;
import ie.atu.userinterface.CompatibilityRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class MotherboardController {
    private final MotherboardService motherboardService;

    public MotherboardController(MotherboardService motherboardService) {
        this.motherboardService = motherboardService;
    }

    //    GET MAPPING
    @GetMapping("/motherboards")
    public String getMotherboards(Model model, HttpSession httpSession) {
        // Try to get the attributes, some could have been set]
        CompatibilityRequest compatibilityRequest = new CompatibilityRequest(
                (CPU) httpSession.getAttribute("selectedCPU")
        );


        List<Motherboard> motherboards = motherboardService.getMotherboards(compatibilityRequest);
        motherboards.forEach(motherboard -> {
            System.out.println(motherboard.getName());
        });
        model.addAttribute("motherboards", motherboards);
        return "motherboardSelection";
    }


    //    POST MAPPING
    @PostMapping("/select-motherboard")
    public String selectMotherboard(Long motherboardId, Model model, HttpSession httpSession) {
        Motherboard selectedMotherboard = motherboardService.getMotherboardById(motherboardId);
        httpSession.setAttribute("selectedMotherboard", selectedMotherboard);
        return "redirect:/";
    }
//    DELETE MAPPING
//    PUT MAPPING
}
