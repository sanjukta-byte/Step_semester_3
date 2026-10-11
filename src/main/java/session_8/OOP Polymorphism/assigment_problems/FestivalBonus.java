
import java.util.Scanner;

interface Employee {
    double bonus();
}

class FullTime implements Employee {
    String name;
    double salary;

    FullTime(String n, double s) {
        name = n;
        salary = s;
    }

    public double bonus() {
        return salary * 0.10;
    }
}

class PartTime implements Employee {
    String name;
    double salary;

    PartTime(String n, double s) {
        name = n;
        salary = s;
    }

    public double bonus() {
        return salary * 0.05;
    }
}

class Intern implements Employee {
    String name;

    Intern(String n) {
        name = n;
    }

    public double bonus() {
        return 2000;
    }
}

class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            Employee e;

            switch (type) {
                case "FULLTIME":
                    e = new FullTime(name, salary);
                    break;
                case "PARTTIME":
                    e = new PartTime(name, salary);
                    break;
                default:
                    e = new Intern(name);
            }

            double result = e.bonus();
            System.out.printf("%s: %.2f%n", name, result);
            total += result;
        }

        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}
