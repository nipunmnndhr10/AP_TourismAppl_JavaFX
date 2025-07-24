package org.example.cleanprj.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
//import org.w3c.dom.Node;
import javafx.scene.Node;


import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class AddNewGuideController implements Initializable {

    @FXML
    private TextField nameField;

    @FXML
    private TextField languagesField;

    @FXML
    private TextField experienceField;

    @FXML
    private TextField contactField;

    @FXML
    private ComboBox<String> specializationComboBox;

    @FXML
    private Button closeButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button saveButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize specialization options
//        specializationComboBox.getItems().addAll(
//                "Mountain Guide",
//                "City Tour Guide",
//                "Historical Guide",
//                "Adventure Guide",
//                "Cultural Guide",
//                "Nature Guide"
//        );
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
        // Validate and save guide information
        String name = nameField.getText().trim();
        String languages = languagesField.getText().trim();
        String experience = experienceField.getText().trim();
        String contact = contactField.getText().trim();
        String specialization = specializationComboBox.getValue();

        if (name.isEmpty() || languages.isEmpty() || experience.isEmpty() ||
                contact.isEmpty() || specialization == null) {
            // Show validation error
            System.out.println("Please fill in all fields");
            return;
        }

        // Process the guide data
        System.out.println("Saving guide: " + name);

        // Close dialog after successful save
        closeDialog();
    }

    private void closeDialog() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

//    public void initialize(){
//
//    }
//
//    @FXML
//    public void handleClose(ActionEvent event) {
//        // Get the current window (stage) and close it
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        stage.close();
//    }
//
//    // You can also add Save logic here before closing
//    @FXML
//    private void handleSave(ActionEvent event) {
//        // TODO: add your saving logic here
//
//        // After saving, close the popup
////        handleClose(event);
//    }



}
