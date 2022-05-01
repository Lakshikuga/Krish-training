package q1;
import java.util.Scanner;
public class q1 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //number of elements in the array
        int arr[] = new int[n];
        System.out.print("Enter the numbers in ur array!!!");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(isCentered(arr));


    }



    public static int isCentered(int arr[]) {
        int n = arr.length;
        if(n % 2 != 0){
            System.out.println("this array will have a middle element");
            //find the middle element's position
            int position = n / 2;
            int middle = arr[n / 2];
            System.out.println("middle element is " + middle + " and in the position " + position);
            for(int i=0; i<n; i++){
                if(arr[i] > middle) {
                }
                else if( arr[i] == middle) {
                    if (i == position) {
                        continue;
                    }
                    else{
                        System.out.println("The array is not centered!!!");
                        //return false;
                        return 0;
                    }
                }
                else if(arr[i] < middle){
                    System.out.println("The array is not centered!!!");
                    //return false;
                    return 0;
                }
            }
            System.out.println("The array is centered!!!");
            //return true;
            return 1;
        }
        else if(n == 0){
            System.out.println("No elements in the array!!!");
            //return false;
            return 0;
        }
        else{
            System.out.println("this array doesn't have a middle element");
            //return false;
            return 0;
        }

    }
}
