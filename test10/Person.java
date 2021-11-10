package RedRock_Android_Java.test10;

import java.util.Random;
import java.util.Scanner;

public abstract class Person {
    private String name; //名字
    private double health; //生命值
    private double damage; //攻击力
    private double defense; //防御力
    private double criticalChance; //暴击率
    private int coin; //金币(被击败者的金币会全部给击败者)
    private int personNum; //角色序号(目前只应用于敌人身上,实现多对多战斗的时候会更有用些)
    private double criticalDamageMultiplier = 0.5; //暴伤倍率(目前没有什么装备能增加暴伤,不过不排除以后会有awa)
    int critical;  //用于判断是否会暴击的数字
    int enemyNum; //敌人(要攻击的对象)的序号
    int onceDamage; //单次伤害(用于计算暴击额外伤害)

    Random ra = new Random();
    Scanner sc = new Scanner(System.in);


    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(double health) {
        this.health = health;
        if(this.health < 0){
            this.health = 0;
        }
    }

    public void setDamage(double damage) {
        this.damage = damage;
        if(this.damage < 0){
            this.damage = 0;
        }
    }

    public void setDefense(double defense) {
        this.defense = defense;
        if(this.defense < 0){
            this.defense = 0;
        }
    }

    public void setCriticalChance(double criticalChance) {
        this.criticalChance = criticalChance;
        if(this.criticalChance < 0){
            this.criticalChance = 0;
        }
    }

    public void setCoin(int coin) {
        this.coin = coin;
        if(this.coin < 0){
            this.coin = 0;
        }
    }

    //留着有用(如果我还做的话awa)(暴伤倍率可是很强的属性!)
    public void setCriticalDamageMultiplier(double criticalDamageMultiplier){
        this.criticalDamageMultiplier = criticalDamageMultiplier;
    }

    public void setPersonNum(int personNum){
        this.personNum = personNum;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public double getDamage() {
        return damage;
    }

    public double getDefense() {
        return defense;
    }

    public double getCriticalChance() {
        return criticalChance;
    }

    public int getCoin() {
        return coin;
    }

    public int getPersonNum() {
        return personNum;
    }

    public double getCriticalDamageMultiplier(){
        return criticalDamageMultiplier;
    }

    public abstract void die(int personNum, Person person);

}
