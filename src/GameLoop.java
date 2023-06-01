
public class GameLoop implements Runnable {

    private boolean running;
    private final double updateRate = 1.0d/60.0d;

    private long nextStartTime;

    private int fps, ups;

    @Override
    public void run() {
        running = true;
        double accumulator = 0;
        long currentTime, lastUpdated = System.currentTimeMillis();

        while(running){
            currentTime = System.currentTimeMillis();
            double lastRenderTimeInSeconds = (currentTime - lastUpdated) / 1000d;
            accumulator += lastRenderTimeInSeconds;
            lastUpdated = currentTime;

            while (accumulator > updateRate) {
                update();
                accumulator -= updateRate;
            }
            render();
        }

    }

    private void update() {
    }

    private void render() {
    }
}
