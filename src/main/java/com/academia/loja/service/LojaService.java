package com.academia.loja.service;

import com.academia.loja.dao.LojaDAO;
import com.academia.loja.dao.LojaDAOJSON;
import com.academia.loja.dao.LojaDAOMySQL;
import com.academia.loja.model.Loja;
import com.academia.produto.model.Produto;
import com.academia.produto.service.ProdutoService;
import com.academia.utils.Config;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class LojaService {
    private final LojaDAO lojaDAO;
    private final ProdutoService produtoService = new ProdutoService();

    public LojaService() {
        try {
            Properties config = Config.getProperties();

            if (config.getProperty("storage.type").equals("json")) {
                this.lojaDAO = new LojaDAOJSON();
            } else {
                this.lojaDAO = new LojaDAOMySQL();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar arquivo de configuração.");
        }
    }

    // Adicionar uma nova loja
    public void adicionarLoja(Loja loja) {
        lojaDAO.adicionarLoja(loja);
    }

    // Atualizar dados da loja
    public void atualizarLoja(Loja loja) {
        lojaDAO.atualizarLoja(loja);
    }

    // Remover uma loja
    public void removerLoja(int lojaId) {
        lojaDAO.removerLoja(lojaId);
    }

    // Buscar loja pelo ID
    public Loja buscarLojaPorId(int lojaId) {
        return lojaDAO.buscarLojaPorId(lojaId);
    }

    // Listar todas as lojas
    public List<Loja> listarLojas() {
        return lojaDAO.listarLojas();
    }

    // Adicionar produto na loja e no estoque
    public void adicionarProdutoNaLoja(int lojaId, int produtoId) {
        Produto produto = produtoService.buscarProdutoPorId(produtoId);
        if (produto != null) {
            lojaDAO.adicionarProdutoNaLoja(lojaId, produto);
        } else {
            throw new RuntimeException("Produto não encontrado com o ID: " + produtoId);
        }
    }

    // Remover produto da loja e do estoque
    public void removerProdutoDaLoja(int lojaId, int produtoId) {
        try {
            lojaDAO.removerProdutoDaLoja(lojaId, produtoId);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao remover produto da loja.", e);
        }

    }

    // Listar produtos de uma loja
    public List<Produto> listarProdutosDaLoja(int lojaId) {
        return lojaDAO.listarProdutosDaLoja(lojaId);
    }
}
