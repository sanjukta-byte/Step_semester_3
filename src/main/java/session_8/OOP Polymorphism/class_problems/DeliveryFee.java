
import java.util.Scanner;

interface Delivery {
    double calculate();
}

class StandardDelivery implements Delivery {
    double weight, distance;

    StandardDelivery(double w, double d) {
        weight = w;
        distance = d;
    }

    public double calculate() {
        return 5 + 0.50 * weight + 0.10 * distance;
    }
}

class ExpressDelivery implements Delivery {
    double weight, distance;

    ExpressDelivery(double w, double d) {
        weight = w;
        distance = d;
    }

    public double calculate() {
        return 15 + weight + 0.20 * distance;
    }
}

class InternationalDelivery implements Delivery {
    double weight, distance, customs;

    InternationalDelivery(double w, double d, double c) {
        weight = w;
        distance = d;
        customs = c;
    }

    public double calculate() {
        return 25 + 2 * weight + 0.50 * distance + customs;
    }
}

class DeliveryFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            Delivery d;

            if (type.equals("STANDARD")) {
                d = new StandardDelivery(weight, distance);
            } else if (type.equals("EXPRESS")) {
                d = new ExpressDelivery(weight, distance);
            } else {
                double customs = sc.nextDouble();
                d = new InternationalDelivery(weight, distance, customs);
            }

            double fee = d.calculate();
            System.out.printf("%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
