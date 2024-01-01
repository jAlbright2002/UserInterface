package ie.atu.userinterface.GPU;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GPUController {
    private final GPUService gpuService;

    public GPUController(GPUService gpuService) {
        this.gpuService = gpuService;
    }

    //    GET MAPPING
    @GetMapping("/gpus")
    public String getGPUs(Model model) {
        List<GPU> gpus = gpuService.getGPUs();
        model.addAttribute("gpus", gpus);
        return "gpuSelection";
    }


    //    POST MAPPINGS
    @PostMapping("/select-gpu")
    public String selectGpu(Long gpuId, Model model, HttpSession httpSession) {
        System.out.println("The id is: " + gpuId);
        GPU selectedGPU = gpuService.getGpuById(gpuId).getFirst();
        httpSession.setAttribute("selectedGPU", selectedGPU);
        System.out.println("This ran. The selected attribute is: " + httpSession.getAttribute("selectedGPU"));
        return "redirect:/";
    }
//    DELETE MAPPING
//    PUT MAPPING
}
