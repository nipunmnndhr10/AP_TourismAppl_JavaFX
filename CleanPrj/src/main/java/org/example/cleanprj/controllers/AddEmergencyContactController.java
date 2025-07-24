package org.example.cleanprj.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class AddEmergencyContactController implements Initializable {

    @FXML
    private TextField nameField;

    @FXML
    private TextField organizationField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField emailField;

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private TextField locationField;

    @FXML
    private CheckBox available24_7CheckBox;

    @FXML
    private Button closeButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button addContactButton;

    // Email validation pattern
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$"
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize emergency contact types
        typeComboBox.getItems().addAll(
                "Police",
                "Fire Department",
                "Medical/Hospital",
                "Mountain Rescue",
                "Tourist Police",
                "Embassy/Consulate",
                "Local Authority",
                "Insurance Provider",
                "Transportation",
                "Other Emergency Service"
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
    private void handleAddContact() {
        // Validate and save emergency contact information
        String name = nameField.getText().trim();
        String organization = organizationField.getText().trim();
        String phone = phoneField.getText().trim();
        String email = emailField.getText().trim();
        String type = typeComboBox.getValue();
        String location = locationField.getText().trim();
        boolean available24_7 = available24_7CheckBox.isSelected();

        // Validation
        if (name.isEmpty() || organization.isEmpty() || phone.isEmpty() ||
                email.isEmpty() || type == null || location.isEmpty()) {
            System.out.println("Please fill in all required fields");
            return;
        }

        // Validate email format
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            System.out.println("Please enter a valid email address");
            return;
        }

        // Validate phone number (basic validation)
        if (!isValidPhoneNumber(phone)) {
            System.out.println("Please enter a valid phone number");
            return;
        }

        // Process the emergency contact data
        System.out.println("Adding emergency contact:");
        System.out.println("Name: " + name);
        System.out.println("Organization: " + organization);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Type: " + type);
        System.out.println("Location: " + location);
        System.out.println("Available 24/7: " + (available24_7 ? "Yes" : "No"));

        // Close dialog after successful save
        closeDialog();
    }

    private boolean isValidPhoneNumber(String phone) {
        return phone.matches("^[+]?[-()\\d\\s]{7,20}$");
    }

    private void closeDialog() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}