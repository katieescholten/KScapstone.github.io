package EnhancedZooKeeperMonitor;

import java.io.FileNotFoundException;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.io.File;
import java.util.Scanner;

public class EnhancedZooKeeperMonitor
{
    public static void main(final String[] args) {
        final Scanner input = new Scanner(System.in);
        //Main options of which monitoring system to pick
        while (true) {
            System.out.println("Welcome to Zoo Monitoring System");
            System.out.println("1.Monitor animal"); 
            System.out.println("2.Monitor habitat");
            // Making the zookeeper assignment option #3 and exit #4
            System.out.println("3.Assign a zookeeper");
            System.out.println("4.Exit");
            System.out.println("Enter your choice: ");
            final int mainOption = Integer.parseInt(input.nextLine());
            //Picking animal after selecting option 1 to Monitor Animal
            switch (mainOption) {
                case 1: {
                    System.out.println("1.Animal - Lion"); 
                    System.out.println("2.Animal - Tiger");
                    System.out.println("3.Animal - Bear");
                    System.out.println("4.Animal - Giraffe");
                    System.out.println("Select Animal: ");
                    final int animalChoice = Integer.parseInt(input.nextLine());
                    String animal = "";
                    switch (animalChoice) {
                        case 1: {
                            animal = "Animal - Lion";
                            break;
                        }
                        case 2: {
                            animal = "Animal - Tiger";
                            break;
                        }
                        case 3: {
                            animal = "Animal - Bear";
                            break;
                        }
                        case 4: {
                            animal = "Animal - Giraffe";
                            break;
                        }
                    }
                    try {
                        final Scanner animalFile = new Scanner(new File("animals.txt"));
                        while (animalFile.hasNextLine() && !animal.equals(animalFile.nextLine())) {}
                        final String name = animalFile.nextLine();
                        final String age = animalFile.nextLine();
                        final String health = animalFile.nextLine();
                        final String feed = animalFile.nextLine();
                        animalFile.close();
                        if (health.contains("*****")) {
                            JOptionPane.showMessageDialog(null, health, "Warning : " + animal, 1);
                        }
                        else {
                            if (!feed.contains("*****")) {
                                continue;
                            }
                            JOptionPane.showMessageDialog(null, feed, "Warning : " + animal, 1);
                        }
                    }
                    catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    continue;
                }
                //Animal Habitat selection
                case 2: {
                    System.out.println("1.Habitat - Penguin ");
                    System.out.println("2.Habitat - Bird");
                    System.out.println("3.Habitat - Aquarium");
                    System.out.println("Select Habitat: ");
                    final int animalHabitat = Integer.parseInt(input.nextLine());
                    String habitat = "";
                    switch (animalHabitat) {
                        case 1: {
                            habitat = "Habitat - Penguin";
                            break;
                        }
                        case 2: {
                            habitat = "Habitat - Bird";
                            break;
                        }
                        case 3: {
                            habitat = "Habitat - Aquarium";
                            break;
                        }
                    }
                    try {
                        final Scanner infile = new Scanner(new File("habitats.txt"));
                        while (infile.hasNextLine() && !habitat.equals(infile.nextLine())) {}
                        final String temperature = infile.nextLine();
                        final String food = infile.nextLine();
                        final String cleanliness = infile.nextLine();
                        if (temperature.contains("*****")) {
                            JOptionPane.showMessageDialog(null, temperature, "Warning : " + habitat, 1);
                        }
                        else if (food.contains("*****")) {
                            JOptionPane.showMessageDialog(null, food, "Warning : " + habitat, 1);
                        }
                        else {
                            if (!cleanliness.contains("*****")) {
                                continue;
                            }
                            JOptionPane.showMessageDialog(null, cleanliness, "Warning : " + habitat, 1);
                        }
                    }
                    catch (FileNotFoundException e2) {
                        System.out.println(e2.getMessage());
                    }
                    continue;
                }
                case 3: {
                    // Zookeeper assignmnet uses zookeepers.txt for information
                    System.out.println("1.Zookeeper - Brad");
                    System.out.println("2.Zookeeper - Lynne");
                    System.out.println("3.Zookeeper - John");
                    System.out.println("Select Zookeeper: ");
                    final int zooKeeper = Integer.parseInt(input.nextLine());
                    String zooKpr = "";
                    // Now store which zookeeper has been assigned
                    switch (zooKeeper) {
                        case 1: {
                            zooKpr = "Zookeeper - Brad";
                            break;
                        }
                        case 2: {
                            zooKpr = "Zookeeper - Lynne";
                            break;
                        }
                        case 3: {
                            zooKpr = "Zookeeper - John";
                            break;
                        }

                    }
                    // Read info from the zookeepers.txt file
                    try {
                        final Scanner infile = new Scanner(new File("zookeepers.txt"));
                        while (infile.hasNextLine() && !zooKpr.equals(infile.nextLine())) {}
                        final String name = infile.nextLine();
                        final String speciality = infile.nextLine();
                        final String employeeId = infile.nextLine();
                        // Show information on the assigned zookeeper
                        if (name.contains("*****")) {
                            JOptionPane.showMessageDialog(null, name, "Warning : " + zooKpr, 1);
                        }
                        else if (speciality.contains("*****")) {
                            JOptionPane.showMessageDialog(null, speciality, "Warning : " + zooKpr, 1);
                        }
                        else {
                            if (!employeeId.contains("*****")) {
                                continue;
                            }
                            JOptionPane.showMessageDialog(null, employeeId, "Warning : " + zooKpr, 1);
                        }
                    }
                    catch (FileNotFoundException e2) {
                        System.out.println(e2.getMessage());
                    }
                    continue;

                }
                case 4: {
                    System.exit(0);
                    continue;
                }
            }
        }
    }
}