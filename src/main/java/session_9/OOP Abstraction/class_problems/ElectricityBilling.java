
import java.util.Scanner;

abstract class Connection {
    int units;

    Connection(int u) {
        units = u;
    }

    abstract double bill();
}

class HomeConnection extends Connection {
    HomeConnection(int u) {
        super(u);
    }

    double bill() {
        if (units <= 100) return units * 5.0;
        return 500 + (units - 100) * 7.0;
    }
}

class ShopConnection extends Connection {
    ShopConnection(int u) {
        super(u);
    }

    double bill() {
        return units * 8.0 + 100;
    }
}

class FactoryConnection extends Connection {
    FactoryConnection(int u) {
        super(u);
    }

    double bill() {
        return Math.max(units * 6.0, 1000);
    }
}

class ElectricityBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Connection c;

            if (type.equals("HOME")) {
                c = new HomeConnection(units);
            } else if (type.equals("SHOP")) {
                c = new ShopConnection(units);
            } else {
                c = new FactoryConnection(units);
            }

            double b = c.bill();
            System.out.printf("%s: %.2f%n", type, b);
            total += b;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
