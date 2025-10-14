import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ConsoleGame {
    public static int bossHeal = 700;
    public static int bossDamage = 50;
    public static String bossDefence;
    public static int[] herousHeal = {300, 250, 220, 280, 400};
    public static int[] herousDamage = {20, 15, 10, 0, 5};
    public static int medicHeal = 50;
    public static String[] herousTypeOfAttack = {"Physical", "Magic", "Kinetic", "Medic", "Tank"};
    public static int roundNumber;

    public static void main(String[] args) {

        statisticRound();
        while (!isGameOver()) {
            playRound();
        }


    }

    public static boolean isGameOver() {
        if (bossHeal <= 0) {
            System.out.println("Herous won!!");
            return true;
        }
        boolean allHerousDead = true;
        for (int i = 0; i < herousHeal.length; i++) {
            if (herousHeal[i] > 0) {
                allHerousDead = false;
                break;
            }
            if (allHerousDead) {
                System.out.println("Boss won!!");
                return true;
            }
        }
        return false;
    }

    public static void statisticRound() {
//    if(bossDefence == null){
//        bossDefence = "No defense";
//    }
        System.out.println("Round: " + roundNumber + " ------------------------------");
        System.out.println("boss Heal: " + bossHeal + " Boss attack: " + bossDamage + "boss typeDefence: " + (bossDefence == null ? "No defence" : bossDefence));
        for (int i = 0; i < herousHeal.length; i++) {
            System.out.println(herousTypeOfAttack[i] + " - Herous heal: " + herousHeal[i] + " Damage herous: " + herousDamage[i]);
        }
    }

    public static void bossAttack() {
        int totalGolemTakeDamage = 0;
        int golemTakeDamage = bossDamage / 5;
        for (int i = 0; i < herousHeal.length; i++) {
            if (i == 4) continue;
            if (herousHeal[i] > 0 && herousHeal[4] > 0) {
                herousHeal[i] = herousHeal[i] - (bossDamage - golemTakeDamage);
                totalGolemTakeDamage += golemTakeDamage;
            }
            if (herousHeal[i] < 0) {
                herousHeal[i] = 0;
            }

            if (herousHeal[4] > 0) {
                herousHeal[4] -= totalGolemTakeDamage;
                System.out.println("Golem take damage: " + totalGolemTakeDamage + "HP");
                if (herousHeal[4] < 0) {
                    herousHeal[4] = 0;
                }
            }

        }
    }

    public static void herousAttack() {
        for (int i = 0; i < herousDamage.length; i++) {
            if (i == 3) continue;
            if (herousHeal[i] > 0 && bossHeal > 0) {
                int damage = herousDamage[i];
                if (bossDefence == herousTypeOfAttack[i]) {
                    Random random = new Random();
                    int crit = random.nextInt(2, 11);
                    damage *= crit;
                    System.out.println("Critical damag: " + damage);
                }
                bossHeal = bossHeal - damage;
            }
        }

        if (bossHeal < 0) {
            bossHeal = 0;
        }
    }

    public static void setMedicHeal() {
        int medicIndex = 3;
        if (herousHeal[medicIndex] <= 0) return;
        for (int i = 0; i < herousHeal.length - 1; i++) {
            if (herousHeal[i] > 0 && herousHeal[i] < 100) {
                herousHeal[i] += medicHeal;
                System.out.println("Medic health " + herousTypeOfAttack[i] + " for " + medicHeal + " heal");
                break;// вылечит только одного героя кроме себя.
            }
        }

    }

    public static void tankGolem() {
    }

    public static void chooseBossDefence() {
        Random defence = new Random();
        int randomdefence = defence.nextInt(herousTypeOfAttack.length - 1);
        bossDefence = herousTypeOfAttack[randomdefence];
    }

    public static void playRound() {
        roundNumber++;
        chooseBossDefence();
        bossAttack();
        herousAttack();
        statisticRound();
        setMedicHeal();

    }
}




