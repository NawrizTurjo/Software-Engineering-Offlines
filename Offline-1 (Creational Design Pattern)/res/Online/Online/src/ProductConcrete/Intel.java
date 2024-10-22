package ProductConcrete;

import ProductInterface.Processors;

public class Intel implements Processors {

    @Override
    public void printProcessor() {
        System.out.println("Intel Xeon Processor");
    }

}
