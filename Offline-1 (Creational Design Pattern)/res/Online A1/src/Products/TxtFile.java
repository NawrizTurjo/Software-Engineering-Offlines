package Products;

import Interface.FileInterface;

public class TxtFile implements FileInterface {
    public void loadDocument(String path) {
        System.out.println("Loading TXT file from " + path);
    }

    public void saveDocument(String path) {
        System.out.println("Saving TXT file to " + path);
    }
    
}
