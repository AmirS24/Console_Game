public class HomeWork_5 {

    public static void main(){

    Boss powerBoss = new Boss();// тут будет работать default constructor;
    powerBoss.setHealBoss(800);
    powerBoss.setDamageBoss(50);
    powerBoss.setTypeOfDefence("Магическая защита");
        System.out.println("Здоровье босса: " + powerBoss.getHealBoss());
        System.out.println("Урон босса: " + powerBoss.getDamageBoss());
        System.out.println("Тип защиты босса: " + powerBoss.getTypeOfDefence());
        System.out.println("Информация о героях: ");
        Hero[] hero = createHero();
        for (Hero heroes : hero){
            System.out.println("Здоровье героя: "+ heroes.getHealHero() +"Урон героя: "+ heroes.getDamageHero()+ "Супер Сила героя: "+ heroes.getSuperPower());
        }
}
public static Hero[] createHero(){
Hero heroMagic = new Hero(150, 25,"FireBall");
Hero heroSoldier = new Hero(250, 35);
Hero heroTank = new Hero(400, 10, "Tanking");
Hero[] hero = {heroMagic,heroSoldier,heroTank};
return hero;
}
}
