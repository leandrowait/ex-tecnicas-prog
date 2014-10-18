/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.derby.jdbc.EmbeddedDataSource;

/**
 *
 * @author julio
 */
public class InicializadorBancoDados {

    public static String DB_NAME = "cadastro";
    public static String USER_NAME = "usuario";
    public static String PASSWORD = "senha";
    private static DataSource dataSource;

    private static DataSource criarDataSource() throws Exception {
        if (dataSource == null) {
            EmbeddedDataSource ds = new EmbeddedDataSource();
            ds.setDatabaseName(DB_NAME);
            ds.setCreateDatabase("create");
            ds.setUser(USER_NAME);
            ds.setPassword(PASSWORD);
            dataSource = ds;
        }
        return dataSource;
    }

    public static void criarBd() throws Exception {
        try (Connection con = criarDataSource().getConnection();
                Statement sta = con.createStatement()) {
            String sqlAutor = "CREATE TABLE AUTORES("
                    + "CODIGO int PRIMARY KEY NOT NULL,"
                    + "PRIMEIRONOME varchar(100) NOT NULL,"
                    + "ULTIMONOME varchar(100) NOT NULL)";
            sta.executeUpdate(sqlAutor);
            String sqlEditora = "CREATE TABLE EDITORAS("
                    + "CODIGO int PRIMARY KEY NOT NULL,"
                    + "NOME varchar(100) NOT NULL)";
            sta.executeUpdate(sqlEditora);
            String sqlLivro = "CREATE TABLE LIVROS("
                    + "CODIGO int PRIMARY KEY NOT NULL,"
                    + "TITULO varchar(100) NOT NULL,"
                    + "ANO int NOT NULL,"
                    + "CODEDITORA int NOT NULL,"
                    + "CONSTRAINT FK_EDITORAS FOREIGN KEY (CODEDITORA) REFERENCES EDITORAS(CODIGO))";
            sta.executeUpdate(sqlLivro);
            String sqlLivroAutor = "CREATE TABLE LIVROSAUTORES("
                    + "CODLIVRO int NOT NULL,"
                    + "CODAUTOR int NOT NULL,"
                    + "CONSTRAINT PK_LIVROSAUTORES PRIMARY KEY (CODLIVRO,CODAUTOR),"
                    + "CONSTRAINT FK_LIVROS FOREIGN KEY (CODLIVRO) REFERENCES LIVROS(CODIGO),"
                    + "CONSTRAINT FK_AUTORES FOREIGN KEY (CODAUTOR) REFERENCES AUTORES(CODIGO))";
            sta.executeUpdate(sqlLivroAutor);
            String sqlVenda = "CREATE TABLE VENDAS("
                    + "CODIGO int PRIMARY KEY NOT NULL,"
                    + "NOMECLIENTE varchar(200) NOT NULL,"
                    + "CPFCLIENTE char(11),"
                    + "CNPJCLIENTE char(14),"
                    + "DATA date NOT NULL)";
            sta.executeUpdate(sqlVenda);
            String sqlItenVenda = "CREATE TABLE ITENSVENDA("
                    + "CODVENDA int NOT NULL,"
                    + "CODLIVRO int NOT NULL,"
                    + "QUANTIDADE int NOT NULL,"
                    + "VALOR real NOT NULL,"
                    + "CONSTRAINT PK_ITENSVENDA PRIMARY KEY (CODVENDA,CODLIVRO),"
                    + "CONSTRAINT FK_ITENSVENDA_LIVROS FOREIGN KEY (CODLIVRO) REFERENCES LIVROS(CODIGO),"
                    + "CONSTRAINT FK_ITENSVENDA_VENDAS FOREIGN KEY (CODVENDA) REFERENCES VENDAS(CODIGO))";
            sta.executeUpdate(sqlItenVenda);
        }
    }

    public static Connection conectarBd() throws Exception {
        return criarDataSource().getConnection();
    }
    
    public static void inicializarDados() throws Exception {
        try(Connection con = conectarBd();
                Statement sta = con.createStatement()){
            String sql = "insert into autores(codigo,primeironome,ultimonome) values(1,'John','Doe')";
            sta.executeUpdate(sql);
            sql = "insert into autores(codigo,primeironome,ultimonome) values(2,'Mary','Doe')";
            sta.executeUpdate(sql);
            sql = "insert into editoras(codigo,nome) values(1,'Editora1')";
            sta.executeUpdate(sql);
            sql = "insert into editoras(codigo,nome) values(2,'Editora2')";
            sta.executeUpdate(sql);
            sql = "insert into livros(codigo,titulo,ano,codeditora) values(1,'Livro1',2014,1)";
            sta.executeUpdate(sql);
            sql = "insert into livros(codigo,titulo,ano,codeditora) values(2,'Livro2',2014,1)";
            sta.executeUpdate(sql);
            sql = "insert into livros(codigo,titulo,ano,codeditora) values(3,'Livro3',2014,2)";
            sta.executeUpdate(sql);
            sql = "insert into livrosautores(codlivro,codautor) values(1,1)";
            sta.executeUpdate(sql);
            sql = "insert into livrosautores(codlivro,codautor) values(2,1)";
            sta.executeUpdate(sql);
            sql = "insert into livrosautores(codlivro,codautor) values(2,2)";
            sta.executeUpdate(sql);
            sql = "insert into livrosautores(codlivro,codautor) values(3,2)";
            sta.executeUpdate(sql);
            sql = "insert into vendas(codigo,nomecliente,cpfcliente,data) values (1,'Cliente1','11111111111',DATE('2014-10-02'))";
            sta.executeUpdate(sql);
            sql = "insert into vendas(codigo,nomecliente,cpfcliente,data) values (2,'Cliente2','22222222222',DATE('2014-10-09'))";
            sta.executeUpdate(sql);
            sql = "insert into itensvenda(codvenda,codlivro,quantidade,valor) values (1,1,5,25.50)";
            sta.executeUpdate(sql);
            sql = "insert into itensvenda(codvenda,codlivro,quantidade,valor) values (1,2,1,45.99)";
            sta.executeUpdate(sql);
            sql = "insert into itensvenda(codvenda,codlivro,quantidade,valor) values (2,2,5,25.50)";
            sta.executeUpdate(sql);
            sql = "insert into itensvenda(codvenda,codlivro,quantidade,valor) values (2,3,1,10.0)";
            sta.executeUpdate(sql);
        }
    }
}
