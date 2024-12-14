package StructuralPatterns.Onlines.B2;

// Component interface representing the basic hardware component
interface Component {
    double getPrice();

    String getDescription();
}

// Concrete Component representing individual hardware components
class HardwareComponent implements Component {
    private String name;
    private double price;

    public HardwareComponent(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return name;
    }
}

class HardwareComponentDecorator implements Component {
    protected Component component;

    public HardwareComponentDecorator(Component component) {
        this.component = component;
    }

    @Override
    public double getPrice() {
        return component.getPrice();
    }

    @Override
    public String getDescription() {
        return component.getDescription();
    }
}

class ExtendedWarranty extends HardwareComponentDecorator {
    public ExtendedWarranty(Component component) {
        super(component);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 100;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Extended Warranty";
    }
}

class InstallitionService extends HardwareComponentDecorator {
    public InstallitionService(Component component) {
        super(component);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 50;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Installation Service";
    }
}

class PerformenceBoost extends HardwareComponentDecorator {
    public PerformenceBoost(Component component) {
        super(component);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 200;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Performance Boost";
    }
}

public class B2Online {
    public static void main(String[] args) {
        Component component = new HardwareComponent("Graphics Card", 500);
        System.out.println("Component: " + component.getDescription() + ", Price: " + component.getPrice());

        Component extendedWarranty = new ExtendedWarranty(component);
        System.out
                .println("Component: " + extendedWarranty.getDescription() + ", Price: " + extendedWarranty.getPrice());

        Component installationService = new InstallitionService(extendedWarranty);
        System.out.println(
                "Component: " + installationService.getDescription() + ", Price: " + installationService.getPrice());

        Component performanceBoost = new PerformenceBoost(installationService);
        System.out
                .println("Component: " + performanceBoost.getDescription() + ", Price: " + performanceBoost.getPrice());
    }
}