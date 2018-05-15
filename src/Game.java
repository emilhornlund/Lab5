import java.util.ArrayList;
import java.util.List;

class Game {
    private List<Frame> frames;
    private int totalScore;

    Game() {
        frames = new ArrayList<>();
    }

    boolean addFrame(int throw1, int throw2) {
        if (this.frames.size() == 10) {
            return false;
        }

        try {
            frames.add(new Frame(throw1, throw2));
        } catch (Exception e) {
            return false;
        }

        this.calculateTotalScore();

        return true;
    }

    private void calculateTotalScore() {
        this.totalScore += this.frames.get(this.frames.size() - 1).getScore();
    }

    Frame getFrameAt(int index) {
        return this.frames.get(index);
    }

    int getNrOfFrames () {
        return this.frames.size();
    }

    int getTotalScore () {
        return this.totalScore;
    }
}
