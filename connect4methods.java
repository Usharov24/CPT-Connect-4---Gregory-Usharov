import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font; 

public class connect4methods{

	public static int mainmenu(int intmousex, int intmousey, int intmouseclick){
		int intcount = 0;
		
		//no con.clear statement because no prior text
		
		//makes sure the drawn image is visible
		if (intmousex > 845 && intmousex < 1126 && intmousey <330 && intmousey > 212 && intmouseclick == 1){
			intcount = 1;
		}
		if (intmousex > 860 && intmousex < 1115 && intmousey <445 && intmousey > 363 && intmouseclick == 1){
			intcount = 2;
		}
		if (intmousex > 880 && intmousex < 1100 && intmousey <550 && intmousey > 480 && intmouseclick == 1){
			intcount = 3;
		}
		if (intmousex > 900 && intmousex < 1080 && intmousey <656 && intmousey > 585 && intmouseclick == 1){
			intcount = 4;
		}
	
	return intcount;
	}
	
	public static void maindraw(Console con){
		BufferedImage imgscene = con.loadImage("start.jpg");
		con.drawImage(imgscene,0,0);
		con.repaint();
	}
	public static String name1(Console con){
		BufferedImage imgscene = con.loadImage("namescreen.png");
		String strresponse = "";
		String strname = "";
		while (!strresponse.equals("yes")){
		con.drawImage(imgscene,0,0);
		con.drawString("Enter name for player 1", 850,250);
		strname = con.readLine();
		con.drawString("Are you sure: " + strname +" is the right name?", 780, 300);
		con.drawString("input 'yes' or 'no'", 850, 350);
		strresponse = con.readLine();
		con.clear();
		}
		con.repaint();
		return strname;
	}
	public static String name2(Console con){
		BufferedImage imgscene = con.loadImage("namescreen.png");
		String strresponse = "";
		String strname = "";
		while (!strresponse.equals("yes")){
		con.drawImage(imgscene,0,0);
		con.drawString("Enter name for player 2", 850,250);
		strname = con.readLine();
		con.drawString("Are you sure: " + strname +" is the right name?", 780, 300);
		con.drawString("input 'yes' or 'no'", 850, 350);
		strresponse = con.readLine();
		con.clear();
		}
		con.repaint();
		return strname;
	}
	
	public static void namescreen(Console con){
		BufferedImage imgscene = con.loadImage("namescreen.png");
		con.drawImage(imgscene,0,0);
		con.repaint();
	}
	public static void pregame (Console con){
		Color clrblue = new Color(0, 0, 255);
		Color clrwhite = new Color(240,240,240);
		con.fillRect(0,0,1280,720);
		con.setDrawColor(clrblue);
		con.fillRect(0,100,1280,719);
		con.setDrawColor(clrwhite);
		con.fillOval(265,105,95,95);
		con.fillOval(265,208,95,95);
		con.fillOval(265,311,95,95);
		con.fillOval(265,414,95,95);
		con.fillOval(265,517,95,95);
		con.fillOval(265,620,95,95);
		con.fillOval(375,105,95,95);
		con.fillOval(375,208,95,95);
		con.fillOval(375,311,95,95);
		con.fillOval(375,414,95,95);
		con.fillOval(375,517,95,95);
		con.fillOval(375,620,95,95);
		con.fillOval(485,105,95,95);
		con.fillOval(485,208,95,95);
		con.fillOval(485,311,95,95);
		con.fillOval(485,414,95,95);
		con.fillOval(485,517,95,95);
		con.fillOval(485,620,95,95);
		con.fillOval(595,105,95,95);
		con.fillOval(595,208,95,95);
		con.fillOval(595,311,95,95);
		con.fillOval(595,414,95,95);
		con.fillOval(595,517,95,95);
		con.fillOval(595,620,95,95);
		con.fillOval(705,105,95,95);
		con.fillOval(705,208,95,95);
		con.fillOval(705,311,95,95);
		con.fillOval(705,414,95,95);
		con.fillOval(705,517,95,95);
		con.fillOval(705,620,95,95);
		con.fillOval(815,105,95,95);
		con.fillOval(815,208,95,95);
		con.fillOval(815,311,95,95);
		con.fillOval(815,414,95,95);
		con.fillOval(815,517,95,95);
		con.fillOval(815,620,95,95);
		con.fillOval(925,105,95,95);
		con.fillOval(925,208,95,95);
		con.fillOval(925,311,95,95);
		con.fillOval(925,414,95,95);
		con.fillOval(925,517,95,95);
		con.fillOval(925,620,95,95);
		
		con.repaint();
	}

}
