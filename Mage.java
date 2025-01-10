public abstract class Mage extends Adventurer{
  public Mage(String name){
    super(name);
  }
  public Mage(String name, int hp){
    super(name, hp);
  }
  private int mana, manaMax;
  public String getSpecialName(){
    return "Mana";
  }
  public int getSpecial(){
    this.mana;
  }
  public int getSpecialMax(){
    this.manaMax = 50;
    return 50;
  }
  public void setSpecial(int n){
    if(n < this.manaMax){
      this.mana = n;
    }
    else{
      this.mana = this.manaMax;
    }
  }
  
  public String specialAttack(ArrayList<Adventurer> party){

  }

}
