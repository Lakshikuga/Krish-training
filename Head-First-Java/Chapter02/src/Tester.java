public class Tester {

    //main method
    public static void main(String args[]){

        /*The dot operator (.) gives you access to an object's
        state and behaviour (instance variables and methods) */

        //make a new object, a Dog object
        Dog d = new Dog();

        //giving a value to the instance variable
        //set the size using the dot operator
        d.size = 45;

        //calling the bark() method. Telling it to bark using
        //the dot operator on the variable d to call bark()
        d.bark();


        //movie class

        Movie one = new Movie();
        one.title = "Gone with the Stock";
        one.genre = "Tragic";
        one.rating = -2;

        Movie two = new Movie();
        two.title = "Lost in Cubicle Space";
        two.genre = "Comedy";
        two.rating = 5;

        two.playIt();

    }

}
