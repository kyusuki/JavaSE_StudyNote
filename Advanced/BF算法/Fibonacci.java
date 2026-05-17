import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {
    public static void add(List<Integer> a, List<Integer> b, List<Integer> result) {
        result.clear();
        int carry = 0;
        int i = 0;
        while (i < a.size() || i < b.size() || carry > 0) {
            int sum = carry;
            if (i < a.size()) {
                sum += a.get(i);
            }
            if (i < b.size()) {
                sum += b.get(i);
            }
            result.add(sum % 10);
            carry = sum / 10;
            i++;
        }
    }
    public static List<Integer> fibonacci(int n) {
        List<Integer> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        if (n == 1 || n == 2) {
            result.add(1);
            return result;
        }
        List<Integer> a = new ArrayList<>();
        a.add(1);
        List<Integer> b = new ArrayList<>();
        b.add(1);
        List<Integer> c = new ArrayList<>();
        for (int i = 3; i <= n; i++) {
            add(a, b, c);
            a.clear();
            a.addAll(b);
            b.clear();
            b.addAll(c);
        }
        return b;
    }
    public static void printNumber(List<Integer> num) {
        for (int i = num.size() - 1; i >= 0; i--) {
            System.out.print(num.get(i));
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        List<Integer> result = fibonacci(n);
        if (!result.isEmpty()) {
            printNumber(result);
        }
    }
}
    