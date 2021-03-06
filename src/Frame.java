class Frame {
    private static final int MAX_THROWS = 2;
    private static final int MAX_PINS = 10;

    private int[] bowling_throws;

    private int remainingPins;
    private int score;

    private boolean strike;
    private boolean spare;
    private boolean extraThrow;

    Frame(int throw1, int throw2, final boolean isBonusFrame) throws Exception {
        this.bowling_throws = new int[MAX_THROWS];
        this.remainingPins = MAX_PINS;

        this.strike = false;
        this.spare = false;
        this.extraThrow = isBonusFrame;

        if (!isBonusFrame) {
            if (!this.validateThrows(throw1, throw2)) {
                throw new Exception("Invalid scores!");
            }
        }

        this.bowling_throws[0] = throw1;
        this.bowling_throws[1] = throw2;

        this.checkIfStrike(throw1);

        this.score = this.calculateScore(throw1, throw2);
    }

    private int calculateScore(int throw1, int throw2) {
        if(throw1 + throw2 == 10) {
            this.spare = true;
        }

        return throw1 + throw2;
    }

    private boolean validateThrows(int throw1, int throw2) {
        if (throw1 < 0 || throw1 > 10) {
            return false;
        } else {
            this.remainingPins -= throw1;
        }

        if (throw1 == 10 && throw2 != 0) {
            return false;
        }

        return throw2 >= 0 && throw2 <= this.remainingPins;
    }

    private void checkIfStrike(int throw1) {
        if (throw1 == 10) {
            this.strike = true;
        }
    }

    int getThrowAt(int idx) {
        return this.bowling_throws[idx];
    }

    int getScore() {
        return this.score;
    }

    boolean isStrike() {
        return this.strike;
    }

    void setStrike(final boolean strike) {
        this.strike = strike;
    }

    boolean isSpare() {
        return this.spare;
    }

    boolean isExtraThrow() {
        return this.extraThrow;
    }

    void setIsExtraThrow(final boolean extraThrow) {
        this.extraThrow = extraThrow;
    }
}
