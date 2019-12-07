package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CorrectMovesDraughtGameTest extends GameTest {

    private Game expectedGame;

    private void setExpectedGame(Color color, String... strings) {
        this.expectedGame = new GameBuilder().setColor(color).rows(strings).build();
    }

    private void assertMove(Coordinate... coordinates){
        assertNull(this.game.move(coordinates));
        assertEquals(this.game, this.expectedGame);
    }


    @Test
    public void testGivenGameWhenMoveWithWhiteCorrectMovementThenOk() {
        this.setGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "B       ",
            "        ",
            "        ");
        this.setExpectedGame(Color.BLACK,
            "        ",
            "        ",
            "        ",
            "        ",
            " B      ",
            "        ",
            "        ",
            "        ");
        this.assertMove(
            new Coordinate(5, 0), 
            new Coordinate(4, 1)
        );
    }

    @Test
    public void testGivenGameWhenMoveWithBlackCorrectMovementThenOk() {
        this.setGame(Color.BLACK,
            "        ",
            "        ",
            "   N    ",
            "        ",
            "        ",
            "b       ",
            "        ",
            "        ");
        this.setExpectedGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "    N   ",
            "        ",
            "b       ",
            "        ",
            "        ");
        this.assertMove(
            new Coordinate(2, 3), 
            new Coordinate(3, 4));
    }

    @Test
    public void testGivenGameWhenMoveWithBlackEatingThenOk() {
        this.setGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "  n     ",
            " B      ",
            "        ",
            "        ",
            "        ");
        this.setExpectedGame(Color.BLACK,
            "        ",
            "        ",
            "   B    ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ");
        this.assertMove(new Coordinate(4, 1), new Coordinate(2, 3));
    }

    @Test
    public void testGivenGameWhenMoveWithWhiteEatingThenOk() {
        this.setGame(Color.BLACK,
            "        ",
            "        ",
            "        ",
            "N       ",
            " b      ",
            "        ",
            "        ",
            "        ");
        this.setExpectedGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "  N     ",
            "        ",
            "        ");
        this.assertMove(
            new Coordinate(3, 0), 
            new Coordinate(5, 2));
    }

    @Test
    public void testGivenGameWhenMoveWithBlackTwoEatingThenOk() {
        this.setGame(Color.WHITE,
            "        ",
            "        ",
            "   n    ",
            "        ",
            " n      ",
            "B       ",
            "        ",
            "        ");
        this.setExpectedGame(Color.BLACK,
            "        ",
            "    B   ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ");
        this.assertMove(
            new Coordinate(5, 0), 
            new Coordinate(3, 2),
            new Coordinate(1, 4));
    }

    @Test
    public void testGivenGameWhenMoveWithWhiteTwoEatingThenOk() {
        this.setGame(Color.BLACK,
            "        ",
            "        ",
            " N      ",
            "  b     ",
            "        ",
            "    b   ",
            "        ",
            "        ");
        this.setExpectedGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "     N  ",
            "        ");
        this.assertMove(
            new Coordinate(2, 1), 
            new Coordinate(4, 3),
            new Coordinate(6, 5));
    }

    
    @Test
    public void testGivenGameWhenMoveWHITEThenNOT_ADVANCED() {
        setGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "        ",
            "       B",
            "        ",
            "        ",
            "        ");
        setExpectedGame(Color.BLACK,
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "    B   ");
        assertMove(
            new Coordinate(4, 7), 
            new Coordinate(7, 4));
    }

    @Test
    public void testGivenGameWhenMoveBLACKThenNOT_ADVANCED() {
        setGame(Color.BLACK,
            "        ",
            "N       ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ");
        setExpectedGame(Color.WHITE,
            " N      ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ");
        assertMove(
            new Coordinate(1, 0), 
            new Coordinate(0, 1));
    }

    
    @Test
    public void testGivenGameWhenMoveWHITEThenWITHOUT_EATING() {
        setGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "    B   ",
            "        ",
            "        ");
        setExpectedGame(Color.BLACK,
            "        ",
            "        ",
            "        ",
            "  B     ",
            "        ",
            "        ",
            "        ",
            "        ");
        assertMove(
            new Coordinate(5, 4), 
            new Coordinate(3, 2));
    }

    @Test
    public void testGivenGameWhenMoveBLACKThenWITHOUT_EATING() {
        setGame(Color.BLACK,
            "        ",
            "        ",
            "        ",
            "  N     ",
            "        ",
            "    b   ",
            "        ",
            "        ");
        setExpectedGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "      N ");
        assertMove(
            new Coordinate(3, 2), 
            new Coordinate(7, 6));
    }

    @Test
    public void testGivenGameWhenMoveWHITEThenTOO_MUCH_ADVANCED() {
        setGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "B       ",
            "        ",
            "        ");
        setExpectedGame(Color.BLACK,
            "     B  ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ");
        assertMove(
            new Coordinate(5, 0), 
            new Coordinate(0, 5));
    }

    @Test
    public void testGivenGameWhenMoveBLACKThenTOO_MUCH_ADVANCED() {
        setGame(Color.BLACK,
            "        ",
            "        ",
            " N      ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ");
        setExpectedGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "    N   ",
            "        ",
            "        ");
        assertMove(
            new Coordinate(2, 1), 
            new Coordinate(5, 4));
    }

    @Test
    public void testGivenGameWhenMoveBLAC2KThenTOO_MUCH_ADVANCED() {
        setGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "    n   ",
            " n      ",
            "B       ");
        setExpectedGame(Color.BLACK,
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "     B  ",
            "        ");
        assertMove(
            new Coordinate(7, 0), 
            new Coordinate(4, 3),
            new Coordinate(6, 5));
    }
    
}