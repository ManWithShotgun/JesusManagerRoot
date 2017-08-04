package ru.jesus.manager;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ILIA on 29.06.2017.
 */
public class FooTabPage extends AnchorPane{

    public FooTabPage() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/jesus/ui/fooTabPage.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
