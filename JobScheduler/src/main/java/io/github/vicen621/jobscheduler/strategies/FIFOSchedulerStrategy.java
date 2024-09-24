package io.github.vicen621.jobscheduler.strategies;

import io.github.vicen621.jobscheduler.JobDescription;

import java.util.List;

public class FIFOSchedulerStrategy implements SchedulerStrategy {
    @Override
    public JobDescription getNextJob(List<JobDescription> jobs) {
        return jobs.get(0);
    }
}
