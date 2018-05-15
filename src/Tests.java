import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {
    @Test
    public void knockedDownPinsTest() {
        Game game = new Game();
        assertTrue(game.addFrame(2, 4));
        assertFalse(game.addFrame(10, 10));
    }

    @Test
    public void sumOfFrameScoreTest() {
        Game game = new Game();

        game.addFrame(2, 6);
        assertEquals(2+6, game.getFrameAt(0).getScore());

        game.addFrame(0, 9);
        assertEquals(9, game.getFrameAt(1).getScore());
    }

    @Test
    public void numberOfFramesTest() {
        Game game = new Game();

        game.addFrame(1, 5);
        game.addFrame(3, 6);
        game.addFrame(7, 2);
        game.addFrame(3, 6);
        game.addFrame(4, 4);
        game.addFrame(5, 3);
        game.addFrame(3, 3);
        game.addFrame(4, 5);
        game.addFrame(8, 1);
        game.addFrame(2, 6);

        game.addFrame(0, 0);

        assertEquals(10, game.getNrOfFrames());
    }
}