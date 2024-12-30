package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the main layout and scene
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 400, 300);

        // Apply CSS styling
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        // Create a label for the title
        Label titleLabel = new Label("Course Management System");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        
        // Create buttons with bullet icons
        Button addCourseButton = createButtonWithIcon("Add New Course");
        Button enrollStudentButton = createButtonWithIcon("Enroll Student");
        Button assignGradeButton = createButtonWithIcon("Assign Grade");
        Button calculateGradeButton = createButtonWithIcon("Calculate Overall Grade");

        // Add buttons to the layout
        root.getChildren().addAll(titleLabel, addCourseButton, enrollStudentButton, assignGradeButton, calculateGradeButton);

        // Set button actions
        addCourseButton.setOnAction(e -> showAddCourseDialog());
        enrollStudentButton.setOnAction(e -> showEnrollStudentDialog());
        assignGradeButton.setOnAction(e -> showAssignGradeDialog());
        calculateGradeButton.setOnAction(e -> showCalculateGradeDialog());

        // Set the stage
        primaryStage.setTitle("Course Management System");
        primaryStage.getIcons().add(new Image(MainApp.class.getResourceAsStream("icon.png"))); // Corrected path
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createButtonWithIcon(String text) {
        Image bulletImage = new Image(MainApp.class.getResourceAsStream("icon.png")); // Corrected path
        ImageView bulletImageView = new ImageView(bulletImage);
        bulletImageView.setFitHeight(30);
        bulletImageView.setFitWidth(30);
        Button button = new Button(text, bulletImageView);
        button.setContentDisplay(ContentDisplay.LEFT);
        button.setStyle("-fx-background-color: transparent;"); // Ensure no background color for the button
        return button;
    }

    private void showAddCourseDialog() {
        // Implementation remains the same
    }

    private void showEnrollStudentDialog() {
        // Implementation remains the same
    }

    private void showAssignGradeDialog() {
        // Implementation remains the same
    }

    private void showCalculateGradeDialog() {
        // Implementation remains the same
    }

    // Method to show alert dialogs
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
