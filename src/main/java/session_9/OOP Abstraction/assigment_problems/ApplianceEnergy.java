
import java.util.Scanner;

abstract class Appliance {
    double hours;

    Appliance(double h) {
        hours = h;
    }

    abstract double power();

    boolean supportsSaver() {
        return false;
    }

    double units(boolean saver) {
        double u = power() * hours / 1000;
        return saver ? u * 0.75 : u;
    }
}

class Fridge extends Appliance {
    Fridge(double h) {
        super(h);
    }

    double power() {
        return 150;
    }
}

class AC extends Appliance {
    AC(double h) {
        super(h);
    }

    double power() {
        return 1500;
    }

    boolean supportsSaver() {
        return true;
    }
}

class TV extends Appliance {
    TV(double h) {
        super(h);
    }

    double power() {
        return 100;
    }
}

class Washer extends Appliance {
    Washer(double h) {
        super(h);
    }

    double power() {
        return 500;
    }

    boolean supportsSaver() {
        return true;
    }
}

class ApplianceEnergy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            String type = input[0];
            double hours = Double.parseDouble(input[1]);
            boolean saver = input.length == 3
                    && input[2].equals("SAVER");
            Appliance a;

            if (type.equals("FRIDGE")) {
                a = new Fridge(hours);
            } else if (type.equals("AC")) {
                a = new AC(hours);
            } else if (type.equals("TV")) {
                a = new TV(hours);
            } else {
                a = new Washer(hours);
            }

            if (saver && !a.supportsSaver()) {
                System.out.println(type + ": saver mode not supported");
            } else {
                double units = a.units(saver);
                double cost = units * 8;
                System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n", type, units, cost
                );
                total += cost;
            }
        }

        System.out.printf("Total Cost: %.2f%n", total);
        sc.close();
    }
}
