module com.datastructuresproject2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.datastructuresproject2 to javafx.fxml;
    exports com.datastructuresproject2;
}