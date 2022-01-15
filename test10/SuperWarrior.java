package redrockjava.test10;

import java.util.Random;

//敌方超级兵类
class SuperWarrior extends Enemy {
    //超级兵释放技能的概率
    int skillReleaseProbability;

    //用于判断超级兵是否会释放技能
    int skillRelease;

    //超级兵技能对角色防御力的削弱程度
    double degreeOfWeakening;
    Random ra = new Random();

    SuperWarrior(String name, double health, double damage, int coin, int personNum, int skillReleaseProbability, double degreeOfWeakening) {
        super(name, health, damage, coin, personNum);
        this.skillReleaseProbability = skillReleaseProbability;
        this.degreeOfWeakening = degreeOfWeakening;
    }

    @Override
    public void attack(Player person) {
        if (this.getHealth() > 0) {
            //获取一个随机数,用于判断超级兵是否会释放技能
            skillRelease = ra.nextInt(1, 100);

            if (skillRelease <= skillReleaseProbability) {
                person.setHealth(person.getHealth() - (int) (this.getDamage() * 2.0 * (100 / (person.getDefense() + 100))));
                System.out.println(this.getName() + "使用*致命一击*对" + person.getName() + "造成了" + (int) (this.getDamage() * 2.0 * (100 / (person.getDefense() + 100))) + "点伤害\n并降低了" + person.getName() + this.degreeOfWeakening + "%的防御力!");
                person.setDefense((int) (person.getDefense() * (100 - degreeOfWeakening) * 0.01));
                System.out.println(person.getName() + "目前的防御力为:" + person.getDefense());
            } else {
                person.setHealth(person.getHealth() - (int) (this.getDamage() * (100 / (person.getDefense() + 100))));
                System.out.println(this.getName() + "使用普通攻击对" + person.getName() + "造成了" + (int) (this.getDamage() * (100 / (person.getDefense() + 100))) + "点伤害!");
            }
            this.critical(person);
            System.out.println(person.getName() + "目前的生命值为:" + person.getHealth());
            //如果英雄血量大于0则会反击
            if(person.getHealth() > 0){
                person.strikeBack(this);
            }
        }
    }
}
