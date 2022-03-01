import java.util.Scanner;

public class Jump {
	public static void main(String args[]) {

		Scanner input  = new Scanner(System.in);
		
		//INPUT THE DISTANCE NEED TO TRAVEL
		System.out.println("How far do you expect Wicky to jump?");
		int distance = input.nextInt();
		
		int distance_jumped = 0, time_taken_to_jump = 0;

		while(distance > distance_jumped) {
			distance_jumped+=5;
			if(distance_jumped >= distance) {
				System.out.println("He jumped for " + time_taken_to_jump +"s");
				System.out.println("He jumped " + distance_jumped +"m");
				break;
			}
			else{
				time_taken_to_jump+=1;
				distance_jumped+=3;
			}
			
			if(distance_jumped >= distance) {
				System.out.println("He jumped for " + time_taken_to_jump +"s");
				System.out.println("He jumped " + distance_jumped +"m");
				break;
			}
			
			else {
				time_taken_to_jump+=2;
				distance_jumped+=1;
			}

			if(distance_jumped >= distance) {
				System.out.println("He jumped for " + time_taken_to_jump +"s");
				System.out.println("He jumped " + distance_jumped +"m");
				break;
			}

			else{
				time_taken_to_jump+=3;
			}
			
		}
	}
}
				

				
			
			

		

			
			

		

		