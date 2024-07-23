
# Bank Queue Simulation

This project simulates the queue management system at a bank's service counters using Java. It aims to optimize customer service and reduce waiting times.

## Features

- **Queue Management:** Simulates customer queues at multiple service counters.
- **Customer Handling:** Manages customer arrival, service time, and waiting time.
- **Performance Analysis:** Provides insights into queue efficiency and customer satisfaction.

## Project Structure

- **Queue Data Structure:** Implements a FIFO queue using Java's `LinkedList`.
- **Customer Class:** Represents a customer with attributes like arrival time, service time, and start time.
- **ServiceCounter Class:** Manages individual service counters, queue length, and total service time.
- **BankSimulation Class:** Controls the simulation, including customer assignment to counters and overall performance metrics.

## How to Run

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/yourusername/bank-queue-simulation.git
    cd bank-queue-simulation
    ```

2. **Compile the Code:**
   ```bash
   javac BankSimulation.java
   ```

3. **Run the Simulation:**
   ```bash
   java BankSimulation
   ```

4. **Input Parameters:**
   - Number of service counters
   - Number of customers
   - Time each customer will take at the counter
   - Rate of customer arrival at the bank (in minutes)

## Example

```plaintext
Enter number of service counters: 2
Enter number of customers: 5
Enter time each customer will take at the counter: 4
Enter rate of customer arrival at the bank (in minutes): 2
```

## Output

The simulation will output the total time taken to serve all customers, the number of customers served by each counter, and the average service time per customer.

## Project Report

Find the project report <a href="https://github.com/saky-semicolon/Bank-Queue-Simulation/blob/main/Report_Bank%20Queue%20Simulation.pdf">here</a>

<hr>
S M Asiful Islam Saky

