package Client;

import Factory.GUIFactory;
import Interfaces.*;

public class Application {
    private Button button;
    private Textfield textfield;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        textfield = factory.createTextfield();
    }

    public void render() {
        button.printButtonType();
        textfield.printTextfieldType();
    }

}
