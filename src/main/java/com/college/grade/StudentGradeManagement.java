package com.college.grade;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeManagement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> studentIds = new ArrayList<>();
        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Double> averages = new ArrayList<>();
        ArrayList<String> grades = new ArrayList<>();

        while (true) {

            System.out.println();
            System.out.println("======================================");
            System.out.println("   STUDENT GRADE MANAGEMENT SYSTEM");
            System.out.println("======================================");

            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.println();
                    System.out.println("---------- Add Student ----------");

                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Java Marks: ");
                    double javaMarks = scanner.nextDouble();

                    System.out.print("Enter SQL Marks: ");
                    double sqlMarks = scanner.nextDouble();

                    System.out.print("Enter DAA Marks: ");
                    double daaMarks = scanner.nextDouble();

                    double average =
                            (javaMarks + sqlMarks + daaMarks) / 3;

                    String grade;

                    if (average >= 90) {
                        grade = "A+";
                    }
                    else if (average >= 80) {
                        grade = "A";
                    }
                    else if (average >= 70) {
                        grade = "B";
                    }
                    else if (average >= 60) {
                        grade = "C";
                    }
                    else if (average >= 50) {
                        grade = "D";
                    }
                    else {
                        grade = "F";
                    }

                    studentIds.add(id);
                    studentNames.add(name);
                    averages.add(average);
                    grades.add(grade);

                    System.out.println();
                    System.out.println("Student added successfully!");
                    System.out.println("Average: " + average);
                    System.out.println("Grade: " + grade);

                    break;

                case 2:

                    System.out.println();
                    System.out.println("---------- All Students ----------");

                    if (studentIds.isEmpty()) {

                        System.out.println("No students available.");

                    }
                    else {

                        for (int i = 0;
                             i < studentIds.size();
                             i++) {

                            System.out.println(
                                    "Student ID   : " +
                                            studentIds.get(i)
                            );

                            System.out.println(
                                    "Student Name : " +
                                            studentNames.get(i)
                            );

                            System.out.println(
                                    "Average      : " +
                                            averages.get(i)
                            );

                            System.out.println(
                                    "Grade        : " +
                                            grades.get(i)
                            );

                            System.out.println(
                                    "--------------------------------"
                            );
                        }
                    }

                    break;

                case 3:

                    System.out.println();
                    System.out.println("---------- Search Student ----------");

                    System.out.print("Enter Student ID: ");

                    int searchId = scanner.nextInt();

                    boolean found = false;

                    for (int i = 0;
                         i < studentIds.size();
                         i++) {

                        if (studentIds.get(i) == searchId) {

                            System.out.println();
                            System.out.println("Student Found!");

                            System.out.println(
                                    "Student ID   : " +
                                            studentIds.get(i)
                            );

                            System.out.println(
                                    "Student Name : " +
                                            studentNames.get(i)
                            );

                            System.out.println(
                                    "Average      : " +
                                            averages.get(i)
                            );

                            System.out.println(
                                    "Grade        : " +
                                            grades.get(i)
                            );

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }

                    break;

                case 4:

                    System.out.println();
                    System.out.println(
                            "Thank you for using " +
                                    "Student Grade Management System!"
                    );

                    scanner.close();
                    return;

                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }
    }
}