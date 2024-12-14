package StructuralPatterns.TemplateCode;

import java.util.ArrayList;
import java.util.List;

// Step 1: Define the Component interface
interface Component {
    void operation();
}

// Step 2: Create Leaf class
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Leaf: " + name);
    }
}

// Step 3: Create Composite class
class Composite implements Component {
    private String name;
    private List<Component> children = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    public List<Component> getChildren() {
        return children;
    }

    @Override
    public void operation() {
        System.out.println("Composite: " + name);
        for (Component child : children) {
            child.operation();
        }
    }
}

// Step 4: Demonstrate the Composite Pattern
public class CompositePatternDemo {
    public static void main(String[] args) {
        // Create leaf nodes
        Leaf leaf1 = new Leaf("Leaf 1");
        Leaf leaf2 = new Leaf("Leaf 2");

        // Create composite nodes
        Composite composite1 = new Composite("Composite 1");
        Composite composite2 = new Composite("Composite 2");

        // Build the tree structure
        composite1.add(leaf1);
        composite1.add(leaf2);

        composite2.add(composite1);

        // Perform operation
        composite2.operation();
    }
}

