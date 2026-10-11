
import java.util.Scanner;

interface Transport {
    double fare();
}

class Bus implements Transport {
    double distance;

    Bus(double d) {
        distance = d;
    }

    public double fare() {
        return Math.min(10, 2 + 0.10 * distance);
    }
}

class Train implements Transport {
    double distance;

    Train(double d) {
        distance = d;
    }

    public double fare() {
        return 3 + 0.15 * distance;
    }
}

class Metro implements Transport {
    double distance, factor;

    Metro(double d, double f) {
        distance = d;
        factor = f;
    }

    public double fare() {
        return (1.50 + 0.20 * distance) * factor;
    }
}

class TransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            Transport t;

            if (type.equals("BUS")) {
                t = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                t = new Train(distance);
            } else {
                double factor = sc.nextDouble();
                t = new Metro(distance, factor);
            }

            double fare = t.fare();
            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
