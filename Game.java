import java.util.*;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BACKGROUND_COLOR = Text.WHITE+Text.BACKGROUND;

  public static void main(String[] args) {
    /*
    drawBackground();
    Text.go(30,80);
    ArrayList<Adventurer> a = new ArrayList<Adventurer>();
    a.add(createRandomAdventurer("Heiter"));
    a.add(createRandomAdventurer("Frieren"));
    //a.get(1).applyDamage(14); //testing color
    drawParty(a, 2);
    */
    run();

  }

  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appear or parties will appear.
  public static void drawBackground(){
    Text.clear();
    String horizontal = "";
    for (int i = 0; i < WIDTH; i++) {
      horizontal += "─"; //30 spaces long
    }
    horizontal = Text.colorize(horizontal, BORDER_COLOR,BACKGROUND_COLOR);
    drawText(horizontal, 0, 0);
    drawText(horizontal,HEIGHT-1,0);
    drawText(horizontal,HEIGHT-7,0);
    drawText(horizontal,HEIGHT-12,0);
    drawText(horizontal, 6,0);
    String space = Text.colorize("│", BORDER_COLOR,BACKGROUND_COLOR);
    for (int i = 1; i <= HEIGHT-1; i++) {
      drawText(space, i, 0);
      drawText(space, i, WIDTH);
    }
    drawText(Text.colorize("┌", BORDER_COLOR,BACKGROUND_COLOR),0,0); //corners
    drawText(Text.colorize("┘", BORDER_COLOR,BACKGROUND_COLOR),29,80);
    drawText(Text.colorize("┐", BORDER_COLOR,BACKGROUND_COLOR),0,80);
    drawText(Text.colorize("└", BORDER_COLOR,BACKGROUND_COLOR),29,0);

    drawText(Text.colorize("├", BORDER_COLOR,BACKGROUND_COLOR),6,0);
    drawText(Text.colorize("├", BORDER_COLOR,BACKGROUND_COLOR),HEIGHT-7,0);
    drawText(Text.colorize("├", BORDER_COLOR,BACKGROUND_COLOR),HEIGHT-12,0);
    drawText(Text.colorize("┤", BORDER_COLOR,BACKGROUND_COLOR),6,80);
    drawText(Text.colorize("┤", BORDER_COLOR,BACKGROUND_COLOR),HEIGHT-7,80);
    drawText(Text.colorize("┤", BORDER_COLOR,BACKGROUND_COLOR),HEIGHT-12,80);
  }

  //Display a line of text starting at
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.
  public static void drawText(String s,int startRow, int startCol){
    Text.go(startRow, startCol);
    System.out.print(s);
    Text.go(30,80);
  }

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner of the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
  public static void TextBox(int row, int col, int width, int height, String text){
    Text.go(row,col);
    String blankLine = "";
    for (int i = 0; i < width; i++) {
      blankLine += " ";
    }
    for (int i = 0; i < height; i++) {
      Text.go(row+i, col);
      System.out.print(blankLine);
    }

    Text.go(row,col);
    String[] words = text.split(" ");
    int currentLineLength = 0;
    int curRow = row;
    for (int i = 0; i < words.length; i++) {
      if (currentLineLength + words[i].length() + 1 < width) {
        System.out.print(words[i] + " ");
        currentLineLength += words[i].length()+1;
      }
      else {
        currentLineLength = 0;
        curRow++;
        Text.go(curRow,col);
        System.out.print(words[i] + " ");
        currentLineLength += words[i].length()+1;
      }
    }
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    return;
  }




    //return a random adventurer (choose between all available subclasses)
    //feel free to overload this method to allow specific names/stats.
    public static Adventurer createRandomAdventurer(String name){
      int rand = (int)(Math.random() * 3); //0 to 2
      if (rand == 0) {
        return new Healer(name, (int)(Math.random()*11+30)); //30 to 40
      }
      else if (rand == 1) {
        return new Mage(name, (int)(Math.random()*5 + 16)); //16 to 20
      } else{
        return new CodeWarrior(name, (int)(Math.random()*9 + 26)); //26 to 34
      }
    }

    /*Display a List of 2-4 adventurers on the rows row through row+3 (4 rows max)
    *Should include Name HP and Special on 3 separate lines.
    *Note there is one blank row reserved for your use if you choose.
    *Format:
    *Bob          Amy        Jun
    *HP: 10       HP: 15     HP:19
    *Caffeine: 20 Mana: 10   Snark: 1
    * ***THIS ROW INTENTIONALLY LEFT BLANK***
    */
    public static void drawParty(ArrayList<Adventurer> party,int startRow){
      TextBox(startRow, 2, 78, 4, ""); //resetting
      int col = 2;
      for (Adventurer a : party) {
        drawText(a.getName(), startRow, col);
        drawText(colorByPercent(a.getHP(), a.getmaxHP()), startRow+1,col);
        drawText(a.getSpecialName() + ": " + a.getSpecial() + "/" + a.getSpecialMax(), startRow+2, col);
        col += 30;
      }
      /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
      //YOUR CODE HERE
      /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
      return;
    }


  //Use this to create a colorized number string based on the % compared to the max value.
  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    // under 25% : red
    // under 75% : yellow
    // otherwise : white
    if (hp <= 0) {
      return Text.colorize("DEAD", Text.RED);
    }
    if (hp * 4 < maxHP) {
        return Text.colorize(output, Text.RED);
    }
    else if (hp * 4 < maxHP * 3) {
        return Text.colorize(output, Text.YELLOW);
    }
    else {
        return Text.colorize(output, Text.WHITE);
    }
  }





  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(ArrayList<Adventurer> p1, ArrayList<Adventurer> p2){

    drawBackground();

    drawParty(p1, 2);

    drawParty(p2, 19);

  }

  public static String userInput(Scanner in){
      Text.go(HEIGHT-4,2);

      String input = in.nextLine();

      //clear the text that was written

      return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }

  public static void drawMsg(String msg) {
    TextBox(7,2,78,11,msg);
  }

  public static void run(){
    //Clear and initialize
    Text.hideCursor();
    Text.clear();
    int turn = 0;


    //Things to attack:
    //Make an ArrayList of Adventurers and add 1-3 enemies to it.
    //If only 1 enemy is added it should be the boss class.
    //start with 1 boss and modify the code to allow 2-3 adventurers later.
    ArrayList<Adventurer>enemies = new ArrayList<Adventurer>();
    Adventurer Bob = createRandomAdventurer("BOB");
    Adventurer Joe = createRandomAdventurer("JOE");//Read user input
    Adventurer Sam = createRandomAdventurer("SAM");
    enemies.add(Bob);
    enemies.add(Joe);
    enemies.add(Sam);
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<>();
    Adventurer a1 = new Healer("a1");
    Adventurer a2 = new Mage("a2");
    Adventurer a3 = new CodeWarrior("a3");
    party.add(a1);
    party.add(a2);
    party.add(a3);
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    String input = "";//blank to get into the main loop.
    Scanner in = new Scanner(System.in);
    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen(enemies, party);//initial state.

    //Main loop

    //display this prompt at the start of the game.


    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      //Read user input

      //example debug statment
      //TextBox(24,2,1,78,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );

      //display event based on last turn's input
      String msg = "Bad input!";

      if(partyTurn && whichPlayer < party.size()){
        //print preprompt
        String preprompt = "Enter command for "+party.get(whichPlayer)+": attack/special/support/quit + enemy number:";
        Text.go(HEIGHT-6,2);
        System.out.print(preprompt);
        //initializing variables and breaking input
        input = userInput(in);
        Scanner scan = new Scanner(input);
        String command = scan.next();
        int target = scan.nextInt();
        //taking commands
        if(command.equals("attack") || command.equals("a")){
          msg = party.get(whichPlayer).attack(enemies.get(target-1));
        }
        else if(command.equals("special") || command.equals("sp")){
          msg = party.get(whichPlayer).specialAttack(enemies,target-1);
        }
        else if(command.equals("su") || command.equals("support")){
          if(!(party.get(whichPlayer).getSpecialName().equals("Mana"))){ //if not mage, pass in your party, and pass in target for support
            msg = party.get(whichPlayer).support(party, party.get(target-1));
          }
          else{
            msg = party.get(whichPlayer).support(enemies, party.get(target - 1)); //if mage, pass in the enemy party, and pass in the target for support
          }
        }
        //System.out.println(msg);
        //return;
        whichPlayer++;

      }

      else {
        partyTurn = false;
        //not the party turn!

        int rand = (int)(Math.random() * 10); // 0 to 9
        int target = (int)(Math.random() * 3); //0 to 2
        if (rand <= 5) { // 6/10 chance of attack random
          msg = enemies.get(whichOpponent).attack(party.get(target));
        }
        else if (rand == 6 || rand == 7) { // 2/10 chance of support random
          if (enemies.get(whichOpponent).getSpecialName().equals("Mana")) {
            msg = enemies.get(whichOpponent).support(party,enemies.get(target));
          }
          else {
            msg = enemies.get(whichOpponent).support(enemies,enemies.get(target));
          }
        }
        else { // 2/10 chance special
          msg = enemies.get(whichOpponent).specialAttack(party, target);
        }


        //Decide where to draw the following prompt:
        String prompt = "press enter to see next turn";
        Text.go(HEIGHT-6,2);
        System.out.print(prompt);
        //Text.go(11,2);
        //System.out.print(partyTurn + " " + whichOpponent);
        input = userInput(in);
        Scanner scan = new Scanner(input);
        whichOpponent++;

      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        //Text.go(13,2);
        //System.out.print("CODE REACHED");
        whichPlayer = 0;
        whichOpponent = 0;
        turn++;
        partyTurn=true;
      }

      //display the updated screen after input has been processed.

    //check for dead enemies
    for (int i = 0; i < party.size(); i++) {
        if (party.get(i).getHP() <= 0) {
            msg += " " + party.get(i) + " has died!";
            party.remove(i);
            i--;

      }
    }
    for (int i = 0; i < enemies.size(); i++) {
        if (enemies.get(i).getHP()<=0) {
          msg += " " + enemies.get(i) + " has died!";
          enemies.remove(i);
          i--;
        }
    }

    drawScreen(enemies, party);
    drawMsg(msg);


    }//end of main game loop


    //After quit reset things:
    quit();
  }
}
