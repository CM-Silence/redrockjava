package RedRock_Android_Java.test7;

import java.util.Scanner;

//work1 level4
//点餐系统(伪)
public class Test7 {
    //声明菜品类和餐厅类的对象
    static Dishes[] dish = new Dishes[5];

    //顺便用构造函数为餐厅类的对象的属性设置初始值
    static Restaurant res = new Restaurant("卷王饭店");

    public static void main(String[] args) {
        //实例化菜品类对象,并利用构造函数为其属性赋值
        dish[0] = new Dishes("清蒸肝帝",66,1);
        dish[1] = new Dishes("爆炒卷王",666,2);
        dish[2] = new Dishes("牛肉炒青椒",85,3);
        dish[3] = new Dishes("青椒炒牛肉",32,4);
        dish[4] = new Dishes("干饭王特惠套餐",233,5);

        res.welcome();
        for(int i = 0; i<dish.length; i++){
            dish[i].tell();
        }
        res.choose();
    }
}

//菜品类
class Dishes {
    //封装菜品类的属性
    private String  name1;
    private int price;
    private int number;
    private int amount = 0;

    //设置菜品的属性
    public Dishes(String n,int p,int num){
        this.name1 = n;
        this.price = p;
        this.number = num;
    }
    void setter(int a){
        this.amount += a;
    }


    //获取菜品的名称、价格、菜品号属性
    public String getName(){
        return name1;
    }

    public int getPrice(){
        return price;
    }

    public int getNumber(){
        return number;
    }

    public int getAmount(){
        return amount;
    }

    //输出菜品的属性
    public void tell(){
        System.out.println(getNumber()+"."+getName()+"  "+getPrice()+"元");
    }
}

//餐厅类
class Restaurant {
    //封装餐厅类的属性
    private String name2;
    private static int sum = 0;
    Scanner sc = new Scanner(System.in);

    //设置餐厅的属性
    public Restaurant(String n){
        this.name2 = n;
    }

    //获取餐厅的属性
    public String getName(){
        return name2;
    }

    //菜品的选择(就这个最难qaq)
    public void choose(){
        String answer;
        do {
            System.out.println("\n请输入要点的菜的序号(空格键分割)\n可输入同一个序号多次来连续点同一份菜品\n如输入的序号不合理或不在列出的范围内则系统会自动视为无效:");
            String number = sc.nextLine();

            //以空格为界将字符串拆分为字符串数组
            String num[] = number.split(" ");

            for (int i = 0; i < num.length; i++) {
                switch (num[i]) {
                    case "1": {
                        Test7.dish[0].setter(1);
                        break;
                    }
                    case "2": {
                        Test7.dish[1].setter(1);
                        break;
                    }
                    case "3": {
                        Test7.dish[2].setter(1);
                        break;
                    }
                    case "4": {
                        Test7.dish[3].setter(1);
                        break;
                    }
                    case "5": {
                        Test7.dish[4].setter(1);
                        break;
                    }
                }
            }
            this.list();
            System.out.println("还需要点菜吗?(输入yes继续点菜,输入其他内容则进入支付环节)");
            answer = sc.nextLine();
        }while(answer.equalsIgnoreCase("yes"));

        //列出已选择的菜品
        this.list();
        //进入支付环节
        this.pay();
    }

    //支付方法的选择
    public void pay(){
        String answer;
        do {
            System.out.println("\n请选择支付方式\n1.支付宝\n2.微信\n3.我没钱...");
            answer = sc.nextLine();
            if(!answer.equals("1") && !answer.equals("2") && !answer.equals("3")){
                System.out.println("请输入支付方式的序号!");
            }
        }while(!answer.equals("1") && !answer.equals("2") && !answer.equals("3"));
        if(answer.equals("3")){
            System.out.println("你被踢出了餐厅!");
        }
        else{
            System.out.println("请出示付款码\n...");
            if(sum > 1500){
                System.out.println("您的余额不足\n...\n你被踢出了餐厅!");
            }
            else{
                System.out.println("付款成功!");
            }
        }
    }

    //列出被选择的菜品的数量和价格
    public void list(){
        //重新计算总价
        sum = 0;

        System.out.println("你一共选择了:");
        for(int i = 0; i<Test7.dish.length; i++){
            //菜品的数量大于0才显示出来并将它的价格加到总价中去
            if(Test7.dish[i].getAmount() != 0){
                System.out.println(Test7.dish[i].getName() + "   " + Test7.dish[i].getAmount()+"份共"+Test7.dish[i].getPrice()*Test7.dish[i].getAmount()+"元");
                sum += (Test7.dish[i].getPrice()*Test7.dish[i].getAmount());
            }
        }
        System.out.println("总计"+sum+"元");
    }

    //欢迎功能
    public void welcome(){
        System.out.println("欢迎来到"+getName()+",这是今天的菜单:");
    }

}
