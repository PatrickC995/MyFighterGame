package GameMechanics;

import classes.Player;
import MyLibrary.clearScreen;

import java.util.Scanner;

public class Login {

    private Player player;
    private final PlayerFileManager pfm = new PlayerFileManager();
    private Navigation nav;
    private final Scanner sc = new Scanner(System.in);

    public void StartGame() {
        System.out.println(
                "[1] Login:\n" +
                        "[2] Create Account");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1: login(); break;
            case 2: CreateAccount(); break;
            default: System.out.println("Invalid option."); break;
        }
    }

    public void login(){
        System.out.println("Enter your Player's name:");
         String name = sc.nextLine().trim();

        System.out.println("Enter your Player's password:");
        String password = sc.nextLine().trim();

        Player authenticated = pfm.authenticatePlayer(name, password);
        clearScreen.clearScreen();

        if (authenticated != null) {
            this.player = authenticated;
            this.nav = new Navigation(this.player); // ensure Navigation uses the authenticated player
            System.out.println("Login successful! Welcome " + player.getName());
            nav.MainMenu();
        } else {
            System.out.println("Login failed. Invalid name or password.");
            login();
        }
    }

    public void CreateAccount() {
        this.player = new Player();

        String username = UsernameValidation();
        player.setName(username);

        String password = PasswordValidation();  // get validated password
        player.setPassword(password);

        player.setId(player.GenerateID());

        //pfm.savePlayer(player);

        this.nav = new Navigation(this.player);
        nav.MainMenu();
    }

    public String UsernameValidation(){
        while (true) {
            System.out.println("Enter your Player's name:");
            String name = sc.nextLine().trim();

            if(name.isEmpty()){
                System.out.println("You must enter a Username:");
                continue;
            }

            if(name.length() < 3 || name.length() > 16){
                System.out.println("Username must be between 3 and 16 characters.");
                continue;
            }

            return name;
        }
    }

    public String PasswordValidation() {
        while (true) {
            System.out.println("Enter your Player's password:");
            String password = sc.nextLine().trim();

            if (password.isEmpty()) {
                System.out.println("You must enter a password.");
                continue;
            }

            if (password.length() < 4 || password.length() > 16) {
                System.out.println("Password must be between 4 and 16 characters.");
                continue;
            }

            boolean hasUppercase = false;

            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    hasUppercase = true;
                    break;
                }
            }

            if (!hasUppercase) {
                System.out.println("Password must contain at least one uppercase letter.");
                continue;
            }

            boolean hasDigit = false;

            for (char c : password.toCharArray()) {
                if (Character.isDigit(c)) {
                    hasDigit = true;
                    break;
                }
            }

            if (!hasDigit) {
                System.out.println("Password must contain at least one number.");
                continue;
            }

            return password; // valid password
        }
    }

    public Player getPlayer() {
        return player;
    }
}