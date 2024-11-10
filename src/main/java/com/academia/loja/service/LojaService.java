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

    /**
     * Construtor da classe.
     */
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

    /**
     * Método para adicionar uma loja.
     *
     * @param loja Loja a ser adicionada.
     */
    public void adicionarLoja(Loja loja) {
        lojaDAO.adicionarLoja(loja);
    }

    /**
     * Método para atualizar os dados de uma loja.
     *
     * @param loja Loja a ser atualizada.
     */
    public void atualizarLoja(Loja loja) {
        lojaDAO.atualizarLoja(loja);
    }

    /**
     * Método para remover uma loja por ID.
     *
     * @param lojaId ID da loja a ser removida.
     */
    public void removerLoja(int lojaId) {
        lojaDAO.removerLoja(lojaId);
    }

    /**
     * Método para buscar uma loja por ID.
     *
     * @param lojaId ID da loja a ser buscada.
     * @return Loja encontrada.
     */
    public Loja buscarLojaPorId(int lojaId) {
        return lojaDAO.buscarLojaPorId(lojaId);
    }

    /**
     * Método para listar todas as lojas.
     *
     * @return Lista de lojas.
     */
    public List<Loja> listarLojas() {
        return lojaDAO.listarLojas();
    }

    /**
     * Método para adicionar um produto à loja.
     *
     * @param lojaId    ID da loja.
     * @param produtoId ID do produto.
     */
    public void adicionarProdutoNaLoja(int lojaId, int produtoId) {
        Produto produto = produtoService.buscarProdutoPorId(produtoId);
        if (produto != null) {
            lojaDAO.adicionarProdutoNaLoja(lojaId, produto);
        } else {
            throw new RuntimeException("Produto não encontrado com o ID: " + produtoId);
        }
    }

    /**
     * Método para adicionar um produto à loja.
     *
     * @param lojaId    ID da loja.
     * @param produtoId ID do produto.
     */
    public void removerProdutoDaLoja(int lojaId, int produtoId) {
        try {
            lojaDAO.removerProdutoDaLoja(lojaId, produtoId);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao remover produto da loja.", e);
        }

    }

    /**
     * Método para listar os produtos de uma loja.
     *
     * @param lojaId ID da loja.
     * @return Lista de produtos da loja.
     */
    public List<Produto> listarProdutosDaLoja(int lojaId) {
        return lojaDAO.listarProdutosDaLoja(lojaId);
    }
}
