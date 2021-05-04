import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Java class extends Scala class. An array will be
 * populated from a given file. The Warshall method
 * in the scala class will perform the operations
 *
 * @author Stockton Woodworth
 */
public class runQ5 extends Q5Final {

    static Q5Final test = new Q5Final();

    /**
     * Drive method, first populates an array from a given file
     * Then calls FloydWarshall method from the Scala class on it.
     *
     * @param args - cmd line arguments
     * @throws FileNotFoundException - file can't be found
     */
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(new BufferedReader(new FileReader("./src/Q5Array")));
        double[][] W = new double[11][11];

        // populate array from file
        while (scan.hasNextLine()) {
            for (int i = 0; i < W.length; i++) {
                String[] line = scan.nextLine().trim().split(" ");
                for (int j = 0; j < line.length; j++) {
                    W[i][j] = Double.parseDouble(line[j]);
                }
            }
        }
        test.FloydWarshall(W);
    }
}
