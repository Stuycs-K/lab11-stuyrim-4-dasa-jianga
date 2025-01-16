import java.util.*;
public class Boss extends Adventurer{
  private int stacks, stacksMax;

  public Boss(String name, int hp){
    super(name,hp);
    this.stacksMax = 70;
    this.stacks = 35;
  }


  public Boss(String name){
    super(name);
  }

  public Boss(){
    this("Boss");
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "Stacks";
  }

  public int getSpecial(){
    return this.stacks;
  }

  public void setSpecial(int n){
    this.stacks = n;
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
    return this.getName() + " attacked " + other.getName() + " and dealt 7 damage while gaining 10 HP.";
  }

  public String specialAttack(ArrayList<Adventurer> others, int i){
    return "not on a team";
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
  /*For the next turn, it takes less 20% less damage from an opponent.*/
  public String support(ArrayList<Adventurer> team, Adventurer other){
    Minion nice = new Minion("Kevin", 3);
    team.add(nice);
    return "Minion spawned.";
  }
  public String support(){
    return "";
  }

}
