package redrockjava.test2;

import java.util.Scanner;
import java.math.BigDecimal;

//work0 level2
//彩票中奖概率计算器
public class Test2 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("从n个数字中抽取k个数字,中奖概率的计算awa");
            int n;
            int k;
            String answer;

        do{
            double num1 = 1.0;
            double num2 = 1.0;
            do {
                n = -1;
                k = -1;
                System.out.println("请输入n的值:");
                if(sc.hasNextInt()) {
                    n = sc.nextInt();
                }
                else{
                    sc.next();
                }
                System.out.println("请输入k的值:");
                if(sc.hasNextInt()) {
                    k = sc.nextInt();
                }
                else{
                    sc.next();
                }
                if (k > n || k < 0 || n < 0) {
                    System.out.println("你输入的数据不合理!");
                }

            } while (k > n || k < 0 || n < 0);

            for (int i = 1; i <= k; i++) {
                num2 *= i;
            }

            for (int j = n; j >= n - k + 1; j--) {
                num1 *= j;
            }

            BigDecimal num3 = new BigDecimal(Double.toString(num1));
            BigDecimal num4 = new BigDecimal(Double.toString(num2));
            System.out.println("没用BigDecimal类中方法计算出的中奖概率为:" + num2 / num1);
            System.out.println("用了BigDecimal类中方法计算出的中奖概率为:" + num4.divide(num3, 20, BigDecimal.ROUND_HALF_UP));

            do {
                System.out.println("要再玩一次吗?yes/no");
                answer = sc.next();

                if (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase( "no")) {
                    System.out.println("请输入yes或者no!");
                }

            }while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase( "no"));

        }while(answer.equalsIgnoreCase("yes"));
    }
}
