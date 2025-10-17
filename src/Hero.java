public class Hero {
private int healHero;
private int damageHero;
private String superPower;
public Hero(int theHealHero, int theDamageHero, String theSuperPower){
    healHero = theHealHero;
    damageHero = theDamageHero;
    superPower = theSuperPower;
}
    public Hero(int theHealHero, int theDamageHero){
        healHero = theHealHero;
        damageHero = theDamageHero;
    }
    public int getHealHero(){
    return healHero;
    }
    public  int getDamageHero(){
    return damageHero;
    }
    public String getSuperPower(){
    return superPower;
    }
}
