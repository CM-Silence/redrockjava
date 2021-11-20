package RedRock_Android_Java.test7;

//work1 level4
//点餐系统(伪)
public class Test7 {
    //声明菜品类和餐厅类的对象
    static Dishes[] dish = new Dishes[5];

    //顺便用构造函数为餐厅类的对象的属性设置初始值
    static Restaurant res = new Restaurant("卷王饭店");

    public static void main(String[] args) {
        //实例化菜品类对象,并利用构造函数为其属性赋值
        dish[0] = new Dishes("清蒸肝帝",66,1);
        dish[1] = new Dishes("爆炒卷王",666,2);
        dish[2] = new Dishes("牛肉炒青椒",85,3);
        dish[3] = new Dishes("青椒炒牛肉",32,4);
        dish[4] = new Dishes("干饭王特惠套餐",233,5);

        res.welcome();
        for(int i = 0; i<dish.length; i++){
            dish[i].tell();
        }
        res.choose();
    }
}

