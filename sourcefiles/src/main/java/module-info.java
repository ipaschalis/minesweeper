module com.mycompany.paschalis {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.paschalis to javafx.fxml;
    exports com.mycompany.paschalis;
}
