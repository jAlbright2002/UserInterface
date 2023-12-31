package ie.atu.userinterface.Storage;

import ie.atu.userinterface.CPU.CPU;
import ie.atu.userinterface.CompatibilityRequest;
import ie.atu.userinterface.Motherboard.Motherboard;
import ie.atu.userinterface.Motherboard.MotherboardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StorageController {
    private final StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    //    GET MAPPING
    @GetMapping("/storages")
    public String getStorages(Model model, HttpSession httpSession) {
        // Try to get the attributes, some could have been set]
        CompatibilityRequest compatibilityRequest = new CompatibilityRequest(
                (Motherboard) httpSession.getAttribute("selectedMotherboard")
        );

        List<Storage> storages = storageService.getStorages(compatibilityRequest);
        storages.forEach(storage -> {
            System.out.println(storage.getName());
        });
        model.addAttribute("storages", storages);
        return "storageSelection";
    }


    //    POST MAPPING
    @PostMapping("/select-storage")
    public String selectStorage(Long storageId, Model model, HttpSession httpSession) {
        Storage selectedStorage = storageService.getStorageById(storageId).getFirst();
        httpSession.setAttribute("selectedStorage", selectedStorage);
        return "redirect:/";
    }
//    DELETE MAPPING
//    PUT MAPPING
}
