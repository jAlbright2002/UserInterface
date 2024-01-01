//package ie.atu.userinterface.BusinessLogic;
//
//import ie.atu.userinterface.FeignClient.HardwareClientNew;
//import ie.atu.userinterface.CPU.CPU;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class HardwareServiceNew {
//
//    private final HardwareClientNew hardwareClientNew;
//
//    public HardwareServiceNew(HardwareClientNew hardwareClientNew) {
//        this.hardwareClientNew = hardwareClientNew;
//    }
//
//    // Communicates with the other service through the Client interface
//    public ResponseEntity<String> saveCPU(CPU cpu) {
//        return hardwareClientNew.saveCPU(cpu);
//    }
//
//    public List<CPU> getCPU(String name, String brand, Float price) {
//        List<CPU> CPUs = hardwareClientNew.getCPUs(name, brand, price);
//        return CPUs;
//    }
//    public CPU getCPUById(Long id) {
//        return hardwareClientNew.getCPUById(id).getBody();
//    }
//
//    public void deleteCPU(Long id) {hardwareClientNew.deleteCPU(id);}
//}
