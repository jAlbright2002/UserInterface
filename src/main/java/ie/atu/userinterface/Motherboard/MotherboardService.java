package ie.atu.userinterface.Motherboard;

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
    List<Motherboard> getMotherboards(@RequestBody(required = false) CompatibilityRequest compatibilityRequest) {
        System.out.println("Comp request: " + compatibilityRequest);
        List<Motherboard> motherboards = motherboardClient.getMotherboards(compatibilityRequest);
        return motherboards;
    }

    public List<Motherboard> getMotherboardById(Long id) {
        return motherboardHardwareClient.getMotherboardById(id).getBody();
    }

//    POST METHODS

//    DELETE METHODS


//    PUT METHODS

}
