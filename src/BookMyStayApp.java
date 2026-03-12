import java.util.*;

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

class RoomInventory {
    int RoomsAvailable;
    int roomtype;

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        roomAvailability.put("Single:", 5);
        roomAvailability.put("Double:", 3);
        roomAvailability.put("Suite:", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}

class RoomSearchService {
    public void searchAvailableRooms(RoomInventory inventory, Room SingleRoom, Room DoubleRoom, Room SuiteRoom) {

        System.out.println("RoomSearch");
        System.out.println();
        if (inventory.getRoomAvailability().get("Single:") > 0) {
            System.out.println("\nSingle Room:");
            SingleRoom.displayroomdetails();
            System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Single:"));
        }
        System.out.println();
        if (inventory.getRoomAvailability().get("Double:") > 0) {
            System.out.println("\nDouble Room:");
            DoubleRoom.displayroomdetails();
            System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Double:"));
        }
        System.out.println();
        if (inventory.getRoomAvailability().get("Suite:") > 0) {
            System.out.println("\nSuite Room:");
            SuiteRoom.displayroomdetails();
            System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Suite:"));
        }
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {

        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        RoomInventory inventory = new RoomInventory();

        RoomSearchService service = new RoomSearchService();

        service.searchAvailableRooms(inventory, singleRoom, doubleRoom, suiteRoom);
    }
}