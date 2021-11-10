public class Code {
    public static void main(String[] args) {
        DoubleSolenoid d = new DoubleSolenoid();
        d.setState(Direction.FORWARD);
        d.setState(Direction.NEUTRAL);
        d.setState(Direction.REVERSE);

        Displayable thing = new DoubleSolenoid();
        thing.display();
    }

    public static enum Direction {
        FORWARD, NEUTRAL, REVERSE
    }

    public static class DoubleSolenoid implements Displayable {
        private Direction state = Direction.NEUTRAL;

        public void setState(Direction state) {
            this.state = state;
        }

        public Direction getState() {
            return state;
        }

        public void display() {
            switch (state) {
                case FORWARD:
                    p("Going forward.");
                    break;
                case NEUTRAL:
                    p("Not avtive.");
                    break;
                case REVERSE:
                    p("Going reverse");
                    break;
                default:
                    break;
            }
        }
    }

    public static interface Displayable {
        void display();
    }

    public static class Motor implements Displayable {
        private double speed;

        public void setSpeed(double speed) {
            speed = Math.max(-1, Math.min(1, speed));
            this.speed = speed;
        }

        public void display() {
            System.out.println("Speed is " + speed + ".");
        }

        public double getSpeed() {
            return this.speed;
        }
    }

    public static void stop(Motor m) {
        m.setSpeed(0);
    }

    public static class MotorGroup extends Motor {
        private Motor[] motors;

        public MotorGroup(Motor... motors) {
            this.motors = motors;
        }

        public double getSpeed() {
            return motors[0].getSpeed();
        }

        public void setSpeed(double speed) {
            for (Motor motor : motors) {
                motor.setSpeed(speed);
            }
        }

        public double getAverageSpeed() {
            double sum = 0.0;
            for (Motor m : motors) {
                sum += m.getSpeed();
            }
            return sum / motors.length;
        }
    }

    public static class DriveTrain {
        private Motor left = new MotorGroup();
        private Motor right = new MotorGroup();

        public DriveTrain(Motor right, Motor left) {
            this.left = left;
            this.right = right;
        }

        public void setAll(double left, double right) {
            this.left.setSpeed(left);
            this.right.setSpeed(right);
        }
    }

    public static class Solenoid {
        private boolean on;

        public Solenoid(boolean on) {
            this.on = on;
        }

        public void setState(boolean on) {
            this.on = on;
        }

        public boolean getState() {
            return on;
        }
    }

    public static float[] bubbleSort(float[] nums) {
        int length = nums.length;
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length - x - 1; y++) {
                if (nums[y] > nums[y + 1]) {
                    float temp = nums[y];
                    nums[y] = nums[y + 1];
                    nums[y + 1] = temp;
                }
            }
        }
        return nums;
    }

    public static void p(Object str) {
        System.out.println(str);
    }
}