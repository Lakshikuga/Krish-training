public class GuessGame {

    // 3 instance variables
    Player p1;
    Player p2;
    Player p3;


    void startGame() {
        //create three player objects and assign them to the 3 Player instance variables
        p1 = new Player();
        p2  = new Player();
        p3 = new Player();

        //3 variables to hold the 3 guesses that the player makes
        int guessp1, guessp2, guessp3 = 0;

        //declare 3 variables to hold true or false based on player's guess
        boolean p1isright = false;
        boolean p2isright = false;
        boolean p3isright = false;

        //generates a random number which is the target number

        int numToGuess = (int) (Math.random() * 10); //multiplied by 10 because to generate numbers only between 0 and 9

        System.out.println("I am thinking of a number between 0 and 9");

        //until the target number is equal to the number guessed by any player, the loop will run
        while(true) {
            System.out.println("The number to guess is " + numToGuess);

            //calling players to guess
            p1.guess();
            p2.guess();
            p3.guess();

            guessp1 = p1.number;
            guessp2 = p2.number;
            guessp3 = p3.number;

            //the numbers guessed by each player
            System.out.println("Player one guessed " + guessp1);
            System.out.println("Player two guessed " + guessp2);
            System.out.println("Player three guessed " + guessp3);

            //checking if any players guessed the number right and set that player's variable to true if that player guessed right
            if (numToGuess == guessp1) {
                p1isright = true;
            } else if (numToGuess == guessp2) {
                p2isright = true;
            } else if (numToGuess == guessp3) {
                p3isright = true;
            } else {
                System.out.println("Players will have to try again!!!");
            }

            if (p1isright || p2isright || p3isright) {
                System.out.println("We have a winner!");
                System.out.println("Player one got it right? " + p1isright);
                System.out.println("Player two got it right? " + p2isright);
                System.out.println("Player three got it right? " + p3isright);

                //displaying the winner
                if(p1isright){
                    System.out.println("Player one is the winner");
                }
                if(p2isright){
                    System.out.println("Player two is the winner");
                }
                if(p3isright){
                    System.out.println("Player three is the winner");
                }
                System.out.println("Game over!");
                break;
            }
        }
    }
}
