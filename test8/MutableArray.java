package RedRock_Android_Java.test8;

import java.util.Scanner;

//听说作业的类名要求是MutableArray，但我是不会放弃我的Test8类的awa
class MutableArray {
    public static void main(String[] args) {
        Test8 list = new Test8();
        Scanner sc = new Scanner(System.in);
        String answer;
        list.add("红岩网校Android");
        list.remove(0);
        list.add(0, "加油冲冲冲!");
        System.out.println(list.getObject(0));
        System.out.println("list内拥有:" + list.getSize() + "个元素");

        //方法的测试
        outer:
        do {
            System.out.println("请输入序号来确认你要进行的操作:\n1.添加元素\n2.插入元素\n3.修改元素\n4.删除元素\n输入其他内容则退出程序");
            answer = sc.next();
            switch (answer) {
                case "1" -> {
                    System.out.println("请输入你要放入元素:");
                    String element = sc.next();
                    list.add(element);
                }
                case "2" -> {
                    System.out.println("请输入你要放入元素:");
                    String element = sc.next();
                    System.out.println("请输入元素的放入位置(索引):");
                    int index = sc.nextInt();
                    list.add(index, element);
                }
                case "3" -> {
                    System.out.println("请输入要修改的元素的位置(索引):");
                    int index = sc.nextInt();
                    System.out.println("请输入修改后的元素:");
                    String element = sc.next();
                    list.modify(index, element);

                }
                case "4" -> {
                    System.out.println("请输入要移除的元素的位置(索引):");
                    int index = sc.nextInt();
                    list.remove(index);
                }
                default -> {
                    break outer;
                }
            }
            for (int j = 0; j < list.getSize(); j++) {
                System.out.println("obj[" + j + "]=" + list.getObject(j));
            }
            System.out.println("\nlist内拥有:" + list.getSize() + "个元素");
            System.out.println("当前数组的容量为:" + list.getCapacity() + "\n");
        } while (true);
    }
}
