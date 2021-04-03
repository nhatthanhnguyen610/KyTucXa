module com.mycompany.kytucxa {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql; 

    opens com.mycompany.kytucxa to javafx.fxml;
    exports com.mycompany.kytucxa;
    exports com.dht.pojo;
}
