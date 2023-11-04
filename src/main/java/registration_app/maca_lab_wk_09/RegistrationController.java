package registration_app.maca_lab_wk_09;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController  implements Initializable {
    @FXML
    private TextField firstNameTextField, lastNameTextField, emailTextField, birthTextField, zipTextField;
    @FXML
    private AnchorPane anchorPane;
    private String firstName, lastName, email;
    private int birthDate, zipCode;

    private boolean newValue;

    {

    }

    @FXML
    protected void registerOnAction() {
        try {
            firstName = firstNameTextField.getText();
            lastName = lastNameTextField.getText();
            email = emailTextField.getText();
            birthDate = Integer.parseInt(birthTextField.getText());
            zipCode = Integer.parseInt(zipTextField.getText());

            Utilities.nameCheck();
            Utilities.emailCheck();
            Utilities.birthDateCheck();
            Utilities.zipCodeCheck();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstNameTextField.setOnKeyPressed(key -> {
            if (key.getCode() != KeyCode.TAB && flag){

            }
                });
        firstNameTextField.focusedProperty().addListener(observable, oldValue , newValue) -> {
            if(newValue){
                System.out.println();
            }else {
                if (firstNameTextField.getText().matches("^(.+)@(.+)$*")){

                }
            }
        });

    }
}