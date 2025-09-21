import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe a quantidade de emprestimos que deseja cadastrar: ");
        int qtdEmprestimos = sc.nextInt();

        Emprestimo[] emprestimos = new Emprestimo[qtdEmprestimos];
        int emprestimosCadastrados = 0;

        int opcao = 0;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar Emprestimo");
            System.out.println("2 - Imprimir um Emprestimo");
            System.out.println("3 - Imprimir Todos Emprestimos");
            System.out.println("4 - Alterar Status da Midia");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = sc.nextInt();

            switch(opcao){
                case 1:
                    if(emprestimosCadastrados < qtdEmprestimos){
                        Emprestimo emprestimo = new Emprestimo(); //Cria um novo objeto emprestimo

                        System.out.println("Informe o nome do cliente: ");
                        emprestimo.cliente = sc.next();
                        System.out.println("Informe a data do emprestimo: ");
                        emprestimo.data = sc.next();
                        System.out.print("Informe a quantidade de midias para este emprestimo: ");
                        int qtdMidias = sc.nextInt();

                        //objeto   atributo
                        emprestimo.midias = new Midia[qtdMidias]; // Inicializa o array de midias

                        for(int i = 0; i < qtdMidias; i++){
                            System.out.println("\nInforme os dados da Midia " + (i + 1) + ":");
                            System.out.println("Informe o tipo da midia: ");
                            String tipo = sc.next();
                            System.out.println("Informe a descricao da midia: ");
                            String descricao = sc.next();
                            System.out.println("Informe o valor da midia: ");
                            float valor = sc.nextFloat();

                            emprestimo.midias[i] = new Midia(tipo, descricao, valor);
                        }

                        emprestimos[emprestimosCadastrados] = emprestimo;
                        emprestimosCadastrados++;
                        System.out.println("Emprestimo cadastrado com sucesso!");
                    } else {
                        System.out.println("Limite de emprestimos atingido!");
                    }
                    break;
                case 2:
                    System.out.print("Informe o indice do emprestimo (1 a " + emprestimosCadastrados + "): ");
                    int idx = sc.nextInt() - 1;
                    if(idx >= 0 && idx < emprestimosCadastrados){
                        Emprestimo e = emprestimos[idx];
                        e.impressaoDados();
                    } else {
                        System.out.println("Indice invalido!");
                    }
                    break;
                case 3:
                    if(emprestimosCadastrados == 0){
                        System.out.println("Nenhum emprestimo cadastrado");
                    } else {
                        for(int i = 0; i < emprestimosCadastrados; i++) {
                            System.out.println("\nEmprestimo " + (i + 1) + ":");
                            emprestimos[i].impressaoDados();
                        }
                    }
                    break;

                    //Criei uma quarta opcao para alterar o status da midia
                case 4:
                    System.out.print("Informe o indice do emprestimo para alterar o status da midia (1 a " + emprestimosCadastrados + "): ");
                    int empIdx = sc.nextInt()-1;
                    sc.nextLine();
                    if(empIdx >= 0 && empIdx <emprestimosCadastrados){
                        Emprestimo emprestimo = emprestimos[empIdx];
                        System.out.print("Informe o indice da midia para alterar o status (1 a " + emprestimo.midias.length + "): ");
                        int midiaIdx = sc.nextInt() - 1;
                        
                        if(midiaIdx >= 0 && midiaIdx < emprestimo.midias.length) {
                            emprestimo.midias[midiaIdx].alterarStatus();
                            System.out.println("Status da midia alterado com sucesso!");
                        } else {
                            System.out.println("Indice de midia invalido!");
                        }
                    }

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while(opcao != 0);

        sc.close();
    }
}
