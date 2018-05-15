import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Frame> frames;

    public Game() {
        frames = new ArrayList<>();
    }

    public boolean addFrame(int throw1, int throw2) {
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

    public Frame getFrameAt(int index) {
        return this.frames.get(index);
    }
}
