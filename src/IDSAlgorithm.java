import java.util.List;

/**
 * Created by hadar on 20/11/2018.
 *  this class implement the IDS  algorithm on a given puzzle
 *  in each iteration perform dLs until the max depth
 */
public class IDSAlgorithm implements IAlgorithm {
    private static int numOfVertecies;

    @Override
    public Solution solve(Puzzle puzzle) {
        State initState=puzzle.getInitState();
        State goalState=puzzle.getGoalState();
        // loops through until a goal node is found
        for (int depth = 0; depth < Integer.MAX_VALUE; depth++) {
            IDSAlgorithm.numOfVertecies=1;
            State found = limitedDFS(initState, goalState,depth,puzzle);
            if (found != null) {
                return new Solution(found.getPath(),numOfVertecies,depth);
            }
        }
        return null;
    }

    /**
     * apply depth limited DFS until given maximal depth
     * @param src source state to start search from
     * @param goalState the goal state
     * @param maxDepth maximal depth
     * @param puzzle puzzle game
     * @return state that is goal state if found, else return null
     */
    private State  limitedDFS(State src,State goalState,int maxDepth,Puzzle puzzle){
        if(maxDepth==0 && src.equals(goalState)){
            return src;
        }
        if(maxDepth<=0){
            return null;
        }
        List<State> possibleStates=puzzle.getAllPossibleStates(src);
        for (State s:possibleStates){
                IDSAlgorithm.numOfVertecies++;
                State st = limitedDFS(s, goalState, maxDepth - 1, puzzle);
                if (st != null) {
                    return st;

            }
        }
        return null;
    }
}
