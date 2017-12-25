/**
 * Created by efetoros on 2/8/17.
 */
public class Palindrome {
    public static Deque<Character> wordToDeque(String word) {
        Deque<Character> end = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            end.addLast(word.charAt(i));

        }
        return end;

    }

    public static boolean isPalindrome(String word) {
        int index1 = 0;
        int index2 = word.length() - 1;
        while (index1 < index2) {
            if (word.charAt(index1) != word.charAt(index2)) {
                return false;
            } else {
                index1 = index1 + 1;
                index2 = index2 - 1;
            }
        }
        return true;
    }
    public static boolean isPalindrome(String word, CharacterComparator cc) {
        int index1 = 0;
        int index2 = word.length() - 1;
        while (index1 < index2) {
            if (!cc.equalChars(word.charAt(index1), word.charAt(index2))) {
                return false;
            } else {
                index1++;
                index2--;
            }
        }
        return true;
    }

}

