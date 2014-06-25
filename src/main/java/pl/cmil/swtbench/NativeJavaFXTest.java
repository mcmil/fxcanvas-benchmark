package pl.cmil.swtbench;

import com.sun.javafx.perf.PerformanceTracker;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.*;

public class NativeJavaFXTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = SceneCreator.createScene();
        primaryStage.setScene(scene);
        PerformanceTracker tracker = PerformanceTracker.getSceneTracker(scene);

        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("Avg: " +
                        tracker.getAverageFPS() + " instant " + tracker.getInstantFPS()), 0, 1, TimeUnit.SECONDS
        );

        primaryStage.show();
    }
}