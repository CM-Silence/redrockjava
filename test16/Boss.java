package redrockjava.test16;

import java.util.Random;

//敌方超级兵类
class Boss extends Enemy {
    //boss释放技能的概率
    private final int skillReleaseProbability;

    Random ra = new Random();

    Boss(String name, double health, double damage, int coin, double defence, double criticalChance, int skillReleaseProbability) {
        super(name, health, damage, coin, defence, criticalChance);
        this.skillReleaseProbability = skillReleaseProbability;
    }

    @Override
    public void attack(Person person) {
        if (this.getHealth() > 0) {

            //获取一个随机数,用于判断boss是否会释放技能
            int skillRelease = ra.nextInt(1, 100);

            if (skillRelease <= skillReleaseProbability / 2) {
                this.setOnceDamage((int) (this.getDamage() * 5.0));
                person.setHealth(person.getHealth() - this.getOnceDamage());
                System.out.println(this.getName() + "使用*最终审判*对" + person.getName() + "造成了" + this.getOnceDamage() + "点真实伤害!");
                this.critical(person);
            }
            else if(skillRelease > skillReleaseProbability / 2 && skillRelease <= skillReleaseProbability) {
                for(int i = 0; i < 5; i++) {
                    this.setOnceDamage((int) (this.getDamage() * (1.0 + i * 0.4) * (100 / (person.getDefense() + 100))));
                    person.setHealth(person.getHealth() - this.getOnceDamage());
                    System.out.println(this.getName() + "使用*毁灭风暴*对" + person.getName() + "造成了" + this.getOnceDamage() + "点伤害!");
                    this.critical(person);
                }
            }
            else{
                this.setOnceDamage((int) (this.getDamage() * (100 / (person.getDefense() / 3 + 100))));
                person.setHealth(person.getHealth() - this.getOnceDamage());
                System.out.println(this.getName() + "使用灵魂打击对" + person.getName() + "造成了" + this.getOnceDamage() + "点伤害!");
                this.critical(person);
            }
            System.out.println(person.getName() + "目前的生命值为:" + person.getHealth());
            //如果英雄血量大于0则会反击
            if(person.getHealth() > 0){
                person.strikeBack(this);
            }
        }
    }

    public int getSkillReleaseProbability() {
        return skillReleaseProbability;
    }

    @Override
    public void strikeBack(Person person) {
        person.setHealth(person.getHealth() - (int) (this.getDamage() * (100 / (person.getDefense() + 100)) * 0.3));
        System.out.println(this.getName() + "对" + person.getName() + "进行了反击,造成了" + (int) (this.getDamage() * (100 / (person.getDefense() + 100)) * 0.3) + "点伤害!");
        System.out.println(person.getName() + "目前的生命值为:" + person.getHealth() + "\n");
    }
}

