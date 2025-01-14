public class Minion extends Adventurer{
  int extra, extramax;
  public Minion(String name, int hp){
    super(name, hp);
  }
  public String toString(){
    return this.getName();
  }

  //Get Methods
  public String getName(){
    return name;
  }

  public int getHP(){
    return HP;
  }

  public int getmaxHP(){
    return maxHP;
  }
  public void setmaxHP(int newMax){
    this.maxHP = 3;
  }
  public void setHP(int health){
    this.HP = health;
  }
  public void setName(String s){
    this.name = s;
  }

  public String getSpecialName(){
    "Extra";
  }
  public int getSpecial(){
    return extra;
  }
  public int getSpecialMax(){
    this.extramax = 3;
    return 3;
  }
  public void setSpecial(int n){
    if(this.getSpecial() + n < this.getSpecialMax()){
      this.extra = this.getSpecial() + n;
    }
    else{
      this.extra = this.extramax;
    }
  }
  /*Deals 2 damage*/
  public String attack(Adventurer other){
    other.setHP(other.getHP() - 2);
    this.setSpecial(this.getSpecial() + 1);
    return "Minion attacked " + other.getName() + " and dealt 2 damage."
  }

  public String specialAttack(ArrayList<Adventurer> others, int i){
    return "not on a team";
  }

  /*Special attack: deals as much damage as current extra*/
  public String specialAttack(Adventurer other){
    other.setHP(other.getHP() - this.extra);
    this.setHP(0);
    return "The minion dealt " + this.extra + " damage to " + other.getName() + " and died."
  }

  /*Support: kills itself and gives 3HP to Boss and helps Boss gain 5 Extras*/
  public String support(Boss other){
    other.setHP(other.getHP() + 3);
    other.setSpecial(other.getSpecial() + 5);
    this.setHP(0);
    return "Aided the greater cause.";
  }
  public String support(){
    return "This character only believes in the greater cause, not itself."
  }
}
