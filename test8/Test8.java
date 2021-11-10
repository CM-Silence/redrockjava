package RedRock_Android_Java.test8;

import java.util.ArrayList;
import java.util.Scanner;

//work1 level5
//动态数组初次尝试
public class Test8 {
    private Object[] obj = new Object[5];
    private int size;
    private ArrayList arraylist = new ArrayList();

    //初始化动态数组内的元素数量
    public Test8() {
        size = 0;
    }

    //获取数组内的元素数量
    public int getSize() {
        return size;
    }

    //获取数组内的元素
    public Object getObject(int i) {
        return obj[i];
    }

    //获取数组长度(容量)
    public int getCapacity() {
        return obj.length;
    }

    //Test类的add方法(两个参数，好难呀QAQ)
    public void add(int i, Object j) {
        //判断索引是否合理
        if (i <= arraylist.size()) {
            arraylist.add(i, j);

            //如果原数组满了,就new一个容量更大的新数组awa
            if (size >= obj.length - 1) {

                Object[] newobj;
                newobj = new Object[obj.length + 5];

                //将原数组中的元素全部装进新数组里面
                //让其他元素往前挪，给卷王obj[i]让路awa
                for (int k = obj.length - 1; k >= 0; k--) {
                    if (k >= i) {
                        newobj[k+1] = obj[k];
                    } else {
                        newobj[k] = obj[k];
                    }
                }
                //卷王obj[i]坦然地插进了队伍awa
                newobj[i] = arraylist.get(i);

                //将原数组变为新数组
                obj = newobj;
            } else {
                //让其他元素往前挪，给卷王obj[i]让路awa
                for (int k = obj.length - 2; k >= i; k--) {
                    obj[k+1] = obj[k];
                }

                //卷王obj[i]坦然地插进了队伍awa
                obj[i] = arraylist.get(i);
            }
            size++;
        }
        else {
            System.out.println("该索引不合理!");
        }
    }

    //只有一个参数的add方法(没测试过QAQ)
    public void add(Object i) {
        arraylist.add(i);

        //如果原数组满了,就建一个容量更大的新数组
        if (size >= obj.length - 1) {
            Object[] newobj = new Object[obj.length + 5];

            //将原数组中的元素全部装进新数组里面
            for (int j = 0; j < obj.length; j++) {
                newobj[j] = obj[j];
            }
            //再把新加入的元素加进新数组里面awa
            newobj[size] = arraylist.get(size);

            //将原数组变为新数组
            obj = newobj;
        } else {
            //如果容量够的话就直接装awa
            obj[size] = arraylist.get(size);
        }
        size++;
    }

    //移除数组中的某个元素
    public void remove(int i) {
        //判断索引是否合理
        if (i <= arraylist.size()-1) {
            arraylist.remove(i);
            Object newobj[] = new Object[size - 1];

            //将数组中的元素重新排列好
            for (int j = 0; j < obj.length; j++) {
                if (j > i) {
                    obj[j - 1] = obj[j];
                }
            }
            for (int k = 0; k < newobj.length; k++) {
                newobj[k] = obj[k];
            }
            obj = newobj;
            size--;
        }
        else{
            System.out.println("该索引不合理!");
        }
    }

    //修改数组中的元素
    public void modify(int i, Object j) {
        if (i <= arraylist.size()-1) {
            obj[i] = j;
            arraylist.set(i, j);
        }
        else{
            System.out.println("该索引不合理!");
        }
    }

}

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
        outer:do {
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
            System.out.println("当前数组的容量为:" + list.getCapacity() +"\n");
        } while (true);
    }
}

