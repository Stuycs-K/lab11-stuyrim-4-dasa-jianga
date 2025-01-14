public class Minion extends Adventurer{
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
}
