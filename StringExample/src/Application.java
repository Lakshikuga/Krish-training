public class Application {
    
    public static void main(String args[]){

        String name = "John";
        String person = "John";
        //String employee = "John";

        String employee = new String("John");

        //using the == sign
        System.out.println(name==person); //true
        System.out.println(person==employee); //false
        System.out.println(name==employee); //false

        System.out.println();
        //using the .equals
        System.out.println(name.equals(person)); //true
        System.out.println(person.equals(employee)); //true
        System.out.println(name.equals(employee)); //true

        System.out.println();
        
        String str1 = "Python";
        String str2 = "Data Science";
        String str3 = "Python";

        String str4 = new String("Java");
        String str5 = new String("Python");

        //using the == sign
        System.out.println(str1==str3); //true
        System.out.println(str3==str5); //false


        System.out.println();
        //using the .equals
        System.out.println(str1.equals(str3)); //true
        System.out.println(str1.equals(str5)); //true

    }
}
