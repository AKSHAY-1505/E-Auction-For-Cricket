import java.util.Scanner;

class ConsoleColors {
    public static final String RESET = "\033[0m";
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE
    public static final String LIGHT_PURPLE = "\033[38;2;200;0;200m"; //LIGHT PURPLE
    public static final String TEAL = "\033[38;2;0;225;221m"; //TEAL
    public static final String ORANGE = "\033[38;2;225;153;0m"; //ORANGE
    public static final String LIGHT_GREEN = "\033[38;2;136;255;0m"; //LIGHT GREEN
    public static final String LIGHT_BLUE = "\033[38;2;120;172;255m"; //LIGHT BLUE
    public static final String DARK_BLUE = "\033[38;2;72;0;255m"; //DARK BLUE
    public static final String ROSY_PINK = "\033[38;2;255;0;162m"; //ROSY PINK
    public static final String BROWN = "\033[38;2;135;82;62m"; //BROWN
    public static final String FOREST_GREEN = "\033[38;2;62;135;81m"; //FOREST GREEN
    public static final String BANANA_YELLOW = "\033[38;2;240;238;113m"; //BANANA YELLOW
    public static final String DARK_RED = "\033[38;2;145;40;16m"; //DARK RED
    public static final String LIGHT_PINK = "\033[38;2;255;153;240m"; //LIGHT PINK

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
    public static final String LIGHT_PURPLE_BACKGROUND = "\033[48;2;200;0;200m"; //LIGHT PURPLE
    public static final String TEAL_BACKGROUND = "\033[48;2;0;225;221m"; //TEAL
    public static final String ORANGE_BACKGROUND = "\033[48;2;225;153;0m"; //ORANGE
    public static final String LIGHT_GREEN_BACKGROUND = "\033[48;2;136;255;0m"; //LIGHT GREEN
    public static final String LIGHT_BLUE_BACKGROUND = "\033[48;2;120;172;255m"; //LIGHT BLUE
    public static final String DARK_BLUE_BACKGROUND = "\033[48;2;72;0;255m"; //DARK BLUE
    public static final String ROSY_PINK_BACKGROUND = "\033[48;2;255;0;162m"; //ROSY PINK
    public static final String BROWN_BACKGROUND = "\033[48;2;135;82;62m"; //BROWN
    public static final String FOREST_GREEN_BACKGROUND = "\033[48;2;62;135;81m"; //FOREST GREEN
    public static final String BANANA_YELLOW_BACKGROUND = "\033[48;2;240;238;113m"; //BANANA YELLOW
    public static final String DARK_RED_BACKGROUND = "\033[48;2;145;40;16m"; //DARK RED
    public static final String LIGHT_PINK_BACKGROUND = "\033[48;2;255;153;240m"; //LIGHT PINK
    
}

class team
{
	Scanner in = new Scanner(System.in);
	public String tname;
	public static int tid;
	public int tidorg;
	public int purse;
	public int bakpurse;
	static int t=1;
	public int bidprice;
	public int maxbid;
	public int tpcount;
	public String password;
	
	String[] tlist=new String[11];
	void space()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println(" ");
		}
	}
	
	
	void createteam()
	{
		tidorg=t;
		tid=t;
		t++;
		System.out.print("Enter the name of your team: ");
		tname=in.nextLine();
		System.out.println();
		purse=50;
		bakpurse=50;
		maxbid=0;
		tpcount=0;
		System.out.print("Create A Password For Your Team: ");
		password=in.nextLine();
		System.out.println("\n"+ConsoleColors.BLACK+ConsoleColors.GREEN_BACKGROUND +
"CONGRATULATIONS! TEAM HAS BEEN SUCCESFULLY REGISTERED FOR THE AUCTION" + ConsoleColors.RESET);
		space();
	}
	void display()
	{
		System.out.println("Team No:"+tidorg+" \tTeam Name:"+tname+" \tPurse Value(Crs):"+purse);

	}
}

class player
{
	Scanner in = new Scanner(System.in);
	public String pname;
	public int pid;
	public int bprice;
	public static int pcount=1;
	public int playerteamid;
	public boolean tmstatus;
	void space()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println(" ");
		}
	}
	void createplayer()
	{
		System.out.print("Enter the Player Name: ");
		pname=in.nextLine();
		pid=pcount;
		pcount++;
		System.out.print("Enter the Player Base Price(Crs): ");
		bprice=in.nextInt();
		System.out.println("\n"+ConsoleColors.BLACK+ConsoleColors.GREEN_BACKGROUND +"CONGRATULATIONS! PLAYER HAS BEEN SUCCESFULLY REGISTERED FOR THE AUCTION" + ConsoleColors.RESET);
		space();
		playerteamid=-1;
		tmstatus=false;
	}
	void display()
	{
		System.out.println("Player No:"+pid+" \tPlayer Name:"+pname+" \tBase Price:"+bprice);

	}
}

public class Auction2 
{
	Scanner in = new Scanner(System.in);
	static int pcount=0,tcount=0;
	player[] players=new player[20];
	player[] tmplayers=new player[20];
	team[] teams=new team[10];
	int i,j,ch,bakprice,noflag,yesflag,tmcount=0;
	
	
	void soldfinder(String s,int pid)
	{
		int j,max,maxflag=0;
		max = teams[0].bidprice;
		for(j=1;j<tcount;j++)
		{
			if(teams[j].bidprice>max)
			{
				max=teams[j].bidprice;
				maxflag=j;
			}
				
		}
		System.out.println("\n");
		System.out.println(ConsoleColors.BLACK+ConsoleColors.GREEN_BACKGROUND +
"PLAYER "+s+" SOLD TO "+teams[maxflag].tname+" FOR "+max+" CRS" + ConsoleColors.RESET);
		players[pid-1].playerteamid=maxflag;
		space();
		teams[maxflag].purse=teams[maxflag].purse-max;
		teams[maxflag].tlist[teams[maxflag].tpcount]=s;
		teams[maxflag].tpcount++;
		for(j=0;j<tcount;j++)
		{
			teams[j].bidprice=0;
		}
	}
	
	void endauc()
	{
		System.out.println("\t\t\t\t\t\t\t\t"+ConsoleColors.BLACK+ConsoleColors.BLUE_BACKGROUND +
"AUCTION CONCLUDED"+ ConsoleColors.RESET+"\n\n\n");
		for(int j=0;j<tcount;j++)
		{
			System.out.println("======================================================================");
			System.out.println("\t\t\t"+ConsoleColors.BLACK+ConsoleColors.ROSY_PINK_BACKGROUND +
teams[j].tname+ConsoleColors.RESET+"\t\tRemaining Purse: "+teams[j].purse);
			System.out.println("======================================================================");
			for(int i=0;i<teams[j].tpcount;i++)
			{
				System.out.println("\t\t\t"+teams[j].tlist[i]);
			}
			space();
		}
		space();
		space();
		menu();
	}
	
	void startauc()
	{

		for(int i=0;i<pcount;i++)
		{
			
			noflag=0;
			yesflag=0;
			for(int j=0;j<tcount;j++) 
			{
			
				System.out.println("========================================================================");
				System.out.println(ConsoleColors.BLACK+ConsoleColors.CYAN_BACKGROUND +
"Player No:"+players[i].pid+" \tPlayer Name:"+players[i].pname+" \tPrice:"+players[i].bprice+ ConsoleColors.RESET);
				System.out.println("========================================================================");
				System.out.println(ConsoleColors.BLACK+ConsoleColors.ROSY_PINK_BACKGROUND +
teams[j].tname+ConsoleColors.RESET+" Would you like to bid for "+ConsoleColors.BLACK+ConsoleColors.PURPLE_BACKGROUND +
players[i].pname+ConsoleColors.RESET+"?\t\t\tPURSE VALUE: "+teams[j].purse+"\n1.YES\n2.NO\nEnter Your Choice:");
				ch=in.nextInt();
				if(ch==1)
				{
					if(teams[j].purse>=players[i].bprice)
					{
					bakprice=players[i].bprice;
					players[i].bprice=players[i].bprice+2;
				//	teams[j].bakpurse=teams[j].bakpurse-2;
					System.out.println(ConsoleColors.BLACK+ConsoleColors.YELLOW_BACKGROUND +
teams[j].tname+" HAVE BIDDED FOR "+players[i].pname + ConsoleColors.RESET);
					noflag=0;
					yesflag=1;
					teams[j].bidprice=players[i].bprice;
					}
					else
					{
						noflag++;
						System.out.println("\n\n"+ConsoleColors.BLACK+ConsoleColors.RED_BACKGROUND +
"BID DENIED !    INSUFFICIENT MONEY IN PURSE TO BID" + ConsoleColors.RESET);
					}
					
				}
				else 
				{
					noflag++;
				}
				if(noflag==tcount)
					{
					if(yesflag==0)
				
						{
							System.out.println(ConsoleColors.BLACK+ConsoleColors.RED_BACKGROUND +"PLAYER UNSOLD"+ ConsoleColors.RESET);
						}
					else if(yesflag==1)
						{
							soldfinder(players[i].pname,players[i].pid);
							break;
						}
					}
				else if(j==tcount-1)
					j=-1;
			}
				
			
		}
		
		endauc();
		
	}
	void space()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println(" ");
		}
	}
	
	void listmarket(int i)
	{
		String pname;
		System.out.println("\n\n"+ConsoleColors.BLACK+ConsoleColors.PURPLE_BACKGROUND +
"Players in Your Team:" + ConsoleColors.RESET);
		for(int j=0;j<teams[i].tpcount;j++)
		{
			System.out.println(teams[i].tlist[j]);
		}
		System.out.print("\nEnter The Name Of The Player To Be Listed In the Transfer Market: ");
		pname=in.nextLine();
		for(int k=0;k<pcount;k++)
		{
			if(players[k].pname.equals(pname))
			{
				if(players[k].playerteamid==i)
				{
				tmplayers[tmcount]=players[k];
				tmplayers[tmcount].tmstatus=true;
				tmcount++;
				System.out.println(ConsoleColors.BLACK+ConsoleColors.GREEN_BACKGROUND +
"Player Succesfully Listed In the Transfer Market!" + ConsoleColors.RESET);
				space();
				break;
				}
				else
				{
					System.out.println(ConsoleColors.BLACK+ConsoleColors.RED_BACKGROUND +
"Player Not In Your Team!" + ConsoleColors.RESET);
				}
			}
			else if(k==pcount-1)
				System.out.println(ConsoleColors.BLACK+ConsoleColors.RED_BACKGROUND +
"Player Not In Your Team!" + ConsoleColors.RESET);
		}
	}
	void viewmarket()
	{
		System.out.println("===============================");
		System.out.println(ConsoleColors.BLACK+ConsoleColors.YELLOW_BACKGROUND +
"Players In the Transfer Market" + ConsoleColors.RESET);
		System.out.println("===============================");
		for(int i=0;i<tmcount;i++)
		{
			if(tmplayers[i].tmstatus==true)
				
				System.out.println(tmplayers[i].pname);
				
		}
		space();
	}
	void makedeal(int x)
	{
		String name;
		viewmarket();
		System.out.print("\nEnter The Name Of The Player You Want To buy: ");
		name=in.nextLine();
		for(int i=0;i<tmcount;i++)
		{
			if(tmplayers[i].pname.equals(name))
			{
				players[tmplayers[i].pid-1].playerteamid=x;
				System.out.println(ConsoleColors.BLACK+ConsoleColors.GREEN_BACKGROUND +
"Player Bought by "+teams[x].tname + ConsoleColors.RESET);
				tmplayers[i].tmstatus=false;
				space();
				break;
			}
			else if(i==tmcount-1)
			{
				System.out.println(ConsoleColors.BLACK+ConsoleColors.RED_BACKGROUND +
"Player Not In Transfer Market!" + ConsoleColors.RESET);
			}
		}
	}
	void finalview()
	{
		System.out.println("\t\t\t\t\t\t\t\t"+ConsoleColors.BLACK+ConsoleColors.YELLOW_BACKGROUND +
"TEAMS" + ConsoleColors.RESET);
		for(int i=0;i<tcount;i++)
		{
			System.out.println("\t\t\t\t\t\t==================================");
			System.out.println("\t\t\t\t\t\t\t\t"+teams[i].tname);
			System.out.println("\t\t\t\t\t\t==================================");
			for(int k=0;k<pcount;k++)
			{
				if(players[k].playerteamid==i)
				{
					System.out.println("\t\t\t\t\t\t\t\t"+players[k].pname);
				}
			}
			System.out.println("\n\n");
		}
	}
	String func()
	{
		String passw;
		System.out.println("Enter Your Team Name: ");
		passw=in.nextLine();
		return passw;
	}
	void transfermarket()
	{
		int ch=0,i=0;
		String teamname,passw;
		boolean status=true;
		while(status)
		{
		System.out.println("\t\t\t\t\t\t\t\t"+ConsoleColors.BLACK+ConsoleColors.CYAN_BACKGROUND +"TRANSFER MARKET"+ConsoleColors.RESET+"\n\n\n\n");
		System.out.println("1.List Player In The Transer Market\n");
		System.out.println("2.View The Transfer Market\n");
		System.out.println("3.Make A Deal For A Player In The Market\n");
		System.out.println("4.Main Menu\n");
		System.out.print(ConsoleColors.BLACK+ConsoleColors.ROSY_PINK_BACKGROUND +"Enter Your Choice:" + ConsoleColors.RESET+" ");
		ch = in.nextInt();
		in.nextLine();
		space();
		if(ch==1)
		{
	
			teamname = func();
			for(i=0;i<tcount;i++)
			{
				if(teams[i].tname.equals(teamname))
				{
					System.out.print("Enter Your Team Password: ");
					passw=in.nextLine();
					if(teams[i].password.equals(passw))
					{
						listmarket(i);
						break;
					}
				}
				else System.out.println(" ");
			}
			
		}
		else if(ch==2)
		{
			viewmarket();
			
		}
		else if(ch==3)
		{
			
			System.out.print("Enter Your Team Name: ");
			teamname=in.nextLine();
			for(i=0;i<tcount;i++)
			{
				if(teams[i].tname.equals(teamname))
				{
					System.out.print("Enter Your Team Password: ");
					passw=in.nextLine();
					if(teams[i].password.equals(passw))
					{
						System.out.println("\n\n");
						makedeal(i);
					}
				}		
			}
			
		}
		else if(ch==4)
		{
			status=false;
		}
		}
		}
	void menu()
	{
		int ch,i=0;
		boolean wh=true;
		boolean auc=true;
		while(wh)
		{
		System.out.println(ConsoleColors.BLACK+ConsoleColors.CYAN_BACKGROUND +"MAIN MENU\n\n" + ConsoleColors.RESET);
		System.out.println("1.Register Player\n");
		System.out.println("2.Register Team\n");
		System.out.println("3.View Registered Players\n");
		System.out.println("4.View Registered Teams\n");
		System.out.println("5.Start Auction\n");
		System.out.println("6.Transfer Market\n");
		System.out.println("7.View Teams\n");
		System.out.print(ConsoleColors.BLACK+ConsoleColors.ROSY_PINK_BACKGROUND +"Enter Your Choice:" + ConsoleColors.RESET+" ");
		ch = in.nextInt();
		space();
		if (ch==1)
		{
			players[pcount]=new player();
			players[pcount].createplayer();
			pcount++;
		}
		else if(ch==2)
		{
			teams[tcount]=new team();
			teams[tcount].createteam();
			tcount++;
		}
		else if(ch==3)
		{
			
			for(i=0;i<pcount;i++)
			{
				players[i].display();
			}
			space();
		}
		else if(ch==4)
		{
			for(i=0;i<tcount;i++)
			{
				teams[i].display();
			}
			space();
		
		}
		else if(ch==5)
		{
			while(auc)
			{
				for(i=0;i<4;i++)
					space();
				System.out.println("\t\t\t\t\t\t\t\t"+ConsoleColors.BLACK+ConsoleColors.GREEN_BACKGROUND +
"AUCTION STARTED" + ConsoleColors.RESET);
				System.out.println("\t\t\t\t\t"+ConsoleColors.BLACK+ConsoleColors.GREEN_BACKGROUND +
"   ALL TEAMS HAVE BEEN GIVEN 50Crs TO PURCHASE PLAYERS" + ConsoleColors.RESET);
				
				for(i=0;i<2;i++)
					space();
				startauc();
				auc=false;
				
			}
			wh=false;
		}
		else if(ch==6)
		{
			transfermarket();
		}
		else if(ch==7)
		{
			finalview();
		}
		}
		}
		
	
	public static void main(String[] args) 
	
	{
		Scanner in = new Scanner(System.in);
		Auction2 a=new Auction2();
		
		for(int i=0;i<16;i++)
		{
			System.out.println(" ");
		}
		System.out.print("\t\t\t\t\t\t\t\t");
		System.out.print(ConsoleColors.BLACK+ConsoleColors.YELLOW_BACKGROUND + "WELCOME\n\n" + ConsoleColors.RESET);
		System.out.print("\t\t\t\t\t\t\t\t");
		System.out.print(ConsoleColors.BLACK+ConsoleColors.YELLOW_BACKGROUND +"E-AUCTION FOR CRICKET\n\n\n" + ConsoleColors.RESET);
				
		in.nextLine();	
		a.menu();

	}

}
