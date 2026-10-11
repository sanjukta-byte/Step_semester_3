
import java.util.Scanner;

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double rate();

    boolean hasNightService() {
        return false;
    }

    double fare(boolean night) {
        double amount = Math.max(100, km * rate());

        if (night) {
            amount *= 1.20;
        }

        return amount;
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double rate() {
        return 10;
    }
}

class Sedan extends Cab {
    Sedan(double km) {
        super(km);
    }

    double rate() {
        return 14;
    }

    boolean hasNightService() {
        return true;
    }
}

class SUV extends Cab {
    SUV(double km) {
        super(km);
    }

    double rate() {
        return 18;
    }

    boolean hasNightService() {
        return true;
    }
}

class CityCab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            boolean night = time.equals("NIGHT");
            Cab c;

            if (type.equals("MINI")) {
                c = new Mini(km);
            } else if (type.equals("SEDAN")) {
                c = new Sedan(km);
            } else {
                c = new SUV(km);
            }

            if (night && !c.hasNightService()) {
                System.out.println(type + ": night service not available");
            } else {
                double fare = c.fare(night);
                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
