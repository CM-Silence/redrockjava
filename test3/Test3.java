package RedRock_Android_Java.test3;

import java.util.Objects;
import java.util.Scanner;

//work0 level3
//学生信息数据库(伪)
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] students;
        students = new String[233][2];  //装学生姓名和学号的数组

        //第一行输出"学号"和"姓名"四个字
        students[0][0] = "学号";
        students[0][1] = "姓名";

        String xz; //记录用户要进行的操作
        main:do {
            System.out.println("欢迎使用学生信息数据库(伪)!\n请选择你要进行的操作\n1:查看学生信息\n2:导入学生信息\n3:删除学生信息\n4:修改学生信息\n输入其他信息:结束该程序");
            xz = sc.next();
            switch (xz) {
                case ("1") -> {
                    for (int i = 1; i < students.length; i++) {
                        for (int j = 0; j < students.length; j++) {
                            //按照学号大小来进行排序
                            try {
                                int a = Integer.parseInt(students[i][0]);
                                int b = Integer.parseInt(students[j][0]);
                                if (a < b) {
                                    String temp1 = students[i][0];
                                    String temp2 = students[i][1];
                                    students[i][0] = students[j][0];
                                    students[j][0] = temp1;
                                    students[i][1] = students[j][1];
                                    students[j][1] = temp2;
                                }
                            } catch (NumberFormatException ignored) {
                            }

                        }
                    }
                    for (String[] student : students) {
                        if (student[0] != null && student[1] != null) {
                            System.out.println(student[0] + "       " + student[1]);
                        }
                    }
                }
                case ("2") -> {
                    System.out.println("请输入需要录入的学生的学号:");
                    String xh1 = sc.next();
                    System.out.println("请输入需要录入的学生的姓名:");
                    String xm = sc.next();

                    //进入a循环
                    a:
                    for (int i = 0; i < students.length; i++) {
                        for (int j = 0; j < students[i].length; j++) {
                            if (students[i][0] == null && students[i][1] == null) {
                                students[i][0] = xh1;
                                students[i][1] = xm;
                                System.out.println("学生信息录入完毕!");
                                break a; //退出a循环
                            }
                        }
                    }
                }
                case ("3") -> {
                    System.out.println("请输入需要删除的学生的学号:");
                    String xh2 = sc.next();
                    //进入b循环
                    b:
                    for (int i = 0; i < students.length; i++) {
                        for (int j = 0; j < students[i].length; j++) {
                            if (Objects.equals(students[i][0], xh2)) {
                                System.out.println(students[i][1] + "同学的信息已删除!");
                                students[i][0] = null;
                                students[i][1] = null;
                                break b; //退出b循环
                            }
                        }
                    }
                }

                case ("4") -> {
                    System.out.println("请输入需要修改的学生的原学号:");
                    String xh3 = sc.next();
                    System.out.println("请输入需要修改的学生的新学号:");
                    String new_xh = sc.next();
                    System.out.println("请输入需要修改的学生的新姓名:");
                    String new_xm = sc.next();
                    //进入c循环
                    c:
                    for (int i = 0; i < students.length; i++) {
                        for (int j = 0; j < students[i].length; j++) {
                            if (Objects.equals(students[i][0], xh3)) {
                                students[i][0] = new_xh;
                                students[i][1] = new_xm;
                                System.out.println("学生信息已修改!");
                                break c; //退出c循环
                            }
                        }
                    }
                }
                default -> {
                    break main; //退出程序
                }
            }
        }while(!xz.equals("1")||!xz.equals("2")||!xz.equals("3")||!xz.equals("4"));
    }
}
