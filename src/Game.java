import java.util.ArrayList;
import java.util.List;

class Game {
    private List<Frame> frames;

    Game() {
        frames = new ArrayList<>();
    }

    boolean addFrame(int throw1, int throw2) {
        if(this.frames.size() == 10) {
            return false;
        }

        try {
            frames.add(new Frame(throw1, throw2));
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    Frame getFrameAt(int index) {
        return this.frames.get(index);
    }
}
