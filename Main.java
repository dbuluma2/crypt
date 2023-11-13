import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Character> alphabet = new LinkedList<Character>();
        for (int i = 0; i < 256; i++) {
            alphabet.add((char) i);
        }
     System.out.print(alphabet.get(1));
        Random rand = new Random(42);
        for (int i = alphabet.size() - 1; i > 0; i--) {
            int counter = rand.nextInt(i + 1);
            char temp = alphabet.get(i);
            alphabet.set(i, alphabet.get(counter));
            alphabet.set(counter, temp);

        }



    }
}