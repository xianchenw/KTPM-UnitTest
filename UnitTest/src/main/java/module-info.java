module com.mycompany.unittest {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.unittest to javafx.fxml;
    exports com.mycompany.unittest;
}
