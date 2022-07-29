import java.util.Scanner;

public class Main extends pgdp.MiniJava {
    public static void main(String[] args) {

        ///Read inputs
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of penguins:");
        int numofpengu = sc.nextInt();
        while (numofpengu < 2) {
            System.out.println("Number of penguins should be >1:");
            numofpengu = sc.nextInt();
        }
        System.out.println("Starting fish per penguin:");
        int numoffish = sc.nextInt();
        while (numoffish < 0) {
            System.out.println("Starting fish should be >0:");
            numoffish = sc.nextInt();
        }


        //create numofpengu quantity penguins array
        int penguins[] = new int[numofpengu];

        // 1 is on 0 is out
        int playerson[] = new int[numofpengu];

        for (int i = 0; i < playerson.length; i++) {
            playerson[i] = 1;
        }
        /// put fishes in array.
        for (int i = 0; i < penguins.length; i++) {
            penguins[i] = numoffish;
        }
        ///Create field array , Every field is empty at first .
        int field[] = new int[12]; ///f2 and f 12 is always empty they have specific function so they are not here , there are 3,4,5,6,7,8,9,10,11
        int first = 0;
        int second = 0;
        int sum = 0;

        int player = penguins.length;
        while (player > 0) {

            for (int i = 0; i < penguins.length; i++) {

                if (playerson[i] == 1) {        ////IF penguin at i index is not playting then its value is 0 and loop wont go here.

                    //Create Borad
                    writeBoard(field[3], field[4], field[5], field[6], field[7], field[8], field[9], field[10], field[11]);
                    System.out.println("It's penguin " + i + "turn:");
                    first = dice();
                    second = dice();
                    sum = first + second;
                    System.out.println(first + "+" + second + "=" + sum + "random was rolled.");

                    // Case1
                    if (sum == 2) {   ///field 2 , take everything except field 7.
                        System.out.println("Lucky penguin! You win all fish on the board except F7!");
                        ///now put all fish from board to pingu
                        for (int j = 3; j < 12; j++) {
                            if (j != 7) {
                                penguins[i] += field[j];  /// put all fish
                                field[j] = 0;   /// empty field////
                            }
                        }

                    }
                    // Case2
                    else if (sum == 7) {
                        System.out.println("Wedding! You give a fish and place it on F7.");
                        penguins[i]--;
                        field[7]++;
                    }
                    //Case3
                    else if (sum == 12) {
                        System.out.println("King Penguin! You win all the fish on the board!");
                        for (int k = 1; k < 12; k++) {
                            penguins[i] += field[k];
                            field[k] = 0;
                        }
                    }
                    //Case4
                    else if (sum != 12 && sum != 7 && sum != 12) {
                        if (field[sum] != 0) {
                            penguins[i] += field[sum];
                            field[sum] = 0;
                            System.out.println("They take the fish from " + "F" + sum + ".");
                        } else {
                            field[sum]++;
                            penguins[i]--;
                            System.out.println("You put a fish on " + "F" + sum + ".");
                        }
                    }
                    write("You now have " + penguins[i] + " fish!");


                    if (penguins[i] == 0) {
                        playerson[i] = 0;
                        player--;
                        System.out.println("You have lost all fish, so you can no longer play!");
                    } else if (readInt("Enter 1 to exit now:") == 1) {
                        playerson[i] = 0;
                        player--;
                    }
                }
            }
        }

        int cc = 0;
        for (int i = 0; i < penguins.length; i++) {
            if (penguins[i] > cc) {
                cc = penguins[i];
            }
        }
        write("The winning penguins with " + cc + " fishes:");
        for (int i = 0; i < penguins.length; i++) {
            if (penguins[i] == cc)
                write("Penguin " + i);
        }
    }
}