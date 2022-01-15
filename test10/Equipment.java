package redrockjava.test10;

class Equipment {
    private final String name; //名字
    private double health; //生命值(目前还没有装备能增加玩家的生命值,不过以后总不可能没有吧awa)
    private final double damage; //攻击力
    private final double defense; //防御力
    private final double criticalChance; //暴击率
    private final int price; //价格
    private int resurgence; //复活次数
    private int amount; //数量
    private double criticalDamageMultiplier; //暴伤倍率(目前还没有装备能增加暴伤,不过有了就是神器呀awa)

    Equipment(String name, int price, double damage, double defense, double criticalChance) {
        this.name = name;
        this.damage = damage;
        this.defense = defense;
        this.criticalChance = criticalChance;
        this.price = price;
        this.amount = 0;
    }

    public String getName() { return name; }

    public double getHealth() {
        return health;
    } //留着以后有用(如果我还做的话awa)

    public double getDamage() {
        return damage;
    }

    public double getDefense() {
        return defense;
    }

    public double getCriticalChance() {
        return criticalChance;
    }

    public double getCriticalDamageMultiplier() { return  criticalDamageMultiplier; } //留着以后有用

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public int getResurgence() {
        return resurgence;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setResurgence(int resurgence) {
        this.resurgence = resurgence;
    }

}
