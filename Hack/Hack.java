package RedRock_Android_Java.hack;
import java.lang.reflect.*;
import java.util.Scanner;

//work4 level4
//回合制小游戏破解版(反射)
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
        Class<?> getReady = Class.forName("RedRock_Android_Java.test16.GetReady"); //GetReady类
        Constructor<?> beginConstructor = getReady.getDeclaredConstructor(); //GetReady类的构造器
        Object getReadyInstance = beginConstructor.newInstance(); //创建一个GetReady类的对象
        Method start = getReady.getDeclaredMethod("begin",RedRock_Android_Java.test16.Hero.class); //找到GetReady类的方begin方法
        Method ready = getReady.getDeclaredMethod("ready"); //找到GetReady类的方ready方法
        Object hero = ready.invoke(getReadyInstance); //创建一个对象hro,并将ready方法的返回值(一个Hero类对象)赋值给他
        Field damage = person.getDeclaredField("damage"); //找到Person类的私有成员变量damage(伤害)
        damage.setAccessible(true); //用setAccessible(true)来跳过私有检测
        damage.set(hero,99999999); //直接修改对象h(英雄)的damage属性(私有)
        damage.setAccessible(false); //修改完后弄回去(你不弄也行)
        start.invoke(getReadyInstance,hero); //开始游戏
    }

}

