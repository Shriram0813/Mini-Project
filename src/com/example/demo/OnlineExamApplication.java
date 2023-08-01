package com.example.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class OnlineExamApplication {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            ExamDAO examDAO = new ExamDAO(connection);
            List<Exam> exams = examDAO.getAllExams();

            Scanner scanner = new Scanner(System.in);

            for (Exam exam : exams) {
                System.out.println("Exam ID: " + exam.getId());
                System.out.println("Exam Title: " + exam.getTitle());
                List<Question> questions = exam.getQuestion();

                int totalMarks = 0;
                int obtainedMarks = 0;

                for (Question question : questions) {
                    System.out.println("Question ID: " + question.getId());
                    System.out.println("Question Text: " + question.getText());

                    // Get user's answer
                    System.out.print("Your Answer: ");
                    String userAnswer = scanner.nextLine().trim();

                    // Evaluate the answer and provide marks
                    if (userAnswer.equalsIgnoreCase(question.getCorrectAnswer())) {
                        System.out.println("Correct!");
                        obtainedMarks++;
                    } else {
                        System.out.println("Incorrect!");
                    }

                    totalMarks++;
                    System.out.println("--------------------------");
                }

                // Display exam score
                System.out.println("Exam Score: " + obtainedMarks + "/" + totalMarks);
                System.out.println("===========================================");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
