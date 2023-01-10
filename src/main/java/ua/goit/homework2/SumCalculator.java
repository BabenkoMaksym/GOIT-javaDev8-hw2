package ua.goit.homework2;

public class SumCalculator {
    public int sum(int n) {
        int result = 0;
            if (n <= 0) {
                throw new IllegalArgumentException("Введено не вірне число, введіть число більше нуля!");
            }
            for (int i = 1; i <= n; i++) {
                result += i;
            }
        return result;
    }
}
