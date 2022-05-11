public class Application {

    public static void main(String args[]) {

        //this is an instantiation of Printer class which is a Thread class now because of inheritance, so here a new thread is created!!!
        Printer printer = new Printer();

        //there is no start() method in the Printer class but Printer class inherits Thread class and Thread class has the start() method, therefore we can call it using the Printer class's object.
        //we start the newly created thread from line 6
        printer.start();

        //main thread also prints 0-100
        for(int i=0; i<=100; i++){
            System.out.println(i);
        }
    }
}
