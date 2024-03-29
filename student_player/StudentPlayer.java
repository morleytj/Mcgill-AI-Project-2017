package student_player;

import java.util.ArrayList;
import java.util.Random;

import bohnenspiel.BohnenspielBoardState;
import bohnenspiel.BohnenspielMove;
import bohnenspiel.BohnenspielPlayer;
import bohnenspiel.BohnenspielMove.MoveType;
import student_player.mytools.MyTools;

/** A Hus player submitted by a student. */
public class StudentPlayer extends BohnenspielPlayer {
	//Random rand = new Random();
    /** You must modify this constructor to return your student number.
     * This is important, because this is what the code that runs the
     * competition uses to associate you with your agent.
     * The constructor should do nothing else. */
    public StudentPlayer() { super("260621657"); }

    /** This is the primary method that you need to implement.
     * The ``board_state`` object contains the current state of the game,
     * which your agent can use to make decisions. See the class
bohnenspiel.RandomPlayer
     * for another example agent. */
    public BohnenspielMove chooseMove(BohnenspielBoardState board_state)
    {
        // Get the contents of the pits so we can use it to make decisions.
        //int[][] pits = board_state.getPits();

        // Use ``player_id`` and ``opponent_id`` to get my pits and opponent pits.
        //int[] my_pits = pits[player_id];
        //int[] op_pits = pits[opponent_id];

        // Use code stored in ``mytools`` package.
        //MyTools.getSomething();

        // Get the legal moves for the current board state.
        //ArrayList<BohnenspielMove> moves = board_state.getLegalMoves();
        //BohnenspielMove move = moves.get(0);
  
     
        // We can see the effects of a move like this...
        //BohnenspielBoardState cloned_board_state = (BohnenspielBoardState) board_state.clone();
        //cloned_board_state.move(move);
    	
    	//For measuring time remaining for a move ;; later I will implement a separate opening strategy
    	long startTime = System.nanoTime();
    	long currentTimeElapsed = System.nanoTime() - startTime;
        //This is (going to be) an iterative deepening AB search.
    	int depth=0;
    	BohnenspielMove choice=null;
    	while(!MyTools.timeOut(currentTimeElapsed))
    	{
    		choice=MyTools.abSearch(board_state, player_id, opponent_id, depth,startTime);
    		currentTimeElapsed = System.nanoTime() - startTime;
    		//System.out.println(depth);
    		depth++;
    	}
    	return choice;
    }
}