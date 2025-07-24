package org.example.cleanprj.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddNewAttractionController implements Initializable {

    @FXML
    private TextField nameField;

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private TextField locationField;

    @FXML
    private ComboBox<String> difficultyComboBox;

    @FXML
    private TextField altitudeField;

    @FXML
    private TextField durationField;

    @FXML
    private TextField bestSeasonField;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private Button closeButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button saveButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize type options
        typeComboBox.getItems().addAll(
                "Mountain Peak",
                "Trekking Route",
                "Cultural Site",
                "Natural Wonder",
                "Adventure Activity",
                "Historical Monument",
                "Religious Site",
                "National Park"
        );

        // Initialize difficulty options
        difficultyComboBox.getItems().addAll(
                "Easy",
                "Moderate",
                "Challenging",
                "Difficult",
                "Extreme"
        );
    }

    @FXML
    private void handleClose() {
        closeDialog();
    }

    @FXML
    private void handleCancel() {
        closeDialog();
    }

    @FXML
    private void handleSave() {
        // Validate and save attraction information
        String name = nameField.getText().trim();
        String type = typeComboBox.getValue();
        String location = locationField.getText().trim();
        String difficulty = difficultyComboBox.getValue();
        String altitude = altitudeField.getText().trim();
        String duration = durationField.getText().trim();
        String bestSeason = bestSeasonField.getText().trim();
        String description = descriptionArea.getText().trim();

        if (name.isEmpty() || type == null || location.isEmpty() ||
                difficulty == null || altitude.isEmpty() || duration.isEmpty() ||
                bestSeason.isEmpty() || description.isEmpty()) {
            // Show validation error
            System.out.println("Please fill in all fields");
            return;
        }

        // Validate altitude is numeric
        try {
            Double.parseDouble(altitude);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid altitude in meters");
            return;
        }

        // Process the attraction data
        System.out.println("Saving attraction: " + name);
        System.out.println("Type: " + type);
        System.out.println("Location: " + location);
        System.out.println("Difficulty: " + difficulty);
        System.out.println("Altitude: " + altitude + " meters");
        System.out.println("Duration: " + duration);
        System.out.println("Best Season: " + bestSeason);
        System.out.println("Description: " + description);

        // Close dialog after successful save
        closeDialog();
    }

    private void closeDialog() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
