import java.util.*;
public abstract class Mage extends Adventurer{
  private int mana, manaMax;
  public Mage(String name){
    this(name,18);
  }
  public Mage(String name, int hp){
    super(name, hp);
    this.mana = 25;
    this.manaMax = 50;
  }
  public String getName(){
    return "Donald";
  }
  public String getSpecialName(){
    return "Mana";
  }
  public int getSpecial(){
    return this.mana;
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
/* Deals 4 damage while gaining 7 Mana*/
  public String attack(Adventurer other){
    int damage = 4;
    restoreSpecial(7);
    other.applyDamage(damage);
    if(other.getHP() <= 0){
      restoreSpecial(this.manaMax);
    }
    return this.getName() + " attacked" + other + " and dealt" + damage + " points of damage";
  }

/* Uses mana in order to attack AoE*/
  public String specialAttack(ArrayList<Adventurer> party, int a){
    this.mana -= 20;
    this.setHP(getHP() + 3);
    for(int x = 0; x < party.size(); x++){
      party.get(x).setHP(party.get(x).getHP()-10);
    }
    return this.getName() + " attacked all opponents and dealt 10 points of damage to each while gaining 3HP. Mana is now: " + this.mana;
  }

/*User selects a character to give  double damage to on next attack. Costs 30 Mana and 3 HP*/
  public String support(Adventurer other){
    this.mana -= 30;
    this.setHP(getHP()-3);
    return "";
  }
}
