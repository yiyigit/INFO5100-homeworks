import java.util.LinkedList;

public class UserData {
    private static final int MaxTransaction = 10;
    private int password;
    private User user;
    private float availableBalance;
    private LinkedList<String> recentTransactions;


    public void setPassword(int password) {
        this.password = password;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public User getUser() {
        return user;
    }


    public void setAvailableBalance(float availableBalance) {
        this.availableBalance = availableBalance;
    }

    public void setRecentTransactions(LinkedList<String> recentTransactions) {
        this.recentTransactions = recentTransactions;
    }


    public int getPassword() {
        return password;
    }

    public float getAvailableBalance() {
        return availableBalance;
    }

    public LinkedList<String> getRecentTransactions() {
        return recentTransactions;
    }
    public void recordTransaction(String action, float amount){
        if(this.recentTransactions.size() >= MaxTransaction){
            this.recentTransactions.removeFirst();
        }
        this.recentTransactions.add(action + " - "+ amount);
    }


    public UserData(int bankAccountNumber, int password, String name, int age, String address, int phoneNumber ){
        this.user = new User(name, age, address,phoneNumber,bankAccountNumber);
        this.password = password;
        setAvailableBalance(0);
        setRecentTransactions(new LinkedList<>());
    }

}
