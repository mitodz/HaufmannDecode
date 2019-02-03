import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    static void printTree(String s, String st, Node tree) {
        int n = st.length(); //количество уникальных букв
        System.out.println(n + " " + tree.getBits()); //реализация вывода уникальных букв и количества бит
        for (int i = 0; i < n; i++) { //реализация кода на каждую букву
            System.out.println(st.charAt(i) + ": " + tree.writeCode(Character.toString(st.charAt(i))));
            tree.clearCode();
        }
        for (int j = 0; j < s.length(); j++) {//реализация кода на весь текст
            System.out.print(tree.writeCode(Character.toString(s.charAt(j))));
            tree.clearCode();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner("aaaaabbb");//aaaaaaaaaaaaaaabbbbbbbccccccddddddeeeee
        String s = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        long n = s.chars().distinct().count(); // количество уникальных букв
        long m = s.chars().count(); // количество повторяющихся букв
        if (n == 1) {
            System.out.print("1 "+m+"\n" + s.charAt(0) + ": 0\n");
            for (int i = 0; i < m; i++) {
                System.out.print(0);
            }
        } else {
            s.chars().mapToObj(x -> (char) x)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.<Character, Long>comparingByValue().thenComparing(Map.Entry::getKey))
                    .forEach(x -> {
                        sb.append(x.getKey());
                        q.add(new Node(Character.toString(x.getKey()), x.getValue()));
                    });
            String st = sb.reverse().toString();//финальный отсортированный список букв

        }
    }
}