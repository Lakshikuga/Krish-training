public class Player {
    //the number guessed by the player
    int number = 0;


    public void guess(){
        number = (int) (Math.random() * 10);
        System.out.println("I'm guessing " + number);
    }
}
