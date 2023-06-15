import arc.*;
//Gregory Usharov
//Connect 4 Game 
//V 1.5

public class connect4{
	public static void main(String[] args){
		Console con = new Console("Connect 4",1280,720);
		int[][] intboard = new int[7][6];
		int intmousex;
		int intmousey;
		int intmouseclick;
		int intcount = 0;
		int intwincount = 0;
		int intwincount1 = 0;
		int intwincount2 = 0;
		int intrecord = 1;
		String strread = "1";
		String strname1= "r";
		String strname2= "e";
		String strresponse = "yes";
		//defines variables for initialization errors
		int intest = 0;
		while (1 == 1) {
			con.clear();
			if (intcount == 0) {
				intwincount = 0;
				intwincount1 = 0;
				intwincount2 = 0;
				intmousex = con.currentMouseX();
				intmousey = con.currentMouseY();
				intmouseclick = con.currentMouseButton();
				connect4methods.maindraw(con);
				intcount = connect4methods.mainmenu(intmousex,intmousey,intmouseclick);
				//uses the start screen method to start
				
			}
			if (intcount == 1){
				strname1 = connect4methods.name1(con);
				con.clear();
				strname2 = connect4methods.name2(con);
				intrecord = connect4methods.record(con);
				//records the names and asks the user if they would like to record the game
				while (strresponse.equals("yes")){
					connect4methods.pregame(strname1, strname2, con);
					if (intrecord == 1){
						intwincount = connect4methods.maingame(con, strname1, strname2, intwincount1, intwincount2);
					}
					if (intrecord == 0){
						intwincount = connect4methods.maingamenorecord(con, strname1, strname2, intwincount1, intwincount2);
					}
					//if the user decided not to record, use the maingame without any recording functions
					if (intwincount == 2){
						intwincount2 = intwincount2 + 1;
					}
					if (intwincount == 1){
						intwincount1 = intwincount1 + 1;
					}
					//if player 1 won, add 1 to their score counter, if player 2 won, add 1 to their score count
					strresponse = con.readLine();
					if (!strresponse.equals("yes")){
						//if the user fails to input yes, their sent to the main menu
						intcount=0;
					}
				}
				connect4methods.highscoresort(con);
				connect4methods.highscoreinput(con, intwincount1, intwincount2, strname1, strname2);
				//inputs score into highscore method
				strresponse = "yes";
			}
			
			if (intcount == 2){
				TextInputFile txtrecord = new TextInputFile("recording.txt");
				if (txtrecord.eof() == true) {
					con.println("nothing recorded, going back to mainscreen");
					con.sleep(1000);
					intcount = 0;
					//if nothing is detected in the recording doc, do the above
				}
				else {
					
					connect4methods.pregame(strname1, strname2, con);
					connect4methods.watching(con);
					//prints the recording and then returns to main menu
					con.sleep(3000);
					intcount = 0;
				}
				
			}
			
			if (intcount == 3){
				connect4methods.highscoresort(con);
				connect4methods.highscoremenu(con);
				//highscore method prints highscore to screen and then goes back to main menu
				con.sleep(5000);
				intcount = 0;
			}
			if (intcount == 4){
				con.closeConsole();
				//closes the game
			}
			
		}
	
	}
}
