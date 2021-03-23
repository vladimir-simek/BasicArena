package cz.educanet.arena.data;

import cz.educanet.arena.logic.Gladiator;

import java.io.*;

/**
 * Utils class that saves and loads gladiators.
 */
public class GladiatorDatabase {

    /**
     * @param filename path to the gladiator file.
     * @return loaded Gladiator
     */
    public static Gladiator loadGladiator(String filename) {
        // TODO:

        try {
            Gladiator newGladiator = new Gladiator();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line = bufferedReader.readLine();
            bufferedReader.close();
            String[] variables = line.split(";");

            newGladiator.setName(variables[0]);
            newGladiator.setHp(Integer.parseInt(variables[1]));
            newGladiator.setMaxDMG(Integer.parseInt(variables[2]));
            newGladiator.setMinDMG(Integer.parseInt(variables[3]));

        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new UnsupportedOperationException();
    }

    /**
     * Saves the gladiator.
     * @param filename path to save too.
     * @param gladiator Gladiator to save.
     */
    public static void saveGladiator(String filename, Gladiator gladiator) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
            bufferedWriter.write(gladiator.getName() + ";" + gladiator.getHp() + ";" + gladiator.getMaxDMG() + ";" + gladiator.getMinDMG() + ";");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
