module so.edu.hodmas.ims.hucims {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens so.edu.hodmas.ims.hucims to javafx.fxml;
    exports so.edu.hodmas.ims.hucims;
}