import java.util.Arrays;

public class Palindrome {

    public static boolean isPalindrome(String word){
        String reversedWord =  new StringBuilder(word).reverse().toString();
        return word.equals(reversedWord);
    }

    public static int countNumberOfPalindromes(String[] words){
        int palindromeCount = 0;
        for(String word:words){
            if(isPalindrome(word) ){
                palindromeCount++;
            }
        }
        return palindromeCount;
    }


    public static int countNumberOfPalindromesLambda(String[] words) {
        return (int)Arrays.stream(words).filter(Palindrome::isPalindrome).count();
    }
}
