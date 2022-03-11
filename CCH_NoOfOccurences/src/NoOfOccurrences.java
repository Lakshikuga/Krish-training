import java.util.Scanner;

public class NoOfOccurrences {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        //get the input string from the user
        System.out.println("Enter a word or a sentence: ");
        String word = input.nextLine();
        //skipping all space characters in a sentence
        word = word.replaceAll("\\s", "");

        int count = 0;

        //divide the string into charaters and store in an array.
        char wordArr[] = word.toCharArray();

        //sorting the word array to alphabetical order
        for(int i=0; i< wordArr.length; i++){
            for(int p=i+1; p<wordArr.length; p++){
                if(wordArr[p]<wordArr[i]){
                    char tempCh = wordArr[i];
                    wordArr[i] = wordArr[p];
                    wordArr[p] = tempCh;
                }
            }
        }

        //Counting the characters irrespective of case.
        for(int i=0; i<wordArr.length; i++){
            count = 1;
            //this for loop identifies as many occurrences irrespective of the case.
            for (int j=i+1; j<wordArr.length; j++) {
                //when both letters are capital or simple
                if ((Character.isUpperCase(wordArr[i]) && Character.isUpperCase(wordArr[j])) || (!Character.isUpperCase(wordArr[i]) && !Character.isUpperCase(wordArr[j]))) {
                    if (wordArr[i] == wordArr[j]) {
                        count++;
                        wordArr[j] = '0';
                    }
                }
                //make a capital letter to lowercase and compare that
                else if(Character.isUpperCase(wordArr[i])) {
                    if(Character.toLowerCase(wordArr[i]) == wordArr[j]) {
                        count++;
                        //to prevent the repeated character from being counted again so flagging as visited for that character.
                        wordArr[j] = '0';
                    }
                }
                //make a capital letter to lowercase and compare that
                else if(Character.isUpperCase(wordArr[j])){
                    if(wordArr[i] == Character.toLowerCase(wordArr[j])) {
                        count++;
                        wordArr[j] = '0';
                    }
                }

            }
            //printing only the characters that has been visited and not printing those that were revisited!
            if(count>=1 && wordArr[i]!='0') {
                System.out.println(wordArr[i] + " " + "-" + "" + count);
            }
        }

    }
}
