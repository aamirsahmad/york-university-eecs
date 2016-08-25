package jr.eecs1022.hexapawn;

/**
 * This class encompases a move on the board. It consists of a fromPosition
 * and a toPosition.
 *
 * @version 1.0
 * @author Michael Jenkin
 */
public class BoardMove
{
    private BoardPos fromPos, toPos;

    public BoardPos getFromPos()
    {
        return fromPos;
    }

    public void setFromPos(BoardPos fromPos)
    {
        this.fromPos = fromPos;
    }

    public BoardPos getToPos()
    {
        return toPos;
    }

    public void setToPos(BoardPos toPos)
    {
        this.toPos = toPos;
    }

    public BoardMove(BoardPos fromPos, BoardPos toPos)
    {
        this.fromPos = fromPos;
        this.toPos = toPos;
    }

    public BoardMove(int row0, int col0, int row1, int col1)
    {
        this(new BoardPos(row0, col0), new BoardPos(row1, col1));
    }
}
