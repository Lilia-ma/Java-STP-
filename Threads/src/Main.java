public class Main {

    public static void main(String[] args) {
        //Task 1
        NewThread newt = new NewThread();
        newt.start();
        //Task 2
        Runable r1 = new Runable();
        Runable r2 = new Runable();
        Runable r3 = new Runable();
        r1.run();
        r2.run();
        r3.run();
        //Task 3
        StringBuilder builder = new StringBuilder("a");
        ExpendingThread et1 = new ExpendingThread(builder);
        ExpendingThread et2 = new ExpendingThread(builder);
        ExpendingThread et3 = new ExpendingThread(builder);
        et1.start();
        et2.start();
        et3.start();
    }
}