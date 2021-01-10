package net.etfbl.kovid.controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import net.etfbl.kovid.models.City;

public class MainFormController {
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
}
