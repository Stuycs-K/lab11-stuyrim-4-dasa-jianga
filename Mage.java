import.java.util.*;
public abstract class Mage extends Adventurer{
  private int mana, manaMax;
  public Mage(String name){
    super(name);
    this.mana = 25;
    this.manaMax = 50;
  }
  public Mage(String name, int hp){
    super(name, hp);
    this.mana = 25;
    this.manaMax = 50;
  }
  public String getSpecialName(){
    return "Mana";
  }
  public int getSpecial(){
    this.mana;
  }

  public int getSpecialMax(){
    return manaMax;
  }

  public void setSpecial(int n){
    if(n < this.manaMax){
      this.mana = n;
    }
    else{
      this.mana = this.manaMax;
    }
  }

  public void applyDamage(int amount){
    this.HP -= amount;
  }

  public String attack(Adventurer other){
    int damage = 4;
    restoreSpecial(7);
    other.applyDamage(damage);
    return this.getName() + " attacked" + other + " and dealt" + damage + " points of damage";
    if(other.getHP() <= 0){
      restoreSpecial(this.manaMax);
    }
  }
  public String specialAttack(ArrayList<Adventurer> party){

  }

}
