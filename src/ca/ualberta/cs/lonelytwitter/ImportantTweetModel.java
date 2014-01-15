package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


public class ImportantTweetModel extends LonelyTweetModel
{

	public ImportantTweetModel(String text, Date timestamp)
	{

		super(text, timestamp);
		// TODO Auto-generated constructor stub
	}

	public ImportantTweetModel(String text)
	{

		super(text);
		// TODO Auto-generated constructor stub
	}
	public void setText(String text)
	{
		this.text = text;
	}

	
	@Override
	public void setTimestamp(Date timestamp)
	{

		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setImportant(boolean important) throws Exception
	{
		if (!important)
		{
			throw new IllegalArgumentException();
		}
		this.important = important;
	}

}
