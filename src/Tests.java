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
        assertEquals(2+6, game.getFrameAt(0).getScore());
    }
}