package redrockjava.test1;
import java.util.Scanner;

//work0 level1
//来自卷王的邀请
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choose = "";
        int a; //平时成绩
        int b; //期中成绩
        int c; //期末成绩
        do {
            System.out.println("卷王廖姐姐向你发出了内卷邀请!");
            do {
                a = -1;
                b = -1;
                c = -1;
                System.out.println("请输入你的平时成绩:");
                String a2 = sc.next();
                if (judge(a2)) {
                    a = Integer.parseInt(a2);
                }
                System.out.println("请输入你的期中成绩:");
                String b2 = sc.next();
                if (judge(b2)) {
                    b = Integer.parseInt(b2);
                }
                System.out.println("请输入你的期末成绩:");
                String c2 = sc.next();
                if (judge(c2)) {
                    c = Integer.parseInt(c2);
                }
                if (a < 0 || a > 100 || b < 0 || b > 100 || c < 0 || c > 100) {
                    System.out.println("你输入的成绩不合理，请再输一次!");
                }
            }while (a < 0 || a > 100 || b < 0 || b > 100 || c < 0 || c > 100);
            int d = (int) (0.2 * a + 0.3 * b + 0.5 * c); //计算最终成绩
            if (d > 0 && d < 60) {
                System.out.println("勇敢俊枭,不怕困难");
            }
            else {
                System.out.println("就这?还没我卷");
            }
            do {
                System.out.println("是否要再来一局?(yes/no)");
                choose =sc.next();
                if(!choose.equalsIgnoreCase("yes") && !choose.equalsIgnoreCase("no")) {
                    System.out.println("请输入yes或者no!");
                }
            }while(!choose.equalsIgnoreCase("yes") && !choose.equalsIgnoreCase("no"));
        }while(choose.equals("yes"));

    }

    //用于判断输入的信息是否能转换为数字
    static boolean judge(String str){
        try{
            Integer.parseInt(str);
            return true;
        }
        catch (Exception ignored){
            return false;
        }
    }
}
