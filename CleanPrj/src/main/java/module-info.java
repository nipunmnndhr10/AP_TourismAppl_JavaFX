module org.example.cleanprj {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens org.example.cleanprj to javafx.fxml;
    exports org.example.cleanprj.controllers to javafx.fxml;
    opens org.example.cleanprj.views to javafx.fxml;
    opens org.example.cleanprj.controllers to javafx.fxml;
    exports org.example.cleanprj;
}