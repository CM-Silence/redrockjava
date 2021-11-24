package RedRock_Android_Java.test15;

public class Calculator {
    public static int temp1; //用于记录num数组中不为""的索引或者记录算式里面的括号的索引
    public static int temp2; //同上

    //用于进行纯数字运算(不包含小括号的中括号的运算)的方法
    public static String finalCalculate(String formula){

        //判断算式是否以正负号开头,是的话在算式前面添个0
        if(formula.startsWith("+")||formula.startsWith("-")){
            formula = "0" + formula; //有正负号开头则在算式开头加"0"
        }

        String[] num = formula.split("[+\\-*/^][+\\-*/^]?"); //将算式中的数字单独分出来装进num数组(number)
        String[] sym = formula.split("(\\d)+(\\.(\\d)+)?"); //将算式中的运算符号分出来装进sym数组(symbol)

        //先算幂次
        for(int i = 0; i < sym.length; i++){
            if(sym[i].equals("^")){
                num[i] = Double.toString(Math.pow(Double.parseDouble(num[i-1]), Double.parseDouble(num[i])));
                num[i-1] = "";
                sym[i] = "";
            }
            else if(sym[i].equals("^-")){ //例子:2^-1 = 1 / 2^1 (取倒数)
                num[i] = Double.toString(1 / Math.pow(Double.parseDouble(num[i-1]), Double.parseDouble(num[i])));
                num[i-1] = "";
                sym[i] = "";
            }
        }

        //然后算乘除法
        for(int i = 0; i < sym.length; i++){
            temp1 = i-1;
            temp2 = i;
            if(sym[i].equals("")){
                continue; //符号位为空则跳过本次循环寻找下一个符号
            }
            while (num[temp1].equals("") || num[temp2].equals("")){
                if(num[temp1].equals("")){
                    temp1--; //因为做前面的计算时的时候把一些num数组的元素弄成""了，所以要找到不等于""的元素
                }
                if(num[temp2].equals("")){
                    temp2++; //同理，一个是向前找，一个是向后找
                }
            }
            switch (sym[i]) {
                case "*" -> {
                    num[i] = Double.toString(Double.parseDouble(num[i - 1]) * Double.parseDouble(num[i]));
                    num[i - 1] = "";
                    sym[i] = "";
                }
                case "/" -> {
                    num[i] = Double.toString(Double.parseDouble(num[i - 1]) / Double.parseDouble(num[i]));
                    num[i - 1] = "";
                    sym[i] = "";
                }
                case "*-" -> { //例子: 2*-1 = -1 * 2*1 (前面乘个-1就完事)
                    num[i] = Double.toString(-1 * Double.parseDouble(num[i - 1]) * Double.parseDouble(num[i]));
                    num[i - 1] = "";
                    sym[i] = "";
                }
                case "/-" -> { //例子: 2/-1 = -1 * 2/1 (前面乘个-1就完事)
                    num[i] = Double.toString(-1 * Double.parseDouble(num[i - 1]) / Double.parseDouble(num[i]));
                    num[i - 1] = "";
                    sym[i] = "";
                }
            }
        }

        //再算加减法
        for(int i = 0; i < sym.length; i++){
            temp1 = i-1;
            temp2 = i;
            if(sym[i].equals("")){
                continue; //符号位为空则跳过本次循环寻找下一个符号
            }
            while (num[temp1].equals("") || num[temp2].equals("")){
                if(num[temp1].equals("")){
                    temp1--; //因为做前面的计算时的时候把一些num数组的元素弄成""了，所以要找到不等于""的元素
                }
                if(num[temp2].equals("")){
                    temp2++; //同理，一个是向前找，一个是向后找
                }
            }
            if(sym[i].equals("+")||sym[i].equals("--")){ //负负得正
                num[temp2] = Double.toString(Double.parseDouble(num[temp1]) + Double.parseDouble(num[temp2]));
                num[temp1] = "";
                sym[i] = "";
            }
            else if(sym[i].equals("-")||sym[i].equals("+-")){ //一正一负得负
                num[temp2] = Double.toString(Double.parseDouble(num[temp1]) - Double.parseDouble(num[temp2]));
                num[temp1] = "";
                sym[i] = "";
            }
        }
        for(String n : num){
            if(!n.equals("")){
                formula = n; //从num数组中找到计算结果
                break;
            }
        }
        if(formula.endsWith(".0")){
            formula = formula.replaceAll("\\.0",""); //如果最终结果不是小数,就去掉后面的".0"
        }
        return formula;
    }

    //先把被括号括着的内容算出来
    public static void calculate(String formula){
        formula = formula.replaceAll(Double.toString(2 * Math.asin(1)),"pi");
        System.out.println("  " + formula); //先把原式显示出来
        formula = formula.replaceAll("pi",Double.toString(2 * Math.asin(1)));
        temp1 = 0; //重置
        temp2 = 0;
        //先算小括号(反复执行直到把所有小括号内的算式都算完(从左到右算))
        while(formula.contains("(")) {
            //将算式拆分成一个个字符装进字符数组里
            char[] element = formula.toCharArray();

            //同上,因为字符数组中一个位置不能装多个字符,字符串数组又不能将其中的一段弄成一个字符串,所以很菜的我只能再定义一个字符串数组
            String[] elements = formula.split("");

            //找到左小括号的位置
            for(int i = temp2; i < element.length; i++){
                if(element[i] == '('){
                    temp1 = i; //记录左小括号的索引
                    element[i] = ' '; //记录完之后清除掉这个小括号
                    break; //找到一个就退出循环
                }
            }
            //找到右小括号的位置
            for(int i = temp1; i < element.length; i++){ //从左小括号的位置开始找右小括号
                if(element[i] == ')'){
                    temp2 = i; //记录右小括号的索引
                    element[i] = ' '; //记录完之后清除掉这个小括号
                    break; //找到一个就退出循环
                }
            }
            String newFormula = new String(element,temp1+1,temp2-temp1-1); //用小括号里括着的内容(不包括小括号)组成一个新的字符串(一个算式)
            for (int i = temp1; i < temp2; i++){
                elements[i] = ""; //清除掉字符串数组中小括号以及小括号括着的内容
            }
            elements[temp2] = finalCalculate(newFormula); //将字符串数组的最后一项(右小括号)变为计算newFormula得到的结果
            formula = ""; //清空原算式
            for (String s : elements) {  //将字符串数组连成一个字符串(计算完一个小括号后的算式)
                formula = formula + s;
            }
            System.out.println("= " + formula);  //输出一次算式
        }

        //再算中括号(方法与计算小括号相同,不再赘述)
        while(formula.contains("[")) {
            char[] element = formula.toCharArray();
            String[] elements = formula.split("");
            //找到左中括号的位置
            for(int i = temp2; i < element.length; i++){
                if(element[i] == '['){
                    temp1 = i;
                    element[i] = ' ';
                    break; //找到一个就退出循环
                }
            }
            //找到右中括号的位置
            for(int i = temp1; i < element.length; i++){ //从左中括号的位置开始找右中括号
                if(element[i] == ']'){
                    temp2 = i;
                    element[i] = ' ';
                    break; //找到一个就退出循环
                }
            }
            String newFormula = new String(element,temp1+1,temp2-temp1-1);
            for (int i = temp1; i < temp2; i++){
                elements[i] = "";
            }
            elements[temp2] = finalCalculate(newFormula);
            formula = "";
            for (String s : elements) {
                formula = formula + s;
            }
            System.out.println("= " + formula); //输出一次算式(计算完一个中括号的算式)
        }

        formula = finalCalculate(formula); //所有括号都算完后再进行最后的计算
        System.out.println("= " + formula); //输出计算结果
    }
}
