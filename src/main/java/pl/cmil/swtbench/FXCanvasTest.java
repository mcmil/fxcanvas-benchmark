package pl.cmil.swtbench;

import com.sun.javafx.perf.PerformanceTracker;
import javafx.scene.Scene;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


public class FXCanvasTest {


    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());
        javafx.embed.swt.FXCanvas canvas = new javafx.embed.swt.FXCanvas((Composite) shell, SWT.NONE);

        Scene scene = SceneCreator.createScene();
        canvas.setScene(scene);

        PerformanceTracker tracker = PerformanceTracker.getSceneTracker(scene);
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("Avg: " +
                        tracker.getAverageFPS() + " instant " + tracker.getInstantFPS()), 0, 1, TimeUnit.SECONDS );
        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();

        }
        display.dispose();
    }
}