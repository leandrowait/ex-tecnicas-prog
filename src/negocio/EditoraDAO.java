package negocio;

import java.util.List;

import negocio.exception.DAOEditoraException;
import negocio.modelo.Editora;

public interface EditoraDAO {
	List<Editora> buscarTodos() throws DAOEditoraException;
	Editora buscarPorCodigo(int codigo) throws DAOEditoraException;
	void inserir(Editora editora) throws DAOEditoraException;
	void alterar(Editora editora) throws DAOEditoraException;
}
