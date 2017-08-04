package ru.jesus.manager.tabs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Narayan
 */
public class About extends VBox implements Initializable {

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("About");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
