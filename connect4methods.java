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
	
	public static String record(Console con){
		BufferedImage imgscene = con.loadImage("namescreen.png");
		String strresponse = "";
		String strrecord = "";
		while (!strresponse.equals("yes")&&!strresponse.equals("no")){
		con.drawImage(imgscene,0,0);
		con.drawString("Would you like to record the game?", 850,250);
		con.drawString("input 'yes' or 'no'", 850, 350);
		strresponse = con.readLine();
		con.clear();
		}
		con.repaint();
		return strresponse;
	}
	
	public static void namescreen(Console con){
		BufferedImage imgscene = con.loadImage("namescreen.png");
		con.drawImage(imgscene,0,0);
		con.repaint();
	}
	public static void pregame (String strname, String strname2, Console con){
		Color clrblue = new Color(0, 0, 255);
		Color clrwhite = new Color(240,240,240);
		Color clrblack = new Color(0,0,0);
		int intcirclex=265;
		int intcount;
		int intcount2;
		int intcircley=105;
		con.setDrawColor(clrwhite);
		con.fillRect(0,0,1280,720);
		con.setDrawColor(clrblue);
		con.fillRect(0,100,1280,719);
		con.setDrawColor(clrwhite);
		for(intcount = 7; intcount>0; intcount--){
			for (intcount2 = 6; intcount2>0;intcount2--){
				con.fillOval(intcirclex,intcircley,95,95);
				intcircley = intcircley + 103;
			}
			intcircley = 105;
			intcirclex = intcirclex+110;
			
		} 
		con.setDrawColor(clrblack);
		con.drawString(strname,0,0);
		con.drawString(strname2, 1150,0);
		con.drawString("1", 305,70);
		con.drawString("2", 415,70);
		con.drawString("3", 525,70);
		con.drawString("4", 635,70);
		con.drawString("5", 745,70);
		con.drawString("6", 855,70);
		con.drawString("7", 965,70);
		con.drawString("Input the Number for Your Token", 450,20);
		con.repaint();
	}
	public static int maingame(Console con){
		BufferedImage imgp1 = con.loadImage("player1.png");
		BufferedImage imgp2 = con.loadImage("player2.png");
		BufferedImage imgnon = con.loadImage("nonturn.png");
		int intplayerinput=0;
		Color clrred = new Color(255, 0, 0);
		Color clryellow = new Color(255, 255, 0);
		int[][] intboard = new int[7][6];
		int intwin = 0;
		int intturn = 1;
		int intswitch = 1;
		int intcheck = 0;
		int intcount;
		int intcount2;
		int intarrayvalue = 1;
		for (intcount = 6; intcount >= 0; intcount--){
			for (intcount2 = 5; intcount2 >=0; intcount2--){
				intboard[intcount][intcount2] = 0;
			}
			
		}
		 
		while (intwin == 0){
			
			intarrayvalue = con.readInt();
			intplayerinput = intarrayvalue - 1;
			for (intcount = 6; intcount >= 0; intcount--){
					if (intboard[intplayerinput][intcheck]> 0){
						intcheck = intcheck + 1;
					}
			}
			con.println(intcheck);
			if (intturn == 1) {
				intboard[intplayerinput][intcheck] = 1;
			}
			if (intturn == 2) {
				intboard[intplayerinput][intcheck] = 2;
			}
			intturn = intturn + intswitch;
			intswitch = intswitch*-1;
		
			if (intboard[intplayerinput][intcheck] == 1){
				con.setDrawColor(clryellow);
				con.fillOval(265 +(intplayerinput*110), 620 - (103*intcheck), 95,95);
			}	
			if (intboard[intplayerinput][intcheck] == 2){
				con.setDrawColor(clrred);
				con.fillOval(265 +intplayerinput*110, 620 - (103*intcheck),95,95);
			}
			/*
			winning code
			if(intcheck < 1) {
				if(intboard[intplayerinput][intcheck] 
			
			
			
			}
			
			
			
			
			*/
			con.println(intcheck);
			intcheck = 0;
			con.repaint();
		}
		return 0;
	}
}
