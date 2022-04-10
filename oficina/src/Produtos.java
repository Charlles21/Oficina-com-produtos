

public class Produtos { 

    private String NomeProduto;
    private Double ValorProduto;
    private int QunatidadeEstoque;
    private int CodigoProduto;  

    public void Produto(){

    }
    public void Produto(String NomeProduto,Double ValorProduto,int QunatidadeEstoque,int CodigoProduto){
        this.NomeProduto = NomeProduto;
        this.ValorProduto = ValorProduto;
        this.QunatidadeEstoque = QunatidadeEstoque;
        this.CodigoProduto = CodigoProduto;
    }    

    public String getNomeProduto() {
        return NomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        NomeProduto = nomeProduto;
    }
    public Double getValorProduto() {
        return ValorProduto;
    }
    public void setValorProduto(Double valorProduto) {
        ValorProduto = valorProduto;
    }
    public int getQunatidadeEstoque() {
        return QunatidadeEstoque;
    }
    public void setQunatidadeEstoque(int qunatidadeEstoque) {
        QunatidadeEstoque = qunatidadeEstoque;
    }
    public int getCodigoProduto() {
        return CodigoProduto;
    }
    public void setCodigoProduto(int codigoProduto) {
                CodigoProduto = codigoProduto;
    }
   

    @Override
    public String toString() {
        return "Produtos [CodigoProduto=" + CodigoProduto + ", Lista=" + ", NomeProduto=" + NomeProduto
                + ", QunatidadeEstoque=" + QunatidadeEstoque + ", ValorProduto=" + ValorProduto + "]";
    }
    public static Iterable<Produtos> stream() {
        return null;
    }



    

 
}       


