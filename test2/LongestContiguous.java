package test2;

import java.util.Scanner;

public class LongestContiguous {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int size= sc.nextInt();
        int array[]=new int[size];
        System.out.println("Enter the element");
        for(int i=0;i<size;i++)
        {
            array[i]=sc.nextInt();
        }
        int start=0;
        int start1=0;
        int end=0;
        int max=0;
        int sum=0;
        int count=0;
        int i=0;
        for(i=0;i<size;i++)
        {
System.out.println(sum);
            if(array[i]<0)
            {
                count=0;
                if(sum>max) {
                    max = sum;
                    start1=start;
                    end=i;
                    sum=0;
                }
            }
            else {
                if(count==0)
                start=i;
                sum+=array[i];
                count++;
            }
        }
        if(sum>max)
        {
            start1=start;
            end=i;
        }
        for(int j=start1;j<end;j++)
            System.out.print(array[j]+",");
    }
}
