public class Customer {
    private int arrivalTime;
    private int serviceTime;
    private int serviceStartTime;
    
    public Customer(int arrivalTime, int serviceTime) {
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.serviceStartTime = 0;
    }
    
    public int getArrivalTime() {
        return arrivalTime;
    }
    
    public int getServiceTime() {
        return serviceTime;
    }
    
    public int getServiceStartTime() {
        return serviceStartTime;
    }
    
    public void setServiceStartTime(int serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }
}
