package jr.eecs1022.hexapawn;

/**
 * A Board position is a  row and column pair.
 *
 * @author Michael Jenkin
 * @version 1.0
 */
public class BoardPos
{
    private int row, col;

    public int getCol()
    {
        return col;
    }

    public void setCol(int col)
    {
        this.col = col;
    }

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public BoardPos(int row, int col)
    {
        this.row = row;
        this.col = col;

    }

    public String toString()
    {
        return "boardPos " + this.row + " " + this.col;
    }
}
