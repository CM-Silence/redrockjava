package RedRock_Android_Java.test16;
import java.lang.reflect.*;
import java.util.Scanner;

public class Hack {
    static Scanner sc = new Scanner(System.in);
    //static String choose;
    //static String className;
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        /*System.out.println("Hack:是否需要手动输入需要修改的对象类名?\n需要请输入yes,不需要则输入其他内容,系统会使用预设的类名");
        choose = sc.next();
        if(choose.equalsIgnoreCase("yes")){
            System.out.println("Hack:请输入类名(需要把包名也写上)");
            className = sc.nextLine();
        }
        else{
            className = "RedRock_Android_Java.test16.Hero";
        }
        Class<?> hero = Class.forName(className);*/
        Class<?> person = Class.forName("RedRock_Android_Java.test16.Person"); //找到Person类
        Class<?> hero = Class.forName("RedRock_Android_Java.test16.Hero"); //Hero类
        Class<?> getReady = Class.forName("RedRock_Android_Java.test16.GetReady"); //GetReady类
        Constructor<?> beginConstructor = getReady.getDeclaredConstructor(); //GetReady类的构造器
        Object getReadyInstance = beginConstructor.newInstance(); //创建一个GetReady类的对象
        Method start = getReady.getDeclaredMethod("begin",Hero.class); //找到GetReady类的方begin方法
        Method ready = getReady.getDeclaredMethod("ready"); //找到GetReady类的方ready方法
        Object h = ready.invoke(getReadyInstance); //创建一个对象h,并将ready方法的返回值(一个Hero类对象)赋值给他
        Field damage = person.getDeclaredField("damage"); //找到Person类的私有成员变量damage(伤害)
        damage.setAccessible(true); //用setAccessible(true)来跳过私有检测
        damage.set(h,99999999); //修改对象h(英雄)的damage属性
        damage.setAccessible(false); //修改完后弄回去(你不弄也行)
        start.invoke(getReadyInstance,h); //开始游戏
    }

}

