import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class Tests {
    @Test
    //@Ignore
    // 1. Frame
    public void knockedDownPinsTest() {
        Game game = new Game();
        assertTrue(game.addFrame(2, 4));
        assertFalse(game.addFrame(10, 10));
    }

    @Test
    //@Ignore
    // 2. Frame score
    public void sumOfFrameScoreTest() {
        Game game = new Game();

        game.addFrame(2, 6);
        assertEquals(2+6, game.getFrameAt(0).getScore());

        game.addFrame(0, 9);
        assertEquals(9, game.getFrameAt(1).getScore());
    }

    @Test
    //@Ignore
    // 3. Game
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
    // 4. Game Score
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
    // 5. Strike
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
    // 6. Spare
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
    // 8. Multiple strikes
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
    // 7. Strike and spare
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
    // 9. Multiple Spares
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
    // 10. Spare as the last frame
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
    // 11. Strike as the last frame
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

        //Test number of bonus throws
        Game game2 = new Game();

        game2.addFrame(1,5);
        game2.addFrame(3,6);
        game2.addFrame(7,2);
        game2.addFrame(3,6);
        game2.addFrame(4,4);
        game2.addFrame(5,3);
        game2.addFrame(3,3);
        game2.addFrame(4,5);
        game2.addFrame(8,1);
        game2.addFrame(6,2);

        game2.addFrame(7,2); //this should not be possible, ignore frame

        assertEquals(10, game2.getNrOfFrames());
    }

    @Test
    //@Ignore
    // 14. Real game
    public void realGameTest () {
        Game game1 = new Game();

        game1.addFrame(6, 3);
        game1.addFrame(7, 1);
        game1.addFrame(8, 2);
        game1.addFrame(7, 2);
        game1.addFrame(10, 0);
        game1.addFrame(6, 2);
        game1.addFrame(7, 3);
        game1.addFrame(10, 0);
        game1.addFrame(8, 0);
        game1.addFrame(7, 3);

        game1.addFrame(10); // Extra throw after strike

        assertEquals(135, game1.getTotalScore());
    }

    @Test
    //@Ignore
    //12. Bonus is a strike
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
    // 13. Best score
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