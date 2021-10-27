import java.util.Scanner;
 
public class PlayerExecuter {
	public static void main(String[] args) {
		char key='q';
		pri
		while(key!='q') {
			System.out.println()
		}
		
		//get number of players
		Scanner input  = new Scanner(System.in);
		System.out.print("Enter number of players :");
		int numberOfPlayers = input.nextInt();
 
 
		//create player array
		Player[] playerArray;
		playerArray  = createPlayerArray(numberOfPlayers);
 
		//add elements into playerArray
		addElements(playerArray,input);
 
		//update an element
		System.out.println("Update Module");
		System.out.println("Enter the player name");   //assuming no two players have same name
		String playerName  = input.nextLine();
		Player player = getPlayerByName(playerArray,playerName);
		System.out.print("Select what to update: 1.name 2.run 3.age 4.country");
		switch(input.nextInt()) {
		case 1:System.out.print("Enter new name");
				playerName = input.nextLine();
				player.setPlayerName(playerName);
				break;	
		case 2:System.out.print("Enter runs to add");
		int newRuns = input.nextInt();
		player.IncrementRun(newRuns);
		break;	
		case 3:System.out.print("Enter new age");
		int newAge = input.nextInt();
		player.setPlayerAge(newAge);
		break;
		case 4:System.out.print("Enter new country");
		String newCountry = input.nextLine();
		player.setPlayerCountry(newCountry);
		break;
		
		default:
			break;
		}
		System.out.println("Enter runs to filter players:");
		int runs = input.nextInt();
		System.out.println("");
		System.out.println("Players information scored more than "+runs);
		printHighScoringPlayers(playerArray,runs);
 
		}
 
	public static Player[] createPlayerArray(int numberOfPlayers) {
	Player[] playerArray	= new Player[numberOfPlayers];
		for(int i = 0; i< numberOfPlayers ; i++) {
			playerArray[i] = new Player();
		}
		return playerArray;
	}
 
	public static void addElements(Player[] playerArray, Scanner input) {
		for(Player playerInstance : playerArray) {
			System.out.print("Enter Name Of Player : ");
			playerInstance.setPlayerName(input.nextLine());
 
			System.out.print("plays for: ");
			playerInstance.setPlayerCountry(input.nextLine());
 
			System.out.print("total runs scored: ");
			playerInstance.setPlayerTotalRun(input.nextInt());
 
			System.out.print("Age : ");
			playerInstance.setPlayerAge(input.nextInt());
 
		}
	}
	public static Player getPlayerByName(Player[] playerArray, String playerName) {
		for (Player player : playerArray) {
			if(player.getName().equals(playerName)) {
				return player;
			}
		}
		return null;
	}
 
 
		static void printHighScoringPlayers(Player[] player, int runs) {
			for(Player p : player) {
				if(Player.getTotalRun(p)> runs) {
					Player.printPlayer(p);
				}
			}
		}
 
 
 
 
	}
 
class Player{
	private String name;
	private String country;
	private int totalRun;
	private int age;
 
	void setPlayerName(String name) {
		this.name=name;
	}
	void setPlayerCountry(String country){
		this.country = country;
	}
	void setPlayerTotalRun(int totalRun) {
		this.totalRun = totalRun;
	}
	void setPlayerAge(int age) {
		this.age = age;
	}
	Player(){
		this.name = getPlayerInfo("name");
		this.country  =  getPlayerInfo("country");
		this.totalRun = Integer.parseInt(getPlayerInfo("totalRun"));
		this.age = Integer.parseInt(getPlayerInfo("age"));
		System.out.println("");
	}
 
 
	private String getPlayerInfo(String variableName) {
		Scanner input  = new Scanner(System.in);
		System.out.print("Enter "+variableName+" :");
		variableName = input.nextLine();
		return variableName;
	}
	static void printPlayer(Player p) {
		System.out.println("");
		System.out.println("Player Name :"+p.name);
		System.out.println("Player country :"+p.country);
		System.out.println("Player total run :"+p.totalRun);
		System.out.println("Player age :"+p.age);
	}
	static int getTotalRun(Player p) {
		return p.totalRun;
	}
	String getName() {
		return this.name;
	}
	void IncrementRun(int newRuns) {
		this.totalRun+=newRuns;
	}
}
