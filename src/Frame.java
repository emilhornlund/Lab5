class Frame {
    static final int MAX_THROWS = 2;
    static final int MAX_PINS = 10;

    private int[] bowling_throws;

    private int remainingPins;

    Frame(int throw1, int throw2) throws Exception{
        bowling_throws = new int[MAX_THROWS];
        remainingPins = MAX_PINS;

        if (!this.validateThrows(throw1, throw2)) {
            throw new Exception("Invalid scores!");
        }

        bowling_throws[0] = throw1;
        bowling_throws[1] = throw2;
    }

    private boolean validateThrows(int throw1, int throw2) {
        if (throw1 < 0 || throw1 > 10) {
            return false;
        } else {
            this.remainingPins -= throw1;
        }
        return throw2 >= 0 && throw2 <= this.remainingPins;
    }

    int getThrowAt(int idx) {
        return this.bowling_throws[idx];
    }
}
