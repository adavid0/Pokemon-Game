import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Player player = new Player();
        System.out.println("Choose your player ID. \n 1. Player One \n 2. Player Two");
        int playerNo = sc.nextInt();
        if(playerNo == 1){
            System.out.println("Enter your player details.");
            player.GetDetails();
            System.out.println("Do you wish to play the game? \n 1. Yes \n 2. No");
            int choice = sc.nextInt();
            if(choice == 1){
                player.Play();
            }
        }
    }
}
