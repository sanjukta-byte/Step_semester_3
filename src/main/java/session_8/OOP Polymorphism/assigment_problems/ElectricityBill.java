
import java.util.Scanner;

interface Room {
    double bill();
}

class SingleRoom implements Room {
    int units;

    SingleRoom(int u) {
        units = u;
    }

    public double bill() {
        return units * 8;
    }
}

class SharedRoom implements Room {
    int units, occupants;

    SharedRoom(int u, int o) {
        units = u;
        occupants = o;
    }

    public double bill() {
        return units * 6.0 / occupants;
    }
}

class AcRoom implements Room {
    int units;

    AcRoom(int u) {
        units = u;
    }

    public double bill() {
        return units * 10 + 200;
    }
}

class ElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Room r;

            if (type.equals("SINGLE")) {
                r = new SingleRoom(units);
            } else if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                r = new SharedRoom(units, occupants);
            } else {
                r = new AcRoom(units);
            }

            double result = r.bill();
            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
