package redrockjava.test12;

public interface Soldier {
    String name = null;
    void respond(String name);
    default String getName(){
        return name;
    }
}
