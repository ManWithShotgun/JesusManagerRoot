package ru.jesus.manager.tabs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Narayan
 */
public class Home extends VBox implements Initializable{

    @FXML
    private void handleAction(ActionEvent event) {
        System.out.println("Home");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
