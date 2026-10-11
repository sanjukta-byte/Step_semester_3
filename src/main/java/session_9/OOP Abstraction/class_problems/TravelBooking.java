
import java.util.Scanner;

abstract class Booking {
    static final double FEE = 50;
    double distance;

    Booking(double d) {
        distance = d;
    }

    abstract double baseFare();

    double totalFare() {
        return baseFare() + FEE;
    }
}

class BusBooking extends Booking {
    BusBooking(double d) {
        super(d);
    }

    double baseFare() {
        return distance * 2;
    }
}

class TrainBooking extends Booking {
    TrainBooking(double d) {
        super(d);
    }

    double baseFare() {
        return distance * 1.5;
    }
}

class FlightBooking extends Booking {
    FlightBooking(double d) {
        super(d);
    }

    double baseFare() {
        return 2500 + distance * 4;
    }
}

class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            Booking b;

            if (mode.equals("BUS")) {
                b = new BusBooking(distance);
            } else if (mode.equals("TRAIN")) {
                b = new TrainBooking(distance);
            } else {
                b = new FlightBooking(distance);
            }

            System.out.printf("%s: %.2f%n",
                              mode, b.totalFare());
        }

        sc.close();
    }
}
