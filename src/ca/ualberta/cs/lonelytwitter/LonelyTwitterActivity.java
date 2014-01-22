package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				//Gson gson = new Gson();
				//LonelyTweetModel str = gson.fromJson(json,LonelyTweetModel.class);
				
				
				//Gson gson =  new Gson();
				//String text = bodyText.getText().toString();
				//String text = gson.toJson(bodyText, String.class);
				//gson.toJson(text);
				//saveInFile(text, new Date(System.currentTimeMillis()));
				//finish();
				onStart();
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		String[] tweets = loadFromFile();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private String[] loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			//can only handle byte data
			FileInputStream fis = openFileInput(FILENAME);
			
			Reader reader = new InputStreamReader(fis);
			
			Gson gson = new Gson();
			try{
			
				while (true) {
					
					LonelyTweetModel tweet = gson.fromJson(reader,LonelyTweetModel.class);
					String texti = tweet.getText();
					String datei = tweet.getTimestamp().toString();
					tweets.add(datei+"|"+texti);	
					

			} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return tweets.toArray(new String[tweets.size()]);
	}
	

	
	//file for store the information
	public void saveInFile(LonelyTweetModel tweetf) {
		try {
			//to mode is output and append

			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
			Gson gson =  new Gson();
			String json = gson.toJson(tweetf);
			
			
			fos.write(json.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}