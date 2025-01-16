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
      this.setHP(this.getmaxHP());
    }
    return this.getName() + " attacked " + other.getName() + " and dealt " + damage + " damage.";
  }

/* Uses mana in order to attack AoE*/
@Override
  public String specialAttack(ArrayList<Adventurer> party, int a){
    if(this.getSpecial() < 20){
      return this + " does not have enough mana.";
    }
    this.setSpecial(this.getSpecial() - 20);
    this.restoreHP(3);
    for(int x = 0; x < party.size(); x++){
      party.get(x).setHP(party.get(x).getHP()-10);
      if(party.get(x).getHP() <= 0){
        this.setHP(this.getmaxHP());
      }
    }
    return this.getName() + " cast Earthquake, dealing 10 damage to all enemies, and restores HP.";
  }

/*User selects a character to give double damage to a randomly selected opponent. Costs 30 Mana and 3 HP*/
@Override
  public String support(ArrayList<Adventurer> party, Adventurer other){
    if(this.mana < 30){
      return this + " does not have enough mana.";
    }
    if(this.getHP() <= 3){
      return "Not enough health";
    }
    this.mana -= 30;
    this.setHP(this.getHP() - 3);
    int rand = (int)(Math.random() * party.size());
    other.attack(party.get(rand));
    other.attack(party.get(rand));
    return other.getName() + " attacked " + party.get(rand).getName() + " two times, thanks to a support by the mage.";
  }
  /*
   * IMPLEMENT THIS - THIS IS JUST A TEMPORARY COMPILE FIX;
   */
  public String support() {
    return "";
  }
}
