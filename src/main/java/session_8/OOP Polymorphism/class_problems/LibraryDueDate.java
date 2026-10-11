
import java.util.Scanner;
import java.time.LocalDate;

interface LibraryItem {
    LocalDate dueDate();
}

class Book implements LibraryItem {
    public LocalDate dueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(14);
    }
}

class DVD implements LibraryItem {
    public LocalDate dueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(7);
    }
}

class Magazine implements LibraryItem {
    public LocalDate dueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(3);
    }
}

class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            int first = line.indexOf('"');
            int last = line.lastIndexOf('"');

            String type = line.substring(0, first).trim();
            String title = line.substring(first + 1, last);
            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book();
                    break;
                case "DVD":
                    item = new DVD();
                    break;
                default:
                    item = new Magazine();
            }

            System.out.println(title + ": " + item.dueDate());
        }

        sc.close();
    }
}
