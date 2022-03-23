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
    }

}
