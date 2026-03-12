abstract class Room {

    protected int numberofbeds;
    protected int squarefeet;
    protected double pricepernight;

    public Room(int numberofbeds, int squarefeet, double pricepernight) {
        this.numberofbeds = numberofbeds;
        this.squarefeet = squarefeet;
        this.pricepernight = pricepernight;
    }

    public void displayroomdetails() {
        System.out.println("Number of beds: " + numberofbeds);
        System.out.println("Square feet: " + squarefeet);
        System.out.println("Price per night: " + pricepernight);
    }
}

class SingleRoom extends Room {
    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}
public class BookMyStayApp {
    public static void main(String[] args) {

        Room single = new SingleRoom();
        Room doub = new DoubleRoom();
        Room suite = new SuiteRoom();

        System.out.println("Single Room Details:");
        single.displayroomdetails();

        System.out.println();

        System.out.println("Double Room Details:");
        doub.displayroomdetails();

        System.out.println();

        System.out.println("Suite Room Details:");
        suite.displayroomdetails();
    }
}