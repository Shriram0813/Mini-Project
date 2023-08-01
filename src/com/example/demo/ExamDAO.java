package com.example.demo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamDAO extends Examm {
    private Connection connection;

    public ExamDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Exam> getAllExams() {
        List<Exam> exams = new ArrayList<>();
        try (PreparedStatement examStmt = connection.prepareStatement("SELECT * FROM exam");
             ResultSet examResultSet = examStmt.executeQuery()) {

            while (examResultSet.next()) {
                int examId = examResultSet.getInt("id");
                String title = examResultSet.getString("title");

                List<Question> questions = new ArrayList<>();
                try (PreparedStatement questionStmt = connection.prepareStatement("SELECT * FROM question WHERE exam_id = ? LIMIT 5")) {
                    questionStmt.setInt(1, examId);
                    ResultSet questionResultSet = questionStmt.executeQuery();

                    while (questionResultSet.next()) {
                        int questionId = questionResultSet.getInt("id");
                        String text = questionResultSet.getString("text");
                        String correctAnswer = questionResultSet.getString("correct_answer");
                        Question question = new Question(questionId, text, correctAnswer);
                        questions.add(question);
                    }
                }

                Exam exam = new Exam(examId, title, questions);
                exams.add(exam);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exams;
    }

    // Other methods for CRUD operations on exams can also be implemented.
}
