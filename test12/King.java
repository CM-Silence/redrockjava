package RedRock_Android_Java.test12;

import java.util.ArrayList;
import java.util.List;

public abstract class King {
    List<Soldier> soldiers = new ArrayList<>();
    abstract void review(); //阅兵方法
    abstract void addSoldier1(String name); //普通的增兵方法
    abstract void addSoldier2(String name); //普通的增兵方法
    abstract void addSoldier3(String name); //利用内部匿名类实现的增兵方法
    abstract void addSoldier4(String name); //利用lambda表达式实现的增兵方法(能给士兵命名)
    abstract void addSoldier5(String name); //利用lambda表达式实现的增兵方法(尽可能短,因此无法给士兵命名)
    abstract void subSoldier(String name); //裁军方法
}
