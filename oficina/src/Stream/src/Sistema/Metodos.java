package Sistema;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

import Classes.Produtos;
import Classes.Venda;

public class Metodos {
   private boolean achado = false; 
   private boolean quantidadeEstoque = false;
   private String ProdutosAnalitico;


    Produtos produtos = new Produtos(); //classe produtos instanciada  
    Venda vendas = new Venda();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
    List<Produtos> Lista = new ArrayList<Produtos>();
    List<Venda> VendasLista = new ArrayList<Venda>();
    

   public void entradaDeDados(){
        //produtos testes
        Lista.add(new Produtos(11,"teste", 157.97,4));
        Lista.add(new Produtos(57,"tinta vermelha com ver iz", 54.5,8));
        Lista.add(new Produtos(987,"volante ferrari 478", 247.99,1));
        Lista.add(new Produtos(3265,"parabriza blindado", 2547.94,9));
        Lista.add(new Produtos(14,"mocinetica crossfox 2011", 895.0,4));
        Lista.add(new Produtos(87,"filtro de oleo", 21.98,1));
        Lista.add(new Produtos(36,"balança fusca 1987", 1274.97,8));
    }
    
   public void incluirProduto(String Nome, int Codigo, int Estoque, double Valor){
       Lista.add(new Produtos(Codigo,Nome,Valor,Estoque));
   }

   public void Consultar(String NomeBusca){

       if(Lista.isEmpty()){           
        System.out.println("Lista esta Vazia!!");
       }else{

        for (Produtos produtos : Lista) {

            if(NomeBusca.equals(produtos.getNome())){

                achado = true;

                ProdutosAnalitico = produtos.toString();

            }
        }
       }

       if(achado){
        System.out.printf("\n*************Produto encontrado*************\n %s",ProdutosAnalitico);
       }else{
           System.out.println("Produto nao encontrado verifique o nome novamente");
       }

   }

   
    public void realizarVenda(String NomeBusca,int quantidade, LocalDate data){
    
    if(Lista.isEmpty()){           
        System.out.println("Lista esta Vazia!!");
       }else{

        for (Produtos produtos : Lista) {
            
            if(NomeBusca.equals(produtos.getNome())){

                //quantidadeEstoque = true se tiver no estoque pra descontar a quantidade se nao retorna false
                if(produtos.getEstoque() >= quantidade){

                    //Lista.get(Lista.indexOf(produtos)); acha o index do produto dentro da array para que seja adcionado ao array vendas
                    VendasLista.add(new Venda(quantidade, Lista.get(Lista.indexOf(produtos)), data));
                    achado = true;

                   

                }else{                   
                    quantidadeEstoque = true;
                }
             }

            }
        }       

       if(achado){
        System.out.printf("\n*************Produto Vendido*************\n",ProdutosAnalitico);
       }else if(quantidadeEstoque){           
           System.out.println("Quantidade Invalida!");
       }else{
        System.out.println("Produto nao encontrado verifique o nome novamente");
       }
    

   }


   public void Relatorio(LocalDate DataInicio, LocalDate Datafim) throws Exception{

    if(VendasLista.isEmpty()){
        System.out.println("Lista de Vendas Vazia");
    }else{
        if(DataInicio.compareTo(Datafim)==1){
            throw new DataFormatException("A data inicial deve ser menor ou igual à data final");            
            
        }

        System.out.printf("\n%10s\t%30s\t%12s\t%15s\t%20s\n", "Data", "Produto", "Quantidade", "Valor (R$)", "Valor total (R$)");
        System.out.println("---------------------------------------------------------------------------");
        VendasLista.stream()
        .filter(v -> v.getData().compareTo(DataInicio) >=0 && v.getData().compareTo(Datafim)<=0)
        .forEach(v ->
        System.out.printf("%10s\t%30s\t%12d\t%15.2f\t%20.2f\n", v.getData().format(dtf),
        v.getProdutos().getNome(), v.getQuantidade(), v.getProdutos().getValor(), v.getProdutos().getValor() * v.getQuantidade())
        );

        System.out.println("---------------------------------------------------------------------------");
        Double media = VendasLista.stream()
        .filter( v -> v.getData().compareTo(DataInicio) >= 0 && v.getData().compareTo(Datafim) <= 0 )
        .collect( Collectors.averagingDouble(
         venda -> venda.getProdutos().getValor() * venda.getQuantidade()
            ) );
            System.out.printf("Valor médio das vendas no período: R$ %.2f\n", media);


    }   

   }



}