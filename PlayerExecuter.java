import java.util.Scanner;

public class PlayerExecuter {
	public static void main(String[] args) {
		int key = -1;
		Player[] playerArray = null;
		int numberOfPlayers = 0;
		printMenu();
		Scanner input = new Scanner(System.in);
		while (key != 0) {
			key = input.nextInt();
			switch (key) {
			case 0:
				System.exit(0);
			case 1: // create objects
				System.out.print("Enter number of players :");
				numberOfPlayers = input.nextInt();
				playerArray = createPlayerArray(numberOfPlayers);
				System.out.println(numberOfPlayers+" players created.");
				System.out.println("");
				printMenu();
				break;
			case 2:
				//1. this case doesnt work for arrayObjects.length = 1
				//2. not working for any object.
				System.out.println("Enter name of player to delete");
				String playerName = input.next();
				Player player = getPlayerByName(playerArray, playerName);
				int index = 0;
				Player[] newArray = new Player[numberOfPlayers];
				for (int i = 0; i < numberOfPlayers; i++) {
				 if(playerArray[i].hashCode()==player.hashCode() ) {
					continue;
				 }
				 newArray[index] = playerArray[i];
				 index+=1;
				}
				playerArray  = newArray;
				numberOfPlayers -= 1;
				if (numberOfPlayers == 0) {
					System.out.println("Array! Number of Objects cannot be zero.");
					break;
				}
				printMenu();
				break;
			case 3:
				// add player information
				addElements(playerArray, input);
				printMenu();
				break;
			case 4:
				System.out.println("");
				System.out.println("==Update Module==");
				System.out.print("Enter the player name : "); // assuming no two players have same name
				playerName = input.next();
				player = getPlayerByName(playerArray, playerName);
				System.out.print("Select what to update: 1.name 2.run 3.age 4.country");
				switch (input.nextInt()) {
				case 1:
					System.out.print("Enter new name : ");
					playerName = input.next();
					player.setPlayerName(playerName);
					break;
				case 2:
					System.out.print("Enter runs to add : ");
					int newRuns = input.nextInt();
					player.IncrementRun(newRuns);
					break;
				case 3:
					System.out.print("Enter new age : ");
					int newAge = input.nextInt();
					player.setPlayerAge(newAge);
					break;
				case 4:
					System.out.print("Enter new country : ");
					String newCountry = input.next();
					player.setPlayerCountry(newCountry);
					break;

				default:
					break;
				}
				printMenu();
				break;
			case 5: 
				for(Player p : playerArray) {
					Player.printPlayer(p);
				}
				printMenu();
				break;
			case 6:
				System.out.println("");
				System.out.println("Terminating Program");
				System.exit(6);
			default:
				System.out.println("enter correct choice");
				printMenu();
			}
		}

		// update an element

//		System.out.println("Enter runs to filter players:");
//		int runs = input.nextInt();
//		System.out.println("");
//		System.out.println("Players information scored more than "+runs);
//		printHighScoringPlayers(playerArray,runs);
// 
	}

	public static void printMenu() {
		System.out.println("\tMenu");
		System.out.println("1 . Create objects");
		System.out.println("2 . Delete object");
		System.out.println("3 . add data");
		System.out.println("4 . update data");
		System.out.println("5 . print object");
		System.out.println("6. exit program");
		System.out.println("");
		System.out.print("Enter choice :");
	}

	public static Player[] createPlayerArray(int numberOfPlayers) {
		Player[] playerArray = new Player[numberOfPlayers];
		for (int i = 0; i < numberOfPlayers; i++) {
			playerArray[i] = new Player();
		}
		return playerArray;
	}

	public static void addElements(Player[] playerArray, Scanner input) {
		for (Player playerInstance : playerArray) {
			System.out.print("Enter Name Of Player : ");
			playerInstance.setPlayerName(input.next());

			System.out.print("plays for: ");
			playerInstance.setPlayerCountry(input.next());

			System.out.print("total runs scored: ");
			playerInstance.setPlayerTotalRun(input.nextInt());

			System.out.print("Age : ");
			playerInstance.setPlayerAge(input.nextInt());
			
			System.out.println("");  //to add space  in between 
		}
	}

	public static Player getPlayerByName(Player[] playerArray, String playerName) {
		for (Player player : playerArray) {
			if (player.getName().equals(playerName)) {
				return player;
			}
		}
		return null;
	}

	static void printHighScoringPlayers(Player[] player, int runs) {
		for (Player p : player) {
			if (Player.getTotalRun(p) > runs) {
				Player.printPlayer(p);
			}
		}
	}

}

class Player {
	private String name;
	private String country;
	private int totalRun;
	private int age;

	void setPlayerName(String name) {
		this.name = name;
	}

	void setPlayerCountry(String country) {
		this.country = country;
	}

	void setPlayerTotalRun(int totalRun) {
		this.totalRun = totalRun;
	}

	void setPlayerAge(int age) {
		this.age = age;
	}

	private String getPlayerInfo(String variableName) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter " + variableName + " :");
		variableName = input.nextLine();
		return variableName;
	}

	static void printPlayer(Player p) {
		System.out.println("");
		System.out.println("Player Name :" + p.name);
		System.out.println("Player country :" + p.country);
		System.out.println("Player total run :" + p.totalRun);
		System.out.println("Player age :" + p.age);
		System.out.println("");
	}

	static int getTotalRun(Player p) {
		return p.totalRun;
	}

	String getName() {
		return this.name;
	}

	void IncrementRun(int newRuns) {
		this.totalRun += newRuns;
	}
}
