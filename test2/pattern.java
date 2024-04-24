package test2;

import java.util.Scanner;

public class pattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number");
        int number= sc.nextInt();
        int matrix[][]=new int[number][number];
        int row=0;
        int rowEnd=number-1;
        int column=0;
        int columnEnd=number-1;

        int value=1;
        while(row<=rowEnd&&column<=columnEnd)
        {
            for(int i=row;i<=rowEnd;i++)
            {
                matrix[i][row]=value;
            }
            row++;
            for(int j=row;j<=rowEnd;j++)
            {
                matrix[rowEnd][j]=value;
            }
            rowEnd--;
           for(int k=rowEnd;k>=column;k--)
            {
                matrix[k][columnEnd]=value;
            }
            columnEnd--;
            for(int L=rowEnd;L>=row;L--)
            {
                matrix[column][L]=value;
            }
            column++;
            if(value==0)
                value=1;
            else
                value=0;
        }
        for(int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix.length;j++)
                System.out.print(matrix[i][j]);
            System.out.println();
        }
    }
}
