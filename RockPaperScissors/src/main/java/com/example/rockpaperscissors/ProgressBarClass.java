package com.example.rockpaperscissors;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;

public class ProgressBarClass {
    public void test (ProgressBar progressbar, SchereSteinPapier_Control controller) {
        final Task<Void> task = new Task<Void>() {
            final int N_ITERATIONS = 100;

            /**
             * This method makes the loading progressbar with the actions
             * which are meant to be after the loading finished
             */

            @Override
            protected Void call() throws Exception {
                for (int i = 0; i < N_ITERATIONS; i++) {
                    updateProgress(i + 1, N_ITERATIONS);
                    // sleep is used to simulate doing some work which takes some time....
                    Thread.sleep(10);
                }
                Platform.runLater(() -> {
                    controller.RandomChoice();
                    controller.Highscore();
                    controller.ButtonsDisable();
                });
                return null;
            }
        };

        progressbar.progressProperty().bind(
                task.progressProperty()
        );

        final Thread thread = new Thread(task, "task-thread");
        thread.setDaemon(true);
        thread.start();
    }
    }

