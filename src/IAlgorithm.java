/**
 * Created by hadar on 20/11/2018.
 * interface of algorithm to solve puzzle
 */
public interface IAlgorithm {
     /**
      * apply the desire algorithm logic to solve given puzzle
      * @param puzzle the puzzle game board
      * @return solution object
      */
     Solution solve(Puzzle puzzle);

}


