
// Step 1: Define the Mediator interface
interface ChatMediator {
    void showMessage(User user, String message);
}

// Step 2: Create the Concrete Mediator
class ChatRoom implements ChatMediator {
    @Override
    public void showMessage(User user, String message) {
        System.out.println(user.getName() + ": " + message);
    }
}

abstract class UserAbstract {
    protected String name;
    protected ChatMediator chatMediator; // # Must have a reference to the mediator

    public UserAbstract(String name, ChatMediator med) {
        this.chatMediator = med;
        this.name = name;
    }

    public abstract void sendMessage(String msg);

    // public abstract void receive(String msg);
}

// Step 3: Define a Colleague class
class User extends UserAbstract {

    public User(String name, ChatMediator chatMediator) {
        super(name, chatMediator);
    }

    public String getName() {
        return super.name;
    }

    public void sendMessage(String message) {
        chatMediator.showMessage(this, message); // # uses the mediator to send the message
    }
}

// Step 4: Client code
public class Mediat {
    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatRoom();

        UserAbstract user1 = new User("Alice", chatRoom);
        UserAbstract user2 = new User("Bob", chatRoom);

        user1.sendMessage("Hello, Bob!");
        user2.sendMessage("Hey, Alice!");
    }
}

// TLDR:
// Step 1: Define the Mediator interface
// Step 2: Create the Concrete Mediator
// Step 3: Define a Colleague class (must have a mediator reference)
// Step 4: Client code