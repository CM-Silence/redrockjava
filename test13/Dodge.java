package RedRock_Android_Java.test13;

public abstract class Dodge {
    Dodge next;

    static final int DODGE = 100; //王子防御力为100

    abstract void dodgeEnemy(Enemy enemy); //抽象闪避方法

    public Dodge getNext(){ return next; }

    public void setNext(Dodge next) { this.next = next; }

    //静态内部类
    public static class Builder {
        DodgeLv1 first = new DodgeLv1();
        Dodge next = first;

        //Builder类的add方法
        public Builder add(DodgeLv1 dodge){
            next.setNext(dodge);
            next = dodge;
            return this;
        }

        //Builder类的build方法
        public DodgeLv1 build(){
            return first;
        }
    }
}
