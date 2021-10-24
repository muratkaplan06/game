package com.company;

import java.util.Scanner;

public class mineSweeper {
    private int rowNumber;
    private int colNumber;


    public mineSweeper(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;

    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColNumber() {
        return colNumber;
    }




    public void run() {
        char[][] arr = new char[this.rowNumber][this.colNumber];
        for (int i = 0; i <this.rowNumber; i++){
            for (int j = 0; j <this.colNumber; j++)
            {
                arr[i][j] = '_';
            }
        }

            int flag=1;

             while(flag<=getRowNumber()*getColNumber()/4)
             {
                 arr[(int) (Math.random()*getRowNumber())][(int) (Math.random()*getColNumber())]='*';
                 flag++;
             }
        System.out.println("Mayın Tarlası oyununa hos geldiniz.");
        System.out.println("Not: bu alan gösterilmeyecektir.");
        for (int i = 0; i < rowNumber; i++){
            for (int j = 0; j < colNumber; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

          ciz(arr);


    }
    public void ciz(char[][] arr){

        System.out.println("=========================");
        for (int i = 0; i < rowNumber; i++){
            for (int j = 0; j < colNumber; j++){
                if(arr[i][j]!='*')
                  System.out.print(arr[i][j]);
                else
                    System.out.print('_');
                System.out.print('\t');
            }
            System.out.println();
        }

        printRequest(arr,rowNumber,colNumber);
    }
    public void printRequest(char[][] arr,int rowNumber,int colNumber){
        Scanner scanner=new Scanner(System.in);
        System.out.print("satir giriniz():");
        int row=scanner.nextInt();
        System.out.print("sutun giriniz():");
        int col=scanner.nextInt();
        if(row>rowNumber||col>colNumber){
            System.out.println("invalid numbers!");
            printRequest(arr,rowNumber,colNumber);
        }
        sumOfFlag(row,col,arr,rowNumber,colNumber);

    }
    public void sumOfFlag(int row,int col,char[][] arr,int rowNumber,int colNumber){
        int sum=0;
        boolean continueGame=true;
        if(arr[row][col]=='*')
        {
            System.out.println("Game Over");
            continueGame=false;
        }
        if(col==0&&row==0)
        {
            if(arr[row][col+1]=='*' && arr[row+1][col]=='*' && arr[row+1][col+1]=='*')
                sum=sum+3;
            else if(arr[row][col+1]=='*' && arr[row+1][col]=='*')
                sum=sum+2;
            else if(arr[row][col+1]=='*' && arr[row+1][col+1]=='*')
                sum=sum+2;
            else if(arr[row+1][col]=='*' && arr[row+1][col+1]=='*')
                sum=sum+2;
            else if(arr[row][col+1]=='*' || arr[row+1][col]=='*' || arr[row+1][col+1]=='*')
                sum++;


        }
        else if(row==0&&col==(colNumber-1)){
            if(arr[row][col-1]=='*'&&arr[row+1][col-1]=='*'&&arr[row+1][col]=='*')
                sum=sum+3;
            else if(arr[row][col-1]=='*'&&arr[row+1][col-1]=='*')
                sum=sum+2;
            else if(arr[row+1][col-1]=='*'&&arr[row+1][col]=='*')
                sum=sum+2;
            else if(arr[row][col-1]=='*'&&arr[row+1][col]=='*')
                sum=sum+2;
            else if(arr[row][col-1]=='*'||arr[row+1][col-1]=='*'||arr[row+1][col]=='*')
                sum++;
        }
        else if(row==0){
            if(arr[row][col-1]=='*'&&arr[row][col+1]=='*')
                sum=sum+2;
            else if(arr[row][col-1]=='*'||arr[row][col+1]=='*')
                sum++;


            if(arr[row+1][col-1]=='*'&&arr[row+1][col]=='*'&&arr[row+1][col+1]=='*')
                sum=sum+3;
            else if(arr[row+1][col-1]=='*'&&arr[row+1][col]=='*')
                sum=sum+2;
            else if(arr[row+1][col]=='*'&&arr[row+1][col+1]=='*')
                sum=sum+2;
            else if(arr[row+1][col-1]=='*'&&arr[row+1][col+1]=='*')
                sum=sum+2;
            else if(arr[row+1][col-1]=='*'||arr[row+1][col]=='*'||arr[row+1][col+1]=='*')
                sum++;
        }
        else if(row==(rowNumber-1)&&col==0)
        {
            if(arr[row-1][col]=='*'&&arr[row-1][col+1]=='*'&&arr[row][col+1]=='*')
                sum=sum+3;
            else if(arr[row-1][col]=='*'&&arr[row-1][col+1]=='*')
                sum=sum+2;
            else if(arr[row-1][col+1]=='*'&&arr[row][col+1]=='*')
                sum=sum+2;
            else if(arr[row-1][col]=='*'&&arr[row][col+1]=='*')
                sum=sum+2;
            else if(arr[row-1][col]=='*'||arr[row-1][col+1]=='*'||arr[row][col+1]=='*')
                sum++;
        }
        else if(col==0){
            if(arr[row-1][col]=='*'&& arr[row+1][col]=='*')
                sum=sum+2;
            else if(arr[row-1][col]=='*'||arr[row+1][col]=='*')
                sum++;

            if(arr[row-1][col+1]=='*'&&arr[row][col+1]=='*'&&arr[row+1][col+1]=='*')
                sum=sum+3;
            else if(arr[row-1][col+1]=='*'&&arr[row][col+1]=='*')
                sum=sum+2;
            else if(arr[row][col+1]=='*'&&arr[row+1][col+1]=='*')
                sum=sum+2;
            else if(arr[row-1][col+1]=='*'&&arr[row+1][col+1]=='*')
                sum=sum+2;
            else if(arr[row-1][col+1]=='*'||arr[row][col+1]=='*'||arr[row+1][col+1]=='*')
                sum++;
        }
        else if(row==(rowNumber-1)&&col==(colNumber-1))
        {
            if(arr[row-1][col-1]=='*'&&arr[row][col-1]=='*'&&arr[row-1][col]=='*')
                sum=sum+3;
            else if(arr[row-1][col-1]=='*'&&arr[row][col-1]=='*')
                sum=sum+2;
            else if(arr[row][col-1]=='*'&&arr[row-1][col]=='*')
                sum=sum+2;
            else if(arr[row-1][col-1]=='*'&&arr[row-1][col]=='*')
                sum=sum+2;
            else if(arr[row-1][col-1]=='*'||arr[row][col-1]=='*'||arr[row-1][col]=='*')
                sum++;
        }else if(row==(rowNumber-1)){
            if(arr[row][col-1]=='*'&&arr[row][col+1]=='*')
                sum=sum+2;
            else if(arr[row][col-1]=='*'||arr[row][col+1]=='*')
                sum++;

            if(arr[row-1][col-1]=='*'&&arr[row-1][col]=='*'&&arr[row-1][col+1]=='*')
                sum=sum+3;
            else if(arr[row-1][col-1]=='*'&&arr[row-1][col]=='*')
                sum=sum+2;
            else if(arr[row-1][col]=='*'&&arr[row-1][col+1]=='*')
                sum=sum+2;
            else if(arr[row-1][col-1]=='*'&&arr[row-1][col+1]=='*')
                sum=sum+2;
            else if(arr[row-1][col-1]=='*'||arr[row-1][col]=='*'||arr[row-1][col+1]=='*')
                sum++;
        }else if(col==(colNumber-1)){
            if(arr[row+1][col]=='*'&&arr[row-1][col]=='*')
                sum=sum+2;
            else if(arr[row+1][col]=='*'||arr[row-1][col]=='*')
                sum++;

            if(arr[row+1][col-1]=='*'&&arr[row][col-1]=='*'&&arr[row-1][col-1]=='*')
                sum=sum+3;
            else if(arr[row+1][col-1]=='*'&&arr[row][col-1]=='*')
                sum=sum+2;
            else if(arr[row][col-1]=='*'&&arr[row-1][col-1]=='*')
                sum=sum+2;
            else if(arr[row+1][col-1]=='*'&&arr[row-1][col-1]=='*')
                sum=sum+2;
            else if(arr[row+1][col-1]=='*'||arr[row][col-1]=='*'||arr[row-1][col-1]=='*')
                sum++;
        }
        else
        {
            if(arr[row][col-1]=='*' && arr[row][col+1]=='*')
                sum=sum+2;
            else if(arr[row][col-1]=='*'||arr[row][col+1]=='*')
                sum++;

            if(arr[row-1][col-1]=='*'&&arr[row-1][col]=='*'&&arr[row-1][col+1]=='*')
                sum=sum+3;
            else if(arr[row-1][col-1]=='*'&&arr[row-1][col]=='*')
                sum=sum+2;
            else if(arr[row-1][col]=='*'&&arr[row-1][col+1]=='*')
                sum=sum+2;
            else if(arr[row-1][col-1]=='*'&&arr[row-1][col+1]=='*')
                sum=sum+2;
            else if(arr[row-1][col-1]=='*'||arr[row-1][col]=='*'||arr[row-1][col+1]=='*')
                sum++;

            if(arr[row+1][col-1]=='*'&&arr[row+1][col]=='*'&&arr[row+1][col+1]=='*')
                sum=sum+3;
            else if(arr[row+1][col-1]=='*'&&arr[row+1][col]=='*')
                sum=sum+2;
            else if(arr[row+1][col]=='*'&&arr[row+1][col+1]=='*')
                sum=sum+2;
            else if(arr[row+1][col-1]=='*'&&arr[row+1][col+1]=='*')
                sum=sum+2;
            else if(arr[row+1][col-1]=='*'||arr[row+1][col]=='*'||arr[row+1][col+1]=='*')
                sum++;

        }
        if(sum==1)
            arr[row][col]='1';
        else if(sum==2)
            arr[row][col]='2';
        else if(sum==3)
            arr[row][col]='3';
        else if(sum==4)
            arr[row][col]='4';
        else if(sum==5)
            arr[row][col]='5';
        else
            arr[row][col]='x';

        if (continueGame)
        {

            score(arr,rowNumber,colNumber);


        }
    }
    public void score(char[][] arr,int rowNumber,int colNumber){
        int flag=0;
        for(int i=0;i<rowNumber;i++){
              for (int j=0;j<colNumber;j++)
              {
                  if (arr[i][j]=='_')
                  {
                      flag++;
                  }
              }
          }
        if(flag==0)
            System.out.println("oyunu kazandiniz.");
        else
            ciz(arr);
    }
}
