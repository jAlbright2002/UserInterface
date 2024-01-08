package ie.atu.userinterface.Storage;

import ie.atu.userinterface.Compatibility.CompatibilityRequest;
import ie.atu.userinterface.RAM.RAM;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StorageService {
    private final StorageClient storageClient;
    private final StorageHardwareClient storageHardwareClient;

    public StorageService(StorageClient storageClient, StorageHardwareClient storageHardwareClient) {
        this.storageClient = storageClient;
        this.storageHardwareClient = storageHardwareClient;
    }

    //    GET METHODS

    public List<Storage> getStorage(String name, String brand, Float price) {
        return storageHardwareClient.getStorage(name, brand, price).getBody();
    }

    List<Storage> getStorages(@RequestBody(required = false) CompatibilityRequest compatibilityRequest) {
        System.out.println("Comp request: " + compatibilityRequest);
        List<Storage> storages = storageClient.getStorages(compatibilityRequest);
        return storages;
    }

    public List<Storage> getStorageById(Long id) {
        return storageHardwareClient.getStorageById(id).getBody();
    }

    // POST METHODS
    public void saveStorage(Storage storage) {
        storageHardwareClient.saveStorage(storage);
    }

    // DELETE METHODS
    public void deleteStorage(Long id) {
        storageHardwareClient.deleteStorage(id);
    }

    public void editStorage(Long id) {storageHardwareClient.editStorage(id);}

}
