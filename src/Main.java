import java.util.*;

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

    static Node createTreeFromCode (Map <String, Integer> map, StringBuilder lastCodeMap) {
        Node left = new Node(0);
        Node right = new Node(0);
        Node p = new Node(0);
        for (int i = 0; i < lastCodeMap.length(); i++) {
            if (lastCodeMap.charAt(i)=='1') {
                left.setCount(1);
            } else {
                right.setCount(0);
            }
            p.setLeft(left);
            p.setRight(right);
        }
        return p;
    }

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
        int lastCodeInt=0;
        StringBuilder lastCodeOfMap = new StringBuilder(); //последний код в мапе
        for (int i = 0; i < n; i++) {
            map.put(scanner.next(), lastCodeInt = scanner.nextInt());
        }
        lastCodeOfMap.append(lastCodeInt);
        System.out.println(lastCodeOfMap.toString());
        StringBuilder sbCode = new StringBuilder(scanner.nextLine()); //закодированная строка
        createTreeFromCode(map, lastCodeOfMap);

//        map.forEach((x,y)-> System.out.println(x + ": " + y));


//        if (n == 1) {
//            System.out.print("1 "+m+"\n" + s.charAt(0) + ": 0\n");
//            for (int i = 0; i < m; i++) {
//                System.out.print(0);
//            }
//        } else {
//
//        }
    }
}