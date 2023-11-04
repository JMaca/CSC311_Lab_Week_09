module registration_app.maca_lab_wk_09 {
    requires javafx.controls;
    requires javafx.fxml;


    opens registration_app.maca_lab_wk_09 to javafx.fxml;
    exports registration_app.maca_lab_wk_09;
}