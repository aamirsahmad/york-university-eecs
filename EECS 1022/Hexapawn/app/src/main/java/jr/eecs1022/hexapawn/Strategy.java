package jr.eecs1022.hexapawn;

import java.util.HashMap;
import java.util.Map;

public class Strategy
{

    // the state is a map that sets the move for a given board
    private Map<String, BoardMove> blackLogic;

    /**
     * Constructs the strategy by initilizing the state
     */
    public Strategy()
    {
        // first move - white movees left pawn
        this.blackLogic.put("BBBW   WW", new BoardMove(0,1,1,0));
        this.blackLogic.put("B BW    W", new BoardMove(0,2,1,2));
        this.blackLogic.put("B BBW   W", new BoardMove(1,0,2,0));
        this.blackLogic.put("B BB W W ", new BoardMove(1,0,2,0));

        // first move - white movees right pawn
        this.blackLogic.put("BBB  WWW ", new BoardMove(0,1,1,2));
        this.blackLogic.put("B B  WW  ", new BoardMove(0,0,1,0));
        this.blackLogic.put("B B WBW  ", new BoardMove(1,2,2,2));
        this.blackLogic.put("B BW B W ", new BoardMove(1,2,2,2));

        // first move - white movees centre pawn
        this.blackLogic.put("BBB W W W", new BoardMove(0,1,1,1));

        // second move - white moves left pawn
        this.blackLogic.put(" BB W   W", new BoardMove(0,2,1,2));
        this.blackLogic.put(" BBWB   W", new BoardMove(1,1,2,1));

        // second move - white moves right pawn
        this.blackLogic.put(" BB W W  ", new BoardMove(0,2,1,2));
        this.blackLogic.put(" B WWB   ", new BoardMove(1,2,2,2));
        this.blackLogic.put(" BB BWW  ", new BoardMove(1,1,2,1));
    }

    /**
     * Given a current board position (as a string), execute the machine's move
     * @param key The current board position expressed as W-white piece, B-black piece,  ' '-empty.
     *            Board is given in row major order
     */
    public BoardMove move(String key)
    {
        return blackLogic.get(key);
    }
}
