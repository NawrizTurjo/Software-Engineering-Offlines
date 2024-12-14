package StructuralPatterns;

import java.util.ArrayList;
import java.util.List;

interface iComponentComposite {
    public void operation();
}

class LeafClass implements iComponentComposite {
    private String name;

    public LeafClass(String name) {
        this.name = name;
    }

    public void operation() {
        System.out.println("Leaf-> " + name + " operation");
    }
}

class CompositeClass implements iComponentComposite {
    private String name;
    private List<iComponentComposite> children = new ArrayList<>();

    public CompositeClass(String name) {
        this.name = name;
    }

    public void add(iComponentComposite component) {
        children.add(component);
    }

    public void remove(iComponentComposite component) {
        children.remove(component);
    }

    public void operation() {
        System.out.println("Composite---> " + name + " operation");
        for (iComponentComposite component : children) {
            component.operation();
        }
    }
}

public class CompositePatternDemo {
    public static void main(String[] args) {
        CompositeClass root = new CompositeClass("root");
        root.add(new LeafClass("Leaf A"));
        root.add(new LeafClass("Leaf B"));

        CompositeClass comp = new CompositeClass("Composite X");
        comp.add(new LeafClass("Leaf XA"));
        comp.add(new LeafClass("Leaf XB"));

        root.add(comp);
        root.operation();
    }
}
