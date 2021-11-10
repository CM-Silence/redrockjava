package RedRock_Android_Java.test4;

//work1 level1
//打印乘法口诀表和五角星
public class Test4 {

    //用于打印乘法口诀表的方法
    public void print1(int num1,int num2) {
        for(int i = 0 ;i < 9 ;i++){
            for(;num2 <= num1 ;num2++){

                //输出乘法口诀表
                System.out.print(num2 + "*" + num1 + "=" + num1*num2 + "   ");
            }
            num1++;
            num2 = 1;

            //换行
            System.out.println();
        }
    }

    //用数组打印五角星的方法
    public void print2() {
        String[][] star;
        star = new String[19][50];
        final int ld = 25;
        int num1 = 0;
        int num2 = 0;

        //用分段函数表示数组中元素是"—"还是"*"
        for(int j = 0 ;j < 19 ;j++){
            if(j > 0 && j <= 6){
                num1 += 1;
            }
            else if(j > 6 && j <= 11){
                num1 = 42 - 3 * j;
            }
            else if(j > 11){
                num1 = j - 4;
            }
            if(j>=14){
                num2 = 3 * j - 41;
            }
            for(int i = 0 ;i < 50 ;i++){
                if(i>=ld - num1 && i<=ld + num1){
                    star[j][i] = "*";

                    //此处为五角星下面两个角,需要额外挖一个三角形出来
                    if(j>=14 && i>=ld - num2 && i <= ld +num2){
                        star[j][i] = "—";
                    }
                }
                else{
                    star[j][i] = "—";
                }

                //输出五角星
                System.out.print(star[j][i]);
            }

            //换行
            System.out.println();
        }
    }

    //不用数组打印五角星的方法
    public void print3() {
        final int ld = 25;
        int num1 = 0;
        int num2 = 0;

        //用分段函数表示打印"—"还是"*"
        for(int j = 0 ;j < 19 ;j++){
            if(j > 0 && j <= 6){
                num1 += 1;
            }
            else if(j > 6 && j <= 11){
                num1 = 42 - 3 * j;
            }
            else if(j > 11){
                num1 = j - 4;
            }
            if(j>=14){
                num2 = 3 * j - 41;
            }
            for(int i = 0 ;i < 50 ;i++){
                if((i >= ld - num1 && i <= ld + num1 && j < 14) || (j >= 14 && (i < ld - num2 || i > ld +num2) && (i >= ld - num1 && i <= ld + num1))) {
                    System.out.print("*");
                }
                else{
                    System.out.print("—");
                }
            }
            //换行
            System.out.println();
        }
    }

    //main方法创建实例并调用类中的方法(好像是这么说来着awa)
    public static void main(String[] args) {
        Test4 text = new Test4();
        System.out.println("开始打印乘法口诀表:");
        text.print1(1,1);
        System.out.println("用二维数组打印五角星:");
        text.print2();
        System.out.println("不用数组打印五角星:");
        text.print3();
    }
}
