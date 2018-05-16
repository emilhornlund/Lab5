import java.util.ArrayList;
import java.util.List;

class Game {
    private List<Frame> frames;
    private int totalScore;
    //int test = 0;

    Game() {
        frames = new ArrayList<>();
    }

    boolean addFrame(int throw1, int throw2) {
        if (this.frames.size() == 10  && !this.frames.get(this.frames.size() - 1).isStrike()) {
            return false;
        }

        try {
            frames.add(new Frame(throw1, throw2));
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

        frames.add(new Frame(extraThrow));

        this.calculateTotalScore();

        return true;
    }

    private void calculateTotalScore() {

        //test += frames.get(frames.size() - 1).getScore();
        //System.out.println("Test: " + test);

        //System.out.println("Strike: " + frames.get(frames.size() - 1).isStrike());
        //System.out.println("Index: " + (frames.size() - 1));

        if(!this.frames.get(this.frames.size() - 1).isStrike()) {
            this.totalScore += this.frames.get(this.frames.size() - 1).getScore();
        }

        if(this.frames.get(this.frames.size() - 1).isStrike() && this.frames.size() == 10) {
            this.totalScore += 10;
        }

        if(this.frames.size() > 1) {
            //System.out.println("Hej");
            if (this.frames.get(this.frames.size() - 2).isStrike()) {
                //System.out.println("Bajs");
                if(!frames.get(frames.size() - 1).isStrike() || frames.size() == 11) {
                    //System.out.println("Inne");
                    int index = getNumberOfStrikesInARow();
                    this.totalScore += calculateScoreToAddAfterStrikes(index);
                }

            } else if (this.frames.get(this.frames.size() - 2).isSpare()) {

                if(!this.frames.get(this.frames.size() - 1).isExtraThrow()) {
                    this.totalScore += this.frames.get(this.frames.size() - 1).getThrowAt(0);
                }
            }
        }

        //System.out.println("Total: " + this.totalScore + "\n");
    }

    private int calculateScoreToAddAfterStrikes(int index) {
        int scoreToAdd = 0;
        //System.out.println("Går du in här?");

        if((this.frames.size() - 2) - index > 0) {                                                                      // If number of strikes is more than one
            System.out.println("Index: " + index);
            System.out.println("Nr of strikes: " + ((this.frames.size()) - index));
            System.out.println("Size: " + (frames.size()));
            //System.out.println(this.frames.get(index).isStrike());
            //System.out.println("Tweet");

            // Loop thru every frame and calculate the score
            while (this.frames.get(index).isStrike() && index < (this.frames.size() - 1)) {
                // Get first score of every frame three times ahead for every strikes except the last one.
                System.out.println("Three new");
                for (int i = index; i < (index + 3) && i < this.frames.size(); i++) {
                    scoreToAdd += this.frames.get(i).getThrowAt(0);
                    System.out.println(this.frames.get(i).getThrowAt(0));
                }
                index++;
            }

            //System.out.println("This");
            // Add the second throw to the last strike
            scoreToAdd += this.frames.get(this.frames.size() - 1).getThrowAt(1);

        } else {                                                                                                        // Only one strike
            if(!this.frames.get(this.frames.size() - 1).isStrike()) {
                //System.out.println("asdasdf");

                if(!this.frames.get(this.frames.size() - 1).isExtraThrow()) {
                    scoreToAdd += this.frames.get(this.frames.size() - 1).getScore();
                    scoreToAdd += 10;
                }
            }

        }

        //System.out.println(scoreToAdd);

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
