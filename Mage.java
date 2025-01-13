import java.util.*;
public class Mage extends Adventurer{
  private int mana, manaMax;
  public Mage(String name){
    this(name,18);
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
@Override
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
@Override
  public String specialAttack(ArrayList<Adventurer> party, int a){
    if(this.mana < 20){
      return "Sorry, not enough mana. Current mana is: " + this.mana + ". Required mana is 20";
    }
    this.mana -= 20;
    this.setHP(getHP() + 3);
    for(int x = 0; x < party.size(); x++){
      party.get(x).setHP(party.get(x).getHP()-10);
    }
    return this.getName() + " attacked all opponents and dealt 10 points of damage to each while gaining 3HP. Mana is now: " + this.mana;
  }

/*User selects a character to give  double damage to on next attack. Costs 30 Mana and 3 HP*/
@Override
  public String support(Adventurer other){
    if(this.mana < 30){
      return "Sorry, not enough mana. Current mana is: " + this.mana + " .Required mana is 20";
    }
    if(this.getHP() <= 3){
      return "Not enough health";
    }
    this.mana -= 30;
    this.setHP(this.getHP() -3);
    int selector = (int)(Math.random()*4);
    return "";
  }
  /*
   * IMPLEMENT THIS - THIS IS JUST A TEMPORARY COMPILE FIX;
   */
  public String support() {
    support(this);
    return "";
  }
}
