package redrockjava.test6;

import java.util.Scanner;
import java.util.Random;

//work1 level3
//矩阵相乘
public class Test6 {

    //生成随机矩阵
    public static void matrix(int[][] a,int row,int column){
        Random ra = new Random();
        for(int j = 0; j < row; j++){
            for(int k = 0; k < column; k++){
                a[j][k] = ra.nextInt(10);
            }
        }
    }

    //打印矩阵
    public void print(int[][] i, int row, int column){
        for(int j = 0; j < row; j++){
            for(int k = 0; k < column; k++){
                System.out.print(i[j][k] + "  ");
            }
            System.out.println();
        }
    }

    //矩阵相乘
    public boolean multiply(int[][] a, int[][] b, int[][] c, int row1, int column1, int row2, int column2){
        if(column1 == row2) {
            for (int j = 0; j < row1; j++) {
                for (int k = 0; k < column2; k++) {
                    for (int i = 0; i < column1; i++) {
                        c[j][k] += (a[j][i] * b[i][k]);
                    }
                }
            }
            return true; //两个矩阵能够相乘,返回true
        }
        else{
            return false; //两个矩阵无法相乘,返回false
        }

    }

    //矩阵对角线元素相加
    public void add(int[][] a, int row, int column){
        if(row == column) {
            int sum = 0;
            for (int i = 0; i < a.length; i++) {
                sum += a[i][i];
            }
            System.out.println("结果为:" + sum);
        }
        else{
            System.out.println("该矩阵不是方阵，无法计算!");
        }
    }

    public static void main(String[] args) {
        int column1;
        int row1;
        int column2;
        int row2;
        Test6 test = new Test6();
        System.out.println("请输入第一个矩阵的列数:");
        column1 = judge();
        System.out.println("请输入第一个矩阵的行数:");
        row1 = judge();
        int[][] matrix1 =new int[row1][column1];
        System.out.println("请输入第二个矩阵的列数:");
        column2 = judge();
        System.out.println("请输入第二个矩阵的行数:");
        row2 = judge();
        int[][] matrix2 =new int[row2][column2];
        int[][] matrix3 =new int[row1][column2];
        matrix(matrix1,row1,column1);
        System.out.println("输出第一个随机矩阵:");
        test.print(matrix1,row1,column1);
        matrix(matrix2,row2,column2);
        System.out.println("输出第二个随机矩阵:");
        test.print(matrix2,row2,column2);
        System.out.println("让两个两个矩阵相乘(第一个乘第二个):");

        //判断输入的两个矩阵是否符合相乘条件(返回1还是0)
        if(test.multiply(matrix1,matrix2,matrix3,row1,column1,row2,column2)) {
            System.out.println("输出两个矩阵相乘得出的矩阵:");
            test.print(matrix3,row1,column2);
            System.out.println("输出相乘得出的矩阵的对角线元素之和:");
            test.add(matrix3,row1,column2);
        }
        else{
            System.out.println("输入的两个矩阵无法进行相乘");
        }
    }
    //用于判断输入的内容是否为数字并赋值给参数的方法
    static int judge(){
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            if(sc.hasNextInt()) {
                num = sc.nextInt();
                if(num > 0) {
                    break;
                }
                else{
                    System.out.println("请输入一个正整数!");
                }
            }
            else{
                sc.next();
                System.out.println("请输入一个正整数!");
            }
        }while (true);
        return num;
    }
}
