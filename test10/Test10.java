package redrockjava.test10;
import java.util.*;
import java.math.*;
//与test11整合到一起了

//work2 level1-5
//work3 level1
//回合制小游戏(接口回调,面向对象,抽象类练习)
public class Test10 {
    //GetReady ready = new GetReady();
    //ready.begin();

    //main方法里面装少点东西应该没问题吧?应该吧?
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String array[] = new String[a];
        for(int i = 0; i < a; i++){
            //获取一个十六进制字符串
            array[i] = sc.next();
            String splitArray[] = array[i].split(""); //全部拆开
            StringBuffer sb = new StringBuffer("");
            for(int j = 0; j < splitArray.length; j++){
                splitArray[j] = "" + Integer.toBinaryString(Integer.parseInt(splitArray[j],16));
                StringBuffer sb2 = new StringBuffer(splitArray[j]);
                for(int k = 0; k < 4 - splitArray[j].length(); k++){
                    sb2.insert(0,"0"); //不够四位的补0上去
                }
                splitArray[j] = sb2.toString();
                sb.append(splitArray[j]);

            }
            StringBuffer sb3 = new StringBuffer(sb.toString());
            for(int j = 0; j < 3 - (sb.toString().length() % 3); j++){
                sb3.insert(0,"0"); //整个字符串长度不能被3整除的话补0上去
            }
            //sb3为转换后的二进制字符串
            String splitArray2[] = sb3.toString().split(""); //全拆
            String splitArray3[] = new String[splitArray2.length / 3];
            StringBuffer sb4 = new StringBuffer("");
            for(int j = 0; j < splitArray2.length / 3; j++){
                for(int k = j * 3; k < j * 3 + 3; k++){
                    sb4.append(splitArray2[k]);
                }
                splitArray3[j] = "" + Integer.toOctalString(Integer.parseInt(sb4.toString(),2));
                sb4.setLength(0);
            }
            StringBuffer sb5 = new StringBuffer("");
            for(int j = 0; j < splitArray3.length; j++){
                sb5.append(splitArray3[j]);
            }
            array[i] = sb5.toString();
            while (array[i].startsWith("0")){
                array[i] = array[i].replaceFirst("0","");
            }
            System.out.println(array[i]);
        }
    }

}


