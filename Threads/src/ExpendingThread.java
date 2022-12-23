public class ExpendingThread extends Thread{
    StringBuilder strB;
    public ExpendingThread(StringBuilder strB){
        this.strB = strB;
    }

    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i+": "+strB);
        }
        this.strB.append('a');
    }
}
