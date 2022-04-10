
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner imput = new Scanner (System.in); // Entrada de dados
        Produtos prd = new Produtos(); //classe produtos instanciada        
        List<Produtos> Lista = new ArrayList<Produtos>(); // array lista pra salvar os dados      
        String PesquisaProduto;
        int qtdvendida;
        int qtdEstoque;   
        boolean achado = false;
        int opcao;                                  
        
        //Produtos de Testes
        Lista.add(new Produtos(11,"carno de descarga", 157.97,0,7));
        Lista.add(new Produtos(57,"tinta vermelha com verniz", 54.5,0,14));
        Lista.add(new Produtos(987,"volante ferrari 478", 247.99,0,6));
        Lista.add(new Produtos(3265,"parabriza blindado", 2547.94,0,3));
        Lista.add(new Produtos(14,"mocinetica crossfox 2011", 895.0,0,4));
        Lista.add(new Produtos(87,"filtro de oleo", 21.98,0,1));
        Lista.add(new Produtos(36,"balança fusca 1987", 1274.97,0,9));
        
        
        //repetiçao o menu
        do{
            //Menu de opçoes
            System.out.println("\n[1] <-> incluir produto");
            System.out.println("[2] <-> Consultar produto");
            System.out.println("[3] <-> Listar todos Produtos");
            System.out.println("[4] <-> Relatorio de vendas [Analitico]");
            System.out.println("[5] <-> Realizar vendas");
            System.out.println("[6] <-> Editar Informações");
            System.out.println("[0] <-> sair");
            System.out.print("opcao: ");
            opcao = imput.nextInt();          


            imput.nextLine(); // pra tirar o ENTER

            
            switch (opcao){
                case 1:                

                    //cadastro dos produtos
                    System.out.print("Nome do Produto: ");
                    prd.setNome(imput.nextLine());

                    System.out.print("Valor do produto:");
                    prd.setValor(imput.nextDouble());

                    System.out.print("Quantidada em Estoque: ");
                    prd.setEstoque(imput.nextInt());                   

                    System.out.print("Codigo do produto: ");
                    prd.setCodigo(imput.nextInt());                             

                    Lista.add(prd);// salva o que foi posto em cima nos cadastros                                                                                
                    prd = new Produtos(); //cria o novo construtor para que seja salvo novos dados   
                                                
                   
                    
                break;

                case 2:               

                if(Lista.isEmpty()){
                    System.out.println("\nlista esta vazia!\n");
                }
                else{
                    
                System.out.println("Digite o Nome do produto: ");
                PesquisaProduto = imput.nextLine();

               for (Produtos produtos : Lista) { //acessa o construtor dentro da lista 

                    if(PesquisaProduto.equals(produtos.getNome())){//pesquisa a variavel e compara com o produtos.getNome()
                        
                        System.out.printf("\nencontrado! %s",produtos.toString());                   

                    }                                           
                  }
                  if(achado){
                    System.out.println("Nao foi encontrado!");
                  }                                          
                }               
                                
                break;
               case 3:

               if(Lista.isEmpty()){
                System.out.println("\nlista esta vazia!\n");
                
                }
                else{

                    Lista.stream()
                    .forEach(System.out::println);
                } 

               break;
               
               case 4:

               if(Lista.isEmpty()){
                System.out.println("\nlista esta vazia!\n");
               }
               else{                 

              
                          

               }               
                
               case 5:

               if(Lista.isEmpty()){
                System.out.println("\nlista esta vazia!\n");
            }
            else{
                
            System.out.println("Digite o Nome do produto: ");
            PesquisaProduto = imput.nextLine();

            for (Produtos produtos : Lista) { //acessa o construtor dentro da lista 

                if(PesquisaProduto.equals(produtos.getNome())){//pesquisa a variavel e compara com o produtos.getNome()
                    
                    System.out.printf("\nencontrado! %s",produtos.toString());

                    if(produtos.getEstoque()<=0){
                        System.out.println("Produto nao se encontra em Estoque!!");

                    }

                    else{

                            System.out.print("Quantidade Vendida: ");
                            qtdvendida = imput.nextInt();                            
                            produtos.setQuantidade(qtdvendida);
                            qtdEstoque = produtos.getEstoque();

                        
                        if(produtos.getEstoque()>=produtos.getQuantidade()){                            

                            System.out.println("\n**********************VENDA REALIZADA**********************\n");                    
                            System.out.printf("Produto Vendido %s \nValor Vendido: R$ %s ",produtos.Relatorio(), prd.venda(produtos.getValor(),produtos.getQuantidade()));           
                            
                            qtdEstoque =- qtdvendida;
                            produtos.setEstoque(qtdEstoque);
                            
                            
                        }           

                    }
                
                }  

              }
              if(achado){
                System.out.println("Nao foi encontrado!");
              }                                          
            }  
               
               break;
               
               case 6:
               if(Lista.isEmpty()){
                System.out.println("\nlista esta vazia!\n");
                }                
                else{
                
                System.out.println("Digite o Nome do produto: ");
                PesquisaProduto = imput.nextLine();

                for (Produtos produtos : Lista) { //acessa o construtor dentro da lista 

                    if(PesquisaProduto.equals(produtos.getNome())){//pesquisa a variavel e compara com o produtos.getNome()
                    
                        System.out.printf("\nencontrado! %s",produtos.toString());
                        
                        System.out.print("Nome do Produto: ");
                        produtos.setNome(imput.nextLine());

                         System.out.print("Valor do produto:");
                        produtos.setValor(imput.nextDouble());

                        System.out.print("Quantidada em Estoque: ");
                        produtos.setEstoque(imput.nextInt());                   

                        System.out.print("Codigo do produto: ");
                        produtos.setCodigo(imput.nextInt());

                     }                                           
                }

                    if(achado){
                    System.out.println("Nao foi encontrado!");
                    }
                
                
                }  

               break;
                         
               default:
                System.out.println("opçao invalida!");
                    break;
            }

        }while(opcao!=0);
        
        
        imput.close();

    }
    
}
