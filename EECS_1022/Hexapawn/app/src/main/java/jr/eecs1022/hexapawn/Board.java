package jr.eecs1022.hexapawn;

import java.util.List;
import java.util.ArrayList;

/**
 * This class encapsulates a Hexapawn board. The board is of size WIDTH x WIDTH.
 * The white home is on row WIDTH-1, while the black home is on row 0. A square on the
 * board contains either a WHITE_PIECE, a BLACK_PIECE or is EMPTY.
 *
 * @author Michael Jenkin
 * @version 1.0
 */
public class Board
{
    public static final int WIDTH = 3;

    public enum Contents
    {
        EMPTY, BLACK_PIECE, WHITE_PIECE
    }

    private Contents[][] field;

    /**
     * Create an empty board with the pieces in their start position.
     */
    public Board()
    {
        field = new Contents[WIDTH][WIDTH];
        resetBoard();
    }

    /**
     * Reset the board so that all the pieces are in their start position.
     */
    public void resetBoard()
    {
        for (int c = 0; c < WIDTH; c++)
            field[0][c] = Contents.BLACK_PIECE;
        for (int r = 1; r < WIDTH - 1; r++)
        {
            for (int c = 0; c < WIDTH; c++)
                field[r][c] = Contents.EMPTY;
        }
        for (int c = 0; c < WIDTH; c++)
            field[WIDTH - 1][c] = Contents.WHITE_PIECE;
    }

    public void setContents(BoardPos pos, Contents val)
    {
        field[pos.getRow()][pos.getCol()] = val;
    }

    public Contents getContents(BoardPos pos)
    {
        return field[pos.getRow()][pos.getCol()];
    }

    public Contents getContents(int row, int col)
    {
        return field[row][col];
    }

    /**
     * Check if white has won. White wins if white has a piece in row 0
     */
    public boolean hasWhiteWon()
    {
        for (int c = 0; c < Board.WIDTH; c++)
            if (this.getContents(0, c) == Board.Contents.WHITE_PIECE)
                return true;
        return false;
    }

    /**
     * Check if black has won. Black wins if black has a piece in row WIDTH-1
     */
    public boolean hasBlackWon()
    {
        for (int c = 0; c < Board.WIDTH; c++)
            if (this.getContents(Board.WIDTH - 1, c) == Board.Contents.BLACK_PIECE)
                return true;
        return false;
    }

    /**
     * Does black have a valid move?
     * @return true if black can move
     */
    public boolean canBlackMove()
    {
        for (int r = 0; r < Board.WIDTH - 1; r++)
        {
            for (int c = 0; c < Board.WIDTH; c++)
            {
                if (this.getContents(r, c) == Contents.BLACK_PIECE)
                {
                    if (this.getContents(r + 1, c) == Contents.EMPTY)
                        return true;
                    if ((c > 0) && (this.getContents(r + 1, c - 1) == Contents.WHITE_PIECE))
                        return true;
                    if ((c < Board.WIDTH - 1) && (this.getContents(r + 1, c + 1) == Contents.WHITE_PIECE))
                        return true;
                }

            }
        }
        return false;
    }

    /**
     * Does white have a valid move?
     * @return true if white can move
     */
    public boolean canWhiteMove()
    {
        for (int r = 1; r < Board.WIDTH; r++)
        {
            for (int c = 0; c < Board.WIDTH; c++)
            {
                if (this.getContents(r, c) == Contents.WHITE_PIECE)
                {
                    if (this.getContents(r - 1, c) == Contents.EMPTY)
                        return true;
                    if ((c > 0) && (this.getContents(r - 1, c - 1) == Contents.BLACK_PIECE))
                        return true;
                    if ((c < Board.WIDTH - 1) && (this.getContents(r - 1, c + 1) == Contents.BLACK_PIECE))
                        return true;
                }

            }
        }
        return false;
    }

    /**
     * Return all of the valid moves for the white piece at position pos.
     * @param pos the location of a white piece on the board.
     * @return a list of all of the valid move locations for the given piece at pos.
     */
    public List<BoardPos> validWhiteMoves(BoardPos pos)
    {
        if (getContents(pos) != Contents.WHITE_PIECE)
            throw new RuntimeException("There was no white piece at " + pos);
        List<BoardPos> moves = new ArrayList<BoardPos>();
        if (pos.getRow() == 0)
            return moves;
        if (getContents(pos.getRow() - 1, pos.getCol()) == Contents.EMPTY)
            moves.add(new BoardPos(pos.getRow() - 1, pos.getCol()));
        if ((pos.getCol() != 0) && (getContents(pos.getRow() - 1, pos.getCol() - 1) == Contents.BLACK_PIECE))
            moves.add(new BoardPos(pos.getRow() - 1, pos.getCol() - 1));
        if ((pos.getCol() != (WIDTH - 1)) && (getContents(pos.getRow() - 1, pos.getCol() + 1) == Contents.BLACK_PIECE))
            moves.add(new BoardPos(pos.getRow() - 1, pos.getCol() + 1));

        return moves;
    }

    public String toStringKey()
    {
        StringBuffer sb = new StringBuffer();
        for (int r = 0; r < Board.WIDTH; r++)
        {
            for (int c = 0; c < Board.WIDTH; c++)
            {
                switch (getContents(r, c))
                {
                    case EMPTY:
                        sb.append(' ');
                        break;
                    case WHITE_PIECE:
                        sb.append('W');
                        break;
                    case BLACK_PIECE:
                        sb.append('B');
                        break;
                }

            }
        }
        return sb.toString();
    }
}
