import arc.*;

public class connect4{
	public static void main(String[] args){
		Console con = new Console("Connect 4",1280,720);
		int[][] intboard = new int[7][6];
		int intmousex;
		int intmousey;
		int intmouseclick;
		int intcount = 0;
		String strname1;
		String strname2;
		connect4methods.pregame(con);
				intmousex = con.readInt();
		while (1 == 1) {
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
				connect4methods.pregame(con);
				intmousex = con.readInt();
			}
			if (intcount == 4){
				con.closeConsole();
			}
			
		}
	
	}
}
