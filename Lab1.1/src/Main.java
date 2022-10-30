import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) {
        //Задание 1
        System.out.println("Hello world!");
        //Задание 2
        int age = 20;
        System.out.println(age);
        //Задание 3
        int al = 10;
        al = al + 1;
        al += 1;
        System.out.println(al);
        //Задание 4
        int first1 = 6;
        int second1 = 9;
        int l;
        l = first1;
        first1 = second1;
        second1 = l;
        System.out.println(first1);
        System.out.println(second1);
        int first = -5;
        int second = 7;

        first ^= second;
        second ^= first;
        first ^= second;
        System.out.println(first);
        System.out.println(second);
        //5
        int kat1 = 12;
        int kat2 = 5;
        int gip;
        gip = kat1*kat1 + kat2*kat2;
        System.out.println(Math.sqrt(gip));
        //Задание 6
        int t = 2132941;
        System.out.println(t%10);
        //Задание 7
        System.out.println(t%100/10);
        //Задание 8
        int e = 39;
        System.out.println(e/10);
        //Задание 12
        System.out.println(dist(1.5, 2, 5, 6));
        Two_number();
        Sr_znach();
        Sr_znach_geo();

    }

    //Задание 9
    public static void Two_number() {
        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        int num21 = 21;
        if (num1>num21){
            System.out.println(num1-num21);
        } else{
            System.out.println(num21-num1);}

    }
    //Задание 10
    public static void Sr_znach(){
        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        System.out.println((num1+num2)/2);
    }
    //Задание 11
    public static void Sr_znach_geo(){
        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        System.out.println(Math.sqrt(num1*num2));
    }
    //Задание 12
    public static double dist(double x1, double y1, double x2, double y2) {
        System.out.println("x1 = " + x1
                + "\ny1 = " + y1
                + "\nx2 = " + x2
                + "\ny2 = " + y2
        );
        return Math.pow((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1), 0.5);

    }

}
