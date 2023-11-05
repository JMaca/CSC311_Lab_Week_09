package registration_app.maca_lab_wk_09;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

public class RegistrationController {
    @FXML
    private TextField firstNameTextField, lastNameTextField, emailTextField, birthTextField, zipTextField;
    @FXML
    private Label firstNameErrorLabel, lastNameErrorLabel, emailErrorLabel, birthErrorLabel, zipErrorLabel;
    @FXML
    private AnchorPane anchorPane;
    private String firstName, lastName, email;
    private int birthDate, zipCode;
    private boolean firstNameFlag = false, lastNameFlag = false, emailFlag = false, birthFlag = false, zipFlag = false;

    @FXML
    protected void registerOnAction() {
        try {
            if (!(firstNameFlag || lastNameFlag || emailFlag || birthFlag || zipFlag)) { //if all fields have no true flags then proceed.
                System.out.println("ALL FIELDS ARE CORRECT. PROCEEDING TO REGISTRATION.");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("One or more fields may have an error.");
                alert.setContentText("A field does not have the correct input , please review the form for errors before proceeding.");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize() {
        firstNameTextField.setOnKeyPressed(key -> {
            if (key.getCode() != KeyCode.TAB && firstNameFlag) {
                firstNameTextField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                firstNameErrorLabel.setText("");
                firstNameFlag = false;
            }
        });
        firstNameTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
            } else {
                if (firstNameTextField.getText().matches("^[A-Za-z'\\s]{1,20}")) {
                    System.out.println("First name Match!");
                    firstNameTextField.setBorder(null);
                } else {
                    firstNameTextField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    System.out.println("No First Name Match!");
                    firstNameErrorLabel.setText(firstNameTextField.getText() + " is not valid first name\nPlease only use only letters, apostrophes, or spaces with a maximum of 20 characters");
                    firstNameFlag = true;
                }
            }
        });
        lastNameTextField.setOnKeyPressed(key -> {
            if (key.getCode() != KeyCode.TAB && lastNameFlag) {
                lastNameTextField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                lastNameErrorLabel.setText("");
                lastNameFlag = false;
            }
        });
        lastNameTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
            } else {
                if (lastNameTextField.getText().matches("^[A-Za-z'\\s]{1,20}")) {
                    System.out.println("last name Match!");
                    lastNameTextField.setBorder(null);
                } else {
                    lastNameTextField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    System.out.println("No last name Match!");
                    lastNameErrorLabel.setText(lastNameTextField.getText() + " is not valid last name\nPlease only use only letters, apostrophes, or spaces with a maximum of 20 characters");
                    lastNameFlag = true;
                }
            }
        });
        emailTextField.setOnKeyPressed(key -> {
            if (key.getCode() != KeyCode.TAB && emailFlag) {
                emailTextField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                emailErrorLabel.setText("");
                emailFlag = false;
            }
        });
        emailTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
            } else {
                if (emailTextField.getText().matches("^(.+)@(\\S+)$")) {
                    System.out.println("email Match!");
                    emailTextField.setBorder(null);
                } else {
                    emailTextField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    System.out.println("No email Match!");
                    emailErrorLabel.setText(emailTextField.getText() + " is not valid email\nMust include an \'@\' and \'.\'");
                    emailFlag = true;
                }
            }
        });
        birthTextField.setOnKeyPressed(key -> {
            if (key.getCode() != KeyCode.TAB && birthFlag) {
                birthTextField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                birthErrorLabel.setText("");
                birthFlag = false;
            }
        });
        birthTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
            } else {
                if (birthTextField.getText().matches("^[0-9\\/]{8,10}")) {
                    System.out.println("birth Match!");
                    birthTextField.setBorder(null);
                } else {
                    birthTextField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    System.out.println("No birth Match!");
                    birthErrorLabel.setText(birthTextField.getText() + " is not valid birthdate\nPlease only use numbers with a slash(EX: 00/00/0000) maximum of 10 characters");
                    birthFlag = true;
                }
            }
        });
        zipTextField.setOnKeyPressed(key -> {
            if (key.getCode() != KeyCode.TAB && zipFlag) {
                zipTextField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                zipErrorLabel.setText("");
                zipFlag = false;
            }
        });
        zipTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
            } else {
                if (zipTextField.getText().matches("^[0-9]{5}")) {
                    System.out.println("zip Match!");
                    zipTextField.setBorder(null);
                } else {
                    zipTextField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    System.out.println("No zip Match!");
                    zipErrorLabel.setText(zipTextField.getText() + " is not valid zipcode\nPlease only use numbers with a maximum of 5 characters");
                    zipFlag = true;
                }
            }
        });
    }
}