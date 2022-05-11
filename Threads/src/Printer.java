public class Printer extends Thread{

    @Override
    public void run() {
        super.run();

        //prints 0-1000
        for(int i=0; i<=1000; i++){
            System.out.println(i);
        }
    }
}
