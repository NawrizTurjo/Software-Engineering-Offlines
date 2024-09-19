package StorageConcrete;

import Interfaces.Storage;

public class BuiltIn implements Storage {

    @Override
    public void addStorage() {
        System.out.println("This microcontroller has built-in storage");
    }

    public String toString() {
        return "Built-in Storage";
    }
    
}
