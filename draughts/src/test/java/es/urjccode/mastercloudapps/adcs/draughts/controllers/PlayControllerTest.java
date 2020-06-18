package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import org.junit.Test;

import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.GameBuilder;

import static org.junit.Assert.*;

public class PlayControllerTest {

    private PlayController playController;

    @Test
    public void testGivenPlayControllerWhenMoveThenOk() {
        Game game = new GameBuilder().build();
        playController = new PlayController(game, new State());
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        playController.move(origin, target);
        assertEquals(playController.getColor(target), Color.WHITE);
        assertFalse(game.isBlocked());
    }

    @Test
    public void testGivenPlayControllerWhenMoveWithoutPiecesThenIsBlocked() {
        Game game = new GameBuilder().rows(
            "        ",
            "        ",
            "        ",
            "        ",
            " n      ",
            "b       ",
            "        ",
            "        ").build();
        playController = new PlayController(game, new State());
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(3, 2);
        playController.move(origin, target);
        assertEquals(playController.getColor(target), Color.WHITE);
        assertTrue(game.isBlocked());
    }

    @Test
    public void testGivenPlayControllerWhenMoveWithoutMovementsThenIsBlocked() {
        Game game = new GameBuilder().rows(
            "   n    ",
            "  b b   ",
            "     b  ",
            "b       ",
            "        ",
            "        ",
            "        ",
            "        ").build();
        playController = new PlayController(game, new State());
        Coordinate origin = new Coordinate(3, 0);
        Coordinate target = new Coordinate(2, 1);
        playController.move(origin, target);
        assertEquals(playController.getColor(target), Color.WHITE);
        assertTrue(game.isBlocked());
    }

    @Test
    public void testGivenPlayControllerWhenCancelThenOk() {
        Game game = new GameBuilder().build();
        playController = new PlayController(game, new State());
        playController.cancel();
        assertEquals(Color.BLACK, playController.getColor());
        assertFalse(game.isBlocked());
    }

    @Test
    public void testGivenPlayControllerWhenWhiteDraughtDoesntEatThenIsRemoved() {
        Game game = new GameBuilder().rows(
            "        ",
            "    B   ",
            "     n  ",
            "        ",
            "        ",
            "        ",
            " b      ",
            "        ").color(Color.WHITE).build();
        playController = new PlayController(game, new State());
        Coordinate origin = new Coordinate(6, 1);
        Coordinate target = new Coordinate(5, 0);
        playController.move(origin, target);
        assertNull(playController.getPiece(new Coordinate(1, 4)));
    }

    @Test
    public void testGivenPlayControllerWhenBlackDraughtDoesntEatThenIsRemoved() {
        Game game = new GameBuilder().rows(
            "        ",
            "        ",
            "n       ",
            "        ",
            "        ",
            "  b     ",
            "   N    ",
            "        ").color(Color.BLACK).build();
        playController = new PlayController(game, new State());
        Coordinate origin = new Coordinate(2, 0);
        Coordinate target = new Coordinate(3, 1);
        playController.move(origin, target);
        assertNull(playController.getPiece(new Coordinate(6, 3)));
    }

    @Test
    public void testGivenPlayControllerWhenWhitePieceDoesntEatThenIsRemoved() {
        Game game = new GameBuilder().rows(
            "        ",
            "        ",
            "        ",
            "        ",
            " n      ",
            "b       ",
            "        ",
            "  b     ").color(Color.WHITE).build();
        playController = new PlayController(game, new State());
        Coordinate origin = new Coordinate(7, 2);
        Coordinate target = new Coordinate(6, 3);
        playController.move(origin, target);
        assertNull(playController.getPiece(new Coordinate(5, 0)));
    }

    @Test
    public void testGivenPlayControllerWhenBlackPieceDoesntEatThenIsRemoved() {
        Game game = new GameBuilder().rows(
            " n      ",
            "        ",
            "       n",
            "      b ",
            "        ",
            "        ",
            "        ",
            "        ").color(Color.BLACK).build();
        playController = new PlayController(game, new State());
        Coordinate origin = new Coordinate(0, 1);
        Coordinate target = new Coordinate(1, 0);
        playController.move(origin, target);
        assertNull(playController.getPiece(new Coordinate(2, 7)));
    }

    @Test
    public void testGivenPlayControllerWhenDraughtWhoMoveDoesntEatThenIsRemoved() {
        Game game = new GameBuilder().rows(
            "  B     ",
            "        ",
            "    n   ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ").build();
        playController = new PlayController(game, new State());
        Coordinate origin = new Coordinate(0, 3);
        Coordinate target = new Coordinate(3, 0);
        playController.move(origin, target);
        assertNull(playController.getPiece(target));
    }

    @Test
    public void testGivenPlayControllerWhenPieceWhoMoveDoesntEatThenIsRemoved() {
        Game game = new GameBuilder().rows(
            " n      ",
            "  b     ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ").build();
        playController = new PlayController(game, new State());
        Coordinate origin = new Coordinate(0, 1);
        Coordinate target = new Coordinate(1, 0);
        playController.move(origin, target);
        assertNull(playController.getPiece(target));
    }

}
