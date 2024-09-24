package io.github.vicen621.jobscheduler.strategies;

import io.github.vicen621.jobscheduler.JobDescription;

import java.util.Comparator;
import java.util.List;

public class HighestPrioritySchedulerStrategy implements SchedulerStrategy {

    @Override
    public JobDescription getNextJob(List<JobDescription> jobs) {
        return jobs.stream()
                .max(Comparator.comparingDouble(JobDescription::getPriority))
                .orElse(null);
    }
}
