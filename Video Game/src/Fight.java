import java.util.Random;

public class Fight {
    int enemyLevel;
    int enemyPokemonHealth;
    int playerPokemonLevel;
    int playerPokemonHealth;
    double damageMultiplier;

    String playerPokemonType;
    String enemyPokemonType;

    public Fight(int enemyLevel, int enemyPokemonHealth, int playerPokemonLevel, int playerPokemonHealth, String playerPokemonType, String enemyPokemonType){
        this.enemyLevel = enemyLevel;
        this.enemyPokemonHealth = enemyPokemonHealth;
        this.playerPokemonLevel = playerPokemonLevel;
        this.playerPokemonHealth = playerPokemonHealth;
        this.playerPokemonType = playerPokemonType;
        this.enemyPokemonType = enemyPokemonType;
    }

    public void fight() throws InterruptedException {
        if( (playerPokemonType.equals("FIRE") && enemyPokemonType.equals("WATER")) || (playerPokemonType.equals(enemyPokemonType) )
        || (playerPokemonType.equals("WATER") && enemyPokemonType.equals("GRASS")) || (playerPokemonType.equals("GRASS") && enemyPokemonType.equals("FIRE")) ){
            damageMultiplier = 0.5;
        }
        else if( (playerPokemonType.equals("FIRE") && enemyPokemonType.equals("GRASS")) || (playerPokemonType.equals("GRASS") && enemyPokemonType.equals("WATER"))
        || (playerPokemonType.equals("WATER") && enemyPokemonType.equals("FIRE")) ){
            damageMultiplier = 2.0;
        }
        else{
            damageMultiplier = 1.0;
        }
        System.out.println("The battle begins!");
        Thread.sleep(200);
        if( (damageMultiplier == 0.5 && playerPokemonLevel <= enemyLevel) ){
            System.out.println("You have lost this battle !");
        }
        else if( (damageMultiplier == 0.5 && playerPokemonLevel > enemyLevel*1.5) ){
            System.out.println("You have won this battle but your pokemon is hurt critically !");
        }
        else if( (damageMultiplier == 2.0 && enemyLevel > playerPokemonLevel*1.5) ){
            System.out.println("You have won this battle but your pokemon is hurt critically !");
        }
        else if( (damageMultiplier == 2.0 && playerPokemonLevel >= enemyLevel) ){
            System.out.println("You have won this battle");
        }
        else{
            Random ran = new Random();
            int luck = ran.nextInt(4);
            if(luck == 2){
                System.out.println("You have lost this battle by luck :( !");
            }
            else {
                System.out.println("You have won this battle by luck :) !");
            }
        }
    }
}
