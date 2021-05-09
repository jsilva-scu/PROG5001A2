import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;

//NEW IMPORTS
import javax.swing.*;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.Border;
import javax.swing.BorderFactory;


//import javax.swing.JLabel;
//import javax.swing.ImageIcon;

public class JMAS_SnakeGame extends JFrame {

    public JMAS_SnakeGame(String gameTille) {      
        //add(new JMAS_GameBoard());
        add(initGUI());
        setTitle(gameTille);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();        
    }
    
    public JPanel initGUI() {
        JLabel lbBestScore = new JLabel("Top player's score", SwingConstants.CENTER);
        JLabel lbCurrentPlayer = new JLabel("Current Player Score", SwingConstants.CENTER);
        JLabel lbProg = new JLabel("PROG50001: 2021", SwingConstants.CENTER);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("resources/snake.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        JLabel lbImage = new JLabel(imageIcon, SwingConstants.CENTER);
        
        JButton buttonLogin= new JButton("Login");

        //LAYOUT 
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints con = new GridBagConstraints();
        con.anchor = GridBagConstraints.NORTH;
        con.insets = new Insets(10, 10, 10, 10);
        
        // Create a line border with the specified color and width
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        
        // Container Panel
        JPanel container = new JPanel(gb);
        
        // GAME BOARD
        JPanel gameBoard = new JMAS_GameBoard();
        con.gridx = 0;
        con.gridy = 0;  
        gameBoard.setBackground(Color.black);
        gameBoard.setPreferredSize(new Dimension(300, 300));
        container.add(gameBoard, con);

        // RIGHT MENY
        JPanel rightMenu = new JPanel();
        GridLayout grid = new GridLayout(3,1);
        con.gridx = 1;
        con.gridy = 0;
        //rightMenu.setBackground(Color.yellow);
        rightMenu.setPreferredSize(new Dimension(200, 300));
        rightMenu.setLayout(new GridBagLayout());
        container.add(rightMenu, con);
        
        // TOP SCORE
        con.gridx = 0;
        con.gridy = 0;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        con.weightx = 1;
        con.weighty = 0;
        con.anchor = GridBagConstraints.NORTH;
        lbBestScore.setBorder(border);
        rightMenu.add(lbBestScore, con);
        
        // CURRENT SCORE
        con.gridx = 0;
        con.gridy = 2;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        con.weightx = 1;
        con.weighty = 0;
        con.anchor = GridBagConstraints.NORTH;
        lbCurrentPlayer.setBorder(border);
        rightMenu.add(lbCurrentPlayer, con);
        
        // IMAGE
        con.gridx = 0;
        con.gridy = 4;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        con.weightx = 1;
        con.weighty = 1;
        con.anchor = GridBagConstraints.NORTH;
        //lbImage.setBorder(border);
        //lbImage.setIcon(imageIcon);
        rightMenu.add(lbImage, con);
        
        
        // PROG5001
        con.gridx = 0;
        con.gridy = 6;
        con.gridwidth = 2;
        con.gridheight = 2;
        con.fill = GridBagConstraints.BOTH;
        con.weightx = 1;
        con.weighty = 2;
        con.anchor = GridBagConstraints.NORTH;
        lbProg.setBorder(border);
        rightMenu.add(lbProg, con);
        
        
        // BUTTON
        con.gridx = 0;
        con.gridy = 8;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        con.weightx = 1;
        con.weighty = 0;
        con.anchor = GridBagConstraints.NORTH;
        rightMenu.add(buttonLogin, con);
        
        return container;
    }
    
    public static void main(String[] args) {    
        EventQueue.invokeLater(() -> {           
            //Creates a new instance of JMAS_LoginForm
            JMAS_LoginForm lf = new JMAS_LoginForm();
            
            //Prompts the login form when the Game starts
            lf.show();
        });
    }
}
