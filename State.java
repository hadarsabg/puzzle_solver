import java.util.List;

/**
 * Created by hadar on 23/11/2018.
 * represent a state of the puzzle board
 * has all the details about this state that is needed for the algorithms
 */
public class State {
    private StringBuilder path;
    private List<String> currentState;
    private State parentState;
    private int estimateCost;

    /**
     * constructor
     * @param currentState
     * @param parentState
     * @param operator
     */
    public State(List<String> currentState,State parentState, char operator ){
        this.currentState=currentState;
        this.parentState=parentState;
        this.path=new StringBuilder();
        if (this.parentState!=null) {
            this.path.append(this.parentState.getPath());
        }
        if(operator!='s') {
            this.path.append(operator);
        }
    }

    /**
     * return the state representation as list
     * @return the state
     */
    public List<String> getCurrentState(){
        return this.currentState;
    }

    /**
     * get the parent of this state
     * @return this parent state
     */
    public State getParentState(){
        return this.parentState;
    }

    /**
     * return the path of the state
     * @return string of path
     */
    public String getPath(){
        return this.path.toString();
    }

    /**
     * set the cost for A* algorithm
     * @param newCost cost
     */
    public void setCost(int newCost){
        this.estimateCost=newCost;
    }

    /**
     * return estimated heuristic cost
     * @return estimate cost
     */
    public int getEstimateCost(){
        return this.estimateCost;
    }
    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof State))return false;
        State otherMyClass = (State) other;
        return currentState.equals(otherMyClass.getCurrentState());
    }

}
