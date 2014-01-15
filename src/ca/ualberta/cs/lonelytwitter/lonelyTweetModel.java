package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class lonelyTweetModel
{
	protected String text;
	protected Date timestamp;
	protected boolean important;
	//---------------------NOTE----------------------
	//private -only can see it in the current class.
	//.....    current class + package.
	//protected - class + + package.
	//public  -anywhere
	
	
	//right click the .java then click the source then click the setters and getter
	//have return type
	public String getText()
	{
	
		return text;
	}
	
	public abstract void setText(String text);

	
	
	public Date getTimestamp()
	{
	
		return timestamp;
	}
	
	
	
	public void setTimestamp(Date timestamp)
	{
	
		this.timestamp = timestamp;
	}
	
	
	//right click the .java then click the source then click Field
	//can only have one.
	public lonelyTweetModel(String text, Date timestamp)
	{
		//this(); run itself it can use for the recursion
		super();
		this.text = text;
		this.timestamp = timestamp;
	}
	
	
	public lonelyTweetModel(String text)
	{
		super();
		this.text = text;
		this.timestamp = new Date();
	}
	
	public boolean getImportant()
	{
		return important;
	}
	public abstract void setImportant(boolean important)throws Exception;
}
