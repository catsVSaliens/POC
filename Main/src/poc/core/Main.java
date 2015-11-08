package poc.core;

/**
 * @author TheToled
 */
public class Main {

	private boolean running = false;

	public static final int FPS = 60;

	public static void main(String[] args) {
		System.out.println("Hello World, it's Tol :)!!!!");

		Main main = new Main();
		main.running = true;
		main.gameLoop();
	}

	private void gameLoop() {
		int frameCount = 0;
		final int NS_PER_S = 1000000000;
		final long NS_PER_FRAME = NS_PER_S / FPS;

		long lastLoopTime = System.nanoTime();
		long lastSecondMark = 0;

		while (running) {
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			double delta = updateLength / ((double) NS_PER_FRAME);

			lastSecondMark += updateLength;
			frameCount++;

			if (lastSecondMark >= 1000000000) {
				System.out.println("FPS: " + frameCount + " fps");
				lastSecondMark = 0;
				frameCount = 0;
			}

			updateGame(delta);
			drawGame();

			try {
				Thread.sleep((lastLoopTime - System.nanoTime() + NS_PER_FRAME) / 1000000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void updateGame(double delta) {

	}

	private void drawGame() {

	}
}
