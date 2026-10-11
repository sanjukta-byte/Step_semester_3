
import java.util.Scanner;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double pay();
}

class FullTimeStaff extends Staff {
    double salary;

    FullTimeStaff(String n, double s) {
        super(n);
        salary = s;
    }

    double pay() {
        return salary;
    }
}

class HourlyStaff extends Staff {
    double hours, rate;

    HourlyStaff(String n, double h, double r) {
        super(n);
        hours = h;
        rate = r;
    }

    double pay() {
        return Math.min(hours, 40) * rate
             + Math.max(0, hours - 40) * rate * 1.5;
    }
}

class InternStaff extends Staff {
    double stipend;

    InternStaff(String n, double s) {
        super(n);
        stipend = s;
    }

    double pay() {
        return stipend;
    }
}

class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Staff s;

            if (type.equals("FULLTIME")) {
                s = new FullTimeStaff(name, sc.nextDouble());
            } else if (type.equals("HOURLY")) {
                s = new HourlyStaff(name, sc.nextDouble(),
                                    sc.nextDouble());
            } else {
                s = new InternStaff(name, sc.nextDouble());
            }

            double p = s.pay();
            System.out.printf("%s: %.2f%n", name, p);
            total += p;
        }

        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}
