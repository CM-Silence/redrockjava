package RedRock_Android_Java.test12;

public class KingBoJi extends King{
    //通过构造方法先给国王两个士兵
    KingBoJi(){
        soldiers.add(new Soldier1("鲍勃"));
        soldiers.add(new Soldier2("迈克"));
    }

    //阅兵方法
    public void review(){
        System.out.println("---------------------国王:士兵们好!-------------------");
        for (Soldier soldier : soldiers) {
            soldier.respond(soldier.getName());
        }
    }

    public void addSoldier1(String name){
        soldiers.add(new Soldier1(name));
    } //往国王的军队里面添加士兵

    public void addSoldier2(String name){
        soldiers.add(new Soldier2(name));
    } //往国王的军队里面添加士兵

    //通过匿名内部类往国王的军队里面添加士兵
    public void addSoldier3(String n){
        Soldier soldier = new Soldier() {
            private final String name = n;

            public void respond(String name) {
                System.out.println(name + ":国王好!!!");
            }

            public String getName() {
                return name;
            }
        };
        soldiers.add(soldier);
    }

    //通过lambda表达式往国王的军队里面添加士兵
    public void addSoldier4(String name){
        this.add(name,n -> System.out.println(n + ":波吉国王好呀!"));
    }
    public void add(String n, Soldier soldier){
        soldiers.add(new Soldier() {
            final String name = n;
            @Override
            public void respond(String name1) {
                soldier.respond(name1);
            }

            public String getName(){
                return name;
            }
        });
    }

    //lambda表达式最终简化版(但是没法给士兵命名,所以无法用subSoldier方法删除qaq)
    public void addSoldier5(String name){
        soldiers.add(n -> System.out.println(name + ":国王好呀!")); //这里的n其实没有用的。。。
    }

    public void subSoldier(String name){
        int index;
        outer:while(true) {
            for (Soldier soldier : soldiers) {
                if (soldier.getName().equals(name)) {
                    index = soldiers.indexOf(soldier);
                    break outer; //如果有人同名怎么办,按国王的说法是谁第一个就踢谁!
                }
            }
            System.out.println("国王:我怎么找不到一个叫" + name + "的人,难道是我记错了?");
            return; //退出该方法
        }
        System.out.println("国王:" + name + "你可以退休了!");
        soldiers.remove(index);
    }
}
