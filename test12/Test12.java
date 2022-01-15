package redrockjava.test12;

//work3 level3
//国王阅兵(回调,匿名类,lambda表达式)
public class Test12 {
    public static void main(String[] args) {
        KingBoJi boJi = new KingBoJi(); //new一个国王出来
        boJi.review(); //国王第一次阅兵

        boJi.addSoldier1("阿伟"); //往国王的军队添加一个叫阿伟的人
        boJi.addSoldier1("彬彬");
        boJi.addSoldier2("杰哥");
        boJi.subSoldier("迈克");  //将迈克从国王的军队里移出
        boJi.subSoldier("卷王");  //尝试去除不在国王军队里面的人
        boJi.review(); //国王第二次阅兵

        boJi.subSoldier("阿伟");
        boJi.subSoldier("彬彬");  //将三个士兵从国王的军队里面移出
        boJi.subSoldier("杰哥");

        boJi.addSoldier3("卷王"); //通过匿名内部类往国王的军队里添加卷王和肝帝
        boJi.addSoldier3("肝帝");
        boJi.review(); //国王第三次阅兵

        boJi.addSoldier4("郭卷王");
        boJi.addSoldier4("廖卷王"); //通过lambda表达式往国王的军队里面添加两个卷王
        boJi.review(); //国王第四次阅兵

        boJi.subSoldier("郭卷王");
        boJi.subSoldier("廖卷王"); //移除两个卷王并用lambda精简版方法添加卷怪
        boJi.addSoldier5("卷怪");
        boJi.review(); //国王第五次阅兵
    }
}
