package Products;

import Interface.FileInterface;

public class PdfFile implements FileInterface {
    public void loadDocument(String path) {
        System.out.println("Loading PDF file from " + path);
    }

    public void saveDocument(String path) {
        System.out.println("Saving PDF file to " + path);
    }
    
}
