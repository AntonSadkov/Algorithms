package algorithm;

public class Recursion {

    public static int getFactorial(int num) {
        if (num == 1 || num == 0) {
            return num;
        } else {
            return num * getFactorial(num - 1);
        }
    }

    public static void elementaryExampleRecursion(int num) {
        if (num != 0) {
            System.out.print(num + " ");
            elementaryExampleRecursion(num - 1);
        }
    }
}
