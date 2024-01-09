package ie.atu.userinterface.RAM;

import ie.atu.userinterface.CPU.CPU;
import ie.atu.userinterface.Compatibility.CompatibilityRequest;

import ie.atu.userinterface.Motherboard.Motherboard;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class RAMService {
    private final RAMClient ramClient;
    private final RAMHardwareClient ramHardwareClient;

    public RAMService(RAMClient ramClient, RAMHardwareClient ramHardwareClient) {
        this.ramClient = ramClient;
        this.ramHardwareClient = ramHardwareClient;
    }

    public List<RAM> getRAM(String name, String brand, Float price) {
        return ramHardwareClient.getRAM(name, brand, price).getBody();
    }

    //    GET METHODS
    List<RAM> getRams(@RequestBody(required = false) CompatibilityRequest compatibilityRequest) {
        System.out.println("Comp request: " + compatibilityRequest);
        List<RAM> rams = ramClient.getRams(compatibilityRequest);
        return rams;
    }

    public List<RAM> getRamById(Long id) {
        return ramHardwareClient.getRamById(id).getBody();
    }


    // POST METHODS
    public void saveRAM(RAM ram) {
        ramHardwareClient.saveRAM(ram);
    }

    // DELETE METHODS
    public void deleteRAM(Long id) {
        ramHardwareClient.deleteRAM(id);
    }

    public RAM editRAM(Long id, RAM ram) {return ramHardwareClient.editRAM(id, ram).getBody();}

}
