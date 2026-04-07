import java.util.*;

class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

class BookingRequestQueue {
    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}

class RoomInventory {
    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    public int getAvailableRooms(String roomType) {
        return roomAvailability.getOrDefault(roomType, 0);
    }

    public void reduceRoomCount(String roomType) {
        roomAvailability.put(roomType, roomAvailability.get(roomType) - 1);
    }
}

class RoomAllocationService {
    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String roomType = reservation.getRoomType();

        if (inventory.getAvailableRooms(roomType) <= 0) {
            System.out.println("No rooms available for Guest: " + reservation.getGuestName());
            return;
        }

        String roomId = generateRoomId(roomType);

        allocatedRoomIds.add(roomId);

        assignedRoomsByType.putIfAbsent(roomType, new HashSet<>());
        assignedRoomsByType.get(roomType).add(roomId);

        inventory.reduceRoomCount(roomType);

        System.out.println("Booking confirmed for Guest: " + reservation.getGuestName() + ", Room ID: " + roomId);
    }

    private String generateRoomId(String roomType) {
        int count = assignedRoomsByType.getOrDefault(roomType, new HashSet<>()).size() + 1;
        return roomType + "-" + count;
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {

        System.out.println("Room Allocation Processing\n");

        BookingRequestQueue queue = new BookingRequestQueue();

        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Subha", "Single"));
        queue.addRequest(new Reservation("Vanmathi", "Suite"));

        RoomInventory inventory = new RoomInventory();
        RoomAllocationService service = new RoomAllocationService();

        while (queue.hasPendingRequests()) {
            Reservation r = queue.getNextRequest();
            service.allocateRoom(r, inventory);
        }
    }
}