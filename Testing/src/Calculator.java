import java.util.stream.DoubleStream;
public class Calculator {
        static double add(double... operands) {
            return DoubleStream.of(operands)
                    .sum();
        }
        static double multiply(double... operands) {
            return DoubleStream.of(operands)
                    .reduce(1, (a, b) -> a * b);
        }
        static String reverse_word(String word) {
            String reversed = "";
            for(String letter : word) {
                reversed = letter + reversed;
                return reversed;
            }
        }
        static boolean checkPalindrome(String[] arr) {
            if (arr[0] == reverse_word(arr[0])) {
                if (arr[1] == reverse_word(arr[1])) {
                    if (arr[2] == reverse_word(arr[2])) {
                        return true;
                    }
                }
            }
            return false;
        }
}
