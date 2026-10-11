
import java.util.Scanner;

interface Question {
    double grade();
}

class MCQ implements Question {
    String correct, answer;
    double points;

    MCQ(String c, String a, double p) {
        correct = c;
        answer = a;
        points = p;
    }

    public double grade() {
        return answer.equalsIgnoreCase(correct) ? points : 0;
    }
}

class TrueFalse implements Question {
    String correct, answer;
    double points;

    TrueFalse(String c, String a, double p) {
        correct = c;
        answer = a;
        points = p;
    }

    public double grade() {
        return answer.equalsIgnoreCase(correct) ? points : 0;
    }
}

class Essay implements Question {
    String keywords, answer;
    double points;

    Essay(String k, String a, double p) {
        keywords = k;
        answer = a;
        points = p;
    }

    public double grade() {
        String[] words = keywords.split(",");
        int count = 0;

        for (String word : words) {
            if (answer.toLowerCase().contains(word.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) return points * 0.75;
        if (count == 1) return points * 0.50;
        return 0;
    }
}

class QuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\"");
            String type = parts[0].trim();
            String correct = parts[2].trim();
            String answer = parts[4].trim();
            double points = Double.parseDouble(parts[5].trim());
            Question q;

            if (type.equals("MCQ")) {
                q = new MCQ(correct, answer, points);
            } else if (type.equals("TF")) {
                q = new TrueFalse(correct, answer, points);
            } else {
                q = new Essay(correct, answer, points);
            }

            double score = q.grade();
            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
