# MiniBrain 🧠

MiniBrain is a simple biologically-inspired neural network simulation written in Java for a university project.

The project was built to explore how learning and memory can be represented using neurons, weighted connections, and reinforcement rather than hardcoded decision-making.

Instead of using modern AI frameworks or machine learning libraries, MiniBrain focuses on building the core neural concepts manually using object-oriented programming.

---

## Features

* Neural architecture using custom classes
* Weighted neuron connections
* Positive and inhibitory signals
* Reinforcement-based learning
* Persistent memory using file storage
* Interactive object learning
* Pattern recognition from features
* Pure Java implementation

---

## How It Works

The system learns through feature associations.

For example, if the user enters:

big grey water

and the system has never seen those features before, it asks the user what the object is.

If the user answers with "hippo", the network creates weighted neural pathways between the feature neurons and the HIPPO neuron.

Over time, repeatedly recognising the same object strengthens those pathways, making future recognition more accurate.

---

## Project Structure

### Neuron.java

Represents a neuron in the network.

Each neuron stores:

* a name
* an activation value
* outgoing neural connections

---

### Connection.java

Represents a synapse between neurons.

Each connection stores:

* a target neuron
* a connection weight

Positive weights strengthen activation while negative weights inhibit activation.

---

### Brain.java

Acts as the control center of the system.

Responsible for:

* learning
* recognition
* reinforcement
* memory management
* loading and saving learned data

---

### Main.java

Handles user interaction and program execution.

---

## Example

First interaction:

Enter features:
big grey water

I don't know this object.
What is it?

hippo

After learning:

Enter features:
grey water big

I think this is: hippo

---

## Memory System

Learned connections are stored inside a memory.txt file so the network can retain knowledge between executions.

Example stored data:

big -> hippo : 2
grey -> hippo : 3
water -> hippo : 4

The values represent the strength of each neural pathway.

---

## Reinforcement Learning

Whenever the network correctly identifies an object, the related connection weights are strengthened.

This simulates how repeated usage strengthens memory pathways in biological neural systems.

---

## Technologies Used

* Java
* Object-Oriented Programming
* File Persistence
* Basic Neural Network Concepts
* Reinforcement Learning Concepts



```text
I don't know this object.
What is it?
```

User:

```text
hippo
```

The brain then creates neural pathways:

```text
BIG -> HIPPO
GREY -> HIPPO
WATER -> HIPPO
```

Each connection stores a weight representing memory strength.

The more the brain correctly recognises a concept, the stronger the neural pathways become.

---

# Neural Architecture

The project is structured around four main classes:

## Neuron.java

Represents a neuron in the network.

Stores:

* neuron name
* activation value
* outgoing neural connections

---

## Connection.java

Represents a synapse/pathway between neurons.

Stores:

* target neuron
* connection weight

Positive weights excite neurons.
Negative weights inhibit neurons.

---

## Brain.java

Acts as the control center of the network.

Responsible for:

* learning
* recognition
* reinforcement
* memory persistence
* neuron management

---

## Main.java

Handles:

* user interaction
* input
* training flow

---

# Example Session

```text
Enter features:
big grey water

I don't know this object.
What is it?

hippo

Learned: hippo
```

Later:

```text
Enter features:
grey water big

I think this is: hippo
```

---

# Memory System

MiniBrain stores learned neural connections inside:

```text
memory.txt
```

Example stored pathways:

```text
big,hippo,2
grey,hippo,3
water,hippo,4
```

This allows the brain to retain knowledge between executions.

---

# Reinforcement Learning

When the brain correctly identifies an object, the associated neural pathways become stronger.

Example:

```text
BIG -> HIPPO = 2
```

After reinforcement:

```text
BIG -> HIPPO = 3
```

This simulates biological memory strengthening.

---

# Technologies Used

* Java
* Object-Oriented Programming
* File Persistence
* Neural Network Concepts
* Reinforcement Learning Concepts

---
