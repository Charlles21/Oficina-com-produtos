import Funcoes.funcao;

public class Produtos implements funcao {
    private int Codigo;
    private String Nome;  
    private int Estoque;
    private int Quantidade;
    private double Valor; 

    

    public Produtos(int codigo, String nome, double Valor, int Quantidade, int Estoque){
        this.Codigo = codigo;
        this.Nome = nome;
        this.Valor = Valor;   
        this.Quantidade = Quantidade;
        this.Estoque = Estoque;    
    }

    public Produtos(){

    } 


    

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
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

    @Override
    public String toString() {
        return "\nNome: " + Nome + "\nCodigo: " + Codigo + "\nEstoque: " + Estoque + "\nValor: "+Valor+ "\n";
    }

    public String Relatorio(){
        return "\nNome: " + Nome + "\nCodigo: " + Codigo + "\nEstoque: " + Estoque + "\nValor: "+Valor+ "\nQuantidade Ja vendida: "+ Quantidade +"\n";
    }

    @Override
    public Object venda(double Valor, int Quantidade) {  
        Valor = Valor * Quantidade;            
        return Valor;
    }
   
    
}
