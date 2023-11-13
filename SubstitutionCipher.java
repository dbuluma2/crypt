
import java.util.List;
import java.util.LinkedList;
import java.util.Random;
public class SubstitutionCipher extends Cipher {
    List<Character> unchangedalphabet;
    List<Character> shuffledalphabet;
    /**
     * The specialized constructor.
     *
     * @param key The key to be used for encryption/decryption operations.
     **/
    public SubstitutionCipher(long key) {
        super(key);
        unchangedalphabet = new LinkedList<Character>();
        for (int i = 0; i < 256; i++) {
            unchangedalphabet.add((char) i);
        }
        shuffledalphabet = new LinkedList<Character>();
        for (int i = 0; i < 256; i++) {
            shuffledalphabet.add((char) i);
        }
        Random rand = new Random(getKey());
        for (int i = shuffledalphabet.size() - 1; i > 0; i--) {
            int counter = rand.nextInt(i + 1);
            char temp = shuffledalphabet.get(i);
            shuffledalphabet.set(i, shuffledalphabet.get(counter));
            shuffledalphabet.set(counter, temp);

        }
    }

    @Override
    public List<Character> encrypt(List<Character> cleartext) {

        List<Character> ciphertext = new LinkedList<Character>();
        for (char element : cleartext) {
            int position = unchangedalphabet.indexOf(element);
            char toadd = shuffledalphabet.get(position);
            ciphertext.add(toadd);
        }
        return ciphertext;
    }

    @Override
    public List<Character> decrypt(List<Character> ciphertext) {

        List<Character> cleartext = new LinkedList<Character>();
        for (char tochange : ciphertext) {
            int position = shuffledalphabet.indexOf(tochange);
            char toadd = unchangedalphabet.get(position); ;
            cleartext.add(toadd);
        }
        return cleartext;
    }
}
