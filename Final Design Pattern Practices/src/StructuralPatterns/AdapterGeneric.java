package StructuralPatterns;

interface iAdaptee {
    public void specificRequest();
}

class Adaptee implements iAdaptee {
    public void specificRequest() {
        System.out.println("Specific Request");
    }
}

interface iTarget {
    public void request();
}

class Adapter implements iTarget {
    private iAdaptee adaptee;

    public Adapter(iAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        adaptee.specificRequest();
    }
}

public class AdapterGeneric {
    public static void main(String[] args) {
        iAdaptee adaptee = new Adaptee();
        iTarget target = new Adapter(adaptee);
        target.request();
    }
}
