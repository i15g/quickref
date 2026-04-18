import java.util.Arrays;

public class Loops {
  public static void main(String[] args) {
    String s = "hello";
    System.out.println("for loop:");
    for (int i = 0; i < s.length(); i++) {
      System.out.println(s.charAt(i));
    }

    System.out.println("for-each loop:");
    for (char c : s.toCharArray()) {
      System.out.println(c);
    }

    System.out.println("forEach() loop:");
    Arrays.asList(s.toCharArray()).forEach(c -> System.out.println(c));

    System.out.println("while loop:");
    int j = 0;
    while (j < s.length()) {
      System.out.println(s.charAt(j));
      j++;
    }

    System.out.println("do-while loop:");
    int k = 0;
    do {
      System.out.println(s.charAt(k));
      k++;
    } while (k < s.length());

    System.out.println("stream:");
    s.chars().forEach(i -> System.out.println((char) i));
  }
}