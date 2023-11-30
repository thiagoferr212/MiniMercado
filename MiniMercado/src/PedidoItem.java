public class PedidoItem {
    private String nomeItem;
    private int quantidadeItem;
    private double precoItem;

    public PedidoItem(String nomeItem, int quantidadeItem, double precoItem) {
        this.nomeItem = nomeItem;
        this.quantidadeItem = quantidadeItem;
        this.precoItem = precoItem;
    }

    // Getters and setters

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public int getQuantidadeItem() {
        return quantidadeItem;
    }

    public void setQuantidadeItem(int quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
    }

    public double getPrecoItem() {
        return precoItem;
    }

    public void setPrecoItem(double precoItem) {
        this.precoItem = precoItem;
    }

    public boolean atualizaEstoqueItem(Produto produto) {
        if (produto.getEstoqueAtual() >= this.quantidadeItem) {
            produto.setEstoqueAtual(produto.getEstoqueAtual() - this.quantidadeItem);
            return true;
        } else {
            System.out.println("Erro: Estoque insuficiente para o item " + this.nomeItem);
            return false;
        }
    }
}
