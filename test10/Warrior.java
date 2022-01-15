package redrockjava.test10;

//敌方士兵类
class Warrior extends Enemy {

    Warrior(String name, double health, double damage, int coin, int personNum) {
        super(name, health, damage, coin, personNum);
    }

    @Override
    public void attack(Player person) {
        if (this.getHealth() > 0) {
            person.setHealth((int) (person.getHealth() - (this.getDamage() * (100 / (person.getDefense() + 100)))));
            System.out.println(this.getName() + "使用普通攻击对" + person.getName() + "造成了" + (int) (this.getDamage() * (100 / (person.getDefense() + 100))) + "点伤害!");
            this.critical(person);
            System.out.println(person.getName() + "目前的生命值为:" + person.getHealth());
            //如果英雄血量大于0则会反击
            if(person.getHealth() > 0){
                person.strikeBack(this);
            }
        }
    }
}
