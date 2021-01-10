package net.etfbl.kovid.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import net.etfbl.kovid.models.City;

import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {
    public void startMoving(ActionEvent actionEvent) {

        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        City u = (City) stage.getUserData();
        System.out.println(u);
        
    }

    public void sendCar(ActionEvent actionEvent) {
        
    }

    public void seeAmbulanceData(ActionEvent actionEvent) {
        
    }

    public void seeStatisticalData(ActionEvent actionEvent) {
    }

    public void pauseSimulation(ActionEvent actionEvent) {
        
    }

    public void startAgain(ActionEvent actionEvent) {
        
    }

    public void closeSimulation(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CitySingleton instance = CitySingleton.getInstance();
        City city = instance.getCity();
        System.out.println("inside main form: " + city);
    }
}
