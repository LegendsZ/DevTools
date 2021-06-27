public class Performance_Tracker {

    static Performance_Tracker[] timers;

    long start;
    long end;
    long result;

    public Performance_Tracker() {
        update();
    }

    public void update() {
        if (timers == null) {
            timers = new Performance_Tracker[0];
        }
        Performance_Tracker[] temp = new Performance_Tracker[timers.length];
        for (int i =0; i < timers.length;i++) {
            temp[i] = timers[i];
        }

        timers = new Performance_Tracker[temp.length+1];

        for (int i =0; i < temp.length;i++) {
            timers[i] = temp[i];
        }

        timers[timers.length-1] = this;
    }

    public void start() {
        this.start = System.nanoTime();
    }

    public void setTime(long now) {
        this.start = now;
    }

    public void end() {
        this.end = System.nanoTime();
        this.result = this.end - this.start;
    }

    public void end(boolean printOnOff) {
        this.end = System.nanoTime();
        this.result = this.end - this.start;
        if (printOnOff == true) {
            System.out.println("Result: " + this.result + "ns | " + (this.result/1000000) + "ms");
        }
    }
}
