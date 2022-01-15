package redrockjava.test13;
import  java.util.Scanner;

//work3 level2,4
//灵活的波吉王子(匿名类,伪链表,构造器,内部静态类)
public class Test13 {
    public static void main(String[] args) {

        DodgeLv1 dodge = new DodgeLv1.Builder().add(new DodgeLv1(){

            @Override
            void dodgeEnemy(Enemy enemy){

                if(enemy.ATK > DODGE * 3) {
                    System.out.println("敌人攻击太高,王子直接逃跑了!");
                }
                else {
                    getNext().dodgeEnemy(enemy);
                }
            }

        }).add(new DodgeLv1(){

            @Override
            void dodgeEnemy(Enemy enemy){

                if(enemy.ATK > DODGE * 2) {
                    System.out.println("王子挡下了敌人的一击,然后逃跑了!");
                }
                else {
                    getNext().dodgeEnemy(enemy);
                }
            }

        }).add(new DodgeLv1(){

            @Override
            void dodgeEnemy(Enemy enemy){
                if(enemy.ATK > DODGE) {
                    System.out.println("王子躲避了敌人的攻击,并进行了反击!");
                    enemy.attacked();
                }
                else {
                    getNext().dodgeEnemy(enemy);
                }
            }

        }).add(new DodgeLv1(){

            @Override
            void dodgeEnemy(Enemy enemy){
                System.out.println("王子选择直接反击!");
                enemy.attacked();
            }

        }).build();

        System.out.println("请输入敌人的攻击力(王子防御力为100):");
        int attack = judge();
        Enemy enemy = new Enemy(attack);
        enemy.attack(dodge);
    }

    //用于判断输入的内容是否为非负整数并赋值给参数的方法
    public static int judge(){
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            if(sc.hasNextInt()) {
                num = sc.nextInt();
                if(num >= 0) {
                    break;
                }
                else{
                    System.out.println("请输入一个非负整数!");
                }
            }
            else{
                sc.next();
                System.out.println("请输入一个非负整数!");
            }
        }while (true);
        return num;
    }
}

