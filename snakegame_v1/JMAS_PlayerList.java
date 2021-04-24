/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class JMAS_PlayerList
{
    // list of player objects
    private ArrayList<Player> playerList;
    
    //Constant to avoid repeating the use of String 'players.txt'
    private static final String PLAYERS_FILE_NAME = "players.txt";

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
     * Method to add a Player
     * @params name, password
     * @return none
     */
    public void add(String name, String password) {
        Player player = new Player(name, password);
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
        } else if (direction == 'D')        
        {
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

        Iterator<Player> iter = playerList.iterator();
        while (iter.hasNext()) {
            Player player = iter.next();
            if ((player.name.compareTo(name)==0) && (player.password.compareTo(password)==0)) {
                match = true;
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
                    add(name, password);
                    
                    //Closes scan to save resources
                    scan.close();
                }
                
                scn.close();
            } else {
                //If file players.txt does not yet exists, creates a new one and adds the users credentials
                FileWriter fw = new FileWriter(PLAYERS_FILE_NAME, true);
                fw.write("atie Adm1n");
                fw.write(System.lineSeparator());
                fw.write("jhonny 1234");
                fw.write(System.lineSeparator());
                fw.write("vinh Adm1n");
                fw.close();
                
                //After creating the file call it self (readPlayersFile) and read the file
                readPlayersFile(PLAYERS_FILE_NAME);
            }
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

        Iterator<Player> iter = playerList.iterator();
        while (iter.hasNext()) {
            Player player = iter.next();
            s = s + player.toString() + System.lineSeparator();
        }
        return s;
    }

    /**
     * This private class for storing player's details 
     */
    class Player implements Comparable<Player> {
        public String name;
        public String password;

        public Player(String name, String password) {
            this.name = name;
            this.password = password;
        }

        @Override
        public String toString() {
            return name + "[pass=" + password + "]";
        }

        @Override
        public int compareTo(Player p) {
            return this.name.compareTo(p.name);
        }
    }
}
