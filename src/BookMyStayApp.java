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

class BookingService {
    public void processRequests(BookingRequestQueue queue) {
        System.out.println("Booking Request Queue\n");
        while (queue.hasPendingRequests()) {
            Reservation r = queue.getNextRequest();
            System.out.println("Processing booking for Guest: " + r.getGuestName() + ", Room Type: " + r.getRoomType());
        }
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        BookingRequestQueue queue = new BookingRequestQueue();

        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        queue.addRequest(r1);
        queue.addRequest(r2);
        queue.addRequest(r3);

        BookingService service = new BookingService();
        service.processRequests(queue);
    }
}