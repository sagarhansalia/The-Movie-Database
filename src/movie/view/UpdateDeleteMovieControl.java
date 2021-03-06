package movie.view;

import java.io.IOException;

import java.sql.Connection;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import movie.Main;
import movie.model.MovieModel;
import movie.model.SqliteConnection;


public class UpdateDeleteMovieControl extends AnchorPane
{

	Connection connection;
	
	@FXML
 	private Label isConnected;
	@FXML
	private Button backBT;
	@FXML
	private ListView<String> moviesLV;
	
	private boolean isAdmin;
	
	public void setAdmin(boolean isAdmin)
	{
		this.isAdmin = isAdmin;
	}
	
  	public MovieModel mm = new MovieModel();
  	
  	
  	public void setLabel(String label)
  	{
  		isConnected.setText(label);
  	}
  	

  	@FXML
  	public void initialize()
  	{
  		connection = SqliteConnection.Connector();
  		showMovies();
  	}
 	
 	public void userSetMovies(ArrayList<String> userAL)
 	{
 		moviesLV.setItems(FXCollections.observableArrayList(userAL));
 	}
 	
 	
 	public void showMovies()
 	{
 		ArrayList<String> movies = mm.getMovies();
 		ObservableList<String> m = FXCollections.observableArrayList(movies);
// 		m.addListener(new ListChangeListener<String>(){
// 			
//			@Override
//			public void onChanged(javafx.collections.ListChangeListener.Change<? extends String> list)
//			{
//				System.out.println(list.getList().);
//			}
//			});
// 		m.addListener(new ChangeListener<String>(){
// 			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
// 			{
// 				System.out.println(newValue);
// 			}
// 		}
//
//		);
		moviesLV.setItems(m);
		moviesLV.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
			
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
				System.out.println(newValue);
				try {
		 	  		
		  			Stage primaryStage;
		  			
		  			primaryStage = (Stage)moviesLV.getScene().getWindow();
		  			
		  			FXMLLoader loader = new FXMLLoader();    //check file name here
		  			loader.setLocation(Main.class.getResource("view/AdminGenericMoviePage.fxml"));
		  			AnchorPane rootLayout = (AnchorPane) loader.load();
		  			
		  			AdminGenericMovieControl g = loader.getController();
		  			g.setMovie(newValue);
		  			//g.setAdmin(isAdmin);
		  			
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
		});
 	}
 	@FXML
   	public void loadPrevPage()
   	{
   		try {
   		
   			Stage primaryStage;
   			
   			primaryStage = (Stage)backBT.getScene().getWindow();
   			
   			FXMLLoader loader = new FXMLLoader();    //check file name here
   			loader.setLocation(Main.class.getResource("view/AdminHome.fxml"));
   			AnchorPane rootLayout = (AnchorPane) loader.load();
   			
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
 	
}