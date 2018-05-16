import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class Tests {
    @Test
    //@Ignore
    public void knockedDownPinsTest() {
        Game game = new Game();
        assertTrue(game.addFrame(2, 4));
        assertFalse(game.addFrame(10, 10));
    }

    @Test
    //@Ignore
    public void sumOfFrameScoreTest() {
        Game game = new Game();

        game.addFrame(2, 6);
        assertEquals(2+6, game.getFrameAt(0).getScore());

        game.addFrame(0, 9);
        assertEquals(9, game.getFrameAt(1).getScore());
    }

    @Test
    //@Ignore
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

        game.addFrame(5, 0); // <- This will not be added

        assertEquals(10, game.getNrOfFrames());
    }

    @Test
    //@Ignore
    public void gameScoreTest() {
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

        assertEquals(81, game.getTotalScore());
    }

    @Test
    //@Ignore
    public void strikeTest() {

        // Test single strike at beginning
        Game game = new Game();

        game.addFrame(10, 0); // <- Here
        game.addFrame(3, 6);
        game.addFrame(7, 2);
        game.addFrame(3, 6);
        game.addFrame(4, 4);
        game.addFrame(5, 3);
        game.addFrame(3, 3);
        game.addFrame(4, 5);
        game.addFrame(8, 1);
        game.addFrame(2, 6);

        assertEquals(94, game.getTotalScore());

        // Test single strike in the middle of the game
        Game game2 = new Game();

        game2.addFrame(5, 3);
        game2.addFrame(3, 3);
        game2.addFrame(4, 4);
        game2.addFrame(10, 0); // <- Here
        game2.addFrame(3, 6);
        game2.addFrame(7, 2);
        game2.addFrame(3, 6);
        game2.addFrame(4, 4);
        game2.addFrame(4, 5);
        game2.addFrame(8, 1);
        game2.addFrame(2, 6);

        assertEquals(94, game2.getTotalScore());
    }

    @Test
    //@Ignore
    public void spareTest() {

        // Test spare in the beginning of game
        Game game = new Game();

        game.addFrame(1, 9); // <- Here
        game.addFrame(3, 6);
        game.addFrame(7, 2);
        game.addFrame(3, 6);
        game.addFrame(4, 4);
        game.addFrame(5, 3);
        game.addFrame(3, 3);
        game.addFrame(4, 5);
        game.addFrame(8, 1);
        game.addFrame(2, 6);

        assertEquals(88, game.getTotalScore());

        // Test spare in the middle of the game
        Game game2 = new Game();

        game2.addFrame(4, 4);
        game2.addFrame(5, 3);
        game2.addFrame(1, 9); // <- Here
        game2.addFrame(3, 6);
        game2.addFrame(7, 2);
        game2.addFrame(3, 6);
        game2.addFrame(3, 3);
        game2.addFrame(4, 5);
        game2.addFrame(8, 1);
        game2.addFrame(2, 6);

        assertEquals(88, game2.getTotalScore());
    }

    @Test
    //@Ignore
    public void multipleStrikesTest() {

        // Test multiple strikes
        Game game = new Game();

        game.addFrame(10, 0); // <- Here
        game.addFrame(10, 0); // <- Here
        game.addFrame(7, 2);
        game.addFrame(3, 6);
        game.addFrame(4, 4);
        game.addFrame(5, 3);
        game.addFrame(3, 3);
        game.addFrame(4, 5);
        game.addFrame(8, 1);
        game.addFrame(2, 6);

        assertEquals(112, game.getTotalScore());

        // Test multiple strikes in middle of the game
        Game game2 = new Game();

        game2.addFrame(4, 4);
        game2.addFrame(10, 0); // <- Here
        game2.addFrame(10, 0); // <- Here
        game2.addFrame(7, 2);
        game2.addFrame(3, 6);
        game2.addFrame(4, 4);
        game2.addFrame(5, 3);
        game2.addFrame(3, 3);
        game2.addFrame(4, 5);
        game2.addFrame(8, 1);
        game2.addFrame(2, 6);

        assertEquals(112, game2.getTotalScore());
    }

    @Test
    //@Ignore
    public void strikeAndSpareTest() {

        // Test strike and spare at beginning
        Game game = new Game();

        game.addFrame(10,0); // <- Here
        game.addFrame(4,6); // <- Here
        game.addFrame(7,2);
        game.addFrame(3,6);
        game.addFrame(4,4);
        game.addFrame(5,3);
        game.addFrame(3,3);
        game.addFrame(4,5);
        game.addFrame(8,1);
        game.addFrame(2,6);

        assertEquals(103, game.getTotalScore());


        // Test strike and spare in the middle of the game
        Game game2 = new Game();

        game2.addFrame(4,4);
        game2.addFrame(5,3);
        game2.addFrame(3,3);
        game2.addFrame(10,0); // <- Here
        game2.addFrame(4,6); // <- Here
        game2.addFrame(7,2);
        game2.addFrame(3,6);
        game2.addFrame(4,5);
        game2.addFrame(8,1);
        game2.addFrame(2,6);

        assertEquals(103, game2.getTotalScore());
    }

    @Test
    //@Ignore
    public void multipleSpareTest() {
        // Test multiple spares in beginning of game
        Game game = new Game();

        game.addFrame(8,2); // <- Here
        game.addFrame(5,5); // <- Here
        game.addFrame(7,2);
        game.addFrame(3,6);
        game.addFrame(4,4);
        game.addFrame(5,3);
        game.addFrame(3,3);
        game.addFrame(4,5);
        game.addFrame(8,1);
        game.addFrame(2,6);

        assertEquals(98, game.getTotalScore());

        // Test multiple spares in the middle of the game
        Game game2 = new Game();

        game2.addFrame(5,3);
        game2.addFrame(3,3);
        game2.addFrame(4,5);
        game2.addFrame(8,2); // <- Here
        game2.addFrame(5,5); // <- Here
        game2.addFrame(7,2);
        game2.addFrame(3,6);
        game2.addFrame(4,4);
        game2.addFrame(8,1);
        game2.addFrame(2,6);

        assertEquals(98, game2.getTotalScore());
    }

    @Test
    //@Ignore
    public void lastSpareTest () {
        Game game = new Game();

        game.addFrame(1,5);
        game.addFrame(3,6);
        game.addFrame(7,2);
        game.addFrame(3,6);
        game.addFrame(4,4);
        game.addFrame(5,3);
        game.addFrame(3,3);
        game.addFrame(4,5);
        game.addFrame(8,1);
        game.addFrame(2,8);

        game.addFrame(7); // Extra throw after spare

        assertEquals(90, game.getTotalScore());
    }

    @Test
    //@Ignore
    public void lastStrikeTest () {
        Game game = new Game();

        game.addFrame(1,5);
        game.addFrame(3,6);
        game.addFrame(7,2);
        game.addFrame(3,6);
        game.addFrame(4,4);
        game.addFrame(5,3);
        game.addFrame(3,3);
        game.addFrame(4,5);
        game.addFrame(8,1);
        game.addFrame(10,0);

        game.addFrame(7,2); // Extra throw after strike

        assertEquals(92, game.getTotalScore());
    }

    @Test
    //@Ignore
    public void realGameTest () {
        Game game = new Game();

        game.addFrame(6, 3);
        game.addFrame(7, 1);
        game.addFrame(8, 2);
        game.addFrame(7, 2);
        game.addFrame(10, 0);
        game.addFrame(6, 2);
        game.addFrame(7, 3);
        game.addFrame(10, 0);
        game.addFrame(8, 0);
        game.addFrame(7, 3);

        game.addFrame(10); // Extra throw after strike

        assertEquals(135, game.getTotalScore());
    }

    @Test
    //@Ignore
    public void bonusStrikeTest() {
        Game game = new Game();

        game.addFrame(1,5);
        game.addFrame(3,6);
        game.addFrame(7,2);
        game.addFrame(3,6);
        game.addFrame(4,4);
        game.addFrame(5,3);
        game.addFrame(3,3);
        game.addFrame(4,5);
        game.addFrame(8,1);
        game.addFrame(2,8);

        game.addFrame(10);

        assertEquals(93, game.getTotalScore());
    }

    @Test
    //@Ignore
    public void bestScoreTest () {
        Game game = new Game();

        game.addFrame(10,0);
        game.addFrame(10,0);
        game.addFrame(10,0);
        game.addFrame(10,0);
        game.addFrame(10,0);
        game.addFrame(10,0);
        game.addFrame(10,0);
        game.addFrame(10,0);
        game.addFrame(10,0);
        game.addFrame(10,0);

        game.addFrame(10, 10);

        assertEquals(300, game.getTotalScore());
    }
}