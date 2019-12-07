package com.company;

import java.util.*;

public class Theatre {
    private List<Seat> seatList = new ArrayList<Seat>();
    private final String name;

    public Theatre(String name, int numRows, int seatPerRow) {
        this.name = name;
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seatList.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return this.name;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seatList, requestSeat, null);
        if (foundSeat >= 0) {
            return seatList.get(foundSeat).reserve();
        } else {
            System.out.println("There is not such kind of seat " + seatNumber);
            return false;
        }
//        for (Seat seat : seatList) {
//            if (seat.getSeatNumber().equalsIgnoreCase(seatNumber)) {
//                requestSeat = seat;
//                break;
//            }
//        }
//        if (requestSeat == null) {
//            System.out.println("There is no seat " + seSystem.out.println();atNumber);
//            return false;
//        }
//        return requestSeat.reserve();
    }

    public void getSeats() {
        int i = 0;
        for (Seat seat : seatList) {
            System.out.print(seat.getSeatNumber() + "\t");
            if ((i + 1) % 5 == 0)
                System.out.println();
            i++;
        }
    }

    private class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat" + seatNumber + " reserved !");
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int compareTo(Seat object) {
            return this.seatNumber.compareToIgnoreCase(object.getSeatNumber());
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled !");
                return true;
            } else
                return false;
        }

        public String getSeatNumber() {
            return seatNumber;
        }
    }
}
