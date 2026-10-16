package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Cliente;
import com.example.model.ItemPedido;
import com.example.model.Pagamento;
import com.example.model.Pedido;
import com.example.model.Produto;

public class LojaService {

    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Produto> produtos = new ArrayList<>();
    private final List<Pedido> pedidos = new ArrayList<>();
    private int proximoCodigoProduto = 1;

    public void cadastrarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente é obrigatório.");
        }
        clientes.add(cliente);
    }

    public void cadastrarProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto é obrigatório.");
        }
        if (produto.getCodigo() <= 0) {
            produto.setCodigo(proximoCodigoProduto++);
        }
        produtos.add(produto);
    }

    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }

    public List<Produto> listarProdutos() {
        return new ArrayList<>(produtos);
    }

    public void reporEstoque(int codigo, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }

        Produto produto = buscarProdutoPorCodigo(codigo);
        if (produto == null) {
            throw new IllegalArgumentException("Produto não cadastrado na loja.");
        }

        produto.setQuantidade(produto.getQuantidade() + quantidade);
    }

    public Produto buscarProdutoPorCodigo(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    public Pedido abrirPedido(Cliente cliente) {
        if (!clienteCadastrado(cliente)) {
            throw new IllegalArgumentException(
                    "Cliente não cadastrado.");
        }

        return new Pedido(cliente);
    }

    public void finalizarCompra(Pedido pedido, Pagamento pagamento) {
        if (pedido == null || pagamento == null) {
            throw new IllegalArgumentException(
                    "Pedido e pagamento são obrigatórios.");
        }

        if (pedido.getItens().isEmpty()) {
            throw new IllegalArgumentException(
                    "O pedido precisa ter pelo menos um item.");
        }

        if (!clienteCadastrado(pedido.getCliente())) {
            throw new IllegalArgumentException(
                    "Cliente não cadastrado.");
        }

        for (ItemPedido item : pedido.getItens()) {
            Produto produto = item.getProduto();
            Produto cadastrado = buscarProdutoPorCodigo(produto.getCodigo());

            if (produto == null || cadastrado == null) {
                throw new IllegalArgumentException(
                        "Produto não cadastrado na loja.");
            }
            if (cadastrado.getQuantidade() < item.getQuantidade()) {
                throw new IllegalArgumentException(
                        "Estoque insuficiente para o produto " + produto.getNome() + ".");
            }
        }

        if (Double.compare(
                pagamento.getValor(),
                pedido.calcularTotal()) != 0) {
            throw new IllegalArgumentException(
                    "Pagamento diferente do pedido.");
        }

        for (ItemPedido item : pedido.getItens()) {
            Produto produto = item.getProduto();
            Produto cadastrado = buscarProdutoPorCodigo(produto.getCodigo());
            cadastrado.setQuantidade(cadastrado.getQuantidade() - item.getQuantidade());
        }

        pagamento.processar();
        pedidos.add(pedido);
    }

    public List<Pedido> listarPedidos() {
        return new ArrayList<>(pedidos);
    }

    private boolean clienteCadastrado(Cliente cliente) {
        for (Cliente cadastrado : clientes) {
            if (cadastrado == cliente) {
                return true;
            }
        }
        return false;
    }
}
