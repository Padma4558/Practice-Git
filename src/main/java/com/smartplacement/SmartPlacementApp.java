package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class SmartPlacementApp {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Student> students =
            new ArrayList<>();


    public static void main(String[] args) {

        int choice;

        do {

            displayMenu();

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayAllStudents();
                    break;

                case 3:
                    generateReport();
                    break;

                case 4:
                    System.out.println(
                            "\nThank you for using "
                                    + "Smart Placement Readiness System!"
                    );
                    break;

                default:
                    System.out.println(
                            "\nInvalid choice. Please try again."
                    );
            }

        } while (choice != 4);

        scanner.close();
    }


    static void displayMenu() {

        System.out.println("\n");
        System.out.println("==============================================");
        System.out.println("       SMART PLACEMENT READINESS SYSTEM");
        System.out.println("==============================================");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Generate Placement Report");
        System.out.println("4. Exit");
        System.out.println("==============================================");
    }


    static void addStudent() {

        System.out.println("\n----------- ADD STUDENT -----------");

        scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Branch: ");
        String branch = scanner.nextLine();

        int programming =
                readScore(
                        "Programming Skill (0-10): ",
                        0, 10
                );

        int dsa =
                readScore(
                        "DSA Skill (0-10): ",
                        0, 10
                );

        int sql =
                readScore(
                        "SQL Skill (0-10): ",
                        0, 10
                );

        int aptitude =
                readScore(
                        "Aptitude Score (0-100): ",
                        0, 100
                );

        int communication =
                readScore(
                        "Communication Skill (0-10): ",
                        0, 10
                );

        int codingProblems =
                readScore(
                        "Coding Problems Solved: ",
                        0, 1000
                );

        int mockInterviews =
                readScore(
                        "Mock Interviews Attended: ",
                        0, 100
                );

        boolean resumeReady =
                readYesNo(
                        "Is Resume Ready? (yes/no): "
                );


        Student student =
                new Student(
                        name,
                        branch,
                        programming,
                        dsa,
                        sql,
                        aptitude,
                        communication,
                        codingProblems,
                        mockInterviews,
                        resumeReady
                );


        PlacementAnalyzer analyzer =
                new PlacementAnalyzer();

        analyzer.analyze(student);

        students.add(student);


        System.out.println(
                "\n✓ Student added successfully!"
        );

        System.out.printf(
                "Placement Readiness Score: %.2f%%%n",
                student.readinessScore
        );
    }


    static void displayAllStudents() {

        System.out.println(
                "\n----------- ALL STUDENTS -----------"
        );

        if (students.isEmpty()) {

            System.out.println(
                    "No students registered yet."
            );

            return;
        }


        System.out.printf(
                "%-5s %-20s %-15s %-15s%n",
                "No.",
                "Name",
                "Branch",
                "Readiness"
        );

        System.out.println(
                "--------------------------------------------------------"
        );


        int number = 1;

        for (Student student : students) {

            System.out.printf(
                    "%-5d %-20s %-15s %.2f%%%n",
                    number,
                    student.name,
                    student.branch,
                    student.readinessScore
            );

            number++;
        }
    }


    static void generateReport() {

        System.out.println(
                "\n----------- GENERATE REPORT -----------"
        );

        if (students.isEmpty()) {

            System.out.println(
                    "No students registered yet."
            );

            return;
        }


        displayAllStudents();


        int studentNumber =
                readScore(
                        "\nEnter student number: ",
                        1,
                        students.size()
                );


        Student selectedStudent =
                students.get(studentNumber - 1);


        PlacementAnalyzer analyzer =
                new PlacementAnalyzer();

        analyzer.analyze(selectedStudent);

        analyzer.displayReport(selectedStudent);
    }


    static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }


    static int readScore(
            String message,
            int minimum,
            int maximum) {

        while (true) {

            int value = readInt(message);

            if (value >= minimum
                    && value <= maximum) {

                return value;
            }

            System.out.println(
                    "Please enter a value between "
                            + minimum
                            + " and "
                            + maximum
                            + "."
            );
        }
    }


    static boolean readYesNo(String message) {

        while (true) {

            System.out.print(message);

            String input =
                    scanner.nextLine()
                            .trim()
                            .toLowerCase();


            if (input.equals("yes")
                    || input.equals("y")) {

                return true;
            }


            if (input.equals("no")
                    || input.equals("n")) {

                return false;
            }


            System.out.println(
                    "Please enter yes or no."
            );
        }
    }
}
