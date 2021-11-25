package RedRock_Android_Java.test16;

import java.util.Random;

//敌方超级兵类
class Boss extends Enemy {
    //boss释放技能的概率
    private final int skillReleaseProbability;

    //boss技能对角色防御力的削弱程度
    private final double degreeOfWeakening;
    Random ra = new Random();

    Boss(String name, double health, double damage, int coin, double defence, double criticalChance, int skillReleaseProbability, double degreeOfWeakening) {
        super(name, health, damage, coin, defence, criticalChance);
        this.skillReleaseProbability = skillReleaseProbability;
        this.degreeOfWeakening = degreeOfWeakening;
    }

    @Override
    public void attack(Player person) {
        if (this.getHealth() > 0) {

            //获取一个随机数,用于判断boss是否会释放技能
            int skillRelease = ra.nextInt(1, 100);

            if (skillRelease <= skillReleaseProbability/5) {
                this.setOnceDamage((int) (this.getDamage() * 5.0 * (100 / (person.getDefense() + 100))));
                person.setHealth(person.getHealth() - this.getOnceDamage());
                System.out.println(this.getName() + "使用*最终审判*对" + person.getName() + "造成了" + this.getOnceDamage() + "点伤害\n并降低了" + person.getName() + this.degreeOfWeakening + "%的防御力!");
                person.setDefense((int) (person.getDefense() * (100 - degreeOfWeakening) * 0.01));
                System.out.println(person.getName() + "目前的防御力为:" + person.getDefense());
            }
            else if(skillRelease > skillReleaseProbability/5 && skillRelease <= skillReleaseProbability) {
                for(int i = 0; i < 5; i++) {
                    this.setOnceDamage((int) (this.getDamage() * (1.0 + i * 0.4) * (100 / (person.getDefense() + 100))));
                    person.setHealth(person.getHealth() - this.getOnceDamage());
                    System.out.println(this.getName() + "使用*毁灭风暴*对" + person.getName() + "造成了" + this.getOnceDamage() + "点伤害!");
                }
            }
            else{
                this.setOnceDamage((int) (this.getDamage()));
                person.setHealth(person.getHealth() - this.getOnceDamage());
                System.out.println(this.getName() + "使用灵魂打击对" + person.getName() + "造成了" + this.getOnceDamage() + "点真实伤害!");
            }
            this.critical(person);
            System.out.println(person.getName() + "目前的生命值为:" + person.getHealth());
            //如果英雄血量大于0则会反击
            if(person.getHealth() > 0){
                person.strikeBack(this);
            }
        }
    }

    public double getDegreeOfWeakening() {
        return degreeOfWeakening;
    }

    public int getSkillReleaseProbability() {
        return skillReleaseProbability;
    }
}

