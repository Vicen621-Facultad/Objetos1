package io.github.vicen621.jobscheduler.strategies;

import io.github.vicen621.jobscheduler.JobDescription;

import java.util.List;

public class LIFOSchedulerStrategy implements SchedulerStrategy {
    @Override
    public JobDescription getNextJob(List<JobDescription> jobs) {
        return jobs.get(jobs.size() - 1);
    }
}
