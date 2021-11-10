package RedRock_Android_Java.test12;

public class Soldier2 implements Soldier{
    private final String name;

    Soldier2(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void respond(String name){
        System.out.println(name + ":国王好!");
    }
}
