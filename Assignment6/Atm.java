import java.util.HashMap;

public class Atm {
    private float availableAmountInMachine;
    private float transactionFee;
    private HashMap<Integer, UserData> userArchive;
    private UserData currentUser;
    private static final double transactionFeeRate = 0.001;


    public Atm(int availableAmountInMachine, float transactionFee, HashMap<Integer, UserData> userArchive) {
        this.availableAmountInMachine = availableAmountInMachine;
        this.transactionFee = transactionFee;
        this.userArchive = userArchive;
    }

    public float getAvailableAmountInMachine() {
        return availableAmountInMachine;
    }

    public void setAvailableAmountInMachine(float availableAmountInMachine) {
        this.availableAmountInMachine = availableAmountInMachine;
    }

    public float getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(float money) {
        this.transactionFee = Math.round(money * transactionFeeRate);
    }


    public void addNewAccount(int bankAccountNumber, int password, String name, int age, String address, int phoneNumber){
        if(password == 0 || password < 100000 || password >= 1000000){
            throw new RuntimeException("invalid password, must be non-empty 6-digit");
        }
        if(userArchive.containsKey(bankAccountNumber)){
            throw new RuntimeException("user already exist");
        }
        this.currentUser = new UserData(bankAccountNumber, password, name, age, address, phoneNumber);
        userArchive.put(bankAccountNumber, currentUser);
    }
    public void resetPassword(int bankAccountNumber, String name, int age, int phoneNumber, int newPassword){
        if (!userArchive.containsKey(bankAccountNumber)){
            throw new RuntimeException("account does not exist");
        }
        User tobeVerified = userArchive.get(bankAccountNumber).getUser();
        if(name == tobeVerified.getName() && age == tobeVerified.getAge() && phoneNumber == tobeVerified.getPhoneNumber()){
            userArchive.get(bankAccountNumber).setPassword(newPassword);
        }else{
            throw new RuntimeException("not able to verify this account");
        }
    }
    public void changePassword(int newPassword){
        currentUser.setPassword(newPassword);
    }
    public void withdraw(float money){
        if(money < getAvailableAmountInMachine()) {
            throw new RuntimeException("not enough money in machine");
        }
        if(money < currentUser.getAvailableBalance()){
            throw new RuntimeException("not enough money in your account");
        }
        float previousBalance = currentUser.getAvailableBalance();
        setTransactionFee(money);
        setAvailableAmountInMachine(getAvailableAmountInMachine()-money);
        float transactionTotal = getTransactionFee() + money;
        float newBalance = previousBalance - transactionTotal;
        currentUser.setAvailableBalance(newBalance);
        currentUser.recordTransaction("Withdraw",transactionTotal);

    }
    public void deposit(float money){
    setTransactionFee(money);
    setAvailableAmountInMachine(getAvailableAmountInMachine() + money);
    currentUser.setAvailableBalance(currentUser.getAvailableBalance() + money - getTransactionFee());
    currentUser.recordTransaction("Deposit", money - getTransactionFee());
    }
}
