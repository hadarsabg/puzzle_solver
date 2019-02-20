import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by hadar on 20/11/2018.
 * solution object that get path ,num of vertex and depth and
 * can generate a file with these details
 */
public class Solution {
    private String path;
    private int numOfVertices, depth;

    /**
     * constructor
     * @param path soulotion path
     * @param numOfVertices num of expended vertex
     * @param depth depth of tree
     */
    public Solution(String path, int numOfVertices, int depth) {
        this.path = path;
        this.numOfVertices = numOfVertices;
        this.depth = depth;
    }

    /**
     * generate output file with all the details
     */
    public void createOutputFile() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("output.txt");
            writer.println(path + " " + numOfVertices + " " + depth);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

