package clean.code.chess.requirements;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];

    }

    public void Add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if(IsLegalBoardPosition(xCoordinate, yCoordinate)) {
            if(pieces[xCoordinate][yCoordinate] == null) {
                pawn.setXCoordinate(xCoordinate);
                pawn.setYCoordinate(yCoordinate);
                pieces[xCoordinate][yCoordinate] = pawn;
            } else {
                if(pieces[xCoordinate][yCoordinate].getPieceColor() == pieceColor) {
                    pawn.setXCoordinate(-1);
                    pawn.setYCoordinate(-1);
                }
            }
        } else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
    }

    public boolean IsLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return (xCoordinate >= 0 && yCoordinate >=0 && xCoordinate < MAX_BOARD_HEIGHT && yCoordinate < MAX_BOARD_WIDTH);
    }
}
