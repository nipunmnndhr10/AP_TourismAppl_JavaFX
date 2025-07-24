package org.example.cleanprj.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;

public class AdminController {

    @FXML private ToggleButton analyticsTab;
    @FXML private ToggleButton touristTab;
    @FXML private ToggleButton guideTab;
    @FXML private ToggleButton attractionTab;
    @FXML private ToggleButton bookingTab;
    @FXML private ToggleButton emergencyTab;

    @FXML private VBox analyticsPane;
    @FXML private VBox touristPane;
    @FXML private VBox guidePane;
    @FXML private VBox attractionPane;
    @FXML private VBox bookingPane;
    @FXML private VBox emergencyPane;

    public void initialize() {
        // Set default visible pane
        showPane(analyticsPane);
        setActiveTab(analyticsTab);

        analyticsTab.setOnAction(e -> {
            showPane(analyticsPane);
            setActiveTab(analyticsTab);
        });

        touristTab.setOnAction(e -> {
            showPane(touristPane);
            setActiveTab(touristTab);
        });

        guideTab.setOnAction(e -> {
            showPane(guidePane);
            setActiveTab(guideTab);
        });

        attractionTab.setOnAction(e -> {
            showPane(attractionPane);
            setActiveTab(attractionTab);
        });

        bookingTab.setOnAction(e -> {
            showPane(bookingPane);
            setActiveTab(bookingTab);
        });

        emergencyTab.setOnAction(e -> {
            showPane(emergencyPane);
            setActiveTab(emergencyTab);
        });
    }

    private void showPane(VBox paneToShow) {
        analyticsPane.setVisible(false);
        touristPane.setVisible(false);
        guidePane.setVisible(false);
        attractionPane.setVisible(false);
        bookingPane.setVisible(false);
        emergencyPane.setVisible(false);

        paneToShow.setVisible(true);
    }

    private void setActiveTab(ToggleButton activeTab) {
        ToggleButton[] allTabs = {analyticsTab, touristTab, guideTab, attractionTab, bookingTab, emergencyTab};

        for (ToggleButton tab : allTabs) {
            if (tab == activeTab) {
                tab.getStyleClass().remove("inactive-tab");
                if (!tab.getStyleClass().contains("active-tab")) {
                    tab.getStyleClass().add("active-tab");
                }
            } else {
                tab.getStyleClass().remove("active-tab");
                if (!tab.getStyleClass().contains("inactive-tab")) {
                    tab.getStyleClass().add("inactive-tab");
                }
            }
        }
    }

    public void openAddGuideForm(ActionEvent actionEvent) {
        try {

            URL fxmlLocation = getClass().getResource("/org/example/cleanprj/views/AddNewGuideDialog.fxml");
            System.out.println("FXML Location: " + fxmlLocation);
            // Load the Add Guide form FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/cleanprj/views/AddNewGuideDialog.fxml"));
            Parent root = loader.load();

            // Create a new stage for the popup window
            Stage stage = new Stage();
            stage.setTitle("Add New Guide");
            stage.initModality(Modality.APPLICATION_MODAL); // Block events to other windows
            stage.setResizable(false);

            // Set the scene and show the stage
            stage.setScene(new Scene(root));
            stage.showAndWait(); // Wait for the popup to be closed

        } catch (Exception e) {
            e.printStackTrace();
            // You might want to handle errors more gracefully in production
        }
    }

    public void openAddAttractionDialog(ActionEvent actionEvent) {
        try {

            URL fxmlLocation = getClass().getResource("/org/example/cleanprj/views/AddNewAttractionDialog.fxml");
            System.out.println("FXML Location: " + fxmlLocation);
            // Load the Add Guide form FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/cleanprj/views" +
                    "/AddNewAttractionDialog.fxml"));
            Parent root = loader.load();

            // Create a new stage for the popup window
            Stage stage = new Stage();
            stage.setTitle("Add New Attraction");
            stage.initModality(Modality.APPLICATION_MODAL); // Block events to other windows
            stage.setResizable(false);

            // Set the scene and show the stage
            stage.setScene(new Scene(root));
            stage.showAndWait(); // Wait for the popup to be closed

        } catch (Exception e) {
            e.printStackTrace();
            // You might want to handle errors more gracefully in production
        }
    }

    public void openAddContact(ActionEvent actionEvent) {

        try {

            URL fxmlLocation = getClass().getResource("/org/example/cleanprj/views/AddEmergencyContactDialog.fxml");
            System.out.println("FXML Location: " + fxmlLocation);
            // Load the Add Guide form FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/cleanprj/views" +
                    "/AddEmergencyContactDialog.fxml"));
            Parent root = loader.load();

            // Create a new stage for the popup window
            Stage stage = new Stage();
            stage.setTitle("Add New Attraction");
            stage.initModality(Modality.APPLICATION_MODAL); // Block events to other windows
            stage.setResizable(false);

            // Set the scene and show the stage
            stage.setScene(new Scene(root));
            stage.showAndWait(); // Wait for the popup to be closed

        } catch (Exception e) {
            e.printStackTrace();
            // You might want to handle errors more gracefully in production
        }
    }
}

