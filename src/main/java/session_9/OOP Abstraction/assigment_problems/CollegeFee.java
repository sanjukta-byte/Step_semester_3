
import java.util.Scanner;

abstract class Student {
    String name;

    Student(String n) {
        name = n;
    }

    abstract double tuition();

    boolean usesBus() {
        return false;
    }

    double totalFee() {
        return tuition() + (usesBus() ? 12000 : 0);
    }
}

class DayScholar extends Student {
    DayScholar(String n) {
        super(n);
    }

    double tuition() {
        return 40000;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String n) {
        super(n);
    }

    double tuition() {
        return 100000;
    }
}

class Scholar extends Student {
    Scholar(String n) {
        super(n);
    }

    double tuition() {
        return 20000;
    }

    boolean usesBus() {
        return true;
    }
}

class CollegeFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student s;

            if (type.equals("DAY_SCHOLAR")) {
                s = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                s = new Hosteller(name);
            } else {
                s = new Scholar(name);
            }

            double fee = s.totalFee();
            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
