package es.urjccode.mastercloudapps.adcs.draughts.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GameBuilderTest {

    private GameBuilder gameBuilder;

    @Before
    public void before(){
        this.gameBuilder = new GameBuilder();
    }

    @Test(expected = AssertionError.class)
    public void testGivenGameBuilderWhenIncorrectRowsNumberThenError() {
        this.gameBuilder.rows(
            "        ",
            "        ",
 //           "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ").build();
    }

    @Test(expected = AssertionError.class)
    public void testGivenGameBuilderWhenIncorrectCharactersThenError() {
        this.gameBuilder.rows(
            "        ",
            "        ",
            "        ",
            "        ",
            "   x    ",
            "        ",
            "        ",
            "        ").build();
    }

    @Test(expected = AssertionError.class)
    public void testGivenGameBuilderWhenIncorrectRowsLengthThenError() {
        this.gameBuilder.rows(
            "         ",
            "       ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ").build();
    }

    @Test
    public void testGivenGameBuilderWhenCorrectRowsThenOk() {
        Game game = this.gameBuilder.rows(
            " n      ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "b       ").build();
        assertNull(game.getColor(new Coordinate(0, 0)));
        assertEquals(Color.BLACK, game.getColor(new Coordinate(0, 1)));
        assertEquals(Color.WHITE, game.getColor(new Coordinate(7, 0)));
        assertNull(game.getColor(new Coordinate(7, 1)));
    }

}
