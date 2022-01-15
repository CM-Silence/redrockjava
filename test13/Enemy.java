package redrockjava.test13;

public class Enemy {
    final int ATK;
    Enemy(int attack){
        this.ATK = attack;
    }

    void attack(Dodge dodge){
        dodge.dodgeEnemy(this);
    }

    void attacked(){
        System.out.println("反击成功!");
    }
}
