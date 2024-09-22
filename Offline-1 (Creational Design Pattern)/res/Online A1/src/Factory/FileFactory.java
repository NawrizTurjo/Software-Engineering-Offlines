package Factory;

import Interface.FileInterface;
import Products.*;

public class FileFactory {
    public static FileInterface getFile(String Path)
    {
        String extension = Path.split("\\.")[1];
        if(extension.equalsIgnoreCase("docx"))
        {
            return new DocxFile();
        }
        else if(extension.equalsIgnoreCase("pdf"))
        {
            return new PdfFile();
        }
        else if(extension.equalsIgnoreCase("txt"))
        {
            return new TxtFile();
        }
        else
        {
            return null;
        }
    }
    
}
