package lab;

public class VowelConsonant {
    public static int[] count(String s) {
        int vowels = 0, consonants = 0;
        for (char ch : s.toLowerCase().toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) != -1) vowels++;
                else consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }
}
