package redrockjava;
import java.util.*;

public class Test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for(int i = 1; i <= n; i++){
            count += i; //所有的情况数量为n!
        }

    }
}
