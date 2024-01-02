package ie.atu.userinterface.RAM;

import ie.atu.userinterface.Compatibility.CompatibilityRequest;

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

    //    GET METHODS
    List<RAM> getRams(@RequestBody(required = false) CompatibilityRequest compatibilityRequest) {
        System.out.println("Comp request: " + compatibilityRequest);
        List<RAM> rams = ramClient.getRams(compatibilityRequest);
        return rams;
    }

    public List<RAM> getRamById(Long id) {
        return ramHardwareClient.getRamById(id).getBody();
    }


//    POST METHODS

//    DELETE METHODS


//    PUT METHODS

}
