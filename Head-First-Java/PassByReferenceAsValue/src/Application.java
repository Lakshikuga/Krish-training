public class Application {

    public static void main(String args[]){

        Student s = new Student();
        s.name  =  "Saman";

        Course c = new Course("Node");

        s.setCourse(c);

        modify(s);

        System.out.println("Student " + s.name + " is following " + s.cName);

    }

    public static Student modify(Student s){

        Course course = new Course("Java");
        s.setCourse(course);

        return s;
    }
}
