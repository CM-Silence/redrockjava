package RedRock_Android_Java.test10;

//英雄类
class Hero extends Person implements Player{
    public static Equipment[] equipment = new Equipment[4];  //英雄的装备

    Hero(String name, double health, double damage, double defense, double criticalChance) {
        this.setName(name);
        this.setHealth(health);
        this.setDamage(damage);
        this.setDefense(defense);
        this.setCriticalChance(criticalChance);
    }

    //利用接口回调实现的反击机制(造成相当于攻击力30%的伤害且不会触发暴击,不然太强了awa)
    public void strikeBack(Person person){
        person.setHealth(person.getHealth() - (int) (this.getDamage() * (100 / (person.getDefense() + 100)) * 0.3));
        System.out.println(this.getName() + "对" + person.getName() + "进行了反击,造成了" + (int) (this.getDamage() * (100 / (person.getDefense() + 100)) * 0.3) + "点伤害!");
        System.out.println(person.getName() + "目前的生命值为:" + person.getHealth() + "\n");
    }

    public void critical(Person person) {
        critical = ra.nextInt(1, 100);
        if (critical <= getCriticalChance()) {
            person.setHealth(person.getHealth() - (onceDamage * this.getCriticalDamageMultiplier()));
            System.out.println(this.getName() + "触发了暴击!额外造成" + (onceDamage * this.getCriticalDamageMultiplier()) + "点伤害!");
        }
    }

    //虽然敌人都没有防御力,不过不排除以后版本会不会有,因此Hero类的attack方法以及后面关于技能的方法在计算伤害时依旧会计算对方防御,顺便在攻击完后判断敌方是否被击败
    public void attack(Person person) {
        onceDamage = (int) (this.getDamage() * (100 / (person.getDefense() + 100)));
        person.setHealth(person.getHealth() - onceDamage);
        System.out.println(this.getName() + "使用普通攻击对" + person.getName() + "造成了" + onceDamage + "点伤害!");
        //判断是否暴击
        this.critical(person);
        System.out.println(person.getName() + "目前的生命值为:" + person.getHealth() + "\n");
        if (person.getHealth() <= 0) {
            person.die(person.getPersonNum(), this);
        }
    }

    //多重打击
    void multipleHit() {
        for (int i = 0; i < 5; i++) {
            enemyNum = ra.nextInt(GetReady.enemies.length);
            onceDamage = (int) (this.getDamage() * (100 / (GetReady.enemies[enemyNum].getDefense() + 100) * 0.3));
                GetReady.enemies[enemyNum].setHealth(GetReady.enemies[enemyNum].getHealth() - onceDamage);
                System.out.println(this.getName() + "使用多重打击对" + GetReady.enemies[enemyNum].getName() + "造成了" + onceDamage + "点伤害!");
            this.critical(GetReady.enemies[enemyNum]);
            System.out.println(GetReady.enemies[enemyNum].getName() + "目前的生命值为:" + GetReady.enemies[enemyNum].getHealth());
            if (GetReady.enemies[enemyNum].getHealth() <= 0) {
                GetReady.enemies[enemyNum].die(enemyNum, this);
                //如果多段攻击还没打完就把敌人全干掉了就直接退出此循环
                if(GetReady.win){
                    break;
                }
            }
        }
        System.out.println();
    }

    //精准打击
    void precisionStrike() {
        int num;

        //判断玩家输入的序号是否合理,如不合理则让玩家重新输入
        do {
            System.out.println("请输入序号来选择你要攻击的对象:");
            for (int i = 0; i < GetReady.enemies.length; i++) {
                System.out.println((i + 1) + "." + GetReady.enemies[i].getName());
            }
            num = sc.nextInt();
            if (num < 1 || num > GetReady.enemies.length) {
                System.out.println("请输入合理的序号!");
            }
        } while (num < 1 || num > GetReady.enemies.length);
        onceDamage = (int) (this.getDamage() * (100 / (GetReady.enemies[enemyNum].getDefense() + 100) * 0.8));
        GetReady.enemies[num - 1].setHealth(GetReady.enemies[num - 1].getHealth() - onceDamage);
        System.out.println(this.getName() + "使用精准打击对" + GetReady.enemies[num - 1].getName() + "造成了" + onceDamage + "点伤害!");
        this.critical(GetReady.enemies[num - 1]);
        System.out.println(GetReady.enemies[num - 1].getName() + "目前的生命值为:" + GetReady.enemies[num - 1].getHealth() + "\n");
        if (GetReady.enemies[num - 1].getHealth() <= 0) {
            GetReady.enemies[num - 1].die(num - 1, this);
        }
    }

    //购买装备
    void shop() {
        int num;

        //判断玩家输入的序号是否合理,如不合理则让玩家重新输入
        do {
            System.out.println("您现在拥有的金币为:" + this.getCoin());
            System.out.println("请输入序号来选择你要购买的装备:");
            for (int i = 0; i < Hero.equipment.length; i++) {
                System.out.println((i + 1) + "." + Hero.equipment[i].getName());
            }
            num = sc.nextInt();
            if (num < 1 || num > Hero.equipment.length) {
                System.out.println("请输入合理的序号!");
            }
        } while (num < 1 || num > Hero.equipment.length);
        if (this.getCoin() >= Hero.equipment[num - 1].getPrice()) {
            Hero.equipment[num - 1].setAmount(Hero.equipment[num - 1].getAmount() + 1);
            if (num == 4) {
                Hero.equipment[num - 1].setResurgence(Hero.equipment[num - 1].getResurgence() + 1);
            }
            this.setCoin(this.getCoin() - Hero.equipment[num - 1].getPrice());
            this.setDamage(this.getDamage() + Hero.equipment[num - 1].getDamage());
            this.setDefense(this.getDefense() + Hero.equipment[num - 1].getDefense());
            this.setCriticalChance(this.getCriticalChance() + Hero.equipment[num - 1].getCriticalChance());
            System.out.println("你购买了" + Hero.equipment[num - 1].getName() + "!\n");
        } else {
            System.out.println("你的金币不足以购买这件装备!");
        }


    }

    //查看自身属性以及装备
    void check() {
        System.out.println("当前角色生命值为:" + this.getHealth());
        System.out.println("当前角色攻击力为:" + this.getDamage());
        System.out.println("当前角色防御力为:" + this.getDefense());
        System.out.println("当前角色暴击率为:" + this.getCriticalChance());
        System.out.println("当前角色剩余复活次数为:" + Hero.equipment[3].getResurgence() + "\n");
        System.out.println("当前拥有装备:");
        for (int i = 0; i < Hero.equipment.length; i++) {
            if (Hero.equipment[i].getAmount() > 0) {
                System.out.println(Hero.equipment[i].getAmount() + "个" + Hero.equipment[i].getName());
            }
        }
    }

    @Override
    public void die(int personNum,Person person) {
        System.out.println(this.getName() + "被"+ person.getName() + "击败了!\n");
    }

}
