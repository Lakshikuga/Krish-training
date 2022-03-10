import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MissingNo {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        //creating an arraylist with an undefined size
        ArrayList<Integer> numList=new ArrayList<Integer>();

        //user input
        System.out.println("Enter numbers in the sequence with a space or comma delimited! Type 'end' at the last");

        while(!sc.hasNext("end")){ //when user gives "end", it will stop taking the input since the size is not defined.
            while(sc.hasNextInt()){ //checking whether the next input is an integer
                int num=sc.nextInt();
                numList.add(num);
            }
        }

        //printing the arraylist
        System.out.println("unsorted sequence : " + numList);

        /*for(int i=0; i<numList.size(); i++){
            System.out.print(numList.get(i) + " ");
        }*/


        //sorting the arraylist
        for(int i=0; i<numList.size(); i++) {
            for (int k=i+1; k<numList.size(); k++) {
                if (numList.get(k)< numList.get(i)) {
                    int temp = numList.get(i);
                    numList.set(i, numList.get(k));
                    numList.set(k, temp);
                }
            }
        }
        System.out.println("");

        //printing the sorted sequence
        System.out.print("sorted sequence : " + numList + " ");

        /*for (int i:numList) {
            System.out.print(i + " ");
        }*/

        System.out.println(" ");

        //logic for finding the missing no.
        int missing_no, count=0;
        for(int i=0; i<numList.size()-1; i++){

            if(numList.get(i+1)-numList.get(i)!=1 && numList.get(i+1)-numList.get(i)<=2){
                missing_no = numList.get(i+1)-1;
                count++;
                System.out.println("The missing number in the sequence is : " + missing_no + " ");
            }
            if(count > 1){
                System.out.println("Error!!! There are many missing numbers in the sequence!");
                break;
            }
            else if(numList.get(i+1)-numList.get(i)>2){
                System.out.println("Error!!! There is no pattern in your sequence!");
                break;
            }
        }
    }
}
