package com.example.controller;

import java.util.List;

import com.example.model.Cliente;
import com.example.model.Pagamento;
import com.example.model.Pedido;
import com.example.model.Produto;
import com.example.service.LojaService;

/**
 * Esqueleto da atividade: a View e o LojaService já estão prontos.
 * Complete os métodos para encaminhar cada operação ao serviço.
 */
public class LojaController {
    private final LojaService lojaService;

    public LojaController(LojaService lojaService) {
        this.lojaService = lojaService;
    }

    public void cadastrarCliente(Cliente cliente) {
        lojaService.cadastrarCliente(cliente);
    }

    public void cadastrarProduto(Produto produto) {
        lojaService.cadastrarProduto(produto);
    }

    public Produto buscarProdutoPorCodigo(int codigo) {
        return lojaService.buscarProdutoPorCodigo(codigo);
    }

    public List<Cliente> listarClientes() {
        return lojaService.listarClientes();
    }

    public List<Produto> listarProdutos() {
        return lojaService.listarProdutos();
    }

    public void reporEstoque(int codigo, int quantidade) {
        lojaService.reporEstoque(codigo, quantidade);
    }

    public Pedido abrirPedido(Cliente cliente) {
        return lojaService.abrirPedido(cliente);
    }

    public void finalizarCompra(Pedido pedido, Pagamento pagamento) {
        lojaService.finalizarCompra(pedido, pagamento);
    }

    public List<Pedido> listarPedidos() {
        return lojaService.listarPedidos();
    }
}
