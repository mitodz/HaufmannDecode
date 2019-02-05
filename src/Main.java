import java.util.*;

public class Main {
    static String code;

    public static void main(String[] args) {

        Scanner scanner = new Scanner("2 15\n" +
                "z: 0\n" +
                "y: 10\n" +
                "000001010101010").useDelimiter("\\W+");
        long n = scanner.nextInt(); // количество уникальных букв
        long m = scanner.nextInt(); // количество символов результирующей строки
        if (n == 1) {
            String s = scanner.next();
            for (int i = 0; i < m; i++) {
                System.out.print(s);
            }
        } else {
            Map<String, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(scanner.next(), scanner.nextInt());
            }
            code = scanner.next(); //закодированная строка
            for (int i = 0; i <= m; i++) {
                map.forEach((x, y) -> {
                    if (code.startsWith(y.toString())) {
                        System.out.print(x);
                        code = code.subSequence(y.toString().length(), code.length()).toString();
                    }
                });
            }
        }
    }
}