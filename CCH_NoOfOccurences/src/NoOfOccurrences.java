import java.util.Scanner;

public class NoOfOccurrences {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        //get the input string from the user
        System.out.println("Enter a word : ");
        String word = input.nextLine();
        int count = 0;

        //divide the string into charaters and store in an array.
        char wordArr[] = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            //if((wordArr[i]>='A' || wordArr[i]>='a') && (wordArr[i]<='Z' || wordArr[i]<='z')) {
            //if(Character.isUpperCase(wordArr[i]) || Character.isLowerCase(wordArr[i])){
            count = 1;
            for (int j = i + 1; j < word.length(); j++) {
                //if(Character.isUpperCase(wordArr[i]) || Character.isLowerCase(wordArr[i]) || (Character.isUpperCase(wordArr[j]) || Character.isLowerCase(wordArr[j]))){
                if ((Character.isUpperCase(wordArr[i]) && Character.isUpperCase(wordArr[j])) || (Character.isLowerCase(wordArr[i]) && Character.isLowerCase(wordArr[j])) ||
                        (Character.isUpperCase(wordArr[i]) && Character.isLowerCase(wordArr[j])) || (Character.isLowerCase(wordArr[i]) && Character.isUpperCase(wordArr[j]))) {
                    if (wordArr[i] == wordArr[j]) {
                        count++;
                        wordArr[j] = '0';
                    }
                }
            }
            if (count >= 1 && wordArr[i] != '0')
                System.out.println(wordArr[i] + " " + "-" + "" + count);

        }
    }
}
