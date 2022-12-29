package com.ensa.glminiprojectsp.Utils;


public class InputVerifier {
    public enum FLAGS {
        NONE,
        ONLY_CHARS,
        ONLY_NUMBERS,
        NO_SPECIAL
    }
    private InputVerifier() {}
    private static boolean containsNumbers(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)))
                return true;
        }
        return false;
    }
    private static boolean containsSpecialCharacters(String str) {
        String specialCharacters = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
        for (int i = 0; i < str.length(); i++) {
            if (specialCharacters.contains(String.valueOf(str.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsAlphabet(String s) {
      for (int i = 0; i < s.length(); i++) {
        if (Character.isLetter(s.charAt(i))) {
          return true;
        }
      }
      return false;
    }
    public static boolean checkInput(String input) {
        return checkInput(input, FLAGS.ONLY_CHARS);
    }
    public static boolean checkInput(String input, FLAGS flag) {
        if (input == null)
            return false;

        if (input.isEmpty())
            return false;

        if (flag == FLAGS.ONLY_CHARS && (input.length() < 2 || containsNumbers(input) || containsSpecialCharacters(input)))
            return false;

        if (flag == FLAGS.ONLY_NUMBERS && (containsAlphabet(input) || containsSpecialCharacters(input)))
            return false;

        if (flag == FLAGS.NO_SPECIAL && containsSpecialCharacters(input))
            return false;

        return true;
    }
}
