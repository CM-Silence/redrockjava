package RedRock_Android_Java.test10;

public interface Player {
    void strikeBack(Person person); //反击方法

    //实现反击方法需要用到的其他方法
    String getName();

    void setHealth(double health);

    void setDefense(double defense);

    double getHealth();

    double getDefense();

}
