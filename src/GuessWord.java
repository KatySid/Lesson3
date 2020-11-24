import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessWord {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("Угадайте, какое слово из "+Arrays.toString(words)+" я загадал");
        int score = 0;
        Random random = new Random();
        int k = random.nextInt(words.length);
        do {
            String userAnswer = readWord();
            StringBuilder correctChar = getFreeStringBuilder();
            int n = getMinLengthWord(userAnswer, words[k]);
            for (int i = 0; i < n; i++) {
                if (userAnswer.charAt(i) == words[k].charAt(i)) {
                    correctChar.setCharAt(i, words[k].charAt(i));
                    score++;
                }
            }
            if (score < words[k].length()){
                System.out.println(correctChar);
            } else {
                System.out.println("Вы угадали слово " + words[k]);
            }
        } while (score < words[k].length());
    }

    public static StringBuilder getFreeStringBuilder() {
        StringBuilder correctChar = new StringBuilder(15);
        for (int i = 0; i < 15; i++) {
            correctChar.append('#');
        }
        return correctChar;
    }

    static String readWord() {
        System.out.println("Введите слово");
        Scanner sc = new Scanner(System.in);
        String word= sc.nextLine();
        return word;
    }
    static int getMinLengthWord (String i, String j){
        int long1= i.length();
        int long2 = j.length();
        if (long1>long2){
            return long2;
        } else return long1;
    }
}
