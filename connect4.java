import arc.*;

public class connect4{
	public static void main(String[] args){
		Console con = new Console("Connect 4",1280,720);
		int[][] intboard = new int[7][6];
		int intmousex;
		int intmousey;
		int intmouseclick;
		while (1 == 1) {
			intmousex = con.currentMouseX();
			intmousey = con.currentMouseY();
			intmouseclick = con.currentMouseButton();
			
			connect4methods.mainmenu(intmousex,intmousey,intmouseclick,con);
			
	}
	
	}
}
