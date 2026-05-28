import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Brain brain = new Brain();

        System.out.println("=== MINI BRAIN ===");

        while (true) {

            System.out.println("\nEnter features:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {

                brain.saveMemory();

                System.out.println("Memory saved.");

                break;
            }

            String[] features = input.split(" ");

            String result = brain.recognise(features);

            if (result == null) {

                System.out.println("I don't know this object.");
                System.out.println("What is it?");

                String correctObject = scanner.nextLine();

                brain.learn(correctObject, features);

            } else {

                System.out.println("I think this is: " + result);

                System.out.println("Am I correct? (yes/no)");

                String answer = scanner.nextLine();

                if (answer.equalsIgnoreCase("yes")) {

                    brain.reinforce(result, features);

                } else {

                    System.out.println("What is it really?");

                    String correctObject = scanner.nextLine();

                    brain.learn(correctObject, features);
                }
            }
        }

        scanner.close();
    }
}