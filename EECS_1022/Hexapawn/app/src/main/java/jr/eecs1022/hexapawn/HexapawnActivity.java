package jr.eecs1022.hexapawn;

import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;


/**
 * A very simple application to play Hexapawn. The human plays white and the machine
 * plays black. Machine logic is controlled through two methods, initializeBlackLogic,
 * and blackMoves.  The rest of this is just the UI to make it work.
 *
 * @author Michael Jenkin
 * @version 1.0
 */


public class HexapawnActivity extends ActionBarActivity implements View.OnClickListener
{
    private Strategy black;

    // map buttons (corresponding to squares on the board, to the board positions
    private static final int[][] buttons =
            {
                    {R.id.pos00, R.id.pos01, R.id.pos02},
                    {R.id.pos10, R.id.pos11, R.id.pos12},
                    {R.id.pos20, R.id.pos21, R.id.pos22}
            };

    // the game is always in one of these states
    private enum InputState
    {
        PIECE_SELECTION, DESTINATION, GAME_OVER
    }

    // the state of the game is defined by these three values
    private InputState inputState = InputState.PIECE_SELECTION;
    private Board curBoard = new Board();
    private BoardPos oldPos = null;

    /**
     * Set up for a new game
     */
    private void restartGame()
    {
        curBoard.resetBoard();
        drawBoard();
        deselectAll();
        makeWhitePiecesSelectable();
        inputState = InputState.PIECE_SELECTION;
        TextView textView = (TextView) findViewById(R.id.statusLine);
        textView.setText(R.string.play_game);
    }


    /**
     * Given a current board position (as a string), execute the machine's move
     *
     * @param key The current board position expressed as W-white piece, B-black piece,  ' '-empty.
     *            Board is given in row major order
     */
    public void blackMoves(String key)
    {
        System.out.println("time for black to move " + key);
        // insert your move logic here
        BoardMove move = black.move(key);
        System.out.println(black.move(key).getFromPos());
        System.out.println(black.move(key).getToPos());

        // and update the board's state
        oldPos = move.getFromPos();
        curBoard.setContents(move.getFromPos(),Board.Contents.EMPTY);
        curBoard.setContents(move.getToPos(),Board.Contents.BLACK_PIECE);

        // Finally, we update the UI like this:
        TextView textView = (TextView) findViewById(R.id.statusLine);
        textView.setText("board state: |" + key + "| to |" + curBoard.toStringKey() + "|");
    }

    /**
     * Unselect all of the board buttons
     */
    private void deselectAll()
    {
        for (int r = 0; r < Board.WIDTH; r++)
        {
            for (int c = 0; c < Board.WIDTH; c++)
            {
                ImageButton b = (ImageButton) findViewById(buttons[r][c]);
                b.setEnabled(false);
            }
        }

    }

    /**
     * Draw the board based on curBoard
     */
    private void drawBoard()
    {
        for (int r = 0; r < Board.WIDTH; r++)
        {
            for (int c = 0; c < Board.WIDTH; c++)
            {
                ImageButton b = (ImageButton) findViewById(buttons[r][c]);
                boolean isWhite = ((r + c) % 2) == 0;
                switch (curBoard.getContents(r, c))
                {
                    case BLACK_PIECE:
                        b.setImageResource(isWhite ? R.drawable.white_black : R.drawable.black_black);
                        break;
                    case WHITE_PIECE:
                        b.setImageResource(isWhite ? R.drawable.white_white : R.drawable.black_white);
                        break;
                    case EMPTY:
                        b.setImageResource(isWhite ? R.drawable.whitesquare : R.drawable.blacksquare);
                        break;

                }
            }
        }
    }

    /**
     * Mark only squares with white pieces that can be moved as selectable
     */
    private void makeWhitePiecesSelectable()
    {
        for (int r = 0; r < Board.WIDTH; r++)
        {
            for (int c = 0; c < Board.WIDTH; c++)
            {
                BoardPos pos = new BoardPos(r, c);
                boolean enabled = (curBoard.getContents(pos) == Board.Contents.WHITE_PIECE) &&
                        (curBoard.validWhiteMoves(pos).size() > 0);
                ImageButton b = (ImageButton) findViewById(buttons[r][c]);
                b.setEnabled(enabled);
            }
        }
    }

    /**
     * Mark only the squares given as selectable
     */
    private void makeListSelectable(List<BoardPos> list)
    {
        deselectAll();
        for (BoardPos pos : list)
        {
            ImageButton b = (ImageButton) findViewById(buttons[pos.getRow()][pos.getCol()]);
            b.setEnabled(true);
        }
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        this.black = new Strategy();
    }


    @Override
    protected void onResume()
    {
        super.onResume();
        restartGame();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hexapawn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hexapawn, menu);
        return true;
    }

    /**
     * Deal with requests to restart the game from the UI
     * @param view the current view in display.
     */
    public void restartGame(View view)
    {
        restartGame();
    }


    /**
     * Deal with a click on any board position.
     *
     * @param view the current view in display.
     */
    public void onClick(View view)
    {
        int button = view.getId();
        int row = -1;
        int col = -1;
        for (int r = 0; r < Board.WIDTH; r++)
        {
            for (int c = 0; c < Board.WIDTH; c++)
            {
                if (buttons[r][c] == button)
                {
                    row = r;
                    col = c;
                }
            }
        }
        System.out.println("you clicked on row " + row + " col " + col);


        TextView textView = (TextView) findViewById(R.id.statusLine);
        switch (inputState)
        {
            case GAME_OVER:
                break;
            case PIECE_SELECTION:
                oldPos = new BoardPos(row, col);
                List<BoardPos> moves = curBoard.validWhiteMoves(oldPos);
                makeListSelectable(moves);
                inputState = InputState.DESTINATION;
                break;
            case DESTINATION:
                curBoard.setContents(oldPos, Board.Contents.EMPTY);
                curBoard.setContents(new BoardPos(row, col), Board.Contents.WHITE_PIECE);
                if (curBoard.hasWhiteWon())
                {
                    textView.setText(R.string.white_wins);
                    deselectAll();
                    drawBoard();
                    inputState = InputState.GAME_OVER;
                } else
                {
                    if (curBoard.canBlackMove())
                    {
                        blackMoves(curBoard.toStringKey());
                        drawBoard();
                        if (curBoard.hasBlackWon())
                        {
                            textView.setText(R.string.black_wins);
                            inputState = InputState.GAME_OVER;
                            deselectAll();
                        } else if (curBoard.canWhiteMove())
                        {
                            makeWhitePiecesSelectable();
                            inputState = InputState.PIECE_SELECTION;
                        } else
                        {
                            textView.setText(R.string.black_wins);
                            inputState = InputState.GAME_OVER;
                            deselectAll();
                        }
                    } else
                    {
                        textView.setText(R.string.white_wins);
                        drawBoard();
                        inputState = InputState.GAME_OVER;
                    }
                }
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
