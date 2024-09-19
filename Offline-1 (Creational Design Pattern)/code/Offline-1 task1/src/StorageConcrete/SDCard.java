package StorageConcrete;

import Interfaces.Storage;

public class SDCard implements Storage {

    @Override
    public void addStorage() {
        System.out.println("SD card storage added");
    }

    public String toString() {
        return "SD Card Storage";
    }
    
}
