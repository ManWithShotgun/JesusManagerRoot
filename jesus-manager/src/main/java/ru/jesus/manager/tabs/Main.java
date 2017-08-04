package ru.jesus.manager.tabs;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import ru.jesus.manager.util.BatRunner;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * @author Narayan
 */

public class Main extends BorderPane implements Initializable{

    @FXML
    private Home homeContent;
    @FXML
    private About aboutContent;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("init main");

        BatRunner batRunner = new BatRunner("D:\\Games\\LServerOut\\login", "start.bat");
        batRunner.start();
    }
}
