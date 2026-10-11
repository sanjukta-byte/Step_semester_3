
import java.util.Scanner;

interface Vehicle {
    double charge();
}

class Bike implements Vehicle {
    int hours;

    Bike(int h) {
        hours = h;
    }

    public double charge() {
        return hours * 10;
    }
}

class Car implements Vehicle {
    int hours;

    Car(int h) {
        hours = h;
    }

    public double charge() {
        return 30 + (hours - 1) * 20;
    }
}

class Truck implements Vehicle {
    int hours;

    Truck(int h) {
        hours = h;
    }

    public double charge() {
        return Math.max(100, hours * 50);
    }
}

class ParkingCharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            Vehicle v;

            switch (type) {
                case "BIKE":
                    v = new Bike(hours);
                    break;
                case "CAR":
                    v = new Car(hours);
                    break;
                default:
                    v = new Truck(hours);
            }

            double result = v.charge();
            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
