
package craps;


public class DiceRoll {
    
    public DiceRoll(ListofBets list){
        works = list;
    }
    
    
    ListofBets works = new ListofBets();
    int thepoint = 0;
    boolean pointReset = false;
    
    //Roll the dice and resolve the bets
    void die(){
        int roller1 = 1 + (int)(Math.random() * ((6 - 1) + 1));
        System.out.println("The first die is " + roller1);
        int roller2 = 1 + (int)(Math.random() * ((6 - 1) + 1));
        System.out.println("The second die is " + roller2);
        int result = roller1 + roller2;
        System.out.println("THE TOTAL IS: " + result);
       
        /*
        if (thepoint == 0){
        //Method for offpoint rolls    
        }
        
        
        if (thepoint != 0){
        //Method for onpoint rolls    
        } */
        
        
        //POINT ON, POINT SCORE
        if (thepoint == result && thepoint != 0){
            //RESET THE POINT
            thepoint = 0;
            pointReset = true;
             for (int i = 0; i < works.stuff.size(); i++){
                Bets item = works.stuff.get(i);
                //LINE BET WINS ON POINT
                if (item.type.equals("Line")){
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    works.bankcheck.bankset(item.amount*2*-1);
                    System.out.println("You've won $" + item.amount +"!");
                    works.stuff.get(i).type = "foo";
                }//DON'T PASS LOSES ON POINT       
                if (item.type.equals("Don't Pass")){
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has lost");                  
                    works.stuff.get(i).type = "foo";            
           
                    }
                }
             
               
            }
                       
        //SEVENS OR ELEVENS, NO POINT
        if ((result == 7 || result == 11) && thepoint == 0){ 
            //System.out.println("Pay the line! :)");
            for (int i = 0; i < works.stuff.size(); i++){
                Bets item = works.stuff.get(i);
                //LINE BET WINS
                if (item.type.equals("Line")){
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    works.bankcheck.bankset(item.amount*2*-1);
                    System.out.println("You've won $" + item.amount +"!");
                    works.stuff.get(i).type = "foo";
                }//DON'T PASS LOSES ON COME OUT ROLL
                if (item.type.equals("Don't Pass")){
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has lost");                  
                    works.stuff.get(i).type = "foo";            
           
                }
                
            }
                //CRAPS ROLL, POINT IS OFF   
                } else if ((result == 2 || result == 3 || result == 12) && thepoint == 0){
                    System.out.println("We have craps! :(");
                    for (int i = 0; i < works.stuff.size(); i++){
                           Bets item = works.stuff.get(i);
                        if (item.type.equals("Line")){
                            System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                                    + " has lost");                  
                            works.stuff.get(i).type = "foo";            

                        }//DON'T PASS WINS ON CRAPS, NO POINT
                        if(item.type.equals("Don't Pass")){
                           System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                                    + " is a winner!");
                           works.bankcheck.bankset(item.amount*2*-1);
                           System.out.println("You've won $" + item.amount +"!");
                           works.stuff.get(i).type = "foo"; 
                        }
                     }
                //ANY OTHER ROLL AND THE POINT IS ESTABLISHED    
                } else if (thepoint == 0 && pointReset == false){
                thepoint = result;
                System.out.println("The point has been set to: " + thepoint);
                }
        
        
        //SEVEN OUT, POINT IS ON
        if (result == 7 && thepoint != 0){
                //RESET THE POINT
                thepoint = 0;
                pointReset = true;
                System.out.println("Sevens out!");
                for (int i = 0; i < works.stuff.size(); i++){
                    Bets item = works.stuff.get(i);
                    //DON'T COME WINS ON SEVEN OUT
                    if (item.type.equals("Don't Come") && item.comeNUM != 0){
                        System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                                 + " is a winner!");
                        works.bankcheck.bankset(item.amount*2*-1);
                        System.out.println("You've won $" + item.amount +"!");
                        works.stuff.get(i).type = "foo";
                    }
                    //COME BET LOSES ON SEVEN OUT
                    if ((item.type.equals("Come") && item.comeNUM != 0)){
                        System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has lost");
                        works.stuff.get(i).type = "foo";
                    }
                    //LINE BET LOSES ON SEVEN OUT
                    if (item.type.equals("Line")){
                        System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has lost");
                        works.stuff.get(i).type = "foo";
                        works.stuff.get(i).type = "foo";
                    }
                    //DON'T PASS WINS ON SEVEN OUT
                    if (item.type.equals("Don't Pass")){
                        System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                                + " is a winner!");
                        works.bankcheck.bankset(item.amount*2*-1);
                        System.out.println("You've won $" + item.amount +"!");
                        works.stuff.get(i).type = "foo";
                    }
                }
                
            }
        
        
        //Field bets
        if (result == 2 || result == 3 || result == 4
            || result == 9 || result == 10 || result == 11
                ||result == 12){
           for (int i = 0; i < works.stuff.size(); i++){
                   Bets item = works.stuff.get(i);
                if (item.type.equals("Field")){
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has won!");
                    works.bankcheck.bankset(item.amount*2*-1);
                    System.out.println("You've won $" + item.amount +"!");
                    works.stuff.get(i).type = "foo";
               }       
            }
        //Logic for losing a field bet
        }else{
            for (int i = 0; i < works.stuff.size(); i++){
                   Bets item = works.stuff.get(i);
                if (item.type.equals("Field")){
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has lost");                  
                    works.stuff.get(i).type = "foo";            
           
                }
             }
        }

//COME BETS        
                
        //SEVEN OR ELEVEN
        if ((result == 7 || result == 11) ){             
            for (int i = 0; i < works.stuff.size(); i++){
                Bets item = works.stuff.get(i);
                //WINNING A COME BET, comeNUM not established
                if (item.type.equals("Come") && item.comeNUM == 0){
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    works.bankcheck.bankset(item.amount*2*-1);
                    System.out.println("You've won $" + item.amount +"!");
                    works.stuff.get(i).type = "foo";
                }
                //LOSING ON DON'T COME
                if (item.type.equals("Don't Come") && item.comeNUM == 0){
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has lost");
                    works.stuff.get(i).type = "foo";
                }
                
            }
        }
        //CRAPS OUT
        if((result == 2 || result == 3 || result == 12)){
           for (int i = 0; i < works.stuff.size(); i++){
                Bets item = works.stuff.get(i);
                //LOSING A COME BET
                if (item.type.equals("Come") && item.comeNUM == 0){
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has lost");                  
                    works.stuff.get(i).type = "foo";  
                }//WINNING ON A DON'T COME
                if (item.type.equals("Don't Come") && item.comeNUM == 0){
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has won!");
                    works.bankcheck.bankset(item.amount*2*-1);
                    System.out.println("You've won $" + item.amount +"!");
                    works.stuff.get(i).type = "foo"; 
                }
                }
        }
        
        
        
        
        
        //ANY OTHER ROLL
        else{
            for (int i = 0; i < works.stuff.size(); i++){
                Bets item = works.stuff.get(i);
                //COME BET MAKES NUMBER
                if (item.type.equals("Come") && item.comeNUM == result){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    works.bankcheck.bankset(item.amount*2*-1);
                    System.out.println("You've won $" + item.amount +"!");
                    works.stuff.get(i).type = "foo";                                       
                }
                //DON'T COME LOSES ON MAKING NUMBER
                if (item.type.equals("Don't Come") && item.comeNUM == result){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has lost");
                    works.stuff.get(i).type = "foo";                                       
                }
                //SET THE COME NUMBER
                if (item.comeNUM == 0){
                    item.comeNUM=result; 
                }         
                }
        }
        
//PROPOSITION BETS
        for (int i = 0; i < works.stuff.size(); i++){
                Bets item = works.stuff.get(i);
                //ANY SEVEN WINS
                if (item.type.equals("Any Seven") && result == 7){
                 System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    works.bankcheck.bankset((item.amount + (item.amount*4))*-1);
                    System.out.println("You've won $" + item.amount*4 +"!");
                    works.stuff.get(i).type = "foo"; 
                }
                //ANY SEVEN LOSES OTHERWISE
                if (item.type.equals("Any Seven") && result != 7){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has lost");
                    works.stuff.get(i).type = "foo";                                       
                }
                //ANY CRAPS WINS ON CRAPS
                if (item.type.equals("Any Craps") && (result == 2 || result == 3 || result ==12)){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    works.bankcheck.bankset((item.amount + (item.amount*7))*-1);
                    System.out.println("You've won $" + item.amount*7 +"!");
                    works.stuff.get(i).type = "foo";                                       
                }
                //ANY CRAPS LOSES OTHERWISE
                if (item.type.equals("Any Craps") && (result != 2 || result != 3 || result !=12)){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has lost");
                    works.stuff.get(i).type = "foo";                                       
                }
                //CRAPS THREE WINS ON THREE
                if (item.type.equals("Craps Three") && result == 3){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    works.bankcheck.bankset((item.amount + (item.amount*15))*-1);
                    System.out.println("You've won $" + item.amount*15 +"!");
                    works.stuff.get(i).type = "foo";                                       
                }
                //CRAPS THREE LOSES OTHERWISE
                if (item.type.equals("Craps Three") && result != 3){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has lost");
                    works.stuff.get(i).type = "foo";                                       
                }
                //CRAPS TWO WINS ON TWO
                if (item.type.equals("Craps Two") && result == 2){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    works.bankcheck.bankset((item.amount + (item.amount*30))*-1);
                    System.out.println("You've won $" + item.amount*30 +"!");
                    works.stuff.get(i).type = "foo";                                       
                }
                //CRAPS TWO LOSES OTHERWISE
                if (item.type.equals("Craps Two") && result != 2){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has lost");
                    works.stuff.get(i).type = "foo";                                         
                }
                //YO-ELEVEN WINS ON ELEVEN
                if (item.type.equals("Yo-Eleven") && result == 11){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    works.bankcheck.bankset((item.amount + (item.amount*15))*-1);
                    System.out.println("You've won $" + item.amount*15 +"!");
                    works.stuff.get(i).type = "foo";                                       
                }
                //YO-ELEVEN LOSES OTHERWISE
                if (item.type.equals("Yo-Eleven") && result != 11){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has lost");
                    works.stuff.get(i).type = "foo";                                       
                }
                //CRAPS TWELVE WINS ON TWELVE
                if (item.type.equals("Craps Twelve") && result == 12){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    works.bankcheck.bankset((item.amount + (item.amount*30))*-1);
                    System.out.println("You've won $" + item.amount*30 +"!");
                    works.stuff.get(i).type = "foo";                                       
                }
                //CRAPS TWELVE LOSES OTHERWISE
                if (item.type.equals("Craps Twelve") && result != 12){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has lost");
                    works.stuff.get(i).type = "foo";                                          
                }
                //HARD FOUR OR HARD TEN WINS ON HARD ROLL
                if ((item.type.equals("Hard Four") && (roller1 == 2 && roller2 == 2))
                        || (item.type.equals("Hard Ten") && (roller1 == 5 && roller2 == 5))){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    works.bankcheck.bankset((item.amount + (item.amount*7))*-1);
                    System.out.println("You've won $" + item.amount*7 +"!");
                    works.stuff.get(i).type = "foo";                                       
                }
                //HARD FOUR OR HARD TEN LOSES ON MATCH ROLL
                if ((item.type.equals("Hard Four") && (result == 4))
                        || (item.type.equals("Hard Ten") && (result == 10))){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has lost");
                    works.stuff.get(i).type = "foo";                                      
                }
                //HARD SIX OR HARD EIGHT WINS ON HARD ROLL
                if ((item.type.equals("Hard Six") && (roller1 == 3 && roller2 == 3))
                        || (item.type.equals("Hard Eight") && (roller1 == 4 && roller2 == 4))){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    works.bankcheck.bankset((item.amount + (item.amount*9))*-1);
                    System.out.println("You've won $" + item.amount*9 +"!");
                    works.stuff.get(i).type = "foo";                                       
                }
                //HARD SIX OR HARD EIGHT LOSES ON MATCH ROLL
                if ((item.type.equals("Hard Six") && (result == 6))
                        || (item.type.equals("Hard Eight") && (result == 8))){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has lost");
                    works.stuff.get(i).type = "foo";                                        
                }
//BIG SIX AND BIG EIGHT                
                //BIG SIX OR BIG EIGHT WINS ON ROLL
                if ((item.type.equals("Big Six") && (result == 6))
                        || (item.type.equals("Big Eight") && (result == 8))){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    works.bankcheck.bankset(item.amount*2*-1);
                    System.out.println("You've won $" + item.amount +"!");
                    works.stuff.get(i).type = "foo";                                       
                }
//SEVEN KILLS EVERYTHING!!!!!!                
                if (result == 7 && (item.type.equals("Big Six") 
                        || item.type.equals("Big Eight")
                        || item.type.equals("Hard Six")
                        || item.type.equals("Hard Eight")
                        || item.type.equals("Hard Four")
                        || item.type.equals("Hard Ten")
                        || item.type.equals("Place Four")
                        || item.type.equals("Place Ten")
                        || item.type.equals("Place Five")
                        || item.type.equals("Place Nine")
                        || item.type.equals("Place Six")
                        || item.type.equals("Place Eight")
                        || item.type.equals("Buy Four")
                        || item.type.equals("Buy Ten")
                        || item.type.equals("Buy Five")
                        || item.type.equals("Buy Nine")
                        || item.type.equals("Buy Six")
                        || item.type.equals("Buy Eight"))){
                
                System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has lost");
                    works.stuff.get(i).type = "foo";    
                }
              //PLACE 4 OR 10 WINS  
              if ((item.type.equals("Place Four") && (result == 4))
                        || (item.type.equals("Place Ten") && (result == 10))){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    works.bankcheck.bankset((item.amount + ((item.amount*9)/5))*-1);
                    System.out.println("You've won $" + (item.amount*9)/5 +"!");
                    works.stuff.get(i).type = "foo";                                       
                }              
              //PLACE 5 OR 9 WINS  
              if ((item.type.equals("Place Five") && (result == 5))
                        || (item.type.equals("Place Nine") && (result == 9))){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    works.bankcheck.bankset((item.amount + ((item.amount*7)/5))*-1);
                    System.out.println("You've won $" + (item.amount*7)/5 +"!");
                    works.stuff.get(i).type = "foo";                                       
                }
              //PLACE 6 OR 8 WINS  
              if ((item.type.equals("Place Six") && (result == 6))
                        || (item.type.equals("Place Eight") && (result == 8))){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    works.bankcheck.bankset((item.amount + ((item.amount*7)/6))*-1);
                    System.out.println("You've won $" + (item.amount*7)/6 +"!");
                    works.stuff.get(i).type = "foo";                                       
                }
              //BUY 4 OR 10 WINS ODDS ARE GOOD? 
              if ((item.type.equals("Buy Four") && (result == 4))
                        || (item.type.equals("Buy Ten") && (result == 10))){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    double comish = item.amount*.05;                    
                    works.bankcheck.bankset((int)(item.amount +(((item.amount*2)/1)-comish)*-1));
                    System.out.println("You've won $" + ((int)((((item.amount*2)/1)-comish))) +"!");
                    works.stuff.get(i).type = "foo";                                         
                }
              //BUY 5 OR 9 WINS
              if ((item.type.equals("Buy Five") && (result == 5))
                        || (item.type.equals("Buy Nine") && (result == 9))){                    
                     System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    double comish = item.amount*.05;                    
                    works.bankcheck.bankset((int)(item.amount +(((item.amount*3)/2)-comish)*-1));
                    System.out.println("You've won $" + ((int)((((item.amount*3)/2)-comish))) +"!");
                    works.stuff.get(i).type = "foo";                                      
                }
              //BUY 6 OR 8 WINS
              if ((item.type.equals("Buy Six") && (result == 6))
                        || (item.type.equals("Buy Eight") && (result == 8))){                    
                     System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    double comish = item.amount*.05;                    
                    works.bankcheck.bankset((int)(item.amount +(((item.amount*5)/6)-comish)*-1));
                    System.out.println("You've won $" + ((int)((((item.amount*5)/6)-comish))) +"!");
                    works.stuff.get(i).type = "foo";                                      
                }
              
              //LAY 4 OR 10 LOSES
              if ((item.type.equals("Lay Four") && (result == 4))
                        || (item.type.equals("Lay Ten") && (result == 10))){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has lost");
                    works.stuff.get(i).type = "foo";                                         
                }
              //LAY 5 OR 9 LOSES
              if ((item.type.equals("Lay Five") && (result == 5))
                        || (item.type.equals("Lay Nine") && (result == 9))){                    
                    System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has lost");
                    works.stuff.get(i).type = "foo";                                       
                }
              //LAY 6 OR 8 LOSES
              if ((item.type.equals("Lay Six") && (result == 6))
                        || (item.type.equals("Lay Eight") && (result == 8))){                    
                     System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " has lost");
                    works.stuff.get(i).type = "foo";                                     
                }
              //LAY 4 OR 10 WINS
              if (result == 7 && ((item.type.equals("Lay Four")
                      || (item.type.equals("Lay Ten"))))){
                  System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    double comish = ((item.amount*1)/2)*.05;                    
                    works.bankcheck.bankset((int)(item.amount +(((item.amount*1)/2)-comish)*-1));
                    System.out.println("You've won $" + ((int)((((item.amount*1)/2)-comish))) +"!");
                    works.stuff.get(i).type = "foo"; 
              }
              //LAY 5 OR 9 WINS
              if (result == 7 && ((item.type.equals("Lay Five")
                      || (item.type.equals("Lay Nine"))))){
                 System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    double comish = ((item.amount*2)/3)*.05;                    
                    works.bankcheck.bankset((int)(item.amount +(((item.amount*2)/3)-comish)*-1));
                    System.out.println("You've won $" + ((int)((((item.amount*2)/3)-comish))) +"!");
                    works.stuff.get(i).type = "foo";  
              }
              //LAY 6 OR 8 WINS
              if (result == 7 && ((item.type.equals("Lay Six")
                      || (item.type.equals("Lay Eight"))))){
                  System.out.println("Bet " + i + " : " + item.type + " " + item.amount
                            + " is a winner!");
                    double comish = ((item.amount*5)/6)*.05;                    
                    works.bankcheck.bankset((int)(item.amount +(((item.amount*5)/6)-comish)*-1));
                    System.out.println("You've won $" + ((int)((((item.amount*5)/6)-comish))) +"!");
                    works.stuff.get(i).type = "foo"; 
              }


        } 
        
        //A loop to remove resolved bets once they're done
        for (int i = 0; i < works.stuff.size(); i++){
           Bets item = works.stuff.get(i);
          if(item.type.equals("foo")){  
            works.stuff.remove(i).type = "foo";
            i=0;
          }
        }
        pointReset = false;
        
    }
    }
   
    
