package redrockjava.test9;

//work2 level0
//面向对象练习
public class Test9 {
    public static void main(String[] args) {
        //new出CV想要的对象(CV的对象还要我来new呀?)
        Elephant elephant = new Elephant(2.5,4.2,2000);
        Tiger tiger = new Tiger(0.8,3.4,450);
        Monkey monkey = new Monkey(1.4,0.6,80);
        Refrigerator refrigerator = new Refrigerator(2.5,0.8);
        Washer washer = new Washer(1.2,0.8);
        Oven oven = new Oven(0.8,0.6);
        Closet closet = new Closet(3.0,1.0);

        //1.大象进冰箱
        refrigerator.open();
        elephant.in(refrigerator);
        refrigerator.close();

        //2.大象进洗衣机(先出冰箱awa)
        refrigerator.open();
        elephant.out(refrigerator);
        washer.open();
        elephant.in(washer);
        washer.close();

        //3.大象进烤箱(同上)
        washer.open();
        elephant.out(washer);
        oven.open();
        elephant.in(oven);
        oven.close();

        //4.大象进衣柜(同上)
        oven.open();
        elephant.out(oven);
        closet.open();
        elephant.in(closet);
        closet.close();

        //5.老虎进冰箱
        refrigerator.open();
        tiger.in(refrigerator);
        refrigerator.close();

        //6.老虎进衣柜
        refrigerator.open();
        tiger.out(refrigerator);
        closet.open();
        tiger.in(closet);
        closet.close();

        //7.猴子进烤箱
        oven.open();
        monkey.in(oven);
        oven.close();

        //8.烤大象(大象太难了awa)(先出衣柜)(猴子是不是也被烤了awa)
        closet.open();
        elephant.out(closet);
        oven.open();
        elephant.in(oven);
        oven.close();
        oven.bake(elephant);

        //9.洗老虎
        closet.open();
        tiger.out(closet);
        washer.open();
        tiger.in(washer);
        washer.close();
        washer.wash(tiger);

    }
}

