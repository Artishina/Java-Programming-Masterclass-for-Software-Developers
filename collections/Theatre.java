package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Theatre {

    private String theatreName;
    private List<Seat> seats = new ArrayList<>();
 
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
      
        int low = 0;
        int high = seats.size() - 1;

        while (low <= high) {
            int midVal = (low + high) / 2;
            Seat midSeat = seats.get(midVal);
              
            int cmp = midSeat.getSeatNumber().compareTo(seatNumber);

            if (cmp < 0) {
                low = midVal + 1;
            }
            else if (cmp > 0) {
                high = midVal - 1;
            }
            else {
                return seats.get(midVal).reserve();
            }
        }

        System.out.println("There is no seat " + seatNumber);
        return false;
        
        /*
        Seat requestedSeat = new Seat(seatNumber); 
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);

        if (foundSeat > 0) {
            return seats.get(foundSeat).reserve();
        }
        else {
            System.out.println("No such seat");
            return false;
        }
        */
    }

    private class Seat implements Comparable<Seat> {
        private String seatNumber;
        private boolean reserved;

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

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


