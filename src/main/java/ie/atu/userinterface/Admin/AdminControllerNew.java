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
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";

        String selectedOption = (String) httpSession.getAttribute("selectedOption");
        String currentForm = (String) httpSession.getAttribute("currentForm");

        //Add a null check for selectedOption
        if (selectedOption == null) {
            selectedOption = "CPUs";
        }
        if (currentForm == null) {
            currentForm = "create";
        }
        model.addAttribute("currentForm", currentForm);

        // Use a switch-case based on the selectedOption
        switch (selectedOption) {
            case "CPUs":
                model.addAttribute("CPUs", cpuService.getCPU(null, null, null));
                if (httpSession.getAttribute("currentForm") == "update") model.addAttribute("selectedCPU", httpSession.getAttribute("selectedCPU"));
                break;
            case "GPUs":
                model.addAttribute("GPUs", gpuService.getGPU(null, null, null));
                if (httpSession.getAttribute("currentForm") == "update") model.addAttribute("selectedGPU", httpSession.getAttribute("selectedGPU"));
                break;
            case "Motherboards":
                model.addAttribute("Motherboards", motherboardService.getMotherboards(null, null, null));
                if (httpSession.getAttribute("currentForm") == "update") model.addAttribute("selectedMotherboard", httpSession.getAttribute("selectedMotherboard"));
                break;
            case "RAMs":
                model.addAttribute("RAMs", ramService.getRAM(null, null, null));
                if (httpSession.getAttribute("currentForm") == "update") model.addAttribute("selectedRAM", httpSession.getAttribute("selectedRAM"));
                break;
            case "Storages":
                model.addAttribute("Storages", storageService.getStorage(null, null, null));
                if (httpSession.getAttribute("currentForm") == "update") model.addAttribute("selectedStorage", httpSession.getAttribute("selectedStorage"));
                break;

            default:
                // Handle default case if necessary
                model.addAttribute("CPUs", cpuService.getCPU(null, null, null));
                break;
        }

        System.out.println(selectedOption);
        model.addAttribute("componentSelected", selectedOption);
        return "admin";
    }

    //CPU ADMIN FUNCTIONS

    @GetMapping("/cpus")
    public String getCPUs(@RequestParam String name, @RequestParam String brand, @RequestParam Float price, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        List<CPU> CPUs = cpuService.getCPU(name, brand, price);
        return "redirect:/admin";
    }

    @GetMapping("/cpus/{id}")
    public String getCPUById(@PathVariable("id") Long id, HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        CPU cpu = cpuService.getCPUById(id).getFirst();
        httpSession.setAttribute("selectedCPU", cpu);
        httpSession.setAttribute("currentForm", "update");
        return "redirect:/admin";
    }

    @PostMapping("/cpus")
    public String createCPU(@ModelAttribute CPU cpu, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        cpuService.saveCPU(cpu);
        return "redirect:/admin";
    }

    @DeleteMapping("/cpus/{id}")
    public String deleteCPU(@PathVariable("id") Long id, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        cpuService.deleteCPU(id);
        return "redirect:/admin";
    }

    @PostMapping("/cpus/update")
    public String editCPU(@RequestParam(name = "id") Long id, @ModelAttribute CPU cpu, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        cpuService.editCPU(id, cpu);
        httpSession.setAttribute("currentForm", "create");
        return "redirect:/admin";
    }

    //GPU ADMIN FUNCTIONS

    @GetMapping("/gpus")
    public String getGPU(HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        List<GPU> GPUs = gpuService.getGPU(null, null, null);
        return "redirect:/admin";
    }

    @GetMapping("/gpus/{id}")
    public String getGPUById(@PathVariable("id") Long id, HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        GPU gpu = gpuService.getGpuById(id).getFirst();
        httpSession.setAttribute("selectedGPU", gpu);
        httpSession.setAttribute("currentForm", "update");
        return "redirect:/admin";
    }

    @PostMapping("/gpus")
    public String createGPU(@ModelAttribute GPU gpu, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        gpuService.saveGPU(gpu);
        return "redirect:/admin";
    }

    @DeleteMapping("/gpus/{id}")
    public String deleteGPU(@PathVariable("id") Long id, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        gpuService.deleteGPU(id);
        return "redirect:/admin";
    }

    @PostMapping("/gpus/update")
    public String editGPU(@RequestParam(name = "id") Long id, @ModelAttribute GPU gpu, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        gpuService.editGPU(id, gpu);
        httpSession.setAttribute("currentForm", "create");
        return "redirect:/admin";
    }

    //MOBO ADMIN FUNCTIONS

    @GetMapping("/motherboards")
    public String getMotherboard(HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        List<Motherboard> Motherboards = motherboardService.getMotherboards(null, null, null);
        return "redirect:/admin";
    }

    @GetMapping("/motherboards/{id}")
    public String getMotherboardById(@PathVariable("id") Long id, HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        Motherboard motherboard = motherboardService.getMotherboardById(id).getFirst();
        httpSession.setAttribute("selectedMotherboard", motherboard);
        httpSession.setAttribute("currentForm", "update");
        return "redirect:/admin";
    }

    @PostMapping("/motherboards")
    public String createMotherboard(@ModelAttribute Motherboard motherboard, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        motherboardService.saveMotherboard(motherboard);
        return "redirect:/admin";
    }

    @DeleteMapping("/motherboards/{id}")
    public String deleteMotherboard(@PathVariable("id") Long id, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        motherboardService.deleteMotherboard(id);
        return "redirect:/admin";
    }

    @PostMapping("/motherboards/update")
    public String editMotherboard(@RequestParam(name = "id") Long id, @ModelAttribute Motherboard motherboard, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        motherboardService.editMotherboard(id, motherboard);
        httpSession.setAttribute("currentForm", "create");
        return "redirect:/admin";
    }

    //RAM ADMIN FUNCTIONS

    @GetMapping("/rams")
    public String getRAM(HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        List<RAM> RAMs = ramService.getRAM(null, null, null);
        return "redirect:/admin";
    }

    @GetMapping("/rams/{id}")
    public String getRAMById(@PathVariable("id") Long id, HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        RAM ram = ramService.getRamById(id).getFirst();
        httpSession.setAttribute("selectedRAM", ram);
        httpSession.setAttribute("currentForm", "update");
        return "redirect:/admin";
    }

    @PostMapping("/rams")
    public String createRAM(@ModelAttribute RAM ram, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        ramService.saveRAM(ram);
        return "redirect:/admin";
    }

    @DeleteMapping("/rams/{id}")
    public String deleteRAM(@PathVariable("id") Long id, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        ramService.deleteRAM(id);
        return "redirect:/admin";
    }

    @PostMapping("/rams/update")
    public String editRAM(@RequestParam(name = "id") Long id, @ModelAttribute RAM ram, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        ramService.editRAM(id, ram);
        httpSession.setAttribute("currentForm", "create");
        return "redirect:/admin";
    }

    //STORAGE ADMIN FUNCTIONS

    @GetMapping("/storages")
    public String getStorage(HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        List<Storage> Storages = storageService.getStorage(null, null, null);
        return "redirect:/admin";
    }

    @GetMapping("/storages/{id}")
    public String getStorageById(@PathVariable("id") Long id, HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        Storage storage = storageService.getStorageById(id).getFirst();
        httpSession.setAttribute("selectedStorage", storage);
        httpSession.setAttribute("currentForm", "update");
        return "redirect:/admin";
    }

    @PostMapping("/storages")
    public String createStorage(@ModelAttribute Storage storage, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        storageService.saveStorage(storage);
        return "redirect:/admin";
    }

    @DeleteMapping("/storages/{id}")
    public String deleteStorage(@PathVariable("id") Long id, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        storageService.deleteStorage(id);
        return "redirect:/admin";
    }

    @PostMapping("/storages/update")
    public String editStorage(@RequestParam(name = "id") Long id, @ModelAttribute Storage storage, HttpSession httpSession) {
        if (httpSession.getAttribute("loggedIn") != null && httpSession.getAttribute("loggedIn").equals(false)) return "redirect:/";
        storageService.editStorage(id, storage);
        httpSession.setAttribute("currentForm", "create");
        return "redirect:/admin";
    }

    //POST MAPPING FOR RADIAL BUTTONS ON ADMIN.HTML
    @PostMapping("/radial")
    public String radial(@RequestParam("selectedOption") String selectedOption, Model model,  HttpSession httpSession) {
        httpSession.setAttribute("selectedOption", selectedOption);
        return "redirect:/admin";
    }

}
