public class Task1 {
    public static int task(int i, int n){
        if (i > n)
        {
            return -1;
        }
        System.out.println(i);
        return task(i + 1, n);
    }
}

