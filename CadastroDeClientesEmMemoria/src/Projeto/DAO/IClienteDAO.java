package Projeto.DAO;
import Projeto.Dominio.Cliente;
import java.util.Collection;


public interface IClienteDAO {

    public Boolean cadastrar(Cliente cliente);

    public void excluir(String cpf);

    public void alterar(Cliente cliente);

    public Cliente consultar(String cpf);

    public Collection<Cliente> buscarTodos();

}
