package redrockjava.test14;

import java.io.*;
import java.util.List;

public class Io {
    //读取文件
    public static String readFile(String pathname) throws IOException {
        File file = new File(pathname);
        Reader is = new FileReader(file);
        char[] b = new char[1024];
        int len = is.read(b);
        is.close();
        return new String(b,0,len);
    }
    //写入文件
    public static void writeFile(String pathname,String str) throws IOException {
        File file = new File(pathname);
        Writer writer = new FileWriter(file, true);
        writer.write(str);
        writer.flush();
        writer.close();
    }
    //读取对象
    public static List<Person> readObj(String pathname) throws IOException, ClassNotFoundException {
        File file = new File(pathname);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        List<Person> persons = (List<Person>)ois.readObject();
        ois.close();
        return persons;
    }
    //写入对象
    public static void writeObj(String pathname, List<Person> persons) throws IOException {
        File file = new File(pathname);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file,true));
        oos.writeObject(persons);
        oos.flush();
        oos.close();
    }
}
