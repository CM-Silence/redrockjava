package RedRock_Android_Java.test10;

//敌方法师类(无视防御的攻击方法,因为我不想做法抗了awa)
class Magician extends Enemy {

    Magician(String name, double health, double damage, int coin, int personNum) {
        super(name, health, damage, coin, personNum);
    }

    //重写Enemy类的attack方法，让法师类的对象攻击时无视对方防御
    @Override
    public void attack(Player person) {
        if (this.getHealth() > 0) {
            person.setHealth(person.getHealth() - (int) (this.getDamage()));
            System.out.println(this.getName() + "使用法术攻击对" + person.getName() + "造成了" + (int) (this.getDamage()) + "点伤害!");
            this.critical(person);
            System.out.println(person.getName() + "目前的生命值为:" + person.getHealth());
        }
        //如果英雄血量大于0则会反击
        if(person.getHealth() > 0){
            person.strikeBack(this);
        }
    }
}
