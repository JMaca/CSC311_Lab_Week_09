package registration_app.maca_lab_wk_09;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/**
 * This is the Registration Controller class.
 * <p>
 * The tasks performed by the class are:
 * <ul>
 * <li>Runs a listener to check each field for correct input through regex expressions.
 * <li>When all fields are correct it enables the registration button to be clicked
 * <li>Clicking the registration will complete the process and move to follow-up page.
 * </ul>
 *
 * @author John Maca
 */

public class RegistrationController {
    @FXML
    private TextField firstNameTextField, lastNameTextField, emailTextField, birthTextField, zipTextField;
    @FXML
    private Label firstNameErrorLabel, lastNameErrorLabel, emailErrorLabel, birthErrorLabel, zipErrorLabel;
    @FXML
    private boolean firstNameFlag = false, lastNameFlag = false, emailFlag = false, birthFlag = false, zipFlag = false;
    @FXML
    private Button registerBtn;

    @FXML
    protected void registerOnAction() {
        try {
            if (!(firstNameFlag || lastNameFlag || emailFlag || birthFlag || zipFlag)) { //if all fields have no true flags then proceed.
                Parent root = FXMLLoader.load(getClass().getResource("/registration_app/maca_lab_wk_09/function.fxml").toURI().toURL());
                Scene scene = new Scene(root);
                Stage window = (Stage) firstNameTextField.getScene().getWindow();
                window.setScene(scene);
                window.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR); // With the checkButtonDisable method this alert should not come up.
                alert.setTitle("ERROR");
                alert.setHeaderText("One or more fields may have an error.");
                alert.setContentText("A field does not have the correct input , please review the form for errors before proceeding.");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method runs listeners for each text-field.
     * Any input put into each text-field is validated through regex expressions.
     * If any input has errors, then an error message will appear along with a red border around the incorrect field.
     * The error will trigger a specific flag to the "true" value.
     * The flags will be checked through the checkButtonDisable method.
     */
    public void initialize() {
        firstNameTextField.setOnKeyPressed(key -> {
            if (key.getCode() != KeyCode.TAB && firstNameFlag) {
                firstNameTextField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                firstNameErrorLabel.setText("");
                firstNameFlag = false;
            }
            checkButtonDisable();
        });
        firstNameTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
            } else {
                if (firstNameTextField.getText().matches("^[A-Za-z'\\s]{2,25}")) {
                    firstNameTextField.setBorder(null);
                } else {
                    firstNameTextField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    firstNameErrorLabel.setText(firstNameTextField.getText() + " is not valid first name\nPlease only use only letters, apostrophes, or spaces, with a minimum of 2 characters, maximum of 25 characters");
                    firstNameFlag = true;
                }
            }
            checkButtonDisable();
        });
        lastNameTextField.setOnKeyPressed(key -> {
            if (key.getCode() != KeyCode.TAB && lastNameFlag) {
                lastNameTextField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                lastNameErrorLabel.setText("");
                lastNameFlag = false;
            }
            checkButtonDisable();
        });
        lastNameTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
            } else {
                if (lastNameTextField.getText().matches("^[A-Za-z'\\s]{2,25}")) {
                    lastNameTextField.setBorder(null);
                } else {
                    lastNameTextField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    lastNameErrorLabel.setText(lastNameTextField.getText() + " is not valid last name\nPlease only use only letters, apostrophes, or spaces, with a minimum of 2 characters, maximum of 20 characters");
                    lastNameFlag = true;
                }
            }
            checkButtonDisable();
        });
        emailTextField.setOnKeyPressed(key -> {
            if (key.getCode() != KeyCode.TAB && emailFlag) {
                emailTextField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                emailErrorLabel.setText("");
                emailFlag = false;
            }
            checkButtonDisable();
        });
        emailTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
            } else {
                if (emailTextField.getText().matches("^(.+)@farmingdale.edu$")) {
                    emailTextField.setBorder(null);
                } else {
                    emailTextField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    emailErrorLabel.setText(emailTextField.getText() + " is not valid email\nMust include an \'@farmingdale.edu\'");
                    emailFlag = true;
                }
            }
            checkButtonDisable();
        });
        birthTextField.setOnKeyPressed(key -> {
            if (key.getCode() != KeyCode.TAB && birthFlag) {
                birthTextField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                birthErrorLabel.setText("");
                birthFlag = false;
            }
            checkButtonDisable();
        });
        birthTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
            } else {
                if (birthTextField.getText().matches("^(0[0-9]||1[0-2])\\/([0-2][0-9]||3[0-1])\\/([0-9][0-9])?[0-9][0-9]$")) { // Strict regex for only MM/DD/YYYY
                    birthTextField.setBorder(null);
                } else {
                    birthTextField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");

                    birthErrorLabel.setText(birthTextField.getText() + " is not valid birthdate\nPlease only use numbers with a slash separating each EX:MM/DD/YYYY");
                    birthFlag = true;
                }
            }
            checkButtonDisable();
        });
        zipTextField.setOnKeyPressed(key -> {
            if (key.getCode() != KeyCode.TAB && zipFlag) {
                zipTextField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                zipErrorLabel.setText("");
                zipFlag = false;
            }
            checkButtonDisable();
        });
        zipTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
            } else {
                if (zipTextField.getText().matches("^[0-9]{5}")) {
                    zipTextField.setBorder(null);
                } else {
                    zipTextField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    zipErrorLabel.setText(zipTextField.getText() + " is not valid zipcode\nPlease only use numbers with a maximum of 5 characters");
                    zipFlag = true;
                }
            }
            checkButtonDisable();
        });
    }

    /**
     * This method checks all tags for each field.
     * If no errors then it will proceed to change the registerBtn to be clickable.
     * This method requires no input and does not return any value.
     */
    private void checkButtonDisable() { //Checks for flags in order to disable or enable register button
        if (!(firstNameFlag || lastNameFlag || emailFlag || birthFlag || zipFlag)) {
            registerBtn.setDisable(false);
        } else {
            registerBtn.setDisable(true);
        }
    }
}