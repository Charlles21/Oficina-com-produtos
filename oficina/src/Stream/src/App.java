import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import Classes.*;
import Sistema.Metodos;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner imput = new Scanner (System.in); // Entrada de dados
        Produtos produtos = new Produtos(); //classe produtos instanciada  
        Venda vendas = new Venda();  
        Metodos metodos = new Metodos();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");         
        String PesquisaProduto, DataVendaInicio, DataVendaFim;
        int RefazData=1;
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataFim = LocalDate.now();           
        int opcao;

        metodos.entradaDeDados();      
        
        //repetiçao o menu
        do{
            //Menu de opçoes

            Menu();
            System.out.print("opcao: ");
            opcao = imput.nextInt();     
            imput.nextLine(); // pra tirar o ENTER

            
            switch (opcao){
                case 1:                

                    //cadastro dos produtos
                    System.out.print("Nome do Produto: ");
                    produtos.setNome(imput.nextLine());

                    System.out.print("Valor do produto:");
                    produtos.setValor(imput.nextDouble());

                    System.out.print("Quantidada em Estoque: ");
                    produtos.setEstoque(imput.nextInt());                   

                    System.out.print("Codigo do produto: ");
                    produtos.setCodigo(imput.nextInt());                            
                    imput.nextLine();// tira enter
                    metodos.incluirProduto(produtos.getNome(), produtos.getCodigo(), produtos.getEstoque(), produtos.getValor());  
                                                
                   System.out.print("Digite enter para continuar!");
                   imput.nextLine();
                    
                break;

                case 2:              

                    System.out.print("Digite o nome do produto: ");
                    PesquisaProduto = imput.nextLine();
                    metodos.Consultar(PesquisaProduto);  

                                
                break;
                case 3:

              

               break;
               
                case 4:
                
                do{
                    System.out.print("data INICIO da venda caso for data atual apenas digite enter: ");
                    DataVendaInicio = imput.nextLine();

                    if (DataVendaInicio.equals("")) { // apertou enter
                        dataAtual = LocalDate.now();
                        RefazData = 1;
                    } else {

                        try {
                            dataAtual = LocalDate.parse(DataVendaInicio, dtf);
                        } catch (Exception e) {
                            System.out.println("Data inválida");
                            RefazData = 2;
                            imput.nextLine();
                            
                        }
                    } 

                }while(RefazData == 2);

                do{
                    System.out.print("data FIM  da venda caso for data atual apenas digite enter: ");
                    DataVendaFim = imput.nextLine();

                    if (DataVendaFim.equals("")) { // apertou enter
                        dataFim = LocalDate.now();
                        RefazData = 1;
                    } else {

                        try {
                            dataFim = LocalDate.parse(DataVendaFim, dtf);
                        } catch (Exception e) {
                            System.out.println("Data inválida");
                            RefazData = 2;
                            imput.nextLine();
                            
                        }
                    } 

                }while(RefazData == 2);

                try {
                    metodos.Relatorio(dataAtual, dataFim);
                } catch (Exception e) {
                    System.out.println( e.getMessage() );
                }
                
                System.out.println("\nPressione ENTER para continuar");
                imput.nextLine();    

                break;
                             
                
                case 5:
               //ATENÇAO!! VENDAS DOS PRODUTOS:

                System.out.print("Nome do produto pra relizar a venda: ");
                PesquisaProduto = imput.nextLine();

                System.out.print("Quantidade Vendida: ");
                vendas.setQuantidade(imput.nextInt());

                imput.nextLine();   

               
                do{
                    System.out.print("data da venda caso for data atual apenas digite enter: ");
                    DataVendaInicio = imput.nextLine();

                    if (DataVendaInicio.equals("")) { // apertou enter
                        dataAtual = LocalDate.now();
                        RefazData = 1;
                    } else {

                        try {
                            dataAtual = LocalDate.parse(DataVendaInicio, dtf);
                        } catch (Exception e) {
                            System.out.println("Data inválida");
                            RefazData = 2;
                            imput.nextLine();
                            
                        }
                    } 

                }while(RefazData == 2);
                               

                metodos.realizarVenda(PesquisaProduto, vendas.getQuantidade(),dataAtual);

                System.out.println("digite enter pra ir pro menu");
                imput.nextLine();
               
               
               break;
               
               
                         
               default:
                System.out.println("opçao invalida!");
                    break;
            }

        }while(opcao!=0);
        
        
        imput.close();

    }
    public static void Menu(){

            System.out.println("\n[1] <-> incluir produto");
            System.out.println("[2] <-> Consultar produto");
            System.out.println("[3] <-> Listar todos Produtos");
            System.out.println("[4] <-> Relatorio de vendas [Analitico]");
            System.out.println("[5] <-> Realizar vendas");           
            System.out.println("[0] <-> sair");                 

    }
    
}
