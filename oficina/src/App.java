import java.util.Scanner;
public class App {
  public static void main(String[] args) throws Exception {
      Scanner imput = new Scanner(System.in);      
      Produtos prd = new Produtos();
      Sistema sistema = new Sistema();
      int opcao;


  do{
    System.out.println("\n[1] <-> Incluir produto");
    System.out.println("[2] <-> Consultar produto");
    System.out.println("[3] <-> Listagem de produtos");
    System.out.println("[4] <-> Vendas por período");
    System.out.println("[5] <-> Realizar venda");
    System.out.println("[0] <-> Sair");
    System.out.print("opçao: ");
    opcao = imput.nextInt();
    imput.nextLine();


    switch (opcao) {       
        
        case 0:

         System.out.println("Programa Encerrado!");


        break;
        case 1: 

        System.out.print("Nome do Produto: ");
        prd.setNomeProduto(imput.nextLine());

        System.out.print("Valor do Produto: ");
        prd.setValorProduto(imput.nextDouble());

        System.out.print("Quantidade em Estoque: ");
        prd.setQunatidadeEstoque(imput.nextInt());

        prd = new Produtos();
        
       
        break;
        case 2:

        break;
        case 3:

           
              

        case 4:

        break;
        case 5:

        break;
        default: System.out.println("Opçao Invalida!");
            break;
    } 

  }while(opcao!=0);  

  imput.close(); 

   }

}
