public class ExE02{

    public static void main(String[] args){

        String[] words = {"radar","racecar","wow","tacocat","kayak","lepel","lightsaber","word","java"};

        for(String word:words){
            System.out.println(word + " is " + (!Palindrome.isPalindrome(word) ? " not " : "") + " a palindrome");
        }

        System.out.println("\nArray contains " + words.length + " words where there are " + Palindrome.countNumberOfPalindromes(words) + " palindromes");

        System.out.println("\nArray contains " + words.length + " words where there are " + Palindrome.countNumberOfPalindromesLambda(words) + " palindromes");
    }

}
