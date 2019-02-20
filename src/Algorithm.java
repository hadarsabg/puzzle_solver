import java.util.LinkedList;
import java.util.List;

/**
 * Created by hadar on 23/11/2018.
 * abstract class of algorithm- has all members and methods
 * that are shared for all the algorithms
 */
public abstract class Algorithm implements IAlgorithm {
    private int numOfVertices, depth;
    private LinkedList<State> openVer;

    /**
     * constructor
     */
    public Algorithm() {
        this.openVer = new LinkedList<>();
    }

    /**
     * get num of verticies
     * @return  this.numOfVertices
     */
    public int getNumOfVertices() {
        return this.numOfVertices;
    }


    /**
     * add new state to the queue
     * @param state new state
     */
    protected void addVer(State state) {
        this.openVer.add(state);
    }

    /**
     * dequeue from queue
     * @return
     */
    protected State dequeue() {
        numOfVertices++;
        return this.openVer.poll();
    }

    /**
     * check if queue is empty
     * @return True if empty, else retun false
     */
    protected boolean isEmpty() {
        return this.openVer.isEmpty();
    }

    @Override
    public abstract Solution solve(Puzzle puzzle);
}
