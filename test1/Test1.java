package RedRock_Android_Java.test1;

import java.util.Scanner;

//work0 level1
//来自卷王的邀请
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String e = "";
        int a; //平时成绩
        int b; //期中成绩
        int c; //期末成绩
        do {
            System.out.println("卷王廖姐姐向你发出了内卷邀请!");
            System.out.println("请输入你的平时成绩:");
            a = sc.nextInt();
            System.out.println("请输入你的期中成绩:");
            b = sc.nextInt();
            System.out.println("请输入你的期末成绩:");
            c = sc.nextInt();
            if (a<0||a>100||b<0||b>100||c<0||c>100) {
                System.out.println("你输入的成绩不合理，请再输一次!");
                continue;
            }
            int d = (int) (0.2 * a + 0.3 * b + 0.5 * c);
            if (d > 0 && d < 60) {
                System.out.println("勇敢俊枭,不怕困难");
            }
            else {
                System.out.println("就这?还没我卷");
            }
            do {
                System.out.println("是否要再来一局?(yes/no)");
                e =sc.next();
                if(!e.equalsIgnoreCase("yes") && !e.equalsIgnoreCase("no")) {
                    System.out.println("请输入yes或者no!");
                }
            }while(!e.equalsIgnoreCase("yes") && !e.equalsIgnoreCase("no"));
        }while(e.equals("yes"));

    }
}
