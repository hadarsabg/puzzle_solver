import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by hadar on 20/11/2018.
 * this class represnt the puzzle game board, hes all the data about states and legal
 * operators that can be apply on the board
 */
public class Puzzle {
    private int size;
    private State initState;

    /**
     * constructor
     * @param size board size
     * @param initState initial stat
     */
    public Puzzle(int size, State initState) {
        this.size = size;
        this.initState = initState;
    }


    /**
     * return init state
     * @return thi.initstate
     */
    public State getInitState() {
        return this.initState;
    }

    /**
     * return a list of all states you can get from a given state
     * @param currentState state
     * @return
     */
    public List<State> getAllPossibleStates(State currentState) {

        List<State> possibleStates = new ArrayList<>();
        possibleStates.add(this.up(currentState));
        possibleStates.add(this.down(currentState));
        possibleStates.add(this.left(currentState));
        possibleStates.add(this.right(currentState));
        possibleStates.removeAll(Collections.singleton(null));
        return possibleStates;
    }

    /**
     * generate the board goal state
     * @return the board goal state
     */
    public State getGoalState() {
        List<String> currState = new ArrayList<>();
        for (int i = 1; i < this.size * this.size; i++) {
            currState.add(String.valueOf(i));
        }
        currState.add("0");
        return new State(currState, null, 's');
    }

    /**
     * apply move down operator on the puzzle  on given state
     * @param state  current state
     * @return new state of the board
     */
    public State down(State state) {
        List<String> resultState = new ArrayList<>();
        resultState.addAll(state.getCurrentState());
        int i = 0;
        while (!state.getCurrentState().get(i).equals("0")) {
            i++;
        }
        int pos = i - size;
        if (pos < size * size && pos >= 0) {
            Collections.swap(resultState, i, pos);
        } else {
            return null;
        }
        State result = new State(resultState, state, 'D');
        return result;
    }

    /**
     * apply move up operator on the puzzle  on given state
     * @param state  current state
     * @return new state of the board
     */
    public State up(State state) {
        List<String> resultState = new ArrayList<>();
        resultState.addAll(state.getCurrentState());
        int i = 0;
        while (!state.getCurrentState().get(i).equals("0")) {
            i++;
        }
        int pos = i + size;
        if (pos < size * size && pos >= 0) {
            Collections.swap(resultState, i, pos);
        } else {
            return null;
        }
        State result = new State(resultState, state, 'U');
        return result;
    }
    /**
     * apply move right operator on the puzzle  on given state
     * @param state  current state
     * @return new state of the board
     */
    public State right(State state) {
        List<String> resultState = new ArrayList<>();
        resultState.addAll(state.getCurrentState());
        int i = 0;
        while (!state.getCurrentState().get(i).equals("0")) {
            i++;
        }
        int pos = i - 1;
        if (pos < size * size && pos >= 0 && i / size == pos / size) {
            Collections.swap(resultState, i, pos);
        } else {
            return null;
        }
        State result = new State(resultState, state, 'R');
        return result;
    }

    /**
     * apply move left operator on the puzzle  on given state
     * @param state  current state
     * @return new state of the board
     */
    public State left(State state) {
        List<String> resultState = new ArrayList<>();
        resultState.addAll(state.getCurrentState());
        int i = 0;
        while (!state.getCurrentState().get(i).equals("0")) {
            i++;
        }
        int pos = i + 1;
        if (pos < size * size && pos >= 0 && i / size == pos / size) {
            Collections.swap(resultState, i, pos);
        } else {
            return null;
        }
        State result = new State(resultState, state, 'L');
        return result;
    }

    /**
     * calculate the sum of manhtten distance for all cells in board
     * @param state current state
     * @return the manhtten distance
     */
    public int heuristicCostEstimate(State state) {
        int dst = 0;

        for (int i = 0; i < state.getCurrentState().size(); i++) {
            int val = Integer.parseInt(state.getCurrentState().get(i));
            if (val != 0) {
                int rowdst = Math.abs((val - 1) / size - (i / size));
                int coldst = Math.abs((val - 1) % size - (i % size));
                dst += (rowdst + coldst);
            }
        }
        return dst;
    }
}

