package ie.atu.userinterface.Motherboard;

import ie.atu.userinterface.CPU.CPU;
import ie.atu.userinterface.Compatibility.CompatibilityRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MotherboardService {
    private final MotherboardClient motherboardClient;
    private final MotherboardHardwareClient motherboardHardwareClient;

    public MotherboardService(MotherboardClient motherboardClient, MotherboardHardwareClient motherboardHardwareClient) {
        this.motherboardClient = motherboardClient;
        this.motherboardHardwareClient = motherboardHardwareClient;
    }

//    GET METHODS
    public List<Motherboard> getMotherboards(String name, String brand, Float price) {
        return motherboardHardwareClient.getMotherboards(name, brand, price).getBody();
    }

    List<Motherboard> getMotherboards(@RequestBody(required = false) CompatibilityRequest compatibilityRequest) {
        System.out.println("Comp request: " + compatibilityRequest);
        List<Motherboard> motherboards = motherboardClient.getMotherboards(compatibilityRequest);
        return motherboards;
    }

    public List<Motherboard> getMotherboardById(Long id) {
        return motherboardHardwareClient.getMotherboardById(id).getBody();
    }

    // POST METHODS
    public void saveMotherboard(Motherboard motherboard) {
        motherboardHardwareClient.saveMotherboard(motherboard);
    }

    // DELETE METHODS
    public void deleteMotherboard(Long id) {
        motherboardHardwareClient.deleteMotherboard(id);
    }

    public void editMotherboard(Long id) {motherboardHardwareClient.editMotherboard(id);}
}
