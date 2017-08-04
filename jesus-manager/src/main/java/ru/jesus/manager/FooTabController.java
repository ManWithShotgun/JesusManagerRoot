package ru.jesus.manager;


import io.datafx.controller.ViewController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javax.annotation.PostConstruct;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ILIA on 29.06.2017.
 */
public class FooTabController implements Initializable{


    @FXML
    private Button buttonn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("load");
        buttonn.setOnMouseClicked(event -> {
            System.out.println("click2");
        });
    }

}
