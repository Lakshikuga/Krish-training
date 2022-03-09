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

        //Counting the characters irrespective of case.
        for(int i=0; i<wordArr.length; i++){
            count = 1;
            for (int j=i+1; j<wordArr.length; j++) {
                if(Character.isUpperCase(wordArr[i])) {
                    if(Character.toLowerCase(wordArr[i]) == wordArr[j]) {
                        count++;
                        wordArr[j] = '0';
                    }
                }
                if(Character.isUpperCase(wordArr[j])){
                    if(wordArr[i] == Character.toLowerCase(wordArr[j])) {
                        count++;
                        wordArr[j] = '0';
                    }
                }
                else if(!Character.isUpperCase(wordArr[i]) && !Character.isUpperCase(wordArr[j])) {
                    if (wordArr[i] == wordArr[j]) {
                        count++;
                        wordArr[j] = '0';
                    }
                }
                else if (Character.isUpperCase(wordArr[i]) && Character.isUpperCase(wordArr[j])) {
                        if (wordArr[i] == wordArr[j]) {
                            count++;
                            wordArr[j] = '0';
                        }
                    }
                }
            if(count>=1 && wordArr[i]!='0') {
                System.out.println(wordArr[i] + " " + "-" + "" + count);

            }
        }

    }
}


//PRINTING IN ALPAHABETICAL ORDER
        /*for(int k=0; k<wordArr.length-1; k++){
            for(int l=k+1; l<wordArr.length;l++){
                if(wordArr[l] < wordArr[k]){
                    char temp=wordArr[k];
                    wordArr[k] = wordArr[l];
                    wordArr[l] = temp;
                }
            }
            System.out.print(wordArr[k]);
        }*/
