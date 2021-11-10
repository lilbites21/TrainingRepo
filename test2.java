public class test2 {
    public static void main(String[] args) {
        goToHeight(Height.LOW);
        goToHeight(Height.MEDIUM);
        goToHeight(Height.HIGH);
    }

    public static enum Numbers {
        ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10);

        private int value;

        Numbers(int i) {
            value = i;
        }

        public int get() {
            return value;
        }
    }

    public static enum Height {
        LOW(0.0), MEDIUM(2.7), HIGH(3.14);

        private final double value;

        Height(double value) {
            this.value = value;
        }

        public double get() {
            return value;
        }

        public static Height getByName(String name) {
            if (name.toLowerCase().equals("low")) {
                return LOW;
            } else if (name.toLowerCase().equals("medium")) {
                return MEDIUM;
            } else if (name.toLowerCase().equals("high")) {
                return HIGH;
            } else {
                Code.p("Not of the names, returning LOW");
                return LOW;
            }
        }
    }

    public static void goToHeight(Height h) {
        Code.p(h.get() + " m.");
    }
}
