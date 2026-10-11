import java.util.Scanner;

public class ExamScoreBandCounter {
    static int lowerBound(int[] a, int target) {
        int left = 0, right = a.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (a[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++)
            scores[i] = sc.nextInt();

        int low = sc.nextInt();
        int high = sc.nextInt();

        int start = lowerBound(scores, low);
        int end = lowerBound(scores, high + 1);

        System.out.println(end - start);
    }
}