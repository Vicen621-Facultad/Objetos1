package io.github.vicen621.jobscheduler.strategies;

import io.github.vicen621.jobscheduler.JobDescription;

import java.util.List;

public interface SchedulerStrategy {
    JobDescription getNextJob(List<JobDescription> jobs);
}
