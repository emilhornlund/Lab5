import static org.junit.Assert.*;
import org.junit.Test;

public class Tests {
    @Test
    public void knockedDownPinsTest() {
        Game game = new Game();

        assertTrue(game.addFrame(2, 4));

        int throw1 = game.getFrameAt(0).getThrowAt(0);
        assertTrue( throw1 >= 0 && throw1 <= Frame.MAX_PINS);

        int throw2 = game.getFrameAt(0).getThrowAt(1);
        assertTrue(throw2 >= 0 && throw2 <= (Frame.MAX_PINS - throw1));
    }
}