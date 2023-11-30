import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private int numeroPedido;
    private Date dataHoraPedido;
    private double precoTotal;
    private int statusPedido;
    private ArrayList<PedidoItem> itensPedido;

    public Pedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
        this.dataHoraPedido = new Date();
        this.precoTotal = 0.0;
        this.statusPedido = 1;
        this.itensPedido = new ArrayList<>();
    }

    // Getters and setters

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Date getDataHoraPedido() {
        return dataHoraPedido;
    }

    public void setDataHoraPedido(Date dataHoraPedido) {
        this.dataHoraPedido = dataHoraPedido;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(int statusPedido) {
        this.statusPedido = statusPedido;
    }

    public ArrayList<PedidoItem> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(ArrayList<PedidoItem> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public boolean consultarPedido(Pedido pedido) {
        return this.numeroPedido == pedido.getNumeroPedido();
    }

    public void inserirItensPedido(PedidoItem item, Produto produto) {
        if (item.atualizaEstoqueItem(produto)) {
            itensPedido.add(item);
            // Atualizar o status e calcular o total
            this.statusPedido = 2;
            calcularTotalPagar();
        } else {
            System.out.println("Erro ao adicionar item ao pedido " + this.numeroPedido);
        }
    }

    public void excluirItensPedido(PedidoItem item) {
        if (itensPedido.contains(item)) {
            itensPedido.remove(item);
            // Atualizar o status e calcular o total
            this.statusPedido = 2;
            calcularTotalPagar();
        } else {
            System.out.println("Erro: Item não encontrado no pedido " + this.numeroPedido);
        }
    }

    public void calcularTotalPagar() {
        this.precoTotal = 0.0;
        for (PedidoItem item : itensPedido) {
            this.precoTotal += item.getPrecoItem() * item.getQuantidadeItem();
        }
    }

    public int alterarStatus(int novoStatus) {
        this.statusPedido = novoStatus;
        return this.statusPedido;
    }
}
