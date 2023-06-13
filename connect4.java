import arc.*;

public class connect4{
	public static void main(String[] args){
		Console con = new Console("Connect 4",1280,720);
		int[][] intboard = new int[7][6];
		int intmousex;
		int intmousey;
		int intmouseclick;
		int intcount = 0;
		int intwincount;
		int intwincount1 = 0;
		int intwincount2 = 0;
		int intrecord = 1;
		String strread = "1";
		String strname1= "r";
		String strname2= "e";
		String strresponse = "yes";
		while (1 == 1) {
			con.clear();
			if (intcount == 0) {
			intmousex = con.currentMouseX();
			intmousey = con.currentMouseY();
			intmouseclick = con.currentMouseButton();
			connect4methods.maindraw(con);
			intcount = connect4methods.mainmenu(intmousex,intmousey,intmouseclick);
			}
			if (intcount == 1){
				strname1 = connect4methods.name1(con);
				con.clear();
				connect4methods.namescreen(con);
				strname2 = connect4methods.name2(con);
				intrecord = connect4methods.record(con);
				while (strresponse.equals("yes")){
					connect4methods.pregame(strname1, strname2, con);
					intwincount = connect4methods.maingame(con, intrecord, strname1, strname2);
					if (intwincount == 2){
						intwincount2 = intwincount2 + 1;
					}
					if (intwincount == 1){
						intwincount1 = intwincount1 + 1;
					}
					con.println("Would you like to play again?");
					strresponse = con.readLine();
					if (!strresponse.equals("yes")){
						intcount=0;
					}
				}
				
			}
			
			if (intcount == 2){
				TextInputFile txtrecord = new TextInputFile("recording.txt");
				if (txtrecord.eof() == true) {
					con.println("nothing recorded, going back to mainscreen");
					con.sleep(1000);
					intcount = 0;
				}
				else {
					connect4methods.pregame(strname1, strname2, con);
					connect4methods.watching(con);
					con.println("recording finished");
					con.println("recording finished, returning to main menu");
					con.sleep(500);
					intcount = 0;
				}
				
			}
			
			if (intcount == 3){
				connect4methods.highscoremenu(con);
			}
			if (intcount == 4){
				con.closeConsole();
			}
			
		}
	
	}
}
