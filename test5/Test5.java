package RedRock_Android_Java.test5;

import java.util.Scanner;
import java.util.Random;

//work1 level2
//输出随机数组并进行排序
public class Test5 {
    Random ra = new Random();
    int[] a = {ra.nextInt(100)+1,ra.nextInt(100)+1,ra.nextInt(100)+1,ra.nextInt(100)+1,ra.nextInt(100)+1,ra.nextInt(100)+1,0};

    //打印数组
    public void print(){
        for (int j : a) {
            if (j != 0) {
                System.out.print(j + "  ");
            }
        }
        System.out.println();
    }

    //在数组中插入一个数字
    public void insert(int i){
        for (int j = 0; j < a.length; j++) {
            if(a[j] == 0){
                a[j] = i;
                break;
            }
        }
    }


    //选排排序法(从小到大排序)
    public static void sort1(int[] army){
        int temp1;
        int min = 0;
        for(int i = 0; i < army.length-2; i++) {
            //记录要交换的数组的数值
                temp1 = army[i];

            for (int j = i; j < army.length-1; j++) {
                if(army[j]<temp1){
                    //保存数组最小值temp1
                    temp1 = army[j];

                    //保存数组最小值对应序号min
                    min = j;
                }
            }

            //最小值与前面的数值交换
            if(army[i] > temp1) {
                int temp2 = army[i];
                army[i] = army[min];
                army[min] = temp2;
            }
        }
    }

    //冒泡排序法(从小到大排序)
    public static void sort2(int[] army){
        for(int i = 1; i < army.length; i++) {
            for (int j = 0; j < army.length; j++) {
                if (army[i] < army[j]) {
                    int temp = army[i];
                    army[i] = army[j];
                    army[j] = temp;
                }
            }
        }
    }

    //冒泡排序法(从大到小排序)
    public static void sort3(int[] army){
        for(int i = 1; i < army.length; i++) {
            for (int j = 0; j < army.length; j++) {
                if (army[i] > army[j]) {
                    int temp = army[i];
                    army[i] = army[j];
                    army[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Test5 test = new Test5();
        System.out.println("打印随机数组:");
        test.print();
        System.out.println("使用选排排序法进行排序后的数组(从小到大):");
        sort1(test.a);
        test.print();
        System.out.println("请在数组中插入任意一个数字:");
        int num = sc.nextInt();
        test.insert(num);
        System.out.println("使用冒泡排序法进行排序后的数组(从小到大):");
        sort2(test.a);
        test.print();
        System.out.println("使用冒泡排序法进行排序后的数组(从大到小):");
        sort3(test.a);
        test.print();

    }
}
