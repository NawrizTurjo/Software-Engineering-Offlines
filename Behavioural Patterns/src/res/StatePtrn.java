package res;

// Step 1: Define the State interface
interface DocumentState {
    void publish(DocumentContext context);

    void edit(DocumentContext context); // # amar ki ki input ase
}

// Step 2: Define Concrete State classes
class DraftState implements DocumentState {
    @Override
    public void publish(DocumentContext context) {
        System.out.println("Document is now in Moderation.");
        context.setState(new ModerationState());
    }

    @Override
    public void edit(DocumentContext context) {
        System.out.println("Document is being edited in Draft.");
    }
}

class ModerationState implements DocumentState {
    @Override
    public void publish(DocumentContext context) {
        System.out.println("Document is now Published.");
        context.setState(new PublishedState());
    }

    @Override
    public void edit(DocumentContext context) {
        System.out.println("Cannot edit document in Moderation state.");
    }
}

class PublishedState implements DocumentState {
    @Override
    public void publish(DocumentContext context) {
        System.out.println("Document is already Published.");
    }

    @Override
    public void edit(DocumentContext context) {
        System.out.println("Cannot edit document in Published state.");
    }
}

// Step 3: Create the Context class
class DocumentContext {
    private DocumentState state;

    public DocumentContext() {
        // Initial state
        this.state = new DraftState();
    }

    protected void setState(DocumentState state) {
        this.state = state;
    }

    public void publish() {
        state.publish(this);
    }

    public void edit() {
        state.edit(this);
    }
}

// Step 4: Client code
public class StatePtrn {
    public static void main(String[] args) {
        DocumentContext document = new DocumentContext();

        document.edit(); // Editing in Draft
        document.publish(); // Move to Moderation
        document.edit(); // Cannot edit in Moderation
        document.publish(); // Move to Published
        document.edit(); // Cannot edit in Published
    }
}

// TLDR:
// Step 1: Define the State interface
// Step 2: Define Concrete State classes
// Step 3: Create the Context class
// Step 4: Client code : client does not use the setState
// --------------------- (called by the concrete states)
