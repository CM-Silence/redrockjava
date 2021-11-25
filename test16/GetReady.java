package RedRock_Android_Java.test16;

import java.util.Scanner;

public class GetReady {
    Scanner sc = new Scanner(System.in);
    public static boolean win = false; //用于判断游戏是否胜利
    String name; //英雄名
    int round = 1; //回合数
    int initialHealth; //初始生命值
    int initialDamage; //初始攻击力
    int initialDefense; //初始防御力
    int initialCriticalChance; //初始暴击率
    public Hero ready() {
        //输入英雄属性
        do {
            System.out.println("请输入英雄名称(长度为1-10):");
            name = sc.next();
            if (name.length() < 1 || name.length() > 10) {
                System.out.println("输入的名称的长度不合理!");
            }
        } while (name.length() < 1 || name.length() > 10);

        do {
            System.out.println("请输入英雄生命值(1-9999):");
            initialHealth = judge();
            if (initialHealth < 1 || initialHealth > 9999) {
                System.out.println("输入的数据不合理!");
            }
        } while (initialHealth < 1 || initialHealth > 9999);

        do {
            System.out.println("请输入英雄攻击力(1-999):");
            initialDamage = judge();
            if (initialDamage < 1 || initialDamage > 999) {
                System.out.println("输入的数据不合理!");
            }
        } while (initialDamage < 1 || initialDamage > 999);

        do {
            System.out.println("请输入英雄防御力(0-999):");
            initialDefense = judge();
            if (initialDefense < 0 || initialDefense > 999) {
                System.out.println("输入的数据不合理!");
            }
        } while (initialDefense < 0 || initialDefense > 999);

        do {
            System.out.println("请输入英雄暴击率(0-100):");
            initialCriticalChance = judge();
            if (initialCriticalChance < 0 || initialCriticalChance > 100) {
                System.out.println("输入的数据不合理!");
            }
        } while (initialCriticalChance < 0 || initialCriticalChance > 100);

        //我方英雄
        Hero hero = new Hero(name, initialHealth, initialDamage, initialDefense, initialCriticalChance);

        //暴风之剑
        Hero.equipment[0] = new Equipment("暴风之剑(需要100金币,+150攻击力)", 100, 150, 0, 0);

        //无尽之刃
        Hero.equipment[1] = new Equipment("无尽之刃(需要150金币,+250攻击力,+50%暴击率)", 150, 250, 0, 50);

        //锁子甲
        Hero.equipment[2] = new Equipment("锁子甲(需要100金币,+220防御力)", 100, 0, 220, 0);

        //守护天使
        Hero.equipment[3] = new Equipment("守护天使(需要650金币,+350防御力,角色死亡后可复活一次,并恢复生命上限30%的血量,每次购买可增加一次复活机会)", 650, 0, 350, 0);
        return hero;
    }
    public void begin(Hero hero){
        //最终boss(攻击力会随着英雄的生命和防御的提高而提高,且具有10000的初始值,保证能秒杀英雄)
        Boss boss = new Boss("最终Boss—纳什男爵", 50000, (int) ((hero.getHealth() + 1000) * (100 + hero.getDefense())), 9999, 1200, 50, 70, 80);
        System.out.println("纳什男爵:" + hero.getName() + "!你之前击败了我的手下,但是你的好运到头了!\n这次就让你看看我的真正实力!");
        System.out.println("最终Boss—纳什男爵出现!请你运用智慧与勇气,一鼓作气击败他吧!");
        hero.setCoin(600);
        System.out.println("系统:你获得了600金币!");
        outer:while (hero.getHealth() > 0 && !win){
            System.out.println("--------------------第" + round + "回合-------------------");
            String answer;
            do {
                System.out.println("请输入序号来选择你要进行的操作:\n1.精神打击(无视目标50%的防御,对目标造成相当于100%攻击力的伤害)\n2.多重打击Pro(连续攻击5次,首次攻击对目标造成相当于50%攻击力的伤害,\n每攻击一次伤害增加30%)\n3.致命一击(对目标造成相当于350%攻击力的伤害)\n4.购买装备(当前拥有金币:" + hero.getCoin() + ")\n5.查看英雄属性和装备\n6.跪地求饶(6分投)");
                answer = sc.next();
                if(!answer.equals("1") && !answer.equals("2") && !answer.equals("3") && !answer.equals("4") && !answer.equals("5") && !answer.equals("6")){
                    System.out.println("请输入合理的序号!");
                }
            }while (!answer.equals("1") && !answer.equals("2") && !answer.equals("3") && !answer.equals("4") && !answer.equals("5") && !answer.equals("6"));
            switch (answer) {
                case "1" -> {
                    hero.attack(boss);
                }
                case "2" -> {
                    hero.multipleHit(boss);
                }
                case "3" -> {
                    hero.strike(boss);
                }
                case "4" -> {
                    hero.shop();
                    continue;
                }
                case "5" -> {
                    hero.check();
                    continue;
                }
                case "6" -> {
                    hero.setHealth(0);
                    System.out.println("你投降了!");
                    break outer;
                }
            }
            //玩家攻击完后判断敌方是否已经被全部歼灭(Enemy类的die方法)
            if(win){
                break;
            }

            //敌人轮流攻击英雄并判断英雄是否被击败
            boss.attack(hero);
            //如果英雄购买了"守护天使"则消耗一次复活机会来复活一次并恢复一定的生命值(守护天使这件装备不会被消耗掉)
            if(hero.getHealth() <= 0){
                if(Hero.equipment[3].getResurgence() < 1) {
                    hero.die(boss);
                    break;
                }
                else {
                    System.out.println("你受到守护天使的庇护复活了一次!");
                    Hero.equipment[3].setResurgence(Hero.equipment[3].getResurgence() - 1);
                    hero.setHealth((int)(initialHealth * 0.3));

                }
            }
            if (boss.getHealth() <= 0) {
                boss.die(hero);
                if(win){
                    break;
                }
                continue ;
            }

            //回合数+1
            round++;
        }
        if(hero.getHealth() <= 0){
            System.out.println("游戏失败!");
        }
        else {
            System.out.println("你击败了所有敌人，游戏胜利!");
        }
    }

    //用于判断输入的内容是否为数字并赋值给参数的方法
    public static int judge(){
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            if(sc.hasNextInt()) {
                num = sc.nextInt();
                break;
            }
            else{
                sc.next();
                System.out.println("请输入一个数字!");
            }
        }while (true);
        return num;
    }
}

