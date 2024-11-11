package br.edu.ifsp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TicTacToeGame extends Application {

    // Constants for the players and the board
    static final char PLAYER_X = 'X';
    static final char PLAYER_O = 'O';
    static final char EMPTY = ' ';
    private char[][] board = {
        { EMPTY, EMPTY, EMPTY },
        { EMPTY, EMPTY, EMPTY },
        { EMPTY, EMPTY, EMPTY }
    };
    private boolean playerTurn = true;  // True if it's the human player's turn
    private Button[][] buttons;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/edu/ifsp/TicTacToeGame.fxml"));
        Parent root = loader.load();
        
        // Set up buttons array for easier handling
        buttons = new Button[][] {
            { (Button) loader.getNamespace().get("button00"), (Button) loader.getNamespace().get("button01"), (Button) loader.getNamespace().get("button02") },
            { (Button) loader.getNamespace().get("button10"), (Button) loader.getNamespace().get("button11"), (Button) loader.getNamespace().get("button12") },
            { (Button) loader.getNamespace().get("button20"), (Button) loader.getNamespace().get("button21"), (Button) loader.getNamespace().get("button22") }
        };
        
        // Set up button actions
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int row = i, col = j;
                buttons[i][j].setOnAction(e -> handlePlayerMove(row, col));
            }
        }
        
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }

    // Handle player's move
    private void handlePlayerMove(int row, int col) {
        if (board[row][col] == EMPTY && playerTurn) {
            board[row][col] = PLAYER_X;
            buttons[row][col].setText(String.valueOf(PLAYER_X));
            playerTurn = false;

            // Check for game end
            if (evaluate(board) == 10) {
                showAlert("You win!");
                resetBoard();
                return;
            } else if (!isMovesLeft(board)) {
                showAlert("It's a tie!");
                resetBoard();
                return;
            }

            // Make AI move
            int[] bestMove = findBestMove(board);
            board[bestMove[0]][bestMove[1]] = PLAYER_O;
            buttons[bestMove[0]][bestMove[1]].setText(String.valueOf(PLAYER_O));
            playerTurn = true;

            // Check for game end after AI move
            if (evaluate(board) == -10) {
                showAlert("You lose!");
                resetBoard();
            } else if (!isMovesLeft(board)) {
                showAlert("It's a tie!");
                resetBoard();
            }
        }
    }

    // Check if there are any moves left on the board
    public static boolean isMovesLeft(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) return true;
            }
        }
        return false;
    }

    // Evaluate the board and return a score
    public static int evaluate(char[][] board) {
        // Check rows, columns, and diagonals
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                if (board[row][0] == PLAYER_X) return +10;
                else if (board[row][0] == PLAYER_O) return -10;
            }
        }
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                if (board[0][col] == PLAYER_X) return +10;
                else if (board[0][col] == PLAYER_O) return -10;
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == PLAYER_X) return +10;
            else if (board[0][0] == PLAYER_O) return -10;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[0][2] == PLAYER_X) return +10;
            else if (board[0][2] == PLAYER_O) return -10;
        }
        return 0;
    }

    // Minimax function
    public static int minimax(char[][] board, int depth, boolean isMaximizing) {
        int score = evaluate(board);
        if (score == 10) return score - depth;
        if (score == -10) return score + depth;
        if (!isMovesLeft(board)) return 0;

        if (isMaximizing) {
            int best = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == EMPTY) {
                        board[i][j] = PLAYER_X;
                        best = Math.max(best, minimax(board, depth + 1, false));
                        board[i][j] = EMPTY;
                    }
                }
            }
            return best;
        } else {
            int best = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == EMPTY) {
                        board[i][j] = PLAYER_O;
                        best = Math.min(best, minimax(board, depth + 1, true));
                        board[i][j] = EMPTY;
                    }
                }
            }
            return best;
        }
    }

    // Find the best move for the maximizing player
    public static int[] findBestMove(char[][] board) {
        int bestVal = Integer.MIN_VALUE;
        int[] bestMove = {-1, -1};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    board[i][j] = PLAYER_X;
                    int moveVal = minimax(board, 0, false);
                    board[i][j] = EMPTY;

                    if (moveVal > bestVal) {
                        bestMove[0] = i;
                        bestMove[1] = j;
                        bestVal = moveVal;
                    }
                }
            }
        }

        return bestMove;
    }

    // Show an alert with a message
    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Reset the board and UI for a new game
    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
                buttons[i][j].setText(" ");
            }
        }
        playerTurn = true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
