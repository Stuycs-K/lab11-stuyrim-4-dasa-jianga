import java.util.*;
public class Healer extends Adventurer{
  private int lifeforce, lifeforceMax;
  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public Healer(String name, int hp){
    super(name,hp);
    lifeforce = 0;
    lifeforceMax = 40;
  }

  public Healer(String name){
    this(name,35);
  }

  public Healer(){
    this("Joe");
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "Life Force";
  }

  public int getSpecial(){
    return lifeforce;
  }

  public void setSpecial(int n){
    lifeforce = n;
  }

  public int getSpecialMax(){
    return lifeforceMax;
  }

  public String passivePerk(){
    restoreSpecial(2);
    if (this.getHP() + 1 <= this.getmaxHP()) {
      this.setHP(this.getHP()+1);
      return " " + this + " also passively healed 1.";
    }
    return "";
  }

  /*Smack - Deals 2 damage and restores 5 Life Force.*/
  public String attack(Adventurer other){
    int damage = 2;
    other.applyDamage(damage);
    restoreSpecial(5);
    return this + " smacked "+ other + " and dealt "+ damage + "." + passivePerk();
  }

  /*Group Healing - Heals all alive allies for 12 HP.
  Costs 20 Life Force. Healing past max HP is kept as overflow.*/
  public String specialAttack(ArrayList<Adventurer> party, int i){
    if(getSpecial() >= 20){
      setSpecial(getSpecial()-20); 
      for (int k = 0; k < party.size(); k++) {
        party.get(k).setHP(party.get(k).getHP()+ 12);
      }
      return this + " healed whole team for 12 HP!" + passivePerk();
    }else{
      return this + " tried to heal the whole team, but does not have enough life force." + passivePerk();
    }

  }
  /*Restores 5 special to other*/
  public String support(ArrayList<Adventurer> party, Adventurer other){
    if (other.getHP() + 4 > other.getmaxHP()) {
      int heal = other.getmaxHP() - other.getHP();
      other.setHP(other.getmaxHP());
      return this + " heals " + other + " and restores " + heal + " HP" + passivePerk();
    }
    else {
      int heal = 4;
      other.setHP(other.getHP()+4);
      return this + " heals " + other + " and restores " + heal + " HP" + passivePerk();
    }
  }
  /*Restores 6 special and 1 hp to self.*/
  public String support(){
    if (this.getHP() + 4 > this.getmaxHP()) {
      int heal = this.getmaxHP() - this.getHP();
      this.setHP(this.getmaxHP());
      return "Restores " + heal + " HP" + passivePerk();
    }
    else {
      int heal = 4;
      this.setHP(this.getHP()+4);
      return "Heals " + this + " and restores " + heal + " HP" + passivePerk();
    }
  }
}
