module com.mycompany.kytucxa {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.kytucxa to javafx.fxml;
    exports com.mycompany.kytucxa;
}
