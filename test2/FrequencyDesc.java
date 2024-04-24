package test2;

import java.util.Arrays;
import java.util.Scanner;

public class FrequencyDesc {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int size= sc.nextInt();
        System.out.println("Enter the element");
        int counts[]=new int[size];
        int number[]=new int[size];
        int count=0;
        String result="";
        for(int i=0;i<size;i++)
        {
            number[i]= sc.nextInt();
        }
        for(int i=0;i<size;i++) {
            if (result.contains(number[i] + "")) {
                continue;
            } else {
                count = 1;
                result+=number[i];
                for (int j = i + 1; j < size; j++) {
                    if (number[i] == number[j])
                        count++;
                }
                counts[i] = count;
            }
        }
        System.out.println(Arrays.toString(number));
        System.out.println(Arrays.toString(counts));
        for(int i=0;i<size;i++)
        {
            for(int j=i+1;j<size;j++)
            {
                if(counts[i]<counts[j])
                {
                    int temp=counts[i];
                    counts[i]=counts[j];
                    counts[j]=temp;
                    temp=number[i];
                    number[i]=number[j];
                    number[j]=temp;
                }
            }
        }

        for(int i=0;i<number.length;i++)
        {
            if(number[i]!=0) {
                for (int j = 0; j < counts[i]; j++)
                    System.out.print(number[i]);
            }
        }

    }
}
