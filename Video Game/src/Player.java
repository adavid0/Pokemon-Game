import java.util.Random;
import java.util.Scanner;

public class Player{
    String playerName;
    String pokemonType;

    int enemyPokeHealth;
    int enemyLevel = 100;

    String enemyName;
    int pokemonLevel;
    int playerPokeHealth;

    public Player(){

    }
    public Player(String enemyName, int enemyLevel, int enemyPokeHealth){
        this.enemyName = enemyName;
        this.enemyLevel = enemyLevel;
        this.enemyPokeHealth = enemyPokeHealth;
    }

    public void GetDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter player name");
        playerName = sc.nextLine();
        System.out.println("Enter Pokemon Type out of the following : FIRE, WATER, GRASS \n Note : Enter in caps");
        pokemonType = sc.nextLine();
        switch(pokemonType){
            case "FIRE":
            case "WATER":
            case "GRASS":
                System.out.println("Entered type is " + pokemonType);
                break;
            default:
                System.out.println("The type is not accepted. Please enter in caps.");
        }
        System.out.println("Enter the pokemon's level");
        pokemonLevel = sc.nextInt();
        if(pokemonLevel >= 100){
            System.out.println("Pokemon level should be 100 or less than 100.");
        }
        else{
            playerPokeHealth = pokemonLevel*10;
        }

    }

    public void Play() throws InterruptedException {
        System.out.println("A wild pokemon has appeared ! \n Do you want to flee? Or fight? \n 1. Flee \n 2. Fight");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if(choice == 1){
            Random ran = new Random();
            int luck = ran.nextInt(5);
            if(luck < 3) {
                System.out.println("You have fled successfully.");
            }
            else{
                System.out.println("The pokemon does not let you escape !");
                Fight battle = new Fight(enemyLevel,enemyPokeHealth,pokemonLevel,playerPokeHealth,pokemonType,"FIRE");
                battle.fight();
            }
        }
        else if(choice == 2){
            System.out.println("All the best!");
            Thread.sleep(200);
            Fight battle = new Fight(enemyLevel,enemyPokeHealth,pokemonLevel,playerPokeHealth,pokemonType,"FIRE");
            battle.fight();
        }
    }
}
