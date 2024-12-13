

class Numbers {
    public double a, b, c;

    public Numbers(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

interface QuadInterface {
    void handleRequest(Numbers request);
}

class NoSolutionHandler implements QuadInterface {
    private QuadInterface nextChain;

    public NoSolutionHandler(QuadInterface nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void handleRequest(Numbers request) {
        if (request.a == 0 && request.b == 0) {
            System.out.println("No solution");
        } else {
            nextChain.handleRequest(request);
        }
    }
}

class LinearHandler implements QuadInterface {
    private QuadInterface nextChain;

    public LinearHandler(QuadInterface nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void handleRequest(Numbers request) {
        if (request.a == 0) {
            System.out.println("Linear equation: x = " + (-request.c / request.b));
        } else {
            nextChain.handleRequest(request);
        }
    }
}

class SingleSolutionHandler implements QuadInterface {
    private QuadInterface nextChain;

    public SingleSolutionHandler(QuadInterface nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void handleRequest(Numbers request) {
        double d = request.b * request.b - 4 * request.a * request.c;
        if (d == 0) {
            System.out.println("Single solution: x = " + (-request.b / (2 * request.a)));
        } else {
            nextChain.handleRequest(request);
        }
    }
}

class RealSolutionHandler implements QuadInterface {
    private QuadInterface nextChain;

    public RealSolutionHandler(QuadInterface nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void handleRequest(Numbers request) {
        double d = request.b * request.b - 4 * request.a * request.c;
        if (d > 0) {
            double x1 = (-request.b + Math.sqrt(d)) / (2 * request.a);
            double x2 = (-request.b - Math.sqrt(d)) / (2 * request.a);
            System.out.println("Real solutions: x1 = " + x1 + ", x2 = " + x2);
        } else {
            nextChain.handleRequest(request);
        }
    }
}

class ComplexSolutionHandler implements QuadInterface {
    private QuadInterface nextChain;

    public ComplexSolutionHandler(QuadInterface nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void handleRequest(Numbers request) {
        double d = request.b * request.b - 4 * request.a * request.c;
        if (d < 0) {
            double real = -request.b / (2 * request.a);
            // System.out.println("b=" + request.b);
            double imaginary = Math.sqrt(-d) / (2 * request.a);
            System.out.println("Complex solutions: x1 = " + real + " + " + imaginary + "i, x2 = " + real + " - "
                    + imaginary + "i");
        } else {
            nextChain.handleRequest(request);
        }
    }
}

public class QuadCOR {
    public static QuadInterface getChain() {
        QuadInterface complexSolutionHandler = new ComplexSolutionHandler(null);
        QuadInterface realSolutionHandler = new RealSolutionHandler(complexSolutionHandler);
        QuadInterface singleSolutionHandler = new SingleSolutionHandler(realSolutionHandler);
        QuadInterface linearHandler = new LinearHandler(singleSolutionHandler);
        QuadInterface noSolutionHandler = new NoSolutionHandler(linearHandler);

        return noSolutionHandler;
    }

    public static void main(String[] args) {
        QuadInterface chain = getChain();
        Numbers request = new Numbers(0, 0, 0);
        chain.handleRequest(request);
        Numbers request1 = new Numbers(0, 0, 1);
        chain.handleRequest(request1);
        Numbers request2 = new Numbers(0, 1, 1);
        chain.handleRequest(request2);
        Numbers request3 = new Numbers(1, 2, 1);
        chain.handleRequest(request3);
        Numbers request4 = new Numbers(1, 2, 1);
        chain.handleRequest(request4);
        Numbers request5 = new Numbers(1, 1, 1);
        chain.handleRequest(request5);
    }
}
