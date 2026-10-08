package org.example;

public class PlacementAnalyzer {

    public void analyze(Student student) {

        double programmingScore = student.programming * 10;
        double dsaScore = student.dsa * 10;
        double sqlScore = student.sql * 10;
        double communicationScore = student.communication * 10;

        double aptitudeScore = student.aptitude;

        double codingScore =
                Math.min(student.codingProblems * 2, 100);

        double interviewScore =
                Math.min(student.mockInterviews * 20, 100);

        double resumeScore =
                student.resumeReady ? 100 : 0;

        student.readinessScore =
                programmingScore * 0.15 +
                        dsaScore * 0.20 +
                        sqlScore * 0.10 +
                        aptitudeScore * 0.15 +
                        communicationScore * 0.10 +
                        codingScore * 0.10 +
                        interviewScore * 0.05 +
                        resumeScore * 0.15;

        if (student.readinessScore >= 80) {

            student.readinessLevel = "HIGHLY READY";

        } else if (student.readinessScore >= 60) {

            student.readinessLevel = "READY WITH IMPROVEMENT";

        } else {

            student.readinessLevel = "NEEDS PREPARATION";
        }
    }


    public void displayReport(Student student) {

        System.out.println("\n==============================================");
        System.out.println("       SMART PLACEMENT READINESS REPORT");
        System.out.println("==============================================");

        System.out.println("Student Name       : " + student.name);
        System.out.println("Branch             : " + student.branch);

        System.out.println("----------------------------------------------");

        System.out.println("Programming Skill  : "
                + student.programming + "/10");

        System.out.println("DSA Skill          : "
                + student.dsa + "/10");

        System.out.println("SQL Skill          : "
                + student.sql + "/10");

        System.out.println("Aptitude Score     : "
                + student.aptitude + "/100");

        System.out.println("Communication      : "
                + student.communication + "/10");

        System.out.println("Coding Problems    : "
                + student.codingProblems);

        System.out.println("Mock Interviews    : "
                + student.mockInterviews);

        System.out.println("Resume Ready       : "
                + (student.resumeReady ? "Yes" : "No"));

        System.out.println("----------------------------------------------");

        System.out.printf("Overall Score      : %.2f%%%n",
                student.readinessScore);

        System.out.println("Readiness Level    : "
                + student.readinessLevel);

        System.out.println("----------------------------------------------");

        displayStrengths(student);
        displayImprovements(student);
        displayRecommendations(student);

        System.out.println("==============================================");
    }


    private void displayStrengths(Student student) {

        System.out.println("\nSTRONG AREAS:");

        boolean found = false;

        if (student.programming >= 8) {
            System.out.println("✓ Programming");
            found = true;
        }

        if (student.dsa >= 8) {
            System.out.println("✓ Data Structures & Algorithms");
            found = true;
        }

        if (student.sql >= 8) {
            System.out.println("✓ SQL");
            found = true;
        }

        if (student.aptitude >= 80) {
            System.out.println("✓ Aptitude");
            found = true;
        }

        if (student.communication >= 8) {
            System.out.println("✓ Communication");
            found = true;
        }

        if (student.codingProblems >= 40) {
            System.out.println("✓ Coding Practice");
            found = true;
        }

        if (!found) {
            System.out.println("No major strong area identified yet.");
        }
    }


    private void displayImprovements(Student student) {

        System.out.println("\nAREAS TO IMPROVE:");

        boolean found = false;

        if (student.programming < 6) {
            System.out.println("⚠ Programming");
            found = true;
        }

        if (student.dsa < 6) {
            System.out.println("⚠ Data Structures & Algorithms");
            found = true;
        }

        if (student.sql < 6) {
            System.out.println("⚠ SQL");
            found = true;
        }

        if (student.aptitude < 60) {
            System.out.println("⚠ Aptitude");
            found = true;
        }

        if (student.communication < 6) {
            System.out.println("⚠ Communication");
            found = true;
        }

        if (student.codingProblems < 30) {
            System.out.println("⚠ Coding Practice");
            found = true;
        }

        if (student.mockInterviews < 2) {
            System.out.println("⚠ Mock Interviews");
            found = true;
        }

        if (!student.resumeReady) {
            System.out.println("⚠ Resume Preparation");
            found = true;
        }

        if (!found) {
            System.out.println("No major improvement area identified.");
        }
    }


    private void displayRecommendations(Student student) {

        System.out.println("\nPERSONALIZED RECOMMENDATIONS:");

        boolean found = false;

        if (student.programming < 6) {
            System.out.println(
                    "→ Practice Java/programming fundamentals.");
            found = true;
        }

        if (student.dsa < 6) {
            System.out.println(
                    "→ Practice DSA: arrays, strings, sorting and searching.");
            found = true;
        }

        if (student.sql < 6) {
            System.out.println(
                    "→ Practice SQL queries, joins and subqueries.");
            found = true;
        }

        if (student.aptitude < 60) {
            System.out.println(
                    "→ Practice quantitative and logical aptitude.");
            found = true;
        }

        if (student.communication < 6) {
            System.out.println(
                    "→ Practice communication and interview questions.");
            found = true;
        }

        if (student.codingProblems < 30) {
            System.out.println(
                    "→ Solve at least 30 coding problems.");
            found = true;
        }

        if (student.mockInterviews < 2) {
            System.out.println(
                    "→ Attend at least 2 mock interviews.");
            found = true;
        }

        if (!student.resumeReady) {
            System.out.println(
                    "→ Prepare and review your resume.");
            found = true;
        }

        if (!found) {
            System.out.println(
                    "→ Continue regular placement preparation.");
        }
    }
}
