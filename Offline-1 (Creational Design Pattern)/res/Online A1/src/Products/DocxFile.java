package Products;

import Interface.FileInterface;

public class DocxFile implements FileInterface {
    public void loadDocument(String path) {
        System.out.println("Loading DOCX file from " + path);
    }

    public void saveDocument(String path) {
        System.out.println("Saving DOCX file to " + path);
    }
    
}
