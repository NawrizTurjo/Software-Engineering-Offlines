package CreationalPatterns.TemplateCode;

// Step 1: Define the product class
class Product {
    private String partA;
    private String partB;
    private String partC;

    // Setters for each part
    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    @Override
    public String toString() {
        return "Product [PartA=" + partA + ", PartB=" + partB + ", PartC=" + partC + "]";
    }
}

// Step 2: Define the Builder interface
interface Builder {
    void buildPartA();

    void buildPartB();

    void buildPartC();

    Product getResult();
}

// Step 3: Create concrete builders
class ConcreteBuilder1 implements Builder {
    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.setPartA("Builder1 - PartA");
    }

    @Override
    public void buildPartB() {
        product.setPartB("Builder1 - PartB");
    }

    @Override
    public void buildPartC() {
        product.setPartC("Builder1 - PartC");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

class ConcreteBuilder2 implements Builder {
    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.setPartA("Builder2 - PartA");
    }

    @Override
    public void buildPartB() {
        product.setPartB("Builder2 - PartB");
    }

    @Override
    public void buildPartC() {
        product.setPartC("Builder2 - PartC");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

// Step 4: Create the Director class
class Director {
    // private Builder builder;

    // public void setBuilder(Builder builder) {
    // this.builder = builder;
    // }

    public Product construct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}

// Step 5: Demonstrate the Builder Pattern
public class BuilderPatternDemo {
    public static void main(String[] args) {
        Director director = new Director();

        // Use ConcreteBuilder1
        Builder builder1 = new ConcreteBuilder1();
        // director.setBuilder(builder1);
        Product product1 = director.construct(builder1);
        System.out.println(product1);

        // Use ConcreteBuilder2
        Builder builder2 = new ConcreteBuilder2();
        // director.setBuilder(builder2);
        Product product2 = director.construct(builder2);
        System.out.println(product2);
    }
}
