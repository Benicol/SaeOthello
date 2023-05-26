package principal;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


/** TODO comment class responsibility (SRP)
 * @author Jodie Monterde
 *
 */
public class Main extends Application {
	/* non javadoc - @see javafx.application.Application#start(javafx.stage.Stage) */
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,600,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			/** */
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** TODO comment method role
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
