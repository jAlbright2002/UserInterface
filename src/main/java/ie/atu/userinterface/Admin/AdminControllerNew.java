package ie.atu.userinterface.Admin;

import ie.atu.userinterface.CPU.CPU;
import ie.atu.userinterface.CPU.CPUService;
import ie.atu.userinterface.GPU.GPU;
import ie.atu.userinterface.GPU.GPUService;
import ie.atu.userinterface.Motherboard.Motherboard;
import ie.atu.userinterface.Motherboard.MotherboardService;
import ie.atu.userinterface.RAM.RAM;
import ie.atu.userinterface.RAM.RAMService;
import ie.atu.userinterface.Storage.Storage;
import ie.atu.userinterface.Storage.StorageService;
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
    private final MotherboardService motherboardService;
    private final RAMService ramService;
    private final StorageService storageService;

    @Autowired
    public AdminControllerNew(CPUService cpuService,
                              GPUService gpuService,
                              MotherboardService motherboardService,
                              RAMService ramService,
                              StorageService storageService) {
        this.cpuService = cpuService;
        this.gpuService = gpuService;
        this.motherboardService = motherboardService;
        this.ramService = ramService;
        this.storageService = storageService;
    }

    @GetMapping
    public String admin(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";

        String selectedOption = (String) httpSession.getAttribute("selectedOption");

        // Add a null check for selectedOption
        if (selectedOption == null) {
            // Handle the case where selectedOption is null
            model.addAttribute("CPUs", cpuService.getCPU(null, null, null));
            return "redirect:/admin";  // or another appropriate action
        }

        // Use a switch-case based on the selectedOption
        switch (selectedOption) {
            case "CPUs":
                model.addAttribute("CPUs", cpuService.getCPU(null, null, null));
                break;
            case "GPUs":
                model.addAttribute("GPUs", gpuService.getGPU(null, null, null));
                break;
            case "Motherboards":
                model.addAttribute("Motherboards", motherboardService.getMotherboards(null, null, null));
                break;
            case "RAMs":
                model.addAttribute("RAMs", ramService.getRAM(null, null, null));
                break;
            case "Storages":
                model.addAttribute("Storages", storageService.getStorage(null, null, null));
                break;
            // Add more cases if needed

            default:
                // Handle default case if necessary
                break;
        }

        System.out.println(selectedOption);
        model.addAttribute("componentSelected", selectedOption);
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
    public String getGPU(HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        List<GPU> GPUs = gpuService.getGPU(null, null, null);
        return "redirect:/admin";
    }

    @PostMapping("/gpus")
    public String createGPU(@ModelAttribute GPU gpu, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        gpuService.saveGPU(gpu);
        return "redirect:/admin";
    }

    @DeleteMapping("/gpus/{id}")
    public String deleteGPU(@PathVariable("id") Long id, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        gpuService.deleteGPU(id);
        return "redirect:/admin";
    }

    @PutMapping("/gpus/{id}")
    public String editGPU(@PathVariable("id") Long id, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        gpuService.editGPU(id);
        return "redirect:/admin";
    }

    //MOBO ADMIN FUNCTIONS

    @GetMapping("/motherboards")
    public String getMotherboard(HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        List<Motherboard> Motherboards = motherboardService.getMotherboards(null, null, null);
        return "redirect:/admin";
    }

    @PostMapping("/motherboards")
    public String createMotherboard(@ModelAttribute Motherboard motherboard, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        motherboardService.saveMotherboard(motherboard);
        return "redirect:/admin";
    }

    @DeleteMapping("/motherboards/{id}")
    public String deleteMotherboard(@PathVariable("id") Long id, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        motherboardService.deleteMotherboard(id);
        return "redirect:/admin";
    }

    @PutMapping("/motherboards/{id}")
    public String editMotherboard(@PathVariable("id") Long id, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        motherboardService.editMotherboard(id);
        return "redirect:/admin";
    }

    //RAM ADMIN FUNCTIONS

    @GetMapping("/rams")
    public String getRAM(HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        List<RAM> RAMs = ramService.getRAM(null, null, null);
        return "redirect:/admin";
    }

    @PostMapping("/rams")
    public String createRAM(@ModelAttribute RAM ram, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        ramService.saveRAM(ram);
        return "redirect:/admin";
    }

    @DeleteMapping("/rams/{id}")
    public String deleteRAM(@PathVariable("id") Long id, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        ramService.deleteRAM(id);
        return "redirect:/admin";
    }

    @PutMapping("/rams/{id}")
    public String editRAM(@PathVariable("id") Long id, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        ramService.editRAM(id);
        return "redirect:/admin";
    }

    //STORAGE ADMIN FUNCTIONS

    @GetMapping("/storages")
    public String getStorage(HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        List<Storage> Storages = storageService.getStorage(null, null, null);
        return "redirect:/admin";
    }

    @PostMapping("/storages")
    public String createStorage(@ModelAttribute Storage storage, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        storageService.saveStorage(storage);
        return "redirect:/admin";
    }

    @DeleteMapping("/storages/{id}")
    public String deleteStorage(@PathVariable("id") Long id, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        storageService.deleteStorage(id);
        return "redirect:/admin";
    }

    @PutMapping("/storages/{id}")
    public String editStorage(@PathVariable("id") Long id, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        storageService.editStorage(id);
        return "redirect:/admin";
    }

    //POST MAPPING FOR RADIAL BUTTONS ON ADMIN.HTML
    @PostMapping("/radial")
    public String radial(@RequestParam("selectedOption") String selectedOption, Model model,  HttpSession httpSession) {
        httpSession.setAttribute("selectedOption", selectedOption);
//        System.out.println(httpSession.getAttribute("selectedOption"));
        return "redirect:/admin";
    }

}
