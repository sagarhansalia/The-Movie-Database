package movie.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import movie.Main;
import movie.model.MovieModel;

public class UserGenericMovieControl extends AnchorPane 
{

	@FXML
	private Text titleTX;
	@FXML
	private TextArea castTA;
	@FXML
	private TextField ratingTF;
	@FXML
	private TextField genreTF;
	@FXML
	private TextField runtimeTF;
	@FXML
	private TextField categoryTF;
	@FXML
	private TextField releaseDateTF;
	@FXML
	private TextArea summaryTA;
	
	@FXML
	private Button backBT;
//	@FXML
//	private Button updateBT;
//	@FXML
//	private Button deleteBT;
	
	private boolean isAdmin;
	
  	public MovieModel mm = new MovieModel();

	
//	@FXML
//	public void updateDB()
//	{
//		String title = titleTX.getText();
//		String cast = castTA.getText();
// 		String rating = ratingTF.getText();
// 		String genre = genreTF.getText();
// 		String runtime = runtimeTF.getText();
// 		String category = categoryTF.getText();
// 		String releaseDate = releaseDateTF.getText();
// 		String summary = summaryTA.getText();
// 		
// 		mm.updateMovie (title, cast, rating, genre, runtime, category, releaseDate, summary);
// 		loadPrevPage("Movie Updated");
//	}
//	
//	@FXML
//	public void deleteFromDB()
//	{
//		mm.deleteMovie(titleTX.getText());
//		
//		loadPrevPage("Movie Deleted");
//	}
	
	@FXML
	public void loadPrevPageTest()
	{
		loadPrevPage("");
	}
	
	
   	public void loadPrevPage(String label)
   	{
   		//System.out.println("Button clicked");
   		try {
   		
   			Stage primaryStage;
   			
   			primaryStage = (Stage)backBT.getScene().getWindow();
   			
   			FXMLLoader loader = new FXMLLoader();    //check file name here
   			loader.setLocation(Main.class.getResource("view/UserMovieList2.fxml"));
   			AnchorPane rootLayout = (AnchorPane) loader.load();
   			
   			UserMovieListControl obj = loader.getController();
   			obj.setLabel(label);
   			
   			 // Show the scene containing the root layout.	
   			Scene scene = new Scene(rootLayout);
   			primaryStage.setScene(scene);
   			primaryStage.show();
   			} 
   			catch(IOException e)
   			{
   				e.printStackTrace();
   			}
   	}

	/**
	 * @param newValue
	 */
	public void setMovie(String newValue)
	{

		Object[] movieInfo = mm.getMovie(newValue);
		titleTX.setText(newValue);
		castTA.setText((String) movieInfo[0]);
		ratingTF.setText(movieInfo[1].toString());
		genreTF.setText((String) movieInfo[2]);
		runtimeTF.setText((String) movieInfo[3]);
		categoryTF.setText((String) movieInfo[4]);
		releaseDateTF.setText((movieInfo[5].toString()));
		summaryTA.setText((String) movieInfo[6]);

		
	}

	/**
	 * @param isAdmin
	 */
//	public void setAdmin(boolean isAdmin)
//	{
//		this.isAdmin = isAdmin;
//		if(!isAdmin)
//		{
//			deleteBT.setVisible(false);
//			updateBT.setVisible(false);
//		}
//		
//	}
	
}
