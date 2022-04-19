package Classes;
import java.time.LocalDate;

public class Venda {
    private int Quantidade;   
    private LocalDate Data;
    private Produtos produtos;    

    public Venda(int quantidade, Produtos produtos,LocalDate Data ) {
        this.Quantidade = quantidade;        
        this.Data = Data;
        this.produtos = produtos;
              
    }

    public Venda(){

    }


    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }   

    public int getQuantidade() {
        return Quantidade;
    }


    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }


    
    public LocalDate getData() {
        return Data;
    }

    public void setData(LocalDate data) {
        Data = data;
    }

    @Override
    public String toString() {
        return "\nNome: " + produtos.getNome() + "\nCodigo: " + produtos.getCodigo() + "\nEstoque: " + produtos.getEstoque() + "\nValor: "+produtos.getValor()+ 
        "Quantidade Vendida: "+ Quantidade +"\n";
    } 
     
    
    
}
