
import java.util.Scanner;
import java.time.LocalDate;

interface Plan {
    LocalDate renewalDate(LocalDate start);
}

class BasicPlan implements Plan {
    public LocalDate renewalDate(LocalDate start) {
        return start.plusDays(30);
    }
}

class StandardPlan implements Plan {
    public LocalDate renewalDate(LocalDate start) {
        return start.plusDays(90);
    }
}

class PremiumPlan implements Plan {
    public LocalDate renewalDate(LocalDate start) {
        return start.plusDays(365);
    }
}

class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate start = LocalDate.parse(sc.next());
            Plan p;

            switch (type) {
                case "BASIC":
                    p = new BasicPlan();
                    break;
                case "STANDARD":
                    p = new StandardPlan();
                    break;
                default:
                    p = new PremiumPlan();
            }

            System.out.println(name + ": " + p.renewalDate(start));
        }

        sc.close();
    }
}
