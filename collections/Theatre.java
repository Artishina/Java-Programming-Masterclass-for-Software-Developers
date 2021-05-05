package collections;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    private String theatreName;
    private List<Seat> seats = new ArrayList<Seat>();
 
    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row < lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = null;

        for (Seat seat: seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                requestedSeat = seat;
                break;
            }
        }

        if (requestedSeat == null) {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

        return requestedSeat.reserve();
    }

    private class Seat {
        private String seatNumber;
        private boolean reserved;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " is reserved");
                return true;
            }
            else {
                System.out.println("Sorry the seat " + seatNumber + " is taken");
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Seat " + seatNumber + " reservation is cancelled");
                return true;
            }
            else {
                return false;
            }
        }
    }

     // for testing
     public void getSeats() {
        for(Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }
}


