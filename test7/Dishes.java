package redrockjava.test7;

//菜品类
class Dishes {
    //封装菜品类的属性
    private final String name1;
    private final int price;
    private final int number;
    private int amount = 0;

    //设置菜品的属性
    public Dishes(String n, int p, int num) {
        this.name1 = n;
        this.price = p;
        this.number = num;
    }

    void setter(int a) {
        this.amount += a;
    }


    //获取菜品的名称、价格、菜品号属性
    public String getName() {
        return name1;
    }

    public int getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public int getAmount() {
        return amount;
    }

    //输出菜品的属性
    public void tell() {
        System.out.println(getNumber() + "." + getName() + "  " + getPrice() + "元");
    }
}
