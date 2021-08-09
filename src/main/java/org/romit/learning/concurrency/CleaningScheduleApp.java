package org.romit.learning.concurrency;

import org.romit.learning.concurrency.runnables.CleaningScheduleRunnable;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CleaningScheduleApp {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        //service.schedule(new CleaningScheduleRunnable(), 5, TimeUnit.SECONDS);
        //service.scheduleAtFixedRate(new CleaningScheduleRunnable(), 5, 4, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(new CleaningScheduleRunnable(), 5, 4, TimeUnit.SECONDS);
    }
}
