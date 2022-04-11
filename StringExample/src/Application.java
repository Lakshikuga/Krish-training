public class Application {
    
    public static void main(String args[]){

        String name = "John";
        String person = "John";
        String employee = "John";

        //using the == sign
        System.out.println(name==person); //true
        System.out.println(person==employee); //true
        System.out.println(name==employee); //true

        System.out.println();
        //using the .equals
        System.out.println(name.equals(person)); //true
        System.out.println(person.equals(employee)); //true
        System.out.println(name.equals(employee)); //true
    }
}
