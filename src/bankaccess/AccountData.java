package bankaccess;

import java.text.DecimalFormat;
import java.util.Random;

public class AccountData {
    private int numAcount;
    private String id;
    private String password;
    private String cpf;
    private double balance=0;
    DecimalFormat format=new DecimalFormat("#.00");
    //builders
    public AccountData(String id, String password, String cpf, double balance){
        this.id=id;
        this.password=password;
        this.balance=balance;
        this.cpf=cpf;
        Random num=new Random();
        this.numAcount=num.nextInt(10000);
    }
    //setters
    public void setId(String id) {
        this.id = id;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setCpf(String cpf){
        this.cpf=cpf;
    }
    //getters
    public double getBalance() {
        return balance;
    }
    public String getPassword() {
        return password;
    }
    public String getId() {
        return id;
    }
    public String getCpf() {
        return cpf;
    }

    public int getNumAcount() {
        return numAcount;
    }

    //Balance computer
    public String printBalance(){
        String balance= format.format(this.balance);
        return "Seu saldo atual é de R$ "+balance;
    }

}
