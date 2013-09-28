package craps;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Craps {

   
    public static void main(String[] args) {
      //Pull instances of all our classes
        Bank pmoney = new Bank();        
        DisplayMenus menus = new DisplayMenus();
        ListofBets newbet = new ListofBets();
        DiceRoll rolls = new DiceRoll(newbet);
        
        ImagePanel panel = new ImagePanel(new ImageIcon("images/Crapstable.png").getImage());
    JFrame frame = new JFrame();
    frame.getContentPane().add(panel);
    frame.pack();
    frame.setVisible(true);
        
        System.out.println("Welcome to the Craps table!");
      
      //While the player still has money the game goes on  
      while(pmoney.bankNUM() > 0){
        
       
        System.out.println("What would you like to do?");
        //Tell them how much money they have
        newbet.bankcheck.bankget();
        //Is the point on or off?
        if(rolls.thepoint == 0){
            System.out.println("The point is off");
        }else if (rolls.thepoint != 0){
            System.out.println("The point is " + rolls.thepoint);
            }
        
        
        //Show the main menu
        menus.MainMenu();
        Scanner input3 = new Scanner(System.in);
        int selector = input3.nextInt();
        switch(selector){
            case 1:
                rolls.die();
                break;
            case 2:
                if(rolls.thepoint == 0){
                newbet.PlaceBet();
                }else if (rolls.thepoint != 0){
                newbet.PointOnBets();
                }
                break;
            case 3:
                newbet.ViewBets();
                break;
            case 4:
                System.out.println("You end the game with " + newbet.bankcheck.bank + " dollars!");
                System.exit(0);
            default:
                System.out.println("That wasn't a selection!!!!!");
                break;
        }
        
      }
        
       
        
        
    }
    
   
}

 class ImagePanel extends JPanel {

  private Image img;

  public ImagePanel(String img) {
    this(new ImageIcon(img).getImage());
  }

  public ImagePanel(Image img) {
    this.img = img;
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
  }

  public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, null);
  }

}
