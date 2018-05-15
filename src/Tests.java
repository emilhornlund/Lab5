import static org.junit.Assert.*;
import org.junit.Test;

public class Tests {
    @Test
    public void knockedDownPinsTest() {
        Game game = new Game();
        assertTrue(game.addFrame(2, 4));
        assertFalse(game.addFrame(10, 10));
    }
}