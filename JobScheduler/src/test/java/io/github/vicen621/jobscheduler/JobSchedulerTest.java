package io.github.vicen621.jobscheduler;

import io.github.vicen621.jobscheduler.strategies.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JobSchedulerTest {
    protected JobDescription firstJob;
    protected JobDescription highestPriorityJob;
    protected JobDescription mostEffortJob;
    protected JobDescription lastJob;

    private void initializeJobs() {

        firstJob = new JobDescription(1, 1, "Este es el primero");
        highestPriorityJob = new JobDescription(1, 100, "Este es el de más prioridad");
        mostEffortJob = new JobDescription(100, 1, "Este es el de más esfuerzo");
        lastJob = new JobDescription(1, 1, "Este es el último");
    }

    @BeforeEach
    void setUp() {
        this.initializeJobs();
    }

    private JobScheduler newFifoScheduler() {
        return new JobScheduler(new FIFOSchedulerStrategy());
    }

    private JobScheduler newLifoScheduler() {
        return new JobScheduler(new LIFOSchedulerStrategy());
    }

    private JobScheduler newPriorityScheduler() {
        return new JobScheduler(new HighestPrioritySchedulerStrategy());
    }

    private JobScheduler newEffortScheduler() {
        return new JobScheduler(new MostEffortSchedulerStrategy());
    }

    private void scheduleJobsIn(JobScheduler aJobScheduler) {
        aJobScheduler.schedule(firstJob);
        aJobScheduler.schedule(highestPriorityJob);
        aJobScheduler.schedule(mostEffortJob);
        aJobScheduler.schedule(lastJob);
    }

    @Test
    void testSchedule() {
        // Uso cualquier estrategia ya que el schedule es igual para todos
        JobScheduler aScheduler = new JobScheduler(new FIFOSchedulerStrategy());
        aScheduler.schedule(highestPriorityJob);
        assertTrue(aScheduler.getJobs().contains(highestPriorityJob));
    }

    @Test
    void testUnschedule() {
        // Uso cualquier estrategia ya que el unschedule es igual para todos
        JobScheduler aScheduler = new JobScheduler(new FIFOSchedulerStrategy());
        this.scheduleJobsIn(aScheduler);
        aScheduler.unschedule(highestPriorityJob);
        assertFalse(aScheduler.getJobs().contains(highestPriorityJob));
    }

    @Test
    void testNext() {
        JobScheduler scheduler;

        scheduler = this.newFifoScheduler();
        this.scheduleJobsIn(scheduler);
        assertEquals(scheduler.next(), firstJob);
        assertEquals(scheduler.getJobs().size(), 3);

        scheduler = this.newLifoScheduler();
        this.scheduleJobsIn(scheduler);
        assertEquals(scheduler.next(), lastJob);
        assertEquals(scheduler.getJobs().size(), 3);

        scheduler = this.newPriorityScheduler();
        this.scheduleJobsIn(scheduler);
        assertEquals(scheduler.next(), highestPriorityJob);
        assertEquals(scheduler.getJobs().size(), 3);

        scheduler = this.newEffortScheduler();
        this.scheduleJobsIn(scheduler);
        assertEquals(scheduler.next(), mostEffortJob);
        assertEquals(scheduler.getJobs().size(), 3);
    }
}
