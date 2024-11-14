package br.com.douglaspaz.DAO;

import java.util.List;

import br.com.douglaspaz.entity.Cliente;

public interface DAO<T> {
	
	void salvar(T t);
	List<T> listarTodos();
	Object listarUm(long id);
	void atualizar(Cliente usuario);
	void delete(Long id);

}
