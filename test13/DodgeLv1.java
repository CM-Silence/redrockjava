package redrockjava.test13;

public class DodgeLv1 extends Dodge{

    void dodgeEnemy(Enemy enemy){
        next.dodgeEnemy(enemy);
    }

}
