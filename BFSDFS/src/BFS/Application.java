package BFS;

import java.util.Scanner;

public class Application {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("What is your root node?");
        int n = sc.nextInt();

        bfs bfs = new bfs();
        bfs.traverse(n);
    }

}
