package cz.educanet.arena.presentation;

import cz.educanet.arena.data.GladiatorDatabase;
import cz.educanet.arena.logic.Arena;
import cz.educanet.arena.logic.Gladiator;

import java.io.IOException;
import java.util.Scanner;

public class ArenaCLI {

    private Arena logic;
    private Scanner sc;

    /**
     * Initialize all variables that are needed.
     */
    public void init() {
        logic = new Arena();
        sc = new Scanner(System.in);
    }

    public void renderLandingPage() {
        System.out.println("""
                    /\\                        \s
                   /  \\   _ __ ___ _ __   __ _\s
                  / /\\ \\ | '__/ _ \\ '_ \\ / _` |
                 / ____ \\| | |  __/ | | | (_| |
                /_/    \\_\\_|  \\___|_| |_|\\__,_|""".indent(1));
        System.out.println("---------------------------------");
    }

    public void renderGladiatorPicker() {
        System.out.println("Do you wish to create a new Gladiators or load already existing Gladiators?");
        System.out.println("1/2");
        String rawOption = sc.nextLine();
        int option = Integer.parseInt(rawOption);

        try {
            while (option != 1 && option != 2) {
                rawOption = sc.nextLine();
                option = Integer.parseInt(rawOption);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (option == 2) {

            System.out.println("Pick your fighter #1 (enter the path of the saved file):");
            String gladiator1File = sc.nextLine();
            System.out.println("Pick your fighter #2 (enter the path of the saved file):");
            String gladiator2File = sc.nextLine();


            Gladiator gladiator1 = GladiatorDatabase.loadGladiator(gladiator1File);
            Gladiator gladiator2 = GladiatorDatabase.loadGladiator(gladiator2File);
            logic.setGladiator1(gladiator1);
            logic.setGladiator2(gladiator2);
        } else {
            Gladiator gladiator1 = new Gladiator();
            System.out.println("Enter Gladiators number 1 name:");
            gladiator1.setName(sc.nextLine());
            gladiator1.setHp(100);
            gladiator1.setMinDMG(10);
            gladiator1.setMaxDMG(20);

            System.out.println("Enter Gladiators number 1 name:");

        }
    }

    /**
     * Fight until one gladiator dies, or surrenders.
     */
    public void renderEntireFight() {
        // TODO:
        // while(...) {logic.fight.... sout...}

        while (logic.getWinner() == null) {
            logic.fight();
        }
    }

    public void renderGladiatorSaver() {
        System.out.println("Save your fighter #1 (enter the path of the file where you want to save him):");
        String gladiator1Path = sc.nextLine();
        System.out.println("Save your fighter #2 (enter the path of the file where you want to save him):");
        String gladiator2Path = sc.nextLine();

        GladiatorDatabase.saveGladiator(gladiator1Path, logic.getGladiator1());
        GladiatorDatabase.saveGladiator(gladiator2Path, logic.getGladiator2());
    }

}
