import java.util.*;

/**
 * Created by hadar on 20/11/2018.
 * this class implement the A star algorithm on a given puzzle
 * using a heuristic function and priority queue
 */
public class AStarAlgorithm implements IAlgorithm {

    private int numOfVertices, depth;

    @Override
    public Solution solve(Puzzle puzzle) {
        HashSet<State> closeSet = new HashSet<>();
        State initState = puzzle.getInitState();
        State goalState = puzzle.getGoalState();
        Comparator<State> heuristicFunctionComparator = new Comparator<State>() {
            @Override
            public int compare(State s1, State s2) {
                return s1.getEstimateCost()-s2.getEstimateCost();
            }
        };
        PriorityQueue<State>openVer =new PriorityQueue<>(heuristicFunctionComparator);

        openVer.add(initState);

        while (!openVer.isEmpty()) {
            State state = openVer.remove();
            closeSet.add(state);
            if (state.equals(goalState)) {
                return new Solution(state.getPath(),closeSet.size(),state.getPath().length());
            }
            List<State> possibleStates = puzzle.getAllPossibleStates(state);
            for (State s : possibleStates) {
                s.setCost(puzzle.heuristicCostEstimate(s) + s.getPath().length());
                openVer.add(s);
            }

        }
        return null;
    }

}
