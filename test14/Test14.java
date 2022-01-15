package redrockjava.test14;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static redrockjava.test14.Io.*;

//work4 level2
//文件读写器
public class Test14 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        System.out.println("请输入文件的路径:\n例子(windows系统):C:\\file\\java\\Test.txt\\\n不同系统路径规范有所不同，请根据实际情况输入");
        String pathname = judgePathname();
        System.out.println("请输入你要写入的内容:");
        String str = sc.next();
        writeFile(pathname,str);
        System.out.println(readFile(pathname));

        System.out.println("请输入文件的路径(装对象的文件不要跟装信息的文件混在一起!):\n例子(windows系统):C:\\file\\java\\Test.txt\\\n不同系统路径规范有所不同，请根据实际情况输入");
        String pathname2 = judgePathname();
        //创建一个装Person类对象的列表并往里面装两个Person类的对象
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("张三","男",36));
        persons.add(new Person("李四","男",38));
        writeObj(pathname2,persons);

        //逐个输出列表中对象并调用对象的introduce方法
        for (Person person : readObj(pathname2)) {
            System.out.println(person);
            person.introduce();
        }
    }

    //用于判断输入的路径下的文件能否被创建出来的方法
    public static String judgePathname(){
        String pathname;
        do {
            pathname = sc.next();
            File file = new File(pathname);
                try{
                    //尝试创建文件,如果报错就说明文件路径不合理,让用户再输一次
                    file.createNewFile();
                    break; //如果可以创建文件则跳出输入文件路径的循环
                }catch (Exception ignore){
                    System.out.println("文件路径有误或无法创建文件,请再次输入文件的路径:\n例子(windows系统):C:\\file\\java\\Test.txt\\");
                }
        }while (true);
        return pathname;
    }
}
