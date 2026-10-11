
import java.util.Scanner;

abstract class Parcel {
    double weight, value;

    Parcel(double w, double v) {
        weight = w;
        value = v;
    }

    abstract double charge();

    double insurance() {
        return 0;
    }

    double total() {
        return charge() + insurance();
    }
}

interface Insurable {
    double insurance();
}

class StandardParcel extends Parcel {
    StandardParcel(double w, double v) {
        super(w, v);
    }

    double charge() {
        return 40 + 10 * weight;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double w, double v) {
        super(w, v);
    }

    double charge() {
        return 80 + 15 * weight;
    }

    public double insurance() {
        return value * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double w, double v) {
        super(w, v);
    }

    double charge() {
        return 40 + 10 * weight + 50;
    }

    public double insurance() {
        return value * 0.02;
    }
}

class ParcelShipping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grand = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            Parcel p;

            if (type.equals("STANDARD")) {
                p = new StandardParcel(weight, value);
            } else if (type.equals("EXPRESS")) {
                p = new ExpressParcel(weight, value);
            } else {
                p = new FragileParcel(weight, value);
            }

            double insurance = p instanceof Insurable
                    ? ((Insurable) p).insurance() : 0;
            double total = p.charge() + insurance;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, p.charge(), insurance, total
            );

            grand += total;
        }

        System.out.printf("Grand Total: %.2f%n", grand);
        sc.close();
    }
}
