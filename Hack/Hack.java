package RedRock_Android_Java.hack;
import java.lang.reflect.*;
import java.util.Scanner;

//work4 level4
//回合制小游戏破解版(反射)
public class Hack {
    static Scanner sc = new Scanner(System.in);
    static String choose;
    //static String className;
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

        /*System.out.println("Hack:是否需要手动输入需要修改的对象类名?\n需要请输入yes,不需要则输入其他内容,系统会使用预设的类名");
        choose = sc.next();
        if(choose.equalsIgnoreCase("yes")){
            System.out.println("hack:请输入类名(需要把包名也写上)");
            className = sc.nextLine();
        }
        else{
            className = "RedRock_Android_Java.test16.Person";
        }
        Class<?> person = Class.forName(className);*/

        Class<?> person = Class.forName("RedRock_Android_Java.test16.Person"); //找到Person类
        Class<?> getReady = Class.forName("RedRock_Android_Java.test16.GetReady"); //GetReady类
        Constructor<?> getReadyDeclaredConstructor = getReady.getDeclaredConstructor(); //GetReady类的构造器
        Object getReadyInstance = getReadyDeclaredConstructor.newInstance(); //用构造器创建一个GetReady类的对象
        Method begin = getReady.getDeclaredMethod("begin"); //找到GetReady类的方begin方法
        Method ready = getReady.getDeclaredMethod("ready"); //找到GetReady类的方ready方法
        System.out.println("----------------------hack---------------------");
        ready.invoke(getReadyInstance); //调用GetReady类的ready方法
        Field hero = getReady.getDeclaredField("hero"); //找到GetReady类的hero对象
        hero.setAccessible(true); //用setAccessible(true)来跳过私有检测(虽然hero本来也不是私有的)
        Object obj = hero.get(getReadyInstance); //得到hero变量所对应的的对象并将其赋值给obj

        //取得Person类的各个成员变量并用setAccessible(true)来跳过私有检测
        Field health = person.getDeclaredField("health");
        health.setAccessible(true);
        Field damage = person.getDeclaredField("damage");
        damage.setAccessible(true);
        Field defense = person.getDeclaredField("defense");
        defense.setAccessible(true);

        //取得Person类的私有方法(其实我觉得直接改变量会更方便,不过为了记住这个方法还是写着在这吧awa)
        Method setCriticalChance = person.getDeclaredMethod("setCriticalChance", double.class);
        setCriticalChance.setAccessible(true);
        Method getCriticalChance = person.getDeclaredMethod("getCriticalChance");
        setCriticalChance.setAccessible(true);

        outer:do{
            System.out.println("hack:欢迎使用本修改器,请选择你要修改的内容:\n1.角色生命\n2.角色攻击力\n3.角色防御力\n4.角色暴击率\n5.开启一击必杀模式\n6.开始游戏");
            choose = sc.nextLine();

            switch (choose){
                case "1" ->{
                    System.out.println("hack:当前角色生命为:" + health.get(obj) + "\n请输入你要修改的值:");
                    health.set(obj,judge());
                }
                case "2" ->{
                    System.out.println("hack:当前角色攻击为:" + damage.get(obj) + "\n请输入你要修改的值:");
                    damage.set(obj,judge());
                }
                case "3" ->{
                    System.out.println("hack:当前角色防御为:" + defense.get(obj) + "\n请输入你要修改的值:");
                    defense.set(obj,judge());
                }
                case "4" ->{
                    System.out.println("hack:当前角色暴击率为:" + getCriticalChance.invoke(obj) + "\n请输入你要修改的值:");
                    setCriticalChance.invoke(obj,judge());
                }
                case "5" ->{
                    System.out.println("hack:已开启一击必杀模式,请开始游戏吧!");
                    damage.set(obj,99999999);
                    setCriticalChance.invoke(obj,99999999);
                }
                case "6" ->{
                    break outer;
                }
                default -> System.out.println("hack:无法识别你的操作!");

            }
        }
        while (true);
        begin.invoke(getReadyInstance); //开始游戏,虐杀boss
    }

    public static double judge(){
        Scanner sc = new Scanner(System.in);
        double num;
        do {
            if(sc.hasNextDouble()|| sc.hasNextInt()) {
                num = sc.nextInt();
                break;
            }
            else{
                sc.next();
                System.out.println("请输入一个数字!");
            }
        }while (true);
        return num;
    }

}

