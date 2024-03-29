package redrockjava.test16;

import java.util.Random;

public abstract class Person {
    private String name; //名字
    private double health; //生命值
    private double damage; //攻击力
    private double defense; //防御力
    private double criticalChance; //暴击率
    private double criticalDamageMultiplier = 0.5; //暴伤倍率(目前没有什么装备能增加暴伤,不过不排除以后会有awa)
    private int onceDamage; //单次伤害(用于计算暴击额外伤害)

    Random ra = new Random();

    Person(String name, double health, double damage, double defense, double criticalChance) {
        this.setName(name);
        this.setHealth(health);
        this.setDamage(damage);
        this.setDefense(defense);
        this.setCriticalChance(criticalChance);
    }

    //各setter方法设为私有(除了setHealth)
    private void setName(String name) {
        this.name = name;
    }

    public void setHealth(double health) {
        this.health = health;
        if(this.health < 0){
            this.health = 0;
        }
    }

    private void setDamage(double damage) {
        this.damage = damage;
        if(this.damage < 0){
            this.damage = 0;
        }
    }

    private void setDefense(double defense) {
        this.defense = defense;
        if(this.defense < 0){
            this.defense = 0;
        }
    }

    private void setCriticalChance(double criticalChance) {
        this.criticalChance = criticalChance;
        if(this.criticalChance < 0){
            this.criticalChance = 0;
        }
    }

    public void setOnceDamage(int onceDamage){
        this.onceDamage = onceDamage;
    }

    //留着有用(如果我还做的话awa)(暴伤倍率可是很强的属性!)
    private void setCriticalDamageMultiplier(double criticalDamageMultiplier){
        this.criticalDamageMultiplier = criticalDamageMultiplier;
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

    public double getCriticalDamageMultiplier(){
        return criticalDamageMultiplier;
    }

    public int getOnceDamage() {
        return onceDamage;
    }

    public abstract void die(Person person);

    public abstract void strikeBack(Person person);

}

