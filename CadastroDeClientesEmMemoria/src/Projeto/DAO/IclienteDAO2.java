package Projeto.DAO;

import Projeto.Dominio.Cliente;

import java.util.Map;

public interface IclienteDAO2 {
    Boolean cadastrar(Cliente cliente);

    Cliente consultar(String cpf);

    Boolean alterar(Cliente cliente);

    Boolean excluir(String cpf);

    Map<String,Cliente> buscarTodos();
}
