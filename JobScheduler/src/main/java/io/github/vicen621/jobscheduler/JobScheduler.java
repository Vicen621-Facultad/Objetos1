package io.github.vicen621.jobscheduler;

import io.github.vicen621.jobscheduler.strategies.SchedulerStrategy;

import java.util.ArrayList;
import java.util.List;

public class JobScheduler {
    protected List<JobDescription> jobs;
    protected SchedulerStrategy strategy;

    public JobScheduler(SchedulerStrategy strategy) {
        this.jobs = new ArrayList<>();
        this.strategy = strategy;
    }

    public void schedule(JobDescription job) {
        this.jobs.add(job);
    }

    public void unschedule(JobDescription job) {
        if (job != null) {
            this.jobs.remove(job);
        }
    }

    public List<JobDescription> getJobs(){
        return jobs;
    }

    public JobDescription next() {
        JobDescription nextJob = strategy.getNextJob(jobs);
        this.unschedule(nextJob);
        return nextJob;
    }
}
