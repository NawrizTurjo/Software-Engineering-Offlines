package res;

interface Mediator {
    void notify(Component sender, String event);
}

class ConcreteMediator implements Mediator {
    private ComponentA componentA;
    private ComponentB componentB;
    private ComponentC componentC;
    private ComponentD componentD;

    public void setComponentA(ComponentA componentA) {
        this.componentA = componentA;
    }

    public void setComponentB(ComponentB componentB) {
        this.componentB = componentB;
    }

    public void setComponentC(ComponentC componentC) {
        this.componentC = componentC;
    }

    public void setComponentD(ComponentD componentD) {
        this.componentD = componentD;
    }

    @Override
    public void notify(Component sender, String event) {
        if (sender == componentA) {
            System.out.println("Component A triggered event: " + event);
            componentB.reactOnEvent(event);
        } else if (sender == componentB) {
            System.out.println("Component B triggered event: " + event);
            componentA.reactOnEvent(event);
        } else if (sender == componentC) {
            System.out.println("Component C triggered event: " + event);
            componentD.reactOnEvent(event);
        } else if (sender == componentD) {
            System.out.println("Component D triggered event: " + event);
            componentC.reactOnEvent(event);
        }
    }
}

abstract class Component {
    protected Mediator mediator;

    public Component(Mediator mediator) {
        this.mediator = mediator;
    }

    public void triggerEvent(String event) {
        mediator.notify(this, event);
    }

    public abstract void reactOnEvent(String event);
}

class ComponentA extends Component {
    public ComponentA(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void reactOnEvent(String event) {
        System.out.println("Component A reacted to event: " + event);
    }
}

class ComponentB extends Component {
    public ComponentB(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void reactOnEvent(String event) {
        System.out.println("Component B reacted to event: " + event);
    }
}

class ComponentC extends Component {
    public ComponentC(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void reactOnEvent(String event) {
        System.out.println("Component C reacted to event: " + event);
    }
}

class ComponentD extends Component {
    public ComponentD(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void reactOnEvent(String event) {
        System.out.println("Component D reacted to event: " + event);
    }
}

public class MulMed {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        ComponentA componentA = new ComponentA(mediator);
        ComponentB componentB = new ComponentB(mediator);
        ComponentC componentC = new ComponentC(mediator);
        ComponentD componentD = new ComponentD(mediator);

        mediator.setComponentA(componentA);
        mediator.setComponentB(componentB);
        mediator.setComponentC(componentC);
        mediator.setComponentD(componentD);

        componentA.triggerEvent("Event 1");
        componentB.triggerEvent("Event 2");
        componentC.triggerEvent("Event 3");
        componentD.triggerEvent("Event 4");
    }
}
