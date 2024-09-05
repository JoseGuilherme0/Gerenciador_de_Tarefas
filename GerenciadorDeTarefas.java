import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeTarefas {

    private List<Tarefa> tarefas;

    public GerenciadorDeTarefas(){
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String titulo, String descricao){
        Tarefa novaTarefa = new Tarefa(titulo, descricao);
        tarefas.add(novaTarefa);
        System.out.println("Tarefa adicionada com sucesso!!!");
    }

    public void listarTarefas(){
        if(tarefas.isEmpty()){
            System.out.println("Nenhuma tarefa cadastrada!!!");
            return;
        }
        for(int i = 0; i<tarefas.size(); i++){
            System.out.println((i+1)+". "+ tarefas.get(i));
        }
    }

    public void marcarComoConcluida(int indice){
        if(indice >0 && indice<=tarefas.size()){
            tarefas.get(indice-1).concluir();
            System.out.println("Tarefa marcada como concluída!!!");
        }else{
            System.out.println("Índice não encontrado!!!");
        }
    }

    public void removerTarefa(int indice){
        if(indice>0 && indice<= tarefas.size()){
            tarefas.remove(indice-1);
            System.out.println("Tarefa removida com sucesso!!!");
        }else{
            System.out.println("índice não encontrado!!!");
        }
    }
    
    public void menu(){
        Scanner sc = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("\n====Gerenciador de Tarefas====");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Marcar Tarefa como Concluída");
            System.out.println("4. Remover Tarefa");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o titulo da tarefa: ");
                    String titulo = sc.nextLine();
                    System.out.println("Digite a descrição da Tarefa: ");
                    String descricao = sc.nextLine();
                    adicionarTarefa(titulo, descricao);
                    break;
            
                case 2:
                    listarTarefas();
                    break;
                
                case 3:
                    System.out.println("Digite o número da Tarefa para marcá-la como concluída: ");
                    int indiceCloncluido = sc.nextInt();
                    marcarComoConcluida(indiceCloncluido);
                    break;

                case 4: 
                    System.out.println("Digite o número da Tarefa que deseja remover: ");
                    int indiceRemovido = sc.nextInt();
                    removerTarefa(indiceRemovido);
                    break;
                
                case 0:
                    System.out.println("Saindo do Gerenciador...");
                    break;
                
                default:
                    System.out.println("Opção não encontrada!!!");
                    break;
            }
        }while (opcao != 0);

        sc.close();
    }
}
