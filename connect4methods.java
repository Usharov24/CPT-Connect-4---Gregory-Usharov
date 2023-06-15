import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font; 

public class connect4methods{

	public static int mainmenu(int intmousex, int intmousey, int intmouseclick){
		int intcount = 0;
		if (intmousex > 845 && intmousex < 1126 && intmousey <330 && intmousey > 212 && intmouseclick == 1){
			intcount = 1;
		}
		//if the cursor is pressed in the box made via the x and y coordintes, intcount is changed to 1 
		if (intmousex > 860 && intmousex < 1115 && intmousey <445 && intmousey > 363 && intmouseclick == 1){
			intcount = 2;
		}
		//if the cursor is pressed in the box made via the x and y coordintes, intcount is changed to 2
		if (intmousex > 880 && intmousex < 1100 && intmousey <550 && intmousey > 480 && intmouseclick == 1){
			intcount = 3;
		}
		//if the cursor is pressed in the box made via the x and y coordintes, intcount is changed to 3
		if (intmousex > 900 && intmousex < 1080 && intmousey <656 && intmousey > 585 && intmouseclick == 1){
			intcount = 4;
		}
		//if the cursor is pressed in the box made via the x and y coordintes, intcount is changed to 4
	return intcount;
	//returns intcount to use in the main game
	}
	
	public static void maindraw(Console con){
		BufferedImage imgscene = con.loadImage("start.jpg");
		con.drawImage(imgscene,0,0);
		con.repaint();
		//draws the mainscreen
	}
	public static String name1(Console con){
		Color clrblack = new Color(0,0,0);
		//sets draw text font to black
		con.setDrawColor(clrblack);
		BufferedImage imgscene = con.loadImage("namescreen.png");
		String strresponse = "";
		int intcount = 0;
		String strname = "";
		while (!strresponse.equals("yes")){
			con.drawImage(imgscene,0,0);
			con.drawString("Enter name for player 1", 850,250);
			strname = con.readLine();
			con.drawString("Are you sure: " + strname +" is the right name?", 780, 300);
			con.drawString("input 'yes' or 'no'", 850, 350);
			//if the name inputted isn't right and yes is not inputted, it loops
			strresponse = con.readLine();
			con.clear();
		}
		con.repaint();
		return strname;
	}
	public static String name2(Console con){
		BufferedImage imgscene = con.loadImage("namescreen.png");
		String strresponse = "";
		String strkey = "";
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
	//this method is the same as the method above for player 2 instead
	public static int record(Console con){
		BufferedImage imgscene = con.loadImage("namescreen.png");
		String strresponse = "";
		int intanswer = 0;
		String strrecord = "";
		while (!strresponse.equals("yes")&&!strresponse.equals("no")){
		con.drawImage(imgscene,0,0);
		con.drawString("Would you like to record the game?", 850,250);
		con.drawString("input 'yes' or 'no'", 850, 350);
		strresponse = con.readLine();
		con.clear();
		}
		con.repaint();
		if (strresponse.equals("yes")){
			intanswer = 1;
		}
		return intanswer;
	}
	public static void pregame (String strname, String strname2, Console con){
		Color clrblue = new Color(0, 0, 255);
		Color clrwhite = new Color(240,240,240);
		Color clrblack = new Color(0,0,0);
		//colors used for drawing the board
		int intcirclex=265;
		int intcount;
		int intcount2;
		int intcircley=105;
		con.setDrawColor(clrwhite);
		con.fillRect(0,0,1280,720);
		con.setDrawColor(clrblue);
		con.fillRect(0,100,1280,719);
		con.setDrawColor(clrwhite);
		//draws the background and the blue rectange for the board
		for(intcount = 7; intcount>0; intcount--){
			for (intcount2 = 6; intcount2>0;intcount2--){
				con.fillOval(intcirclex,intcircley,95,95);
				intcircley = intcircley + 103;
			}
			intcircley = 105;
			intcirclex = intcirclex+110;
			
		} 
		//draws holes in the board for the tokens
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
		//draws all the numbers and details required to play
		con.repaint();
	}
	public static int maingame(Console con, int intrecord, String strname1, String strname2){
		BufferedImage imgp1 = con.loadImage("player1.png");
		BufferedImage imgp2 = con.loadImage("player2.png");
		BufferedImage imgnon = con.loadImage("nonturn.png");
		//images used to help players know whose turn it is
		
		TextOutputFile txtrecord = new TextOutputFile("recording.txt");
		//opens up a recording document
		int intplayerinput=0;
		Color clrred = new Color(255, 0, 0);
		Color clryellow = new Color(255, 255, 0);
		int[][] intboard = new int[7][6];
		int intwin = 0;
		int intturn = 1;
		int intswitch = 1;
		int intcheck = 0;
		//variables used for turns
		int intcount;
		int intcount2;
		int intcount3;
		int intcount4;
		//variables used to check connect 4's
		int intcountcheck = 0;
		int intcountwin = 0;
		int intarrayvalue = 1;
		//variables used for gameplay
		txtrecord.println(strname1);
		txtrecord.println(strname2);
		for (intcount = 6; intcount >= 0; intcount--){
			for (intcount2 = 5; intcount2 >=0; intcount2--){
				intboard[intcount][intcount2] = 0;
			}
			
		}
		 
		while (intwin == 0){
			con.println("input where you would like to place the peice");
			intarrayvalue = con.getKey();
			//the key is inputted and assigned to the integer intarrayvalue
		
			
			while (intarrayvalue < 49 || intarrayvalue > 55){
				con.clear();
				con.println("Please input a proper value");
				intarrayvalue = con.getKey();
				//if the value inputted is out of 1-7, reinput is demanded
			}
			intplayerinput = intarrayvalue - 49;
			
			for (intcount = 6; intcount >= 0; intcount--){
				if (intcheck == 6){
					con.clear();
					con.println("slot is full, input another");
					intarrayvalue = con.getKey();
					intplayerinput = intarrayvalue-49;
					intcount = 6;
					intcheck = 0;
					//if the column is full, tells the user
						while (intarrayvalue < 49 || intarrayvalue > 55){
							con.clear();
							con.println("Please input a proper value");
							con.println(intarrayvalue);
							intarrayvalue = con.getKey();
							intplayerinput = intarrayvalue-49;
							//if the value inputted is out of the range 1-7, a reinput is demanded
						}
				}
				if (intboard[intplayerinput][intcheck]> 0){
					intcheck = intcheck + 1;
					//if the slot is full, move up one and see if that slot is full
				}
			}
			
			if (intturn == 1) {
				intboard[intplayerinput][intcheck] = 1;
				//if it's player 1's turn, give the array value 1
			}
			if (intturn == 2) {
				//if it's player 2's turn, give the array value 2
				intboard[intplayerinput][intcheck] = 2;
			}
		
			if (intboard[intplayerinput][intcheck] == 1){
				con.setDrawColor(clryellow);
				con.fillOval(265 +(intplayerinput*110), 620 - (103*intcheck), 95,95);
				//if player 1 is placing, draw a yellow circle where the token should be
			}	
			if (intboard[intplayerinput][intcheck] == 2){
				con.setDrawColor(clrred);
				con.fillOval(265 +intplayerinput*110, 620 - (103*intcheck),95,95);
				//if player 2 is placing, draw a red circle where the token should be
			}
			
			for (intcount3 = 2; intcount3 > 0; intcount3--){
				
				//determines which player has the 4 in a row
				for (intcount2 = 6; intcount2 >= 0; intcount2--){
					//moves from column 1 to 7 trying to find a vertical 4 in a row
					for (intcountcheck = 0; intcountcheck <= 2; intcountcheck++){
						//moves the 4 block radius down and scans
						intcountwin = 0;
						// intcountwin is the variable used to show whether a player won or not
						for (intcount = 5-intcountcheck; intcount >= 2-intcountcheck; intcount--){
							if (intboard[intcount2][intcount] == intcount3){
								intcountwin = intcountwin + 1;
							}
							if (intcountwin == 4 && intcount3 == intturn){
								intwin = intcount3;
							}
						}
						
					}
				}
			}
			//checks for a vertical 4 in a row
			for (intcount3 = 2; intcount3 > 0; intcount3--){
				
				//determines which player has the 4 in a row
				for (intcount2 = 5; intcount2 >= 0; intcount2--){
					//moves from column to column
					for (intcountcheck = 0; intcountcheck <= 3; intcountcheck++){
						//moves the 4 block radius down and scans
						intcountwin = 0;
						// intcountwin is the variable used to show whether a player won or not
						for (intcount = 6-intcountcheck; intcount >= 3-intcountcheck; intcount--){
							if (intboard[intcount][intcount2] == intcount3){
								intcountwin = intcountwin + 1;
							}
							if (intcountwin == 4 && intcount3 == intturn){
								intwin = intcount3;
							}
						}
						
					}
				}
			}
			//checks for a horizontal 4 in a row
			for (intcount3 = 2; intcount3 > 0; intcount3--){
				
				//determines which player has the 4 in a row
				for (intcount2 = 3; intcount2 >= 0; intcount2--){
					for (intcountcheck = 0; intcountcheck <= 2; intcountcheck++){
						//moves the 4 block radius down and scans
						intcountwin = 0;
						// intcountwin is the variable used to show whether a player won or not
						for (intcount = 0; intcount <= 2; intcount++){
							for (intcount4 = 0; intcount4 <4; intcount4++){
								if (intboard[intcount2+intcount4][intcount+intcount4] == intcount3){
									intcountwin = intcountwin + 1;
									//if a match between turn and chip value has been detected, intcountwin increases by 1 
								}
								if (intcountwin == 4 && intcount3 == intturn){
									intwin = intcount3;
								}
								//if a 4 in a row has been detected, the intwin variable is changed and makes sure the game stops
							}
						intcountwin =0;
						}
						
					}
				}
			}
			//checks all parts of the array for a diagonal that goes 4 down to up
			for (intcount3 = 2; intcount3 > 0; intcount3--){
				
				//determines which player has the 4 in a row
				for (intcount2 = 3; intcount2 >= 0; intcount2--){
					for (intcountcheck = 0; intcountcheck <= 2; intcountcheck++){
						//moves the 4 block radius down and scans
						intcountwin = 0;
						// intcountwin is the variable used to show whether a player won or not
						for (intcount = 5; intcount >= 3; intcount--){
							for (intcount4 = 0; intcount4 <4; intcount4++){
								if (intboard[intcount2+intcount4][intcount-intcount4] == intcount3){
									intcountwin = intcountwin + 1;
								}
								if (intcountwin == 4 && intcount3 == intturn){
									intwin = intcount3;
								}
							}
						intcountwin =0;
						}
						
					}
				}
			}	
			//checks all parts of the array for a diagonal that goes 4 up to down
			txtrecord.println(intplayerinput + 1);
			intturn = intturn + intswitch;
			intswitch = intswitch*-1;
			intcheck = 0;
			con.repaint();
			con.clear();
		}
		con.println("Player " + intwin + " won");
		//prints which player won
		txtrecord.close();
		return intwin;
	}
	public static int maingamenorecord(Console con, String strname1, String strname2){
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
		int intcount3;
		int intcount4;
		int intcountcheck = 0;
		int intcountwin = 0;
		int intarrayvalue = 1;
		
		for (intcount = 6; intcount >= 0; intcount--){
			for (intcount2 = 5; intcount2 >=0; intcount2--){
				intboard[intcount][intcount2] = 0;
			}
			
		}
		 
		while (intwin == 0){
			con.println("input where you would like to place the peice");
			intarrayvalue = con.getKey();
		
			
			while (intarrayvalue < 49 || intarrayvalue > 55){
				con.clear();
				con.println("Please input a proper value");
				intarrayvalue = con.getKey();
			}
			intplayerinput = intarrayvalue - 49;
			
			for (intcount = 6; intcount >= 0; intcount--){
				if (intcheck == 6){
					con.clear();
					con.println("slot is full, input another");
					intarrayvalue = con.getKey();
					intplayerinput = intarrayvalue-49;
					intcount = 6;
					intcheck = 0;
						while (intarrayvalue < 49 || intarrayvalue > 55){
							con.clear();
							con.println("Please input a proper value");

							con.println(intarrayvalue);
							intarrayvalue = con.getKey();
							intplayerinput = intarrayvalue-49;
						}
				}
				if (intboard[intplayerinput][intcheck]> 0){
					intcheck = intcheck + 1;
						
				}
			}
			
			if (intturn == 1) {
				intboard[intplayerinput][intcheck] = 1;
			}
			if (intturn == 2) {
				intboard[intplayerinput][intcheck] = 2;
			}
		
			if (intboard[intplayerinput][intcheck] == 1){
				con.setDrawColor(clryellow);
				con.fillOval(265 +(intplayerinput*110), 620 - (103*intcheck), 95,95);
			}	
			if (intboard[intplayerinput][intcheck] == 2){
				con.setDrawColor(clrred);
				con.fillOval(265 +intplayerinput*110, 620 - (103*intcheck),95,95);
			}
			
			for (intcount3 = 2; intcount3 > 0; intcount3--){
				for (intcount2 = 6; intcount2 >= 0; intcount2--){
					for (intcountcheck = 0; intcountcheck <= 2; intcountcheck++){
						intcountwin = 0;
						for (intcount = 5-intcountcheck; intcount >= 2-intcountcheck; intcount--){
							if (intboard[intcount2][intcount] == intcount3){
								intcountwin = intcountwin + 1;
							}
							if (intcountwin == 4 && intcount3 == intturn){
								intwin = intcount3;
							}
						}
						
					}
				}
			}
			
			for (intcount3 = 2; intcount3 > 0; intcount3--){
				
				for (intcount2 = 5; intcount2 >= 0; intcount2--){
					for (intcountcheck = 0; intcountcheck <= 3; intcountcheck++){
						intcountwin = 0;
						for (intcount = 6-intcountcheck; intcount >= 3-intcountcheck; intcount--){
							if (intboard[intcount][intcount2] == intcount3){
								intcountwin = intcountwin + 1;
							}
							if (intcountwin == 4 && intcount3 == intturn){
								intwin = intcount3;
							}
						}
						
					}
				}
			}
			for (intcount3 = 2; intcount3 > 0; intcount3--){
				
				for (intcount2 = 3; intcount2 >= 0; intcount2--){
					for (intcountcheck = 0; intcountcheck <= 2; intcountcheck++){
						intcountwin = 0;
						for (intcount = 0; intcount <= 2; intcount++){
							for (intcount4 = 0; intcount4 <4; intcount4++){
								if (intboard[intcount2+intcount4][intcount+intcount4] == intcount3){
									intcountwin = intcountwin + 1;
								}
								if (intcountwin == 4 && intcount3 == intturn){
									intwin = intcount3;
								}
							}
						intcountwin =0;
						}
						
					}
				}
			}
			for (intcount3 = 2; intcount3 > 0; intcount3--){
				
				for (intcount2 = 3; intcount2 >= 0; intcount2--){
					for (intcountcheck = 0; intcountcheck <= 2; intcountcheck++){
						intcountwin = 0;
						for (intcount = 5; intcount >= 3; intcount--){
							for (intcount4 = 0; intcount4 <4; intcount4++){
								if (intboard[intcount2+intcount4][intcount-intcount4] == intcount3){
									intcountwin = intcountwin + 1;
								}
								if (intcountwin == 4 && intcount3 == intturn){
									intwin = intcount3;
								}
							}
						intcountwin =0;
						}
						
					}
				}
			}	
			intturn = intturn + intswitch;
			intswitch = intswitch*-1;
			intcheck = 0;
			con.repaint();
			con.clear();
	}
	con.println("Player " + intwin + " won");
	
		return intwin;
	}
	//this method is just like the maingame just with no recording features
	public static int watching(Console con){
		TextInputFile txtrecord = new TextInputFile("recording.txt");
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
		int intcount3;
		int intgameloop = 0;
		int intcount4;
		int intcountcheck = 0;
		int intcountwin = 0;
		String struseless;
		int intarrayvalue = 1;
		struseless = txtrecord.readLine();
		struseless = txtrecord.readLine();
		for (intcount = 6; intcount >= 0; intcount--){
			for (intcount2 = 5; intcount2 >=0; intcount2--){
				intboard[intcount][intcount2] = 0;
			}
			
		}
		
		 
		while (intwin == 0){
			
			intarrayvalue = txtrecord.readInt();
			
			intplayerinput = intarrayvalue - 1;
			
			while (intboard[intplayerinput][intcheck]> 0){
					intcheck = intcheck + 1;
						
				}
			
			if (intturn == 1) {
				intboard[intplayerinput][intcheck] = 1;
			}
			if (intturn == 2) {
				intboard[intplayerinput][intcheck] = 2;
			}
		
			if (intboard[intplayerinput][intcheck] == 1){
				con.setDrawColor(clryellow);
				con.fillOval(265 +(intplayerinput*110), 620 - (103*intcheck), 95,95);
			}	
			if (intboard[intplayerinput][intcheck] == 2){
				con.setDrawColor(clrred);
				con.fillOval(265 +intplayerinput*110, 620 - (103*intcheck),95,95);
			}
			
			for (intcount3 = 2; intcount3 > 0; intcount3--){
				
				//determines which player has the 4 in a row
				for (intcount2 = 6; intcount2 >= 0; intcount2--){
					//moves from column 1 to 7 trying to find a vertical 4 in a row
					for (intcountcheck = 0; intcountcheck <= 2; intcountcheck++){
						//moves the 4 block radius down and scans
						intcountwin = 0;
						// intcountwin is the variable used to show whether a player won or not
						for (intcount = 5-intcountcheck; intcount >= 2-intcountcheck; intcount--){
							if (intboard[intcount2][intcount] == intcount3){
								intcountwin = intcountwin + 1;
							}
							if (intcountwin == 4 && intcount3 == intturn){
								intwin = intcount3;
							}
						}
						
					}
				}
			}
			
			for (intcount3 = 2; intcount3 > 0; intcount3--){
				
				//determines which player has the 4 in a row
				for (intcount2 = 5; intcount2 >= 0; intcount2--){
					//moves from column 1 to 7 trying to find a vertical 4 in a row
					for (intcountcheck = 0; intcountcheck <= 3; intcountcheck++){
						//moves the 4 block radius down and scans
						intcountwin = 0;
						// intcountwin is the variable used to show whether a player won or not
						for (intcount = 6-intcountcheck; intcount >= 3-intcountcheck; intcount--){
							if (intboard[intcount][intcount2] == intcount3){
								intcountwin = intcountwin + 1;
							}
							if (intcountwin == 4 && intcount3 == intturn){
								intwin = intcount3;
							}
						}
						
					}
				}
			}
			for (intcount3 = 2; intcount3 > 0; intcount3--){
				
				//determines which player has the 4 in a row
				for (intcount2 = 3; intcount2 >= 0; intcount2--){
					//moves from column 1 to 7 trying to find a vertical 4 in a row
					for (intcountcheck = 0; intcountcheck <= 2; intcountcheck++){
						//moves the 4 block radius down and scans
						intcountwin = 0;
						// intcountwin is the variable used to show whether a player won or not
						for (intcount = 0; intcount <= 2; intcount++){
							for (intcount4 = 0; intcount4 <4; intcount4++){
								if (intboard[intcount2+intcount4][intcount+intcount4] == intcount3){
									intcountwin = intcountwin + 1;
								}
								if (intcountwin == 4 && intcount3 == intturn){
									intwin = intcount3;
								}
							}
						intcountwin =0;
						}
						
					}
				}
			}
			for (intcount3 = 2; intcount3 > 0; intcount3--){
				
				//determines which player has the 4 in a row
				for (intcount2 = 3; intcount2 >= 0; intcount2--){
					//moves from column 1 to 7 trying to find a vertical 4 in a row
					for (intcountcheck = 0; intcountcheck <= 2; intcountcheck++){
						//moves the 4 block radius down and scans
						intcountwin = 0;
						// intcountwin is the variable used to show whether a player won or not
						for (intcount = 5; intcount >= 3; intcount--){
							for (intcount4 = 0; intcount4 <4; intcount4++){
								if (intboard[intcount2+intcount4][intcount-intcount4] == intcount3){
									intcountwin = intcountwin + 1;
								}
								if (intcountwin == 4 && intcount3 == intturn){
									intwin = intcount3;
								}
							}
						intcountwin =0;
						}
						
					}
				}
			}
			
			
			
			intturn = intturn + intswitch;
			intswitch = intswitch*-1;
			intgameloop = intgameloop + 1;
			intcheck = 0;
			con.repaint();
			con.clear();
			con.sleep(500);
	}
	con.println("Player " + intwin + " won");
	txtrecord.close();
		return 0;
	}
	public static void highscoremenu(Console con){
		TextInputFile txtscore = new TextInputFile("highscores.txt");
		int intcount;
		con.println("");
		con.println("");
		con.println("");
		con.println("");
		con.println("");
		con.println("");
		con.println("");
		con.println("");
		con.println("");
		con.println("");
		con.println("");
		con.println("");
		//makes it so everything printed is in the centre of the screen.
		for (intcount = 0; intcount <= 4; intcount++){
			con.println("                                                    " + txtscore.readLine());
			con.println("                                                    " + txtscore.readLine());
			//prints both the name and the score in the centre
			//reads off the text document for information
		}
		BufferedImage imgscene = con.loadImage("highscores.png");
		
		con.drawImage(imgscene,0,0);
		//loads and draws the image
		con.repaint();
		
		
	}
	public static void highscoreinput(Console con, int intscore, int intscore2, String strname, String strname2){
		
		String[] strnamearray = new String[5];
		//array for names
		int intcount = 0;
		int intsub;
		int intcurrent;
		String strsub;
		//String for subbing out names
		int[] intlist = new int[5];
		//array for scores
		TextInputFile txtscore = new TextInputFile("highscores.txt");
		//opens up the highscore file for reading
		intcurrent = intscore;
		while (txtscore.eof() == false){
			strnamearray[intcount] = txtscore.readLine();
			intlist[intcount] = txtscore.readInt();
			intcount = intcount + 1;
		}
		//reads all the values of the highscore file and adds them to the name array and score array
		txtscore.close();
		//closes txtscore for use later on
		TextOutputFile txtscore2 = new TextOutputFile("highscores.txt");
		//opens txtscore for writing
		intcount = 0;
		//sets intcount to 0 for later use
		while (intcount < 5) {
			if (intlist[intcount] < intcurrent){
				//if the item on the array is lower than the item inputted the array name and value is saved and compared to the value beneath it
				strsub = strnamearray[intcount];
				strnamearray[intcount] = strname;
				
				intsub = intlist[intcount];
				intlist[intcount] = intcurrent;
				intcurrent = intsub;
				strname = strsub;
				//intcurrent replaced from input to the last used term to check if the next term is lower
			}
			intcount++;
			//intcount goes up and is used to check all items of the array
		}
		intcount = 0;
		//sets intcount to 0 again for writing
		intcurrent = intscore2;
		strname = strname2;
		//sets input values to the 2nd players inputs to double check their stats as well
		while (intcount < 5) {
			if (intlist[intcount] < intcurrent){
				strsub = strnamearray[intcount];
				strnamearray[intcount] = strname;
				
				intsub = intlist[intcount];
				intlist[intcount] = intcurrent;
				intcurrent = intsub;
				strname = strsub;
				//repeats the same as above
			}
			intcount++;
			
		}
		for(intcount = 0; intcount <=4; intcount++){
			txtscore2.println(strnamearray[intcount]);
			txtscore2.println(intlist[intcount]);
			//prints all the items of the array to the new highscore document
		}
		
	}
}
