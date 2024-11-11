import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface ComputerComponent {
    String getName();

    int getPrice();

    void showDetails();
}

class SmallerComponenet implements ComputerComponent {
    private String name;
    private int price;

    public SmallerComponenet(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public void showDetails() {
        System.out.println("Componnet--> Name: " + this.name + ", Price: " + this.price + "$");
    }

}

class BundleComputer implements ComputerComponent {
    private String name;
    private List<ComputerComponent> components = new ArrayList<>();

    public BundleComputer(String name) {
        this.name = name;
    }

    public void addComponent(ComputerComponent component) {
        components.add(component);
    }

    public void removeComponent(ComputerComponent component) {
        components.remove(component);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPrice() {
        int price = 0;
        for (ComputerComponent component : components) {
            price += component.getPrice();
        }
        return price;
    }

    @Override
    public void showDetails() {
        System.out.println("Bundle--> Name: " + this.name + ", Price: " + this.getPrice() + "$");
        for (ComputerComponent component : components) {
            component.showDetails();
        }
    }
}

public class Online {
    public static void main(String[] args) {
        ComputerComponent CPU = new SmallerComponenet("CPU", 250);
        ComputerComponent RAM8GB = new SmallerComponenet("RAM 8GB", 25);
        ComputerComponent HDD = new SmallerComponenet("HDD", 20);
        ComputerComponent GPU = new SmallerComponenet("GPU", 150);
        ComputerComponent SSD = new SmallerComponenet("SSD", 55);
        ComputerComponent RAM16GB = new SmallerComponenet("RAM 16GB", 25);

        BundleComputer gamingSetup = new BundleComputer("Gaming Setup");
        gamingSetup.addComponent(CPU);
        gamingSetup.addComponent(GPU);
        gamingSetup.addComponent(RAM8GB);
        gamingSetup.addComponent(SSD);

        BundleComputer ultimateBundle = new BundleComputer("Ultimate Bundle");
        ultimateBundle.addComponent(gamingSetup);
        ultimateBundle.addComponent(HDD);
        ultimateBundle.addComponent(RAM16GB);

        System.out.println("Gaming Setup price: " + gamingSetup.getPrice() + "$");
        System.out.println("8GB RAM price: " + RAM8GB.getPrice() + "$");

        ultimateBundle.showDetails();
        // Scanner sc = new Scanner(System.in);
        // class Pair {
        //     private String x;
        //     private ComputerComponent y;

        //     public Pair(String x, ComputerComponent y) {
        //         this.x = x;
        //         this.y = y;
        //     }

        //     public String getString() {
        //         return x;
        //     }

        //     public ComputerComponent getValue() {
        //         return y;
        //     }
        // }

        // List<Pair> hardwares = new ArrayList<>();
        // hardwares.add(new Pair("CPU", CPU));
        // hardwares.add(new Pair("RAM 8GB", RAM8GB));
        // hardwares.add(new Pair("HDD", HDD));
        // hardwares.add(new Pair("GPU", GPU));
        // hardwares.add(new Pair("SSD", SSD));
        // hardwares.add(new Pair("RAM 16GB", RAM16GB));
        // hardwares.add(new Pair("gaming", gamingSetup));

        // System.out.println("Press 1 to create a combo, 2 to view menu and 0 to exit");
        // int num;
        // while (sc.nextInt() != 0) {
        //     sc.nextInt();

        // }

    }
}
