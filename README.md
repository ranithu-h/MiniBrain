# MiniBrain 🧠

A biologically-inspired neural network simulation written in Java for a university project.

MiniBrain is a lightweight self-learning artificial brain that uses neurons, weighted connections, reinforcement, and memory persistence to recognise patterns and learn new concepts interactively.

Unlike traditional beginner “if-statement AI” projects, MiniBrain is built around actual neural-style architecture:

* neurons
* synaptic connections
* activation spreading
* reinforcement learning
* inhibitory/positive signals
* long-term memory storage

---

# Features

 Custom Neuron Architecture
 Weighted Neural Connections
 Positive & Negative Signal System
 Reinforcement Learning
 Persistent Memory using File Storage
 Dynamic Concept Learning
 Interactive Training
 Object Recognition based on Features
 Pure Java (No External Libraries)

---

# How It Works

MiniBrain learns concepts through feature associations.

Example:

Input:

```text
big grey water
```

If the system does not recognise the pattern, it asks the user:

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
