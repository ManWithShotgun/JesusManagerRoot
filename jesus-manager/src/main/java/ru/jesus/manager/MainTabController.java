package ru.jesus.manager;

import io.datafx.controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javax.annotation.PostConstruct;

/**
 * Created by ILIA on 29.06.2017.
 */
@ViewController(value = "/fxml/jesus/ui/MainTab.fxml", title = "Jesus Manager")
public class MainTabController {

    @FXML
    private Button button;

//    // Inject tab content.
//    @FXML private FooTabPage fooTabPage;
//    // Inject controller
//    @FXML private FooTabController fooTabPageController;

    @PostConstruct
    public void init() {
        System.out.println("init");
        button.setOnMouseClicked(event -> {
            System.out.println("click");
        });
    }
}
