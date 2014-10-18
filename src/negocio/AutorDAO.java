package negocio;

import java.util.List;

import negocio.exception.DAOAutorException;
import negocio.modelo.Autor;

public interface AutorDAO {
	List<Autor> buscarTodos() throws DAOAutorException;
        Autor buscarPorCodigo(int codigo) throws DAOAutorException;
	List<Autor> buscarPorUltimoNome(String nome) throws DAOAutorException;
	void inserir(Autor autor) throws DAOAutorException;
	void alterar(Autor autor) throws DAOAutorException;
}
