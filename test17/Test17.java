package RedRock_Android_Java.test17;

import java.util.Scanner;

//work4 level5
//链表实现ArrayList
public class Test17 {
    public static void main(String[] args) {
        MList mList = new MList();
        Scanner sc = new Scanner(System.in);
        String answer;
        //先往列表中添加3名学生
        new MList.Builder().add(new Student("小明","男",16))
                .add(new Student("小红","女",16))
                .add(new Student("小刚","男",17));
        outer:
        do {
            System.out.println("欢迎访问全新升级过的学生信息库(伪)\n请输入序号来确认你要进行的操作:\n1.获取学生列表     2.添加学生\n3.插入学生        4.查找学生\n5.修改学生信息     6.删除学生信息\n7.退出该系统");
            answer = sc.next();
            switch (answer) {
                case "1" -> mList.listStudent();
                case "2" -> mList.addStudent();
                case "3" -> mList.addStudentByIndex();
                case "4" -> mList.searchStudent();
                case "5" -> mList.modifyStudent();
                case "6" -> mList.removeStudent();
                case "7" -> {
                    break outer;
                }
                default -> System.out.println("无法判断你的操作!");
            }
        } while (true);
    }
}

