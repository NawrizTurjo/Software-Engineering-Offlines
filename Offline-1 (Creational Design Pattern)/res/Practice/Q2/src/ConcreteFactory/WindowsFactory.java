package ConcreteFactory;

import ConcreteProducts.*;
import Factory.GUIFactory;
import Interfaces.*;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Textfield createTextfield() {
        return new WindowsTextfield();
    }
    
}
