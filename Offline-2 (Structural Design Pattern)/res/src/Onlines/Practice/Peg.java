package Onlines.Practice;

// Provided RoundHole class
class RoundHole {
    private double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    // Method to check if a peg fits the hole
    public boolean fits(RoundPeg peg) {
        return this.radius >= peg.getRadius();
    }
}

// Provided RoundPeg class
class RoundPeg {
    private double radius;

    public RoundPeg(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

// Provided SquarePeg class that we cannot modify
class SquarePeg {
    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }
}

// Adapter class to make SquarePeg compatible with RoundHole
class SquarePegAdapter extends RoundPeg {
    private SquarePeg squarePeg;

    public SquarePegAdapter(SquarePeg squarePeg) {
        super(0); // Call to the RoundPeg constructor with a default radius
        this.squarePeg = squarePeg;
    }

    @Override
    public double getRadius() {
        // Calculate the minimum radius that can fit the square peg
        return (squarePeg.getWidth() * Math.sqrt(2)) / 2;
    }
}

// Main class to test the adapter
public class Peg {
    public static void main(String[] args) {
        // Creating a RoundHole with a specific radius
        RoundHole hole = new RoundHole(5);

        // Creating a RoundPeg with a radius of 5
        RoundPeg roundPeg = new RoundPeg(5);
        System.out.println("Does round peg fit? " + hole.fits(roundPeg));  // Output: true

        // Creating a SquarePeg with a width of 5
        SquarePeg smallSquarePeg = new SquarePeg(5);
        SquarePegAdapter smallSquarePegAdapter = new SquarePegAdapter(smallSquarePeg);
        System.out.println("Does small square peg fit? " + hole.fits(smallSquarePegAdapter));  // Output: true

        // Creating a larger SquarePeg with a width of 10
        SquarePeg largeSquarePeg = new SquarePeg(10);
        SquarePegAdapter largeSquarePegAdapter = new SquarePegAdapter(largeSquarePeg);
        System.out.println("Does large square peg fit? " + hole.fits(largeSquarePegAdapter));  // Output: false
    }
}

