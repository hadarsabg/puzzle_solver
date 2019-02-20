import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hadar on 20/11/2018.
 *  this class implement the BFS algorithm on a given puzzle
 */
public class BFSAlgorithm extends Algorithm {


    @Override
    public Solution solve(Puzzle puzzle) {
        addVer(puzzle.getInitState());
        State goal = puzzle.getGoalState();
        while (!this.isEmpty()) {
            State state = dequeue();
            if (state.equals(goal)) {
                return new Solution(state.getPath(), this.getNumOfVertices(), 0);
            }
            List<State> possibleStates = puzzle.getAllPossibleStates(state);
            for (State s : possibleStates) {
                addVer(s);

            }
        }
        return null;
    }
}


