package net.etfbl.kovid.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import net.etfbl.kovid.models.City;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.ResourceBundle;

public class StartController implements Initializable{


    public TextField kidsInput;
    public TextField adultsInput;
    public TextField elderInput;
    public TextField houseInput;
    public TextField controlInput;
    public TextField ambulanceInput;



    @FXML
    private void startFunction(ActionEvent event) {
        Parent root;
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../resources/mainForm.fxml"));
            City city = new City(
                    Integer.parseInt(kidsInput.getText()), Integer.parseInt(adultsInput.getText()),
                    Integer.parseInt(elderInput.getText()), Integer.parseInt(houseInput.getText()),
                    Integer.parseInt(controlInput.getText()), Integer.parseInt(ambulanceInput.getText())
            );
            CitySingleton instance = CitySingleton.getInstance();
            instance.setCity(city);

            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
//            stage.setUserData(city);

            stage.setScene(scene);
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        // Initialization code can go here.
        // The parameters url and resources can be omitted if they are not needed

        kidsInput.setTextFormatter(getFormatter());
        adultsInput.setTextFormatter(getFormatter());
        elderInput.setTextFormatter(getFormatter());
        houseInput.setTextFormatter(getFormatter());
        controlInput.setTextFormatter(getFormatter());
        ambulanceInput.setTextFormatter(getFormatter());
    }

    private TextFormatter<?> getFormatter() {
        DecimalFormat format = new DecimalFormat("#.0");
        return new TextFormatter<>(c ->
        {
            if ( c.getControlNewText().isEmpty() )
            {
                return c;
            }

            ParsePosition parsePosition = new ParsePosition( 0 );
            Object object = format.parse( c.getControlNewText(), parsePosition );

            if ( object == null || parsePosition.getIndex() < c.getControlNewText().length() )
            {
                return null;
            }
            else
            {
                return c;
            }
        });
    }

}
