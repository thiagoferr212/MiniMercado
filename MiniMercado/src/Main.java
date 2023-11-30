import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar produtos
        Categoria categoria1 = new Categoria("Alimentos");

        ArrayList<Produto> produtos = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Digite o nome do produto " + i + ":");
            String nomeProduto = scanner.nextLine();

            System.out.println("Digite o preço do produto " + i + ":");
            double precoProduto = scanner.nextDouble();
            scanner.nextLine(); // Consumir a quebra de linha pendente

            System.out.println("Digite a descrição do produto " + i + ":");
            String descProduto = scanner.nextLine();

            System.out.println("Digite o estoque atual do produto " + i + ":");
            int estoqueAtual = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha pendente

            Produto produto = new Produto(nomeProduto, precoProduto, descProduto, estoqueAtual, categoria1);
            produtos.add(produto);
        }

        // Criar pedidos
        Pedido pedido1 = new Pedido(1);
        Pedido pedido2 = new Pedido(2);

        for (int i = 1; i <= 2; i++) {
            System.out.println("Para o pedido " + i + ":");

            System.out.println("Digite o número do produto para o item 1:");
            int produtoIndex1 = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha pendente

            System.out.println("Digite a quantidade do item 1:");
            int quantidadeItem1 = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha pendente

            if (produtoIndex1 >= 0 && produtoIndex1 < produtos.size()) {
                PedidoItem item1 = new PedidoItem(produtos.get(produtoIndex1).getNomeProduto(), quantidadeItem1, produtos.get(produtoIndex1).getPrecoProduto());
                pedido1.inserirItensPedido(item1, produtos.get(produtoIndex1));
            } else {
                System.out.println("Erro: Índice de produto inválido para o item 1 do pedido " + i);
            }

            // Adicionar mais itens conforme necessário...
        }

        // Excluir itens dos pedidos (simulando)
        pedido1.excluirItensPedido(pedido1.getItensPedido().get(0));

        // Atualizar o estoque e calcular o total a pagar
        pedido1.calcularTotalPagar();
        pedido2.calcularTotalPagar();

        // Imprimir informações finais
        System.out.println("Produtos:");
        for (Produto produto : produtos) {
            System.out.println(produto.getNomeProduto() + " - Estoque: " + produto.getEstoqueAtual());
        }

        System.out.println("Pedido 1 - Status: " + pedido1.getStatusPedido() + " - Total a pagar: " + pedido1.getPrecoTotal());
        System.out.println("Pedido 2 - Status: " + pedido2.getStatusPedido() + " - Total a pagar: " + pedido2.getPrecoTotal());

        scanner.close();
    }
}
