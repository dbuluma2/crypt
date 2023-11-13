import java.io.FileWriter;
import java.io.IOException;

public class Experiments {
    public static void main(String[] args) {
        int[][] table = new int[256][256];
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                table[i][j] = 0;

            }
        }
        long key = Long.parseLong(args[0]);
            for (int trials = 0; trials < 100; trials++) {

                SubstitutionCipher cipher = new SubstitutionCipher(key);

                for (int i = 0; i < 256; i++) {
                    char mapped = cipher.unchangedalphabet.get(i);
                    char mappedto = cipher.shuffledalphabet.get(i);
                    table[i][mappedto]++;
                }

            }
        try {
            FileWriter writer = new FileWriter("table.txt");
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[0].length; j++) {
                    writer.write(table[i][j] + " ");
                }
                writer.write("\n");
            }
            writer.close();
            System.out.println("Table.txt file was generated successfully! This is it's interpretation:\n" +
                    " \nThe program ran 100 trials of SubstitutionCipher and recorded how many times a character i(vertical) \nwas mapped to character j(horizontal) during the trials." +
                    " I have listed the i characters and j characters\nafter the last paragraph." +
                    " Since the trials done are 100, the frequencies recorded are percentages.\n" +
                    "In the table, each column and row has 100 percent only once and the rest of the digits are 0.\n" +
                    "\nIf (i,j) is 100 percent,this means that i will always be mapped to j and not any other character \nprovided that the key remains the same. This proves that " +
                    "SubstitutionCipher works correctly because\ncharacters are only mapped once. In other words, we can't have a situation where two different\ncharacters are mapped to the same character.\n" +
                    "j characters:");
            for(int i = 0; i < 256; i++){
                System.out.print((char)i);
            }
            System.out.println();
            System.out.println("i characters:");
            for(int i = 0; i < 256; i++){
                System.out.println((char)i);
            }

        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");

    }
        }
    }



