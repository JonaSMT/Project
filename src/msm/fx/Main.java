package msm.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    /*This program is a Musical Society Management, we cant manage instruments, bands and members
    * to create members we need create before some instrument and some band, you can delete, modify and see
    * all of then*/
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("controller.fxml"));
        Pane window = (Pane) loader.load();
        Scene scene = new Scene(window);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
