package bankaccess;

import java.util.Scanner;
public class CaixaEletronico {
    public static void main(String[] args) {
        String inputId;
        String inputPassword;
        int inputNumAccount;
        String confirmPass;
        String inputCPF;
        double inputValue;
        boolean exit=false;
        Scanner sc = new Scanner(System.in);
        VerifyCPF cpf = new VerifyCPF(null);
        AccountData account=new AccountData(null, null,null,0);
        do {
            System.out.println("Olá, seja bem vindo!\nSelecione uma das opções abaixo:\n\n1 - Criar conta;\n2 - Acessar conta;\n3 - Sair.\n");
            int inputOption = sc.nextInt();
            sc.nextLine();
            switch (inputOption) {
                case 1:
                    System.out.println("Digite seu nome:");
                    inputId = sc.nextLine();
                    do {
                        System.out.println("\nDigite seu CPF, sem hifen:");
                        inputCPF = sc.next();
                        inputCPF=inputCPF.substring(0,11);
                        cpf.setCPF(inputCPF);
                        System.out.println(!cpf.isCPF()? "\nNúmero de CPF inválido! Favor, digite novamente:": "CPF verificado!");
                    }while(!cpf.isCPF());
                    do {
                        System.out.println("Defina uma senha:");
                        inputPassword = sc.next();
                        System.out.println("Confirme sua senha:");
                        confirmPass = sc.next();
                        System.out.println(!inputPassword.equals(confirmPass) ? "Senha não coincide! Defina novamente repetindo exatamente a senha na segunda vez:" : null);
                    }while (!inputPassword.equals(confirmPass)) ;
                    account.setId(inputId);
                    account.setPassword(inputPassword);
                    account.setCpf(inputCPF);
                    System.out.println("Parabéns! Conta criada com sucesso! O número de sua conta corrente é: "+account.getNumAcount());
                    break;
                case 2:
                    do{
                        System.out.println("Digite o número de sua conta corrente:");
                        inputNumAccount=sc.nextInt();
                        System.out.println("Digite sua senha:");
                        inputPassword=sc.next();
                        System.out.println((inputNumAccount==account.getNumAcount()) && inputPassword.equals(account.getPassword()) ? "Login efetuado com sucesso!": "Conta e/ou senha invalida!");
                    }while((inputNumAccount!=account.getNumAcount()) || !inputPassword.equals(account.getPassword()));
                    do{
                        System.out.println("*************************************\n\nDados do Cliente:\n\nNome: "+account.getId()+"\nConta corrente: "+account.getNumAcount()+"\nCPF: "+account.getCpf()+"\n\n*************************************");
                        System.out.println("Selecione uma das opções: \n\n1 - Consultar saldo;\n2 - Depositar;\n3 - Sacar/Transferir dinheiro;\n4 - Sair.");
                        inputOption=sc.nextInt();
                        switch(inputOption){
                            case 1:
                                System.out.println(account.printBalance());
                                break;
                            case 2:
                                System.out.println("Qual o valor de deseja depositar?");
                                inputValue=sc.nextDouble();
                                account.setBalance(account.getBalance()+inputValue);
                                System.out.println("Valor depositado com sucesso!");
                                System.out.println(account.printBalance());
                                break;
                            case 3:
                                System.out.println("Qual o valor deseja sacar/transferir?");
                                inputValue=sc.nextDouble();
                                if (inputValue>account.getBalance()){
                                    System.out.println("Saldo insuficiente!");
                                    break;
                                }
                                account.setBalance(account.getBalance()-inputValue);
                                System.out.println("Transferência efetuada com sucesso!");
                                System.out.println(account.printBalance());
                                break;
                            case 4:
                                exit=true;
                                break;
                            default:
                                System.out.println("Opção invalida! Tente novamente:");
                        }
                    }while(!exit);
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Opção invalida!Tente novamente.");
            }
        }while(!exit);
        System.out.println("Sessão encerrada. Volte sempre!");
        sc.close();
    }
}