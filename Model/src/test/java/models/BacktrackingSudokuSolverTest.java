
package models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import sudoku.model.models.SudokuBoard;
import sudoku.model.solver.BacktrackingSudokuSolver;

public class BacktrackingSudokuSolverTest {

    @Test
    public void testSolveCompletesBoardWithoutChangingExistingValues() throws Exception {
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(solver);

        // Set some initial values.
        board.getField(0, 0).setValue(5);
        board.getField(1, 0).setValue(3);
        board.getField(4, 0).setValue(7);
        board.getField(0, 1).setValue(6);
        board.getField(3, 1).setValue(1);

        solver.solve(board);

        // Check that the original values were not changed
        assertEquals(5, board.getField(0, 0).getValue());
        assertEquals(3, board.getField(1, 0).getValue());
        assertEquals(7, board.getField(4, 0).getValue());
        assertEquals(6, board.getField(0, 1).getValue());
        assertEquals(1, board.getField(3, 1).getValue());

        // make sure final board is valid and complete
        assertTrue(board.checkEndGame(),
                "The solver should complete the board without changing existing values.");
    }
}
