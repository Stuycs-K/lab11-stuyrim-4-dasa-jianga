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
    return this.getName() + " used Fireball on " + other.getName() + " and dealt " + damage + " damage. Also restored 7 mana.";
  }

/* Uses mana in order to attack AoE*/
@Override
  public String specialAttack(ArrayList<Adventurer> party, int a){
    if(this.getSpecial() < 20){
      return this + " tried to use Earthquake, but does not have enough mana. Instead " + attack(party.get(a));
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

/*User selects a character to give double damage to a randomly selected opponent. Costs 10 Mana*/
@Override
  public String support(ArrayList<Adventurer> party, Adventurer other){
    if(this.mana < 10){
      return this + " tried to use Double Strike on " + other + ", but does not have enough mana. Instead " + attack(other);
    }
    this.mana -= 10;
    int rand = (int)(Math.random() * party.size());
    other.attack(party.get(rand));
    other.attack(party.get(rand));
    return this + " cast Double Strike on " + other.getName() + ", who attacked " + party.get(rand).getName() + " two times.";
  }

  public String support() {
    return "";
  }
}
