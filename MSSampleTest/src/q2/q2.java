package q2;

import java.util.Scanner;

public class q2 {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //number of elements in the array
        int arr[] = new int[n];
        System.out.print("Enter the numbers in ur array!!!");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(result(arr));

    }

    public static int result(int arr[]) {
        int sumOfEvenNumbers = 0;
        int sumOfOddNumbers = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] % 2 == 0){
                sumOfEvenNumbers += arr[i];
            }
            else{
                sumOfOddNumbers += arr[i];
            }
        }
        return sumOfOddNumbers - sumOfEvenNumbers;
    }
}
