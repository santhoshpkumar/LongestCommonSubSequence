package org.santhoshkumar;

import  java.util.Scanner;

public class LongestCommonSubSequence {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        String one = sc.nextLine();
        String two = sc.nextLine();

        LongestCommonSubSequence lcs = new LongestCommonSubSequence();
        //lcs.findSolution("santhoshkumar","santosh");
        lcs.findSolution(one,two);
    }

    public void findSolution(String one, String two){
        int cols = one.length();
        int rows = two.length();
        char[] strOne = one.toCharArray();
        char[] strTwo = two.toCharArray();

        int matrix[][] = new int[rows+1][cols+1];
        // Initialize the columns to 0, meaning if string is null result is 0, no common subsequence
        for(int i=0; i <= cols; i++){
            matrix[0][i] = 0;
        }

        for(int j=0; j <=rows; j++){
            matrix[j][0] = 0;
        }

        for(int i =1; i<=rows; i++){
            for(int j =1; j<=cols; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        for(int i =1; i<=rows; i++){
            for(int j =1; j<=cols; j++){
                if(strOne[j-1] == strTwo[i-1]){
                    matrix[i][j] = matrix[i-1][j-1]+1;
                }else{
                    matrix[i][j] = Math.max(matrix[i-1][j],matrix[i][j-1]);
                }
            }
        }
        
        // Following code is used to print LCS
        int index = matrix[rows][cols];
        // Create a character array to store the lcs string
        char[] lcs = new char[index];
        index--;
        int i = rows, j = cols;
        while (i > 0 && j > 0)
        {
            if (strOne[j-1] == strTwo[i-1])
            {
                lcs[index--] = strTwo[i-1];
                i--; j--;
            }else if (matrix[i-1][j] > matrix[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        
    }
}
