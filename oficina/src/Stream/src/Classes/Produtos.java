package Classes;
public class Produtos{
    private int Codigo;
    private String Nome;  
    private int Estoque;    
    private double Valor;    
    private static int totalProdutos; // verificar total de produtos cadastrados       

    
    

    public Produtos(int Codigo, String nome, double Valor, int Estoque){
          this.Codigo = Codigo;
          this.Nome = nome;
          this.Valor = Valor;        
          this.Estoque = Estoque; 
          totalProdutos++; 
    }

    public Produtos(){   
        
    }  

    public double getValor() {
        return Valor;
    }

    public void setValor(double valor) {
        Valor = valor;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public String getNome() {  

       return Nome;

    }

    public void setNome(String nome) {       
            Nome = nome;                               
              
    }


    public int getEstoque() {
        return Estoque;
    }

    public void setEstoque(int estoque) {
        Estoque = estoque;
    }

    public static int getTotalProdutos() {
        return totalProdutos;
    }

    public static void setTotalProdutos(int totalProdutos) {
        Produtos.totalProdutos = totalProdutos;
    }

    @Override
    public String toString() {
        return "\nNome: " + Nome + "\nCodigo: " + Codigo + "\nEstoque: " + Estoque + "\nValor: "+Valor+ "\n";
    }    

    
}
