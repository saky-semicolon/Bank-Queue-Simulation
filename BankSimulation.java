import java.util.ArrayList;
import java.util.Scanner;

public class BankSimulation {
    private ArrayList<ServiceCounter> serviceCounters;
    private int numberOfCounters;
    private int numberOfCustomers;
    private int serviceTimePerCustomer;
    private int customerArrivalRate;
    
    public BankSimulation(int numberOfCounters, int numberOfCustomers, int serviceTimePerCustomer, int customerArrivalRate) {
        this.numberOfCounters = numberOfCounters;
        this.numberOfCustomers = numberOfCustomers;
        this.serviceTimePerCustomer = serviceTimePerCustomer;
        this.customerArrivalRate = customerArrivalRate;
        serviceCounters = new ArrayList<>();
        for (int i = 0; i < numberOfCounters; i++) {
            serviceCounters.add(new ServiceCounter());
        }
    }
    
    public void runSimulation() {
        int currentTime = 0;
        int customersProcessed = 0;
        
        while (customersProcessed < numberOfCustomers) {
            for (int i = 0; i < numberOfCounters; i++) {
                serviceCounters.get(i).processQueue(currentTime);
            }
            
            if (currentTime % customerArrivalRate == 0 && customersProcessed < numberOfCustomers) {
                Customer newCustomer = new Customer(currentTime, serviceTimePerCustomer);
                ServiceCounter shortestQueueCounter = getShortestQueueCounter();
                shortestQueueCounter.addCustomer(newCustomer);
                customersProcessed++;
            }
            
            currentTime++;
        }
        
        printResults(currentTime);
    }
    
    private ServiceCounter getShortestQueueCounter() {
        ServiceCounter shortestQueueCounter = serviceCounters.get(0);
        for (ServiceCounter counter : serviceCounters) {
            if (counter.getQueueLength() < shortestQueueCounter.getQueueLength()) {
                shortestQueueCounter = counter;
            }
        }
        return shortestQueueCounter;
    }
    
    private void printResults(int totalTime) {
        System.out.println("Total time taken to serve all customers: " + totalTime + " minutes");
        for (int i = 0; i < numberOfCounters; i++) {
            ServiceCounter counter = serviceCounters.get(i);
            System.out.println("Counter #" + (i + 1) + " served " + counter.getCustomersServed() + " customers");
            System.out.println("Average service time per customer: " + (counter.getTotalServiceTime() / (double) counter.getCustomersServed()) + " minutes");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter number of service counters: ");
        int numberOfCounters = scanner.nextInt();
        
        System.out.println("Enter number of customers: ");
        int numberOfCustomers = scanner.nextInt();
        
        System.out.println("Enter time each customer will take at the counter: ");
        int serviceTimePerCustomer = scanner.nextInt();
        
        System.out.println("Enter rate of customer arrival at the bank (in minutes): ");
        int customerArrivalRate = scanner.nextInt();
        
        BankSimulation simulation = new BankSimulation(numberOfCounters, numberOfCustomers, serviceTimePerCustomer, customerArrivalRate);
        simulation.runSimulation();
    }
}
