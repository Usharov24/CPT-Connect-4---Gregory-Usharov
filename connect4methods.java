import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font; 

public class connect4methods{

	public static int mainmenu(int intmousex, int intmousey, int intmouseclick, Console con){
		BufferedImage imgscene = con.loadImage("start.jpg");
		int intcount = 0;
		//renders images
		con.drawImage(imgscene,0,0);con.repaint();
		
		//no con.clear statement because no prior text
		con.clear();
		con.println(intmousex);
		con.println(intmousey);
		con.println(intmouseclick);
		con.repaint();
		//makes sure the drawn image is visible
		if (intmousex > 845 && intmousex < 1126 && intmousey <330 && intmousey > 212 && intmouseclick == 1){
			intcount = 1;
		}
		if (intmousex > 860 && intmousex < 1115 && intmousey <363 && intmousey > 445 && intmouseclick == 1){
			intcount = 2;
		}
		if (intmousex > 880 && intmousex < 1100 && intmousey <480 && intmousey > 550 && intmouseclick == 1){
			intcount = 3;
		}
		if (intmousex > 900 && intmousex < 1080 && intmousey <585 && intmousey > 656 && intmouseclick == 1){
			intcount = 4;
		}
	
	return intcount;
	}



}
