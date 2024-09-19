import java.util.Random;
import java.util.Scanner;
public class Lucky7 {
    public static void main(String[] args) throws Exception {
        
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        //Presenting the Lucky7-game, explaining the rules, the cost of the game. Player is asked to set a prefered balance to the gaming account and wished good luck.
        System.out.println("Tervetuloa pelaamaan peliä Lucky7. Kone arpoo kolme lukua 1 ja 10 väliltä. Jos saat luvun 7, olet onnekas ja voitat."); 
        System.out.println("Yhden pelin hinta on 1 euroa.");
        System.out.println("Anna summa, jonka haluat tallettaa pelikassaasi:");
        String pelisumma = in.nextLine();
        System.out.println("Onnea Matkaan!");
        
        int i= 0;
        int luku = 0;
        int pelikassa = Integer.parseInt(pelisumma);
        int laina = 0;
        
        //the actual game (inside while-loop):
        while (i < 3){
            System.out.println("");
            System.out.println("Aloitetaan:");
            
            //the game selects three random numbers
            for (i = 0; i < 3; i++){ 
                luku = random.nextInt(11);
                System.out.println(luku);
                
                //case lucky7:
                if (luku == 7) {
                    System.out.println("Lucky7, Voitit 3 euroa!");
                    System.out.println("Haluatko yrittää tuplata? Y/N");
                    String tuplaus = in.nextLine();
                    //doubling the winning
                    if (tuplaus.equalsIgnoreCase("Y")){
                        int tupla = random.nextInt(2);
                        if (tupla == 0){
                            System.out.println("Hävisit.");
                        }
                        else if (tupla == 1){
                            System.out.println("Voitit. Pelitilille siirretty 6 euroa.");
                            pelikassa = pelikassa + 6;    
                        } 
                    }
                    else if (tuplaus.equalsIgnoreCase("N")){
                        pelikassa = pelikassa + 3;
                    }   
                }
                
                //if none of the three numbers are 7, this is printed
                if (i == 3 && luku != 7){
                    System.out.println("Huono mäihä, hävisit.");
                }
            } 

            //Game is over, 1 euro is taken from the game account, printing the balance of the game account
            pelikassa = pelikassa - 1;
            System.out.println("");
            System.out.println("Peli loppu.");       
            System.out.printf("Pelikassasi on %d euroa\n", pelikassa);
            System.out.println("Sinulla on lainaa " + -laina + " euroa.");
            //if player runs out of money:
            if (pelikassa < 0){
                System.out.println("Pelitilillä on 0 euroa. Haluatko lainata pankista 5 euroa, paina 'Y'");
                String lainanotto = in.nextLine();
                if (lainanotto.equalsIgnoreCase("y")){
                    pelikassa = pelikassa + 5;
                    laina = laina - 5;
                    System.out.println("Pelikassaasi lisätty 5 euroa. Pelikassassa nyt yhteensä: " + pelikassa + " euroa.");
                    System.out.println("Sinulla on lainaa " + -laina + " euroa.");
                }
                else if (lainanotto.equalsIgnoreCase("N")) {
                    System.out.println("Sinulla ei ole rahaa pelata.");
                    break;
                }
            }
            else if (laina < 0 && pelikassa >= 1){
                System.out.println("Haluatko lyhentää lainaa? Y/N");
                String lainanlyhennys = in.nextLine();
                if (lainanlyhennys.equalsIgnoreCase("Y")){
                    System.out.println("Paljon haluat lyhentää?");
                    String input = in.nextLine();
                    int vahennyssumma = Integer.parseInt(input);
                    laina = laina + vahennyssumma;
                    pelikassa = pelikassa - vahennyssumma;
                    System.out.printf("Uusi lainasaldo: " + -laina + " euroa.\n");
                    System.out.printf("Pelikassasi on %d euroa\n", pelikassa);
                }
            }
            
            //Asking if the player wants to play again
            System.out.println("Pelataanko uudelleen? Y/N");
            String uusipeli = in.nextLine();
            if (uusipeli.equalsIgnoreCase("y")){
                i = 0;
                //if Gaming account's balance is less than 1 euro, player is asked if they would like to have a 5 euros from the bank 
                if (pelikassa < 1){
                    System.out.println("Ei riittävästi rahaa pelikassassa. Jos haluat lainata pankista 5 euroa, paina 'Y'");
                    String lainanotto = in.nextLine();
                    if (lainanotto.equalsIgnoreCase("y")){
                        pelikassa = pelikassa + 5;
                        laina = laina - 5;
                        System.out.println("Pelikassaasi lisätty 5 euroa. Pelikassassa nyt yhteensä: " + pelikassa + " euroa.");
                        System.out.println("Sinulla on lainaa " + -laina + " euroa.");
                    }
                    else {
                        break;
                    }
                }
                if (uusipeli.equalsIgnoreCase("n")){
                    break;
                }
            }   
        }
        
        System.out.println("Kiitos pelaamisesta. Nähdään taas!");
    }
}