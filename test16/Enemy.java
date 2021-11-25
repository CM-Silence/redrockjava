package RedRock_Android_Java.test16;

//敌人类
abstract class Enemy extends Person {

    Enemy(String name, double health, double damage, int coin, double defence, double criticalChance) {
        super(name,health,damage,defence,criticalChance);
        this.setHealth(health);
    }

    //抽象攻击方法
    public abstract void attack(Person person);

    //暴击
    public void critical(Person person) {
        int critical = ra.nextInt(1, 100);
        if (critical <= getCriticalChance()) {
            person.setHealth(person.getHealth() - this.getOnceDamage() * this.getCriticalDamageMultiplier());
            System.out.println(this.getName() + "触发了暴击!额外造成" + this.getOnceDamage() * this.getCriticalDamageMultiplier() + "点伤害!");
        }
    }

    //boss被击败时则游戏胜利
    public void die(Person person) {
        System.out.println(this.getName() + "被" + person.getName() + "击败了!");
        GetReady.win = true;
    }

}

