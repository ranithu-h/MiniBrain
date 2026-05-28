import java.io.*;
import java.util.*;

public class Brain {

    HashMap<String, Neuron> neurons;

    public Brain() {

        neurons = new HashMap<>();

        loadMemory();
    }

    // Create neuron if it doesn't exist
    public Neuron getNeuron(String name) {

        name = name.toLowerCase();

        if (!neurons.containsKey(name)) {

            neurons.put(name, new Neuron(name));
        }

        return neurons.get(name);
    }

    // Learn new object
    public void learn(String objectName, String[] features) {

        objectName = objectName.toLowerCase();

        Neuron objectNeuron = getNeuron(objectName);

        for (String feature : features) {

            feature = feature.toLowerCase();

            Neuron featureNeuron = getNeuron(feature);

            boolean connectionExists = false;

            for (Connection c : featureNeuron.connections) {

                if (c.target == objectNeuron) {

                    c.weight += 1;
                    connectionExists = true;
                    break;
                }
            }

            // Create new connection
            if (!connectionExists) {

                featureNeuron.connectTo(objectNeuron, 1);
            }
        }

        System.out.println("Learned: " + objectName);
    }

    // Recognise object
    public String recognise(String[] features) {

        // Reset all activations
        for (Neuron n : neurons.values()) {

            n.reset();
        }

        // Activate feature neurons
        for (String feature : features) {

            feature = feature.toLowerCase();

            if (neurons.containsKey(feature)) {

                Neuron featureNeuron = neurons.get(feature);

                featureNeuron.fire();
            }
        }

        String bestMatch = null;
        int highestActivation = 0;

        // Find strongest activated neuron
        for (Neuron n : neurons.values()) {

            if (n.activation > highestActivation) {

                highestActivation = n.activation;
                bestMatch = n.name;
            }
        }

        // Confidence threshold
        if (highestActivation < 2) {

            return null;
        }

        return bestMatch;
    }

    // Strengthen memory
    public void reinforce(String objectName, String[] features) {

        objectName = objectName.toLowerCase();

        Neuron objectNeuron = getNeuron(objectName);

        for (String feature : features) {

            feature = feature.toLowerCase();

            Neuron featureNeuron = getNeuron(feature);

            for (Connection c : featureNeuron.connections) {

                if (c.target == objectNeuron) {

                    c.weight += 1;
                }
            }
        }

        System.out.println("Memory strengthened.");
    }

    // Save memory to text file
    public void saveMemory() {

        try {

            PrintWriter writer = new PrintWriter("memory.txt");

            for (Neuron n : neurons.values()) {

                for (Connection c : n.connections) {

                    writer.println(
                            n.name + "," +
                                    c.target.name + "," +
                                    c.weight
                    );
                }
            }

            writer.close();

        } catch (Exception e) {

            System.out.println("Error saving memory.");
        }
    }

    // Load memory from text file
    public void loadMemory() {

        try {

            File file = new File("memory.txt");

            if (!file.exists()) {
                return;
            }

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                String[] parts = line.split(",");

                String from = parts[0];
                String to = parts[1];
                int weight = Integer.parseInt(parts[2]);

                Neuron fromNeuron = getNeuron(from);
                Neuron toNeuron = getNeuron(to);

                fromNeuron.connectTo(toNeuron, weight);
            }

            scanner.close();

        } catch (Exception e) {

            System.out.println("Error loading memory.");
        }
    }
}