module so.edu.hodmas.ims.hucims {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens so.edu.hodmas.ims.hucims to javafx.fxml;
    opens so.edu.hodmas.ims.hucims.controllers to javafx.fxml;
    opens so.edu.hodmas.ims.hucims.models to javafx.fxml;

    exports so.edu.hodmas.ims.hucims;
    exports so.edu.hodmas.ims.hucims.controllers;
    exports so.edu.hodmas.ims.hucims.models;

}