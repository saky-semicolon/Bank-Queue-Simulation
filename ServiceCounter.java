import java.util.LinkedList;
import java.util.Queue;

public class ServiceCounter {
    private Queue<Customer> queue;
    private int totalServiceTime;
    private int customersServed;
    
    public ServiceCounter() {
        queue = new LinkedList<>();
        totalServiceTime = 0;
        customersServed = 0;
    }
    
    public void addCustomer(Customer customer) {
        queue.add(customer);
    }
    
    public void processQueue(int currentTime) {
        if (!queue.isEmpty()) {
            Customer customer = queue.peek();
            if (customer.getServiceStartTime() == 0) {
                customer.setServiceStartTime(currentTime);
            }
            if (currentTime - customer.getServiceStartTime() >= customer.getServiceTime()) {
                totalServiceTime += customer.getServiceTime();
                customersServed++;
                queue.poll();
            }
        }
    }
    
    public int getQueueLength() {
        return queue.size();
    }
    
    public int getTotalServiceTime() {
        return totalServiceTime;
    }
    
    public int getCustomersServed() {
        return customersServed;
    }
}
