package CreationalPatterns;
interface Builder {
    void buildPart1();

    void buildPart2();

    void buildPart3();

    Product getResult();
}

class ConcreteBuilderA implements Builder {
    private Product product = new Product();

    public void buildPart1() {
        product.setPart1("Part1A");
    }

    public void buildPart2() {
        product.setPart2("Part2A");
    }

    public void buildPart3() {
        product.setPart3("Part3A");
    }

    public Product getResult() {
        return product;
    }
}

class ConcreteBuilderB implements Builder {
    private Product product = new Product();

    public void buildPart1() {
        product.setPart1("Part1B");
    }

    public void buildPart2() {
        product.setPart2("Part2B");
    }

    public void buildPart3() {
        product.setPart3("Part3B");
    }

    public Product getResult() {
        return product;
    }
}

class Product {
    private String part1;
    private String part2;
    private String part3;

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public void setPart3(String part3) {
        this.part3 = part3;
    }

    public void show() {
        System.out.println(part1);
        System.out.println(part2);
        System.out.println(part3);
    }
}

class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildPart1();
        builder.buildPart2();
        builder.buildPart3();
    }
}

public class BuilderDemo {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilderA();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.getResult();
        product.show();
    }
}
