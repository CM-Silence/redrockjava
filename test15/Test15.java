package RedRock_Android_Java.test15;
import java.util.Scanner;

//work4 level3
//简易计算器
public class Test15 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("请输入一个数学表达式(数字与符号之间用空格隔开):\n例子:- 6 * 5 + 2 ^ 3");
        String a = judge();
        String[] b = a.split(" ");
        for (String s : b) {
            System.out.println(s);
        }
        //System.out.println(a + " = " + calculate(b));
    }

    public static String judge(){
        do {
            String formula = sc.nextLine();
            if (!formula.matches("((-\s)?(\\d)+\s[+\\-*/]\s)+(-\s)?(\\d)+")) {
                System.out.println("输入的算式格式有误,请再次输入!\n例子:- 6 * 5 + 2 ^ 3");
            }
            else{
                return formula;
            }
        }while (true);
    }

    //先把被括号括着的内容算出来
    public static void calculate(String[] b){
        double result;
        for (String s : b) {
            if(s.contains("(")){
                s.replaceAll("[()]"," ");
            }
        }
        for (String s : b) {
            if(s.contains("[")){
                s.replaceAll("[\\[\\]]"," ");
            }
        }
        for (String s : b) {
            if(s.contains("{")){
                s.replaceAll("[{}]"," ");
            }
        }
        finalCalculate(b);
    }

    //用于进行加减乘除运算的方法
    public static void finalCalculate(String[] b){

    }
}
