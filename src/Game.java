import java.util.ArrayList;
import java.util.List;

class Game {
    private List<Frame> frames;
    private int totalScore;

    Game() {
        this.frames = new ArrayList<>();
    }

    boolean addFrame(int throw1, int throw2) {
        if (this.frames.size() == 10  && !this.frames.get(this.frames.size() - 1).isStrike()) {
            return false;
        }

        try {
            this.frames.add(new Frame(throw1, throw2, (frames.size() == 10 && throw1 == 10 && throw2 == 10)));
        } catch (Exception e) {
            return false;
        }

        if(this.frames.size() == 11) {
            this.frames.get(frames.size() - 1).setIsExtraThrow(true);
        }

        this.calculateTotalScore();

        return true;
    }

    boolean addFrame(int extraThrow) {
        if (this.frames.size() != 10 && !this.frames.get(this.frames.size() - 2).isSpare()) {
            return false;
        }

        try {
            this.frames.add(new Frame(extraThrow, 0, true));
            this.frames.get(this.frames.size() - 1).setStrike(false);
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

        if(this.frames.get(this.frames.size() - 1).isStrike() && this.frames.size() == 10) {
            this.totalScore += 10;
        }

        if (this.frames.size() == 11) {
            Frame f1 = this.frames.get(this.frames.size() - 2);
            Frame f2 = this.frames.get(this.frames.size() - 1);
            if (f2.getScore() == 20) {
                this.totalScore += f1.getScore() + f2.getScore();
            }
        }

        if(this.frames.size() > 1) {
            if (this.frames.get(this.frames.size() - 2).isStrike()) {
                if(!frames.get(frames.size() - 1).isStrike() || frames.size() == 10) {
                    int index = getNumberOfStrikesInARow();
                    this.totalScore += calculateScoreToAddAfterStrikes(index);
                }
            } else if (this.frames.get(this.frames.size() - 2).isSpare()) {
                if(!this.frames.get(this.frames.size() - 1).isExtraThrow()) {
                    this.totalScore += this.frames.get(this.frames.size() - 1).getThrowAt(0);
                }
            }
        }
    }

    private int calculateScoreToAddAfterStrikes(int index) {
        int scoreToAdd = 0;

        if((this.frames.size() - 2) - index > 0) {                                                                      // If number of strikes is more than one
            // Loop thru every frame and calculate the score
            while (this.frames.get(index).isStrike() && index < (this.frames.size() - 1)) {
                // Get first score of every frame three times ahead for every strikes except the last one.
                for (int i = index; i < (index + 3) && i < this.frames.size(); i++) {
                    scoreToAdd += this.frames.get(i).getThrowAt(0);
                }
                index++;
            }

            // Add the second throw to the last strike
            scoreToAdd += this.frames.get(this.frames.size() - 1).getThrowAt(1);
        } else {                                                                                                        // Only one strike
            if(!this.frames.get(this.frames.size() - 1).isStrike()) {
                if(!this.frames.get(this.frames.size() - 1).isExtraThrow()) {
                    scoreToAdd += this.frames.get(this.frames.size() - 1).getScore();
                    scoreToAdd += 10;
                }
            }
        }

        return scoreToAdd;
    }

    private int getNumberOfStrikesInARow() {
        int index = this.frames.size() - 2;
        while (this.frames.get(index).isStrike() && index > 0) {
            index--;
        }

        if(!this.frames.get(index).isStrike()) {
            index++;
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
