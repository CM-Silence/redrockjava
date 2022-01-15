package redrockjava.test10;

import java.util.Random;
import java.util.Scanner;

public class GetReady {
    Scanner sc = new Scanner(System.in);
    Random ra = new Random();
    public static boolean win = false; //用于判断游戏是否胜利
    public static Enemy[] enemies = new Enemy[5]; //用于储存敌人的数组
    String name; //英雄名
    int round = 1; //回合数
    int initialHealth; //初始生命值
    int initialDamage; //初始攻击力
    int initialDefense; //初始防御力
    int initialCriticalChance; //初始暴击率
    int initialEnemyHealth; //敌人生命值标准
    int initialEnemyDamage; //敌人攻击力标准
    int enemyNum;
    public void begin() {
        //输入英雄属性
        do {
            System.out.println("请输入英雄名称(长度为1-10):");
            name = sc.next();
            if(name.length() < 1 || name.length() > 10){
                System.out.println("输入的名称的长度不合理!");
            }
        }while (name.length() < 1 || name.length() > 10);

        do {
            System.out.println("请输入英雄生命值(1-9999):");
                initialHealth = judge();
            if(initialHealth < 1 || initialHealth > 9999){
                System.out.println("输入的数据不合理!");
            }
        }while (initialHealth < 1 || initialHealth > 9999);

        do {
            System.out.println("请输入英雄攻击力(1-999):");
            initialDamage = judge();
            if(initialDamage < 1 || initialDamage > 999){
                System.out.println("输入的数据不合理!");
            }
        }while (initialDamage < 1 || initialDamage > 999);

        do {
            System.out.println("请输入英雄防御力(1-999):");
            initialDefense = judge();
            if(initialDefense < 1 || initialDefense > 999){
                System.out.println("输入的数据不合理!");
            }
        }while (initialDefense < 1 || initialDefense > 999);

        do {
            System.out.println("请输入英雄暴击率(0-100):");
            initialCriticalChance = judge();
            if(initialCriticalChance < 0 || initialCriticalChance > 100){
                System.out.println("输入的数据不合理!");
            }
        }while (initialCriticalChance < 0 || initialCriticalChance > 100);


        //输入一个基础值,对于不同兵种这些基础值会以一定比例发生变化
        do {
            System.out.println("请输入敌人基础生命值(1-999):");
            initialEnemyHealth = judge();
            if(initialEnemyHealth < 1 || initialEnemyHealth > 999){
                System.out.println("输入的数据不合理!");
            }
        }while (initialEnemyHealth < 1 || initialEnemyHealth > 999);

        do {
            System.out.println("请输入敌人基础攻击力(1-999):");
            initialEnemyDamage = judge();
            if(initialEnemyDamage < 1 || initialEnemyDamage > 999){
                System.out.println("输入的数据不合理!");
            }
        }while (initialEnemyDamage < 1 || initialEnemyDamage > 999);

        //我方英雄
        Hero hero = new Hero(name,initialHealth,initialDamage,initialDefense,initialCriticalChance);

        //普通小兵
        enemies[0] = new Warrior("小兵",initialEnemyHealth,initialEnemyDamage,50,0);

        //弩手血量较少,攻击略高于小兵
        enemies[1] = new Warrior("弩手",initialEnemyHealth * 0.8,initialEnemyDamage * 1.2,60,1);

        //法师血量很少,但攻击很高且无视护甲,需要尽快消灭
        enemies[2] = new Magician("法师",initialEnemyHealth * 0.5,initialEnemyDamage * 2.0,70,2);

        //炮车血量较高,攻击也较高,建议消灭血量较低的单位后再来解决它
        enemies[3] = new Warrior("炮车",initialEnemyHealth * 2.0,initialEnemyDamage * 2.0,210,3);

        //超级兵血量跟攻击都很高,且会使用技能在造成高额伤害的同时降低英雄的防御力,是非常棘手的敌人
        enemies[4] = new SuperWarrior("超级兵",initialEnemyHealth * 3.5,initialEnemyDamage * 3.0,320,4,30,40);

        //暴风之剑
        Hero.equipment[0] = new Equipment("暴风之剑(需要80金币,+40攻击力)",80,40,0,0);

        //无尽之刃
        Hero.equipment[1] = new Equipment("无尽之刃(需要180金币,+60攻击力,+20%暴击率)",180,60,0,20);

        //锁子甲
        Hero.equipment[2] = new Equipment("锁子甲(需要40金币,+50防御力)",40,0,50,0);

        //守护天使
        Hero.equipment[3] = new Equipment("守护天使(需要180金币,+70防御力,角色死亡后可复活一次,并恢复生命上限30%的血量,每次购买可增加一次复活机会)",180,0,70,0);

        //开始游戏
        outer:while (hero.getHealth() > 0 && !win){
            System.out.println("--------------------第" + round + "回合-------------------");
            String answer;
            do {
                System.out.println("请输入序号来选择你要进行的操作:\n1.普通攻击(随机选定目标,对目标造成相当于100%攻击力的伤害)\n2.多重打击(连续攻击5次,随机选定目标,每次对目标造成相当于30%攻击力的伤害)\n3.精准打击(进行一次可以选定目标的攻击,对目标造成相当于80%攻击力的伤害)\n4.购买装备(当前拥有金币:" + hero.getCoin() + ")\n5.查看英雄属性和装备\n6.跪地求饶(6分投)");
                answer = sc.next();
                if(!answer.equals("1") && !answer.equals("2") && !answer.equals("3") && !answer.equals("4") && !answer.equals("5") && !answer.equals("6")){
                    System.out.println("请输入合理的序号!");
                }
            }while (!answer.equals("1") && !answer.equals("2") && !answer.equals("3") && !answer.equals("4") && !answer.equals("5") && !answer.equals("6"));
            switch (answer) {
                case "1" -> {
                    enemyNum = ra.nextInt(GetReady.enemies.length);
                    hero.attack(enemies[enemyNum]);
                }
                case "2" -> {
                    hero.multipleHit();
                }
                case "3" -> {
                    hero.precisionStrike();
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
            for (int i = 0; i < enemies.length; ){
                enemies[i].attack(hero);
                //如果英雄购买了"守护天使"则消耗一次复活机会来复活一次并恢复一定的生命值(守护天使这件装备不会被消耗掉)
                if(hero.getHealth() <= 0){
                    if(Hero.equipment[3].getResurgence() < 1) {
                        hero.die(0,hero);
                        break outer;
                    }
                    else {
                        System.out.println("你受到守护天使的庇护复活了一次!");
                        Hero.equipment[3].setResurgence(Hero.equipment[3].getResurgence() - 1);
                        hero.setHealth((int)(initialHealth * 0.3));

                    }
                }
                if (enemies[i].getHealth() <= 0) {
                    enemies[i].die(enemies[i].getPersonNum(), hero);
                    if(win){
                        break outer;
                    }
                    continue ;
                }
                //如果英雄的反击击败了敌人,数组中敌人的顺序会发生改变,为了保证每个敌人都能攻击到英雄,i++需要放在这边而不是在if的括号里面awa
                i++;
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
