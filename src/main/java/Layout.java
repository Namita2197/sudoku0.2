import javax.swing.*;
import java.awt.*;

public class Layout extends JFrame {
    private String[][] board;
    public Layout(int gridSize,String[][] gridValues, String[][] board){
        JPanel jp = new JPanel();
        setSize(700,700);
        jp.setLayout(new GridLayout(gridSize,gridSize));

        int onePossibleCount=0;
        OnePossible onePossible = new OnePossible(board);
        long startTime1 = System.nanoTime();
        onePossible.solve();
        long endTime1 = System.nanoTime();
        long totalTimeTaken1 = endTime1 - startTime1;
        onePossible.consoleDisplay();
        onePossibleCount = onePossible.getOnePossibleCount();
        this.board = onePossible.getBoard();


        for(int x=1; x< gridSize +1; x++){
            for(int y=0; y<gridSize; y++){
                jp.add(new JButton(board[x][y]));
            }
        }
        getContentPane().add(jp);
    }
}
