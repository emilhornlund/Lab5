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
        if(!this.frames.get(this.frames.size() - 1).isStrike()) {
            this.totalScore += this.frames.get(this.frames.size() - 1).getScore();
        }

        if(this.frames.size() > 1) {
            if (this.frames.get(this.frames.size() - 2).isStrike()) {
                int index = getNumberOfStrikesInARow();
                this.totalScore += calculateScoreToAddAfterStrikes(index);
            } else if (this.frames.get(this.frames.size() - 2).isSpare()) {
                this.totalScore += this.frames.get(this.frames.size() - 1).getThrowAt(0);
            }
        }
    }

    private int calculateScoreToAddAfterStrikes(int index) {
        int scoreToAdd = 0;

        if((this.frames.size() - 2) - index > 0) {                                                                      // If number of strikes is more than one

            // Loop thru every frame and calculate the score
            while (this.frames.get(index).isStrike() && index < this.frames.size() - 1) {
                // Get first score of every frame three times ahead for every strikes except the last one.
                for (int i = index; i < 3 && i < this.frames.size(); i++) {
                    scoreToAdd += this.frames.get(i).getThrowAt(0);
                }
                index++;
            }

            // Add the second throw to the last strike
            scoreToAdd += this.frames.get(this.frames.size() - 1).getThrowAt(1);
            this.totalScore += scoreToAdd;
        } else {                                                                                                        // Only one strike

            if(!this.frames.get(this.frames.size() - 1).isStrike()) {
                scoreToAdd += this.frames.get(this.frames.size() - 1).getScore();
                scoreToAdd += 10;
            }

        }

        return scoreToAdd;
    }

    private int getNumberOfStrikesInARow() {
        int index = this.frames.size() - 2;
        while (this.frames.get(index).isStrike() && index > 0) {
            index--;
        }

        return index;
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
