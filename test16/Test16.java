package redrockjava.test16;

//work4 level4
//回合制小游戏修改版(回调,面向对象,抽象类,反射)
public class Test16 {

    //main方法里面装少点东西应该没问题吧?应该吧?
    public static void main(String[] args) {
        GetReady getReady = new GetReady();
        getReady.ready(); //进行游戏前的准备(让用户输入英雄的属性)
        getReady.begin(); //开始游戏
    }
}
