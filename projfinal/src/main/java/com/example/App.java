package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Scene sceneADM;
    public static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("pedir"), 1280, 800);
        stage.setScene(scene);
        Stage stageAdm = new Stage();
        sceneADM = new Scene(loadFXML("adm"));
        stageAdm.setScene(sceneADM);
        stageAdm.show();
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}