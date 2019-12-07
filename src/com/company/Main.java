package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String seatNumber;
        Theatre theatre = new Theatre("TAW", 5, 10);
        theatre.getSeats();
        System.out.println("Enter the seat which you want to reserve : ");
        seatNumber = scanner.nextLine();
        if (theatre.reserveSeat(seatNumber))
            System.out.println("Please pay for the seat !");
        else
            System.out.println("Sorry,seat is taken !");
    }
}
