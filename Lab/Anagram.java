package lab;

import java.util.Arrays;

public class Anagram {
    public static boolean isAnagram(String s1, String s2) {
        s1 = s1.replaceAll("\\s+", "").toLowerCase();
        s2 = s2.replaceAll("\\s+", "").toLowerCase();
        if (s1.length() != s2.length()) return false;
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }
}
