package craps;

import java.util.ArrayList;
import java.util.Scanner;


public class ListofBets {
 
    
    DisplayMenus menus = new DisplayMenus();
    Bank bankcheck = new Bank();
    
    
    //Our ArrayList that holds all the current bets
    ArrayList<Bets> stuff = new ArrayList<Bets>();
    int BetSize;
    
    //Add a new bet to the list if the point is OFF
    void PlaceBet(){
        //What type of Bet will they make?
        System.out.println("\rWhat kind of bet is this?");
        menus.ComeOutBets();
        Scanner input1 = new Scanner(System.in);
        String BetType = null;
        
        int BetPick = input1.nextInt();
            if(BetPick == 1){
                BetType = "Line";
            }
            if(BetPick == 2){
                BetType = "Don't Pass";               
            }
            if(BetPick == 3){
                BetType = "Field";
            }
            if(BetPick == 4){
                System.out.println("Which proposition?");
                menus.PropositionBets();
                BetPick = input1.nextInt();
                switch (BetPick){
                    case 1:
                        BetType = "Any Seven";
                        break;
                    case 2:
                        BetType = "Any Craps";
                        break;
                    case 3:
                        BetType = "Hard Four";
                        break;
                    case 4:
                        BetType = "Hard Six";
                        break;
                    case 5:
                        BetType = "Hard Eight";
                        break;
                    case 6:
                        BetType = "Hard Ten";
                        break;
                    case 7:
                        BetType = "Craps Three";
                        break;
                    case 8:
                        BetType = "Craps Two";
                        break;
                    case 9:
                        BetType = "Yo-Eleven";
                        break;
                    case 10:
                        BetType = "Craps Twelve";
                        break;
                    
                    }   
                }
  
            
      //Input a Bet amount and make sure its an amount they can bet      
      int onoff=0;  
      while(onoff == 0){  
        System.out.println("\rHow much money would you like to bet?");
        Scanner input2 = new Scanner(System.in);
            //BetSize is just used to hold the input
            BetSize = input2.nextInt();
            if(BetSize > bankcheck.bank || BetSize <= 0){
                System.out.println("You can't make that bet");
               
            }else{
            onoff=1;
            }
        }
      //Subtract the bet from the players money
      bankcheck.bankset(BetSize);
        
        //Make a new bet called line
        Bets line = new Bets(bankcheck);
        line.amount=BetSize;
        line.type=BetType;
        line.comeNUM=0;
        stuff.add(line);
    }
    
    
    //Add a new bet to the list if the point is ON
    void PointOnBets(){
        //What type of Bet will they make?
        System.out.println("\rWhat kind of bet is this?");
        menus.PointIsSetBets();
        Scanner input1 = new Scanner(System.in);
        String BetType = null;
        
        int BetPick = input1.nextInt();
            if(BetPick == 1){
                BetType = "Come";
            }
            if(BetPick == 2){
                BetType = "Don't Come";               
            }
            if(BetPick == 3){
                BetType = "Field";
            }
            if(BetPick == 4){
                System.out.println("Which proposition?");
                menus.PropositionBets();
                BetPick = input1.nextInt();
                switch (BetPick){
                    case 1:
                        BetType = "Any Seven";
                        break;
                    case 2:
                        BetType = "Any Craps";
                        break;
                    case 3:
                        BetType = "Hard Four";
                        break;
                    case 4:
                        BetType = "Hard Six";
                        break;
                    case 5:
                        BetType = "Hard Eight";
                        break;
                    case 6:
                        BetType = "Hard Ten";
                        break;
                    case 7:
                        BetType = "Craps Three";
                        break;
                    case 8:
                        BetType = "Craps Two";
                        break;
                    case 9:
                        BetType = "Yo-Eleven";
                        break;
                    case 10:
                        BetType = "Craps Twelve";
                        break;
                    }
                    }
           if(BetPick == 5){
                System.out.println("Which Big Number?");
                menus.BigSixEight();
                BetPick = input1.nextInt();
                switch (BetPick){
                    case 1:
                        BetType = "Big Six";
                        break;
                    case 2:
                        BetType = "Big Eight";
                        break;
            }
                }
           if(BetPick == 6){
                System.out.println("Which Place Bet?");
                menus.PlaceBets();
                BetPick = input1.nextInt();
                switch (BetPick){
                    case 1:
                        BetType = "Place Four";
                        break;
                    case 2:
                        BetType = "Place Five";
                        break;
                    case 3:
                        BetType = "Place Six";
                        break;
                    case 4:
                        BetType = "Place Eight";
                        break;
                    case 5:
                        BetType = "Place Nine";
                        break;
                    case 6:
                        BetType = "Place Ten";
                        break;    
            }
                }
           
           if(BetPick == 7){
                System.out.println("Which Lay Bet?");
                menus.LayBets();
                BetPick = input1.nextInt();
                switch (BetPick){
                    case 1:
                        BetType = "Lay Four";
                        break;
                    case 2:
                        BetType = "Lay Five";
                        break;
                    case 3:
                        BetType = "Lay Six";
                        break;
                    case 4:
                        BetType = "Lay Eight";
                        break;
                    case 5:
                        BetType = "Lay Nine";
                        break;
                    case 6:
                        BetType = "Lay Ten";
                        break;    
            }
                }
           
           if(BetPick == 8){
                System.out.println("Which Buy Bet?");
                menus.BuyBets();
                BetPick = input1.nextInt();
                switch (BetPick){
                    case 1:
                        BetType = "Buy Four";
                        break;
                    case 2:
                        BetType = "Buy Five";
                        break;
                    case 3:
                        BetType = "Buy Six";
                        break;
                    case 4:
                        BetType = "Buy Eight";
                        break;
                    case 5:
                        BetType = "Buy Nine";
                        break;
                    case 6:
                        BetType = "Buy Ten";
                        break;    
            }
                }
            
            
      //Input a Bet amount and make sure its an amount they can bet      
      int onoff=0;  
      while(onoff == 0){  
        System.out.println("\rHow much money would you like to bet?");
        Scanner input2 = new Scanner(System.in);
            //BetSize is just used to hold the input
            BetSize = input2.nextInt();
            if(BetSize > bankcheck.bank || BetSize <= 0){
                System.out.println("You can't make that bet");
               
            }else{
            onoff=1;
            }
        }
      //Subtract the bet from the players money
      bankcheck.bankset(BetSize);
        
        //Make a new bet called line
        Bets line = new Bets(bankcheck);
        line.amount=BetSize;
        line.type=BetType;
        line.comeNUM=0;
        stuff.add(line);
    }
    
    
    //View all bets in the list
    void ViewBets(){
        System.out.println("\rYour current bets are:");
        for (int i = 0; i < stuff.size(); i++){
            Bets item = stuff.get(i);
                       
            if(!item.type.equals("Come") && !item.type.equals("Don't Come")){
                System.out.println("Bet " + i + " : " + item.type + " $" + item.amount);
            }
            if((item.type.equals("Come") || item.type.equals("Don't Come")) && item.comeNUM == 0){
                System.out.println("Bet " + i + " : " + item.type + " $" + item.amount + " waiting on roll");
            }
            if((item.type.equals("Come") || item.type.equals("Don't Come")) && item.comeNUM != 0){
                System.out.println("Bet " + i + " : " + item.type + " $" + item.amount + " set on " + item.comeNUM);
            }
            }
        
    }
    
}

