package test2;

import java.util.Scanner;

public class alphatpattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the character");
        char character1= sc.next().charAt(0);
        int value=(character1-64);
System.out.println(value);
char a='A';
        for(int i=0;i<(character1-64);i++)
        {




            for(int j=0;j<(character1-64)*2;j++)
            {
               //System.out.println(value+i);


                    if (j == value - i - 1) {
                        System.out.print(a);
                    } else if (j == (value + i - 1)) {
                        System.out.print(a);
                    } else {
                        System.out.print(" ");
                    }
            }
            a++;
            System.out.println();
        }
        a--;
        for(int i=1;i<(character1-64);i++)
        {


            a--;

            for(int j=0;j<(character1-64)*2;j++)
            {
                //System.out.println(value+i);


                if (j == i ||j==(value*2)-i-2){
                    System.out.print(a);
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
