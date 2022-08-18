package zadachi;

import java.util.Arrays;

import javax.sound.sampled.Line;

public class ZadachaProFerzey {
    static int Size = 8;
    static int [][] arrTable = new int [Size][Size];
    public static void main(String[] args) {
        for (int[] line: arrTable){
            System.out.println(Arrays.toString(line));
        }
        System.out.println("Мы создали поле, сейчас будем размещать на нем ферзей");
        for (int i = 0; i<arrTable.length; i++){
            for (int j = 0; j<arrTable.length; j++){
                CheckIfWeCanPut(arrTable, i, j);
                TheFinalOne(arrTable, j);
            }
        }
        for (int[] line: arrTable){
            System.out.println(Arrays.toString(line));
        }
    } 
    
    
   /*  private static void putFerz (int row, int col){
        for (int i = 0; i<Size; i++){
            arrTable[i][col]+=1;
            arrTable[row][i]+=1;
            if (row + col-i <Size && row + col - i >=0){
                arrTable[row + col - i][i] +=1;
            }
            if (row-col+i < Size && row - col + i >=0){
                arrTable[i][row-col+i] +=1;
            }
        }
    }*/

    /*private static void deleteFerz(int row, int col){
        for (int i = 0; i<Size; i++){
            arrTable[i][col] -=1;
            arrTable[row][i] -=1;
            if (row + col-1 <Size && row + col - i >=0){
                arrTable[row + col - i][i] -=1;
            }
            if (row-col+i < Size && row - col + i >=0){
                arrTable[i][row-col+i]-=1;
            }
        }
    }*/

    public static boolean CheckIfWeCanPut(int [][] table, int row, int col){
        for (int i =0; i < col; i++ ){
            if (table[row][i] ==1){
                return false;
            }
        }
        for (int i=0; i<row; i++){
            if (table[i][col] >= 1){
                return false;
            }
        }
        for (int i = row-1, j = col-1; i>=0 && j>=0; i--, j-- ){
            if (table[i][j] >= 1){
                return false;
            }
        }
        for (int i = row+1, j = col-1; i<table.length && j>=0; i++, j-- ){
            if (table[i][j] >= 1){
                return false;
            }
        }
        return true;
    }

    public static boolean TheFinalOne(int [][] table, int col){
        if (col >= table.length){
            return true;
        }
        for (int i = 0; i < table.length; i++){
            if (CheckIfWeCanPut(table, i, col)){
                table[i][col] = 1;
                if (TheFinalOne(table, col+1)){
                    return true;
                }
                else{
                    table[i][col] = 0;
                }
            }
        }
        return false;
    }
}
