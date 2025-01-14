public class Boss extends Adventurer{
  int stacks, stacksMax;
  String preferredLanguage;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public CodeWarrior(String name, int hp, String language){
    super(name,hp);
    stacksMax = 70;
    stacks = 35;
    preferredLanguage = language;
  }

  public CodeWarrior(String name, int hp){
    this(name,hp);
  }

  public CodeWarrior(String name){
    this(name);
  }

  public CodeWarrior(){
    this("Boss");
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "Stacks";
  }

  public int getSpecial(){
    return stacks;
  }

  public void setSpecial(int n){
    stacks = n;
  }

  public int getSpecialMax(){
    return stacksMax;
  }

  /*Deals 7 damage. Restores 10 Stacks.*/
  public String attack(Adventurer other){
    other.setHP(other.getHP() - 7);
    this.setSpecial(this.getSpecial() + 10);
    if((other.getHP() / other.getmaxHP()) < 0.25){
      this.setSpecial(this.getSpecialMax());
    }
    return this.getName() + " attacked " + other.getName() + " and dealt 7 damage while gaining 10 HP."
  }

  /*Deals 10 damage. If an enemy is defeated, reset all stats to max. Costs 35 Stacks.*/
  public String specialAttack(Adventurer other){
    if(this.getSpecial() < 35){
      return "Sorry, not enough stacks needed for this move. You needed 35 stacks. Current stacks: " + this.getSpecial();
    }
    other.setHP(other.getHP() - 10);
    this.setSpecial(this.getSpecial() - 35);
    if(other.getHP() <= 0){
      this.setHP(this.getmaxHP());
      this.setSpecial(this.getSpecialMax());
    }
    return this.getName() + " used 35 stacks and dealt 10 damage to " + other.getName() + " . Current HP: " + this.getHP() + " Current Stacks:" + this.getSpecial();
  }
  /*Restores 5 special to other*/
  public String support(Adventurer other){
    return "Gives a coffee to "+other+" and restores "
    + other.restoreSpecial(5)+" "+other.getSpecialName();
  }
  /*Restores 6 special and 1 hp to self.*/
  public String support(){
    int hp = 1;
    setHP(getHP()+hp);
    return this+" drinks a coffee to restores "+restoreSpecial(6)+" "
    + getSpecialName()+ " and "+hp+" HP";
  }
}
