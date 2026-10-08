package org.example;

public class Student {

    String name;
    String branch;

    int programming;
    int dsa;
    int sql;
    int aptitude;
    int communication;

    int codingProblems;
    int mockInterviews;

    boolean resumeReady;

    double readinessScore;
    String readinessLevel;

    public Student(String name, String branch,
                   int programming, int dsa, int sql,
                   int aptitude, int communication,
                   int codingProblems, int mockInterviews,
                   boolean resumeReady) {

        this.name = name;
        this.branch = branch;
        this.programming = programming;
        this.dsa = dsa;
        this.sql = sql;
        this.aptitude = aptitude;
        this.communication = communication;
        this.codingProblems = codingProblems;
        this.mockInterviews = mockInterviews;
        this.resumeReady = resumeReady;
    }
}
