package negocio;

import java.util.List;

import negocio.exception.DAOLivroException;
import negocio.modelo.Livro;

public interface LivroDAO {
	List<Livro> buscarTodos() throws DAOLivroException;
	Livro buscarPorCodigo(int codigo) throws DAOLivroException;
	List<Livro> buscarPorEditora(int codigo) throws DAOLivroException;
        void inserir(Livro livro) throws DAOLivroException;
	void alterar(Livro livro) throws DAOLivroException;
}
