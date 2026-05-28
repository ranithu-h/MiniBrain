import java.util.ArrayList;

public class Neuron {

    String name;
    int activation;

    ArrayList<Connection> connections;

    public Neuron(String name) {

        this.name = name;
        this.activation = 0;

        connections = new ArrayList<>();
    }

    // Connect this neuron to another neuron
    public void connectTo(Neuron target, int weight) {

        connections.add(new Connection(target, weight));
    }

    // Send signals through all connections
    public void fire() {

        for (Connection c : connections) {

            c.target.activation += c.weight;
        }
    }

    // Reset activation
    public void reset() {

        activation = 0;
    }
}