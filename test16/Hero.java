package redrockjava.test16;

//英雄类
public class Hero extends Person{

    Hero(String name, double health, double damage, double defense, double criticalChance) {
        super(name,health,damage,defense,criticalChance);
        this.setHealth(health);
    }

    //利用接口回调实现的反击机制(造成相当于攻击力30%的伤害且不会触发暴击,不然太强了awa)
    public void strikeBack(Person person){
        person.setHealth(person.getHealth() - (int) (this.getDamage() * (100 / (person.getDefense() + 100)) * 0.3));
        System.out.println(this.getName() + "对" + person.getName() + "进行了反击,造成了" + (int) (this.getDamage() * (100 / (person.getDefense() + 100)) * 0.3) + "点伤害!");
        System.out.println(person.getName() + "目前的生命值为:" + person.getHealth() + "\n");
    }

    public void critical(Person person) {
        int critical = ra.nextInt(1, 100);
        if (critical <= getCriticalChance()) {
            person.setHealth(person.getHealth() - (this.getOnceDamage() * this.getCriticalDamageMultiplier()));
            System.out.println(this.getName() + "触发了暴击!额外造成" + (this.getOnceDamage() * this.getCriticalDamageMultiplier()) + "点伤害!");
        }
    }

    //在攻击完后判断敌方是否被击败
    public void attack(Person person) {
        this.setOnceDamage((int) (this.getDamage() * (100 / (person.getDefense() * 0.5 + 100))));
        person.setHealth(person.getHealth() - this.getOnceDamage());
        System.out.println(this.getName() + "使用精神打击对" + person.getName() + "造成了" + this.getOnceDamage() + "点伤害!");
        //判断是否暴击
        this.critical(person);
        System.out.println(person.getName() + "目前的生命值为:" + person.getHealth() + "\n");
        if (person.getHealth() <= 0) {
            person.die(this);
        }
    }

    //多重打击Pro
    void multipleHit(Person person) {
        for (int i = 0; i < 5; i++) {
            this.setOnceDamage((int) (this.getDamage() * (100 / (person.getDefense() + 100) * (0.5 + 0.3 * i))));
            person.setHealth(person.getHealth() - this.getOnceDamage());
            System.out.println(this.getName() + "使用多重打击Pro对" + person.getName() + "造成了" + this.getOnceDamage() + "点伤害!");
            this.critical(person);
            System.out.println(person.getName() + "目前的生命值为:" + person.getHealth());
            if (person.getHealth() <= 0) {
                person.die(this);
                //如果多段攻击还没打完就把敌人全干掉了就直接退出此循环
                if(GetReady.win){
                    break;
                }
            }
        }
        System.out.println();
    }

    //致命一击
    void strike(Person person) {
        this.setOnceDamage((int) (this.getDamage() * (100 / (person.getDefense() + 100) * 3.5)));
        person.setHealth(person.getHealth() - this.getOnceDamage());
        System.out.println(this.getName() + "使用致命一击对" + person.getName() + "造成了" + this.getOnceDamage() + "点伤害!");
        this.critical(person);
        System.out.println(person.getName() + "目前的生命值为:" + person.getHealth() + "\n");
        if (person.getHealth() <= 0) {
            person.die(this);
        }
    }

    //查看自身属性以及装备
    void check() {
        System.out.println("当前角色生命值为:" + this.getHealth());
        System.out.println("当前角色攻击力为:" + this.getDamage());
        System.out.println("当前角色防御力为:" + this.getDefense());
        System.out.println("当前角色暴击率为:" + this.getCriticalChance());
    }

    @Override
    public void die(Person person) {
        System.out.println(this.getName() + "被"+ person.getName() + "击败了!\n");
    }

}

