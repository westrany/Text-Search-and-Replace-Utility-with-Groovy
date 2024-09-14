import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.VBox
import javafx.stage.Stage
import javafx.geometry.Insets

class TextReplacerUI extends Application {

    @Override
    void start(Stage primaryStage) {
        // Create labels and text input fields
        Label directoryLabel = new Label("Directory Path:")
        TextField directoryInput = new TextField()

        Label searchTextLabel = new Label("Search Text:")
        TextField searchTextInput = new TextField()

        Label replaceTextLabel = new Label("Replace Text:")
        TextField replaceTextInput = new TextField()

        Label logFileLabel = new Label("Log File Path (Optional):")
        TextField logFileInput = new TextField()

        // Create Start Process button and style it
        Button processButton = new Button("Start Process")
        processButton.setStyle("-fx-background-color: #A0D9D9; -fx-text-fill: #333333; -fx-font-weight:bold;")

        // Action for Start Process button
        processButton.setOnAction {
            // Print input to console (logic integrated later)
            println "Directory: " + directoryInput.getText()
            println "Search Text: " + searchTextInput.getText()
            println "Replacement Text: " + replaceTextInput.getText()
            println "Log File Path: " + logFileInput.getText()
            // Here, you would call your TextReplacer logic with the gathered inputs
        }

        // Create layout and add elements
        VBox layout = new VBox(10)
        layout.setPadding(new Insets(15))
        layout.getChildren().addAll(directoryLabel, directoryInput, searchTextLabel, searchTextInput,
                replaceTextLabel, replaceTextInput, logFileLabel, logFileInput, processButton)
        
        // Set background color
        layout.setStyle("-fx-background-color: #E0F7F7;")

        // Create scene and show stage
        Scene scene = new Scene(layout, 400, 300)
        primaryStage.setTitle("Text Replacer")
        primaryStage.setScene(scene)
        primaryStage.show()
    }

    static void main(String[] args) {
        launch(args)
    }
}
