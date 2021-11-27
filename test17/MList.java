package RedRock_Android_Java.test17;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;


public class MList {
    public static List<Student> arraylist = new ArrayList<>();

    //列出所有列表中的元素
    public void listStudent() {
        ListIterator<Student> li = arraylist.listIterator();
        System.out.println("正向输出学生信息:");
        //正向输出
        while (li.hasNext()){
            System.out.print("学生"+(li.nextIndex()+1));
            li.next().introduce();
        }
        System.out.println("反向输出学生信息:");
        //反向输出
        while (li.hasPrevious()){
            System.out.print("学生"+(li.previousIndex()+1));
            li.previous().introduce();
        }
    }

    //寻找列表内的学生
    public void searchStudent() {
        System.out.println("请输入学生的编号:");
        int i = judge() - 1;
        System.out.println("学生信息为:");
        arraylist.get(i).introduce();
    }

    //插入学生
    public void addStudentByIndex() {
        System.out.println("请输入要插入的学生的位置:");
        int i = judge() - 1 ;
        //判断索引是否合理
        if (i < arraylist.size()) {
            arraylist.add(i,createStudent());
            System.out.println("已将" + arraylist.get(i).getName() + "添加进列表!");
        }
        else {
            System.out.println("该索引不合理!");
        }
    }

    //只有一个参数的add方法
    public void addStudent() {
        arraylist.add(createStudent());
        System.out.println("已将" + arraylist.get(arraylist.size()-1).getName() + "添加进列表!");
    }

    //移除列表中的某个元素
    public void removeStudent() {
        System.out.println("请输入学生的编号:");
        int i = judge() - 1;
        //判断索引是否合理
        if (i < arraylist.size()) {
            System.out.println("已将" + arraylist.get(i).getName() + "从列表中移除!");
            arraylist.remove(i);
        }
        else{
            System.out.println("该索引不合理!");
        }
    }

    //修改列表中的元素
    public void modifyStudent() {
        System.out.println("请输入学生的编号:");
        int i = judge() - 1;
        if (i < arraylist.size()) {
            System.out.println("学生原信息:");
            arraylist.get(i).introduce();
            arraylist.set(i, createStudent());
            System.out.println("修改成功!学生新信息为:");
            arraylist.get(i).introduce();
        }
        else{
            System.out.println("该索引不合理!");
        }
    }

    //内部静态类
    static class Builder{
        public Builder add(Student stu){
            arraylist.add(stu);
            return this;
        }
    }

    //判断用户输入的是否是int类型的数据
    public static int judge(){
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            if(sc.hasNextDouble()|| sc.hasNextInt()) {
                try {
                    num = sc.nextInt();
                    break;
                }catch (Exception ignore){
                    sc.next();
                    System.out.println("输入的数字过大!请重新输入!");
                }
            }
            else{
                sc.next();
                System.out.println("请输入一个数字!");
            }
        }while (true);
        return num;
    }

    //用于让用户输入学生数据的方法
    public static Student createStudent(){
        Scanner sc = new Scanner(System.in);
        String name;
        String gender;
        int age;
        do {
            System.out.println("请输入学生名称(长度为1-10):");
            name = sc.next();
            if (name.length() < 1 || name.length() > 10) {
                System.out.println("输入的名称的长度不合理!");
            }
        } while (name.length() < 1 || name.length() > 10);
        do {
            System.out.println("请输入学生性别(男/女):");
            gender = sc.next();
            if (!gender.equals("男") && !gender.equals("女")) {
                System.out.println("输入的性别不合理!");
            }
        } while (!gender.equals("男") && !gender.equals("女"));
        do {
            System.out.println("请输入学生年龄(5-35):");
            age = judge();
            if (age < 5 || age > 35) {
                System.out.println("输入的数据不合理!");
            }
        } while (age < 5 || age > 35);

        return new Student(name,gender,age);
    }

}


