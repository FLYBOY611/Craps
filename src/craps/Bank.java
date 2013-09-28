package craps;



public class Bank {
    int bank = 1000;
    
    void bankset(int change){
        
        bank = bank - change;
        //System.out.println("THERE IS NOW " + bank + "\r");
    }
    
    void bankget(){
        System.out.println("You currently have $" + bank + " dollars");
    }
    
    int bankNUM(){
        return bank;
    }
  
    
    
}
