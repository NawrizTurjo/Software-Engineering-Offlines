package CreationalPatterns.Onlines.C2;
// Step 1: Define abstract product interfaces
interface Letter {
    void displayContent();
}

interface Resume {
    void displayContent();
}

// Step 2: Implement concrete products for Formal Style
class FormalLetter implements Letter {
    @Override
    public void displayContent() {
        System.out.println("This is a formal letter.");
    }
}

class FormalResume implements Resume {
    @Override
    public void displayContent() {
        System.out.println("This is a formal resume.");
    }
}

// Step 3: Implement concrete products for Informal Style
class InformalLetter implements Letter {
    @Override
    public void displayContent() {
        System.out.println("This is an informal letter.");
    }
}

class InformalResume implements Resume {
    @Override
    public void displayContent() {
        System.out.println("This is an informal resume.");
    }
}

// Step 4: Define the abstract factory interface
interface DocumentFactory {
    Letter createLetter();
    Resume createResume();
}

// Step 5: Implement concrete factories
class FormalDocumentFactory implements DocumentFactory {
    @Override
    public Letter createLetter() {
        return new FormalLetter();
    }

    @Override
    public Resume createResume() {
        return new FormalResume();
    }
}

class InformalDocumentFactory implements DocumentFactory {
    @Override
    public Letter createLetter() {
        return new InformalLetter();
    }

    @Override
    public Resume createResume() {
        return new InformalResume();
    }
}

// Step 6: Implement the client
class DocumentCreator {
    private DocumentFactory documentFactory;

    public DocumentCreator(DocumentFactory factory) {
        this.documentFactory = factory;
    }

    public void createLetter() {
        Letter letter = documentFactory.createLetter();
        letter.displayContent();
    }

    public void createResume() {
        Resume resume = documentFactory.createResume();
        resume.displayContent();
    }
}

// Step 7: Main method to demonstrate the system
public class C2Online {
    public static void main(String[] args) {
        // Example: Creating Formal Documents
        DocumentFactory formalFactory = new FormalDocumentFactory();
        DocumentCreator formalCreator = new DocumentCreator(formalFactory);
        System.out.println("Formal Mode:");
        formalCreator.createLetter();
        formalCreator.createResume();

        System.out.println();

        // Example: Creating Informal Documents
        DocumentFactory informalFactory = new InformalDocumentFactory();
        DocumentCreator informalCreator = new DocumentCreator(informalFactory);
        System.out.println("Informal Mode:");
        informalCreator.createLetter();
        informalCreator.createResume();
    }
}
