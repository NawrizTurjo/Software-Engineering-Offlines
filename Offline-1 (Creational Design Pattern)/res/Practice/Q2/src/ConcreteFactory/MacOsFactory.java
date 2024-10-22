package ConcreteFactory;

import ConcreteProducts.*;
import Factory.GUIFactory;
import Interfaces.*;

public class MacOsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOsButton();
    }

    @Override
    public Textfield createTextfield() {
        return new MacOsTextfield();
    }
    
}
