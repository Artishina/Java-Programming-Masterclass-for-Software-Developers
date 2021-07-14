package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.*;

public class Theatre {

    private String theatreName;
    private List<Seat> seats = new ArrayList<>();

    static final Comparator<Seat> PRICE_ORDER;
    static final Comparator<Seat> SEATNUM_ORDER;

    static {
        PRICE_ORDER = new Comparator<Seat>() {
            @Override
            public int compare(Seat seat1, Seat seat2) {
                if (seat1.getPrice() < seat2.getPrice()) {
                    return -1;
                } else if (seat1.getPrice() > seat2.getPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
    }

    static {
        SEATNUM_ORDER = new Comparator<Seat>() {
            @Override
            public int compare(Seat seat1, Seat seat2) {
                return seat1.getSeatNumber().compareTo(seat2.getSeatNumber());
            }
        };
    }
 
    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row < lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12.00;

                if((row < 'D') && (seatNum >=4 && seatNum <=9)) {
                    price = 14.00;
                } else if((row > 'F') || (seatNum < 4 || seatNum > 9)) {
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber, 0); 
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);

        if (foundSeat > 0) {
            return seats.get(foundSeat).reserve();
        }
        else {
            System.out.println("No such seat");
            return false;
        }                                  
    }

    public class Seat implements Comparable<Seat> {
        private String seatNumber;
        private boolean reserved;
        private double price;

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
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
     public Collection<Seat> getSeats() {
        return seats;        
    }
}


