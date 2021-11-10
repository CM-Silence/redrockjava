package RedRock_Android_Java.test10;

//敌人类
abstract class Enemy extends Person {

    Enemy(String name, double health, double damage, int coin, int personNum) {
        this.setName(name);
        this.setHealth(health);
        this.setDamage(damage);
        this.setCoin(coin);
        this.setPersonNum(personNum);
    }

    //抽象攻击方法
    public abstract void attack(Player person);

    //虽然敌人还不能暴击,不过我要留着,因为以后的敌人怎么能不暴击呢?
    public void critical(Player person) {
        critical = ra.nextInt(1, 100);
        if (critical <= getCriticalChance()) {
            person.setHealth(person.getHealth() - (int) (this.getDamage() * (100 / (person.getDefense() + 100)) * getCriticalDamageMultiplier()));
            System.out.println(this.getName() + "触发了暴击!额外造成" + (int) (this.getDamage() * (100 / (person.getDefense() + 100)) * getCriticalDamageMultiplier()) + "点伤害!");
        }
    }

    //敌人被击败时,将其从数组中删除掉,顺便判断敌人是否已经全部被歼灭
    public void die(int enemyNum, Person person) {
        System.out.println(this.getName() + "被" + person.getName() + "击败了!");
        System.out.println("你从" + this.getName() + "手中获得了" + this.getCoin() + "金币!\n");
        person.setCoin(person.getCoin() + this.getCoin());
        if (GetReady.enemies.length > 1) {
            Enemy[] newEnemies = new Enemy[GetReady.enemies.length - 1];

            //将数组中的元素重新排列好
            for (int j = 0; j < GetReady.enemies.length; j++) {
                if (j > enemyNum) {
                    GetReady.enemies[j - 1] = GetReady.enemies[j];
                    GetReady.enemies[j].setPersonNum(GetReady.enemies[j].getPersonNum() - 1);
                }
            }
            for (int k = 0; k < newEnemies.length; k++) {
                newEnemies[k] = GetReady.enemies[k];
            }
            GetReady.enemies = newEnemies;
            //还有敌人剩余，返回false
            GetReady.win = false;
        } else {
            //敌人死光光了,返回true
            GetReady.win = true;
        }
    }

}
