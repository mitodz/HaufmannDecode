import java.util.*;

public class Main {
    static String code;

    public static void main(String[] args) {

        Scanner scanner = new Scanner("4 14\n" +
                "a: 0\n" +
                "b: 10\n" +
                "c: 110\n" +
                "d: 111\n" +
                "01001100100111").useDelimiter("\\W+");

        long n = scanner.nextInt(); // количество уникальных букв
        long m = scanner.nextInt(); // количество символов результирующей строки
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(scanner.next(), scanner.nextInt());
        }
        code = scanner.next(); //закодированная строка
        for (int i = 0; i < code.length(); i++) {
            map.forEach((x,y)-> {
                if (code.startsWith(y.toString())) {
                    System.out.print(x);
                    code=code.subSequence(1,code.length()-1).toString();
                }
            });
        }
    }
}