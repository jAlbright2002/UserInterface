package ie.atu.userinterface;

import ie.atu.userinterface.CPU.CPU;
import ie.atu.userinterface.Motherboard.Motherboard;
import ie.atu.userinterface.RAM.RAM;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompatibilityRequest {
    private CPU cpu;
    //private GPU gpu;
    private Motherboard motherboard;
    private RAM ram;
    //private Storage storage;


    public CompatibilityRequest(CPU cpu) {
        this.cpu = cpu;
    }

    public CompatibilityRequest(CPU cpu, Motherboard motherboard) {
        this.cpu = cpu;
        this.motherboard = motherboard;
    }
}