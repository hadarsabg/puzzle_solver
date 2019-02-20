import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hadar on 20/11/2018.
 *main- read from input file, parse the text to the right arguments to create a puzzle object
 * and call the solve method of the desired algorithm, then print solution to the output file
 */
public class java_ex1 {
    public static void main(String[] args) {
        int algorithmCode, size;
        List<String> init = new ArrayList<String>();

        Solution solution;


        File file = new File("input.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            algorithmCode = Integer.parseInt(br.readLine());
            size = Integer.parseInt(br.readLine());
            //read from input file
            init = Arrays.asList(br.readLine().split("-"));
            State initState = new State(init, null, 's');
            Puzzle puzzle = new Puzzle(size, initState);
            br.close();
            // apply desire algorithm according to input file
            switch (algorithmCode) {
                case 1:
                    solution=new IDSAlgorithm().solve(puzzle);
                    break;
                case 2:
                    solution = new BFSAlgorithm().solve(puzzle);
                    break;
                case 3:
                    solution = new AStarAlgorithm().solve(puzzle);
                    break;
                default:
                    solution = null;
            }
            //generate output file of solution
            if (solution != null) {
                solution.createOutputFile();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
