/**
 * Class representing a List of players.
 *
 * @author Jhonathan Silva
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class JMAS_PlayerList
{
    // list of player objects
    private ArrayList<JMAS_Player> playerList;

    //Constant to avoid repeating the use of String 'players.txt'
    private static final String PLAYERS_FILE_NAME = "players.txt";

    private JMAS_Player loggedPlayer;

    /**
     * Constructor for objects of class Player
     */
    public JMAS_PlayerList() {
        // initialise the player list
        playerList = new ArrayList<>();

        try{
            readPlayersFile(PLAYERS_FILE_NAME);
        }
        catch (java.io.FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
    }

    /**
     * Method to add a Player ti the players list.
     * @params String name, String password, int bestScore
     * @return none
     */
    public void add(String name, String password, int bestScore) {
        JMAS_Player player = new JMAS_Player(name, password, bestScore);
        playerList.add(player);
    }

    /**
     * Method to sort PlayerList
     * @params direction (A - Acsending order, D - Descending order)
     * @return none
     */
    public void sort(char direction) {
        //modify this method to makes it works as expected
        if (direction == 'A') {
            //sort the list in ascending order
            Collections.sort(playerList);
        } else if (direction == 'D') {
            //sort the list in descending order
            Collections.sort(playerList, Collections.reverseOrder());
        }
    }

    /**
     * Method to match a player in the list with a given name and password
     * @param name, password
     * @return true if matched and false if not
     */
    public boolean matchPlayer(String name, String password) {
        boolean match;
        match = false;

        Iterator<JMAS_Player> iter = playerList.iterator();
        while (iter.hasNext()) {
            JMAS_Player player = iter.next();
            if ((player.name.compareTo(name)==0) && (player.password.compareTo(password)==0)) {
                match = true;
                loggedPlayer = player;
                break;
            }
        }        

        return match;
    }

    private void readPlayersFile(String fileName) throws FileNotFoundException{
        try {
            File playersList = new File(fileName);

            //Checks if there is a players.txt file
            if(playersList.exists()) {
                Scanner scn = new Scanner(playersList);
                while(scn.hasNextLine()) {
                    String line = scn.nextLine();

                    Scanner scan = new Scanner(line);
                    String name = scan.next();
                    String password = scan.next();
                    int bestScore = Integer.parseInt(scan.next()); 
                    add(name, password, bestScore);

                    //Closes scan to save resources
                    scan.close();
                }

                scn.close();
            } else {
                //If file players.txt does not yet exists, creates a new one and adds the users credentials
                FileWriter fw = new FileWriter(PLAYERS_FILE_NAME, true);
                fw.write("atie Adm1n 0");
                fw.write(System.lineSeparator());
                fw.write("jhonny 1234 0");
                fw.write(System.lineSeparator());
                fw.write("vinh Adm1n 0");
                fw.close();

                //After creating the file call it self (readPlayersFile) and read the file
                readPlayersFile(PLAYERS_FILE_NAME);
            }
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Returns the currently logged in player
     * @params none
     * @return a Player object that represents the currently logged in player
     */
    public JMAS_Player getCurrentPlayer() {
        return this.loggedPlayer;
    }

    /**
     * Sets the players best score
     * @params JMAS_Player player, int score
     * @return none
     */
    public void setPlayerBestScore(JMAS_Player player, int score) {
        int i = 0;
        try {
            FileWriter fw = new FileWriter(PLAYERS_FILE_NAME, false);

            for(JMAS_Player filePlayer : playerList) {
                if ((filePlayer.getName().compareTo(player.getName()) == 0) && (filePlayer.getPassword().compareTo(player.getPassword()) == 0)) {
                    playerList.get(i).setBestScore(score);
                    break;
                }
                i++;
            }

            for(JMAS_Player filePlayer : playerList) {
                fw.write(filePlayer.getName() + " " + filePlayer.getPassword() + " " + filePlayer.getBestScore());
                fw.write(System.lineSeparator());
            }
            fw.close();

        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method to convert the PlayerList to a string
     * @params none
     * @return a string that represents all players in the list
     */
    @Override
    public String toString() {
        String s = "";

        Iterator<JMAS_Player> iter = playerList.iterator();
        while (iter.hasNext()) {
            JMAS_Player player = iter.next();
            s = s + player.toString() + System.lineSeparator();
        }
        return s;
    }    
}
