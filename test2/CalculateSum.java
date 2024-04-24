package test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculateSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of digits");
        int digits= sc.nextInt();
        int first[]=new int[digits];
        System.out.println("Enter the element");
        for(int i=0;i<digits;i++)
        {
            first[i]=sc.nextInt();
        }
        System.out.println("Enter the number of digits");
        digits= sc.nextInt();
        int second[]=new int[digits];
        for(int i=0;i<digits;i++)
        {
            second[i]=sc.nextInt();
        }
       calculateSum(first,second);


    }

    private static void calculateSum(int[] first, int[] second) {
        String result="";
        int firstlen=first.length-1;
        int secondlen=second.length-1;
        List<Integer> sum=new ArrayList<>();
        int total=0;
        int carry=0;
        while(firstlen>=0&&secondlen>=0)
        {

            total=first[firstlen]+second[secondlen]+carry;
            carry=0;
            result=total%10+result;
            sum.add(total%10);
            carry=total/10;
            if(firstlen>=0)
                firstlen--;
            if(secondlen>=0)
                secondlen--;
        }
        System.out.println(result);
        if(secondlen>0)
        {
            for(int i=secondlen;i>-0;i--)
            {
                total=carry+second[i];

                carry=0;
                result=(total%10)+result;
                carry=total/10;
            }

        }
        else if(firstlen>0) {
            for(int i=firstlen;i>=0;i--)
            {
System.out.println(carry);
                total=carry+first[i];
                System.out.println(total+"........."+first[i]);
                carry=0;
                result=(total%10)+result;
                carry=total/10;
                //sum.add(second[i]);
            }

        }
        System.out.println(result);

    }
}
