package web.flatremainder.common.define;

public enum ArtHeadColor
{
	lightGreen("light-green lighten-3"),
	lightBule("light-blue lighten-3"),
	pink("pink lighten-3"),
	glay("blue-grey");
	
	private String color;
	
	private ArtHeadColor(String color)
	{
		this.color = color;
	}
	
	public String getColor()
	{
		return this.color;
	}
	

}
