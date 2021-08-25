
package br.pizzutti.dao;

import br.pizzutti.entity.Book;
import br.pizzutti.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pedro
 * classe destinada a fazer a interação entre as entidades e o banco de dados
 */
public class BookDao {
    
    private Connection con;
    private Statement stmt;
    private Statement stmtNav;
    private ResultSet rsNav;
    private ResultSet rs;
    
    public BookDao() throws ClassNotFoundException, SQLException {
        
        con = ConnectionFactory.getConnection();
        stmt = con.createStatement();
        stmtNav = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        rsNav = stmtNav.executeQuery("SELECT * FROM MYLIBRARY.BOOKS");
       
    }
    
    public boolean salvarRegistro(Book book) throws SQLException{
        
        String titulo = book.getTitulo();
        String autoria = book.getAutoria();
        int ano = book.getAno();
        String genero = book.getGenero();
        String citacao = book.getCitacao();
        
           
        stmt.executeUpdate("INSERT INTO MYLIBRARY.BOOKS (TITULO, AUTORIA, ANO, GENERO, CITACAO)"
                + " VALUES ('"+titulo+"', '"+autoria+"', "+ano+", '"+genero+"', '"
            +citacao+"')");
        
        rsNav = stmtNav.executeQuery("SELECT * FROM MYLIBRARY.BOOKS");
            
        return true;
    }
    /**
    * Método para inserir registro no banco de dados.
    * @throws SQLException.
    * @return boolean.
    */
    
    public boolean updateRegistro(Book book) throws SQLException{
        
            
        String titulo = book.getTitulo();
        String autoria = book.getAutoria();
        int ano = book.getAno();
        String genero = book.getGenero();
        String citacao = book.getCitacao();
        int cod = book.getCod();
                
        stmt.executeUpdate("UPDATE MYLIBRARY.BOOKS SET TITULO = '"+titulo+"', AUTORIA = '"
                +autoria+"', ANO = "+ano+", GENERO = '"+genero+"', CITACAO = '"+citacao+"' WHERE"
                        + " COD = "+cod);
        
        rsNav = stmtNav.executeQuery("SELECT * FROM MYLIBRARY.BOOKS WHERE COD = " + cod);
        rsNav = stmtNav.executeQuery("SELECT * FROM MYLIBRARY.BOOKS");
            
        return true;
    }        
    /**
    * Método para atualizar registro no banco de dados.
    * @throws SQLException.
    * @return boolean.
    */
    
    public boolean excluirRegistro(int cod) throws SQLException{
        
        stmt.executeUpdate("DELETE FROM MYLIBRARY.BOOKS WHERE COD = "+cod);
        rsNav = stmtNav.executeQuery("SELECT * FROM MYLIBRARY.BOOKS");
        
        return true;
    }
    
    /**
     * Método para excluir registro no banco de dados.
     * @throws java.sql.SQLException
     * @return boolean.
    */
    
    public Book primeiro() throws SQLException {
        
            if (rsNav.first()){

                Book book = new Book();
                book.setTitulo(rsNav.getString("TITULO"));
                book.setAutoria(rsNav.getString("AUTORIA"));
                book.setAno(rsNav.getInt("ANO"));
                book.setGenero(rsNav.getString("GENERO"));
                book.setCitacao(rsNav.getString("CITACAO"));
                book.setCod(rsNav.getInt("COD"));

                return book;
            } else {
                return null;
            }
        }
        /**
         * Método para settar o registro no primeiro no primeiro registro
         * @throws java.sql.SQLException
         * @return Book
         */
    
        public Book ultimo() throws SQLException {
        
            if (rsNav.last()){

                Book book = new Book();
                book.setTitulo(rsNav.getString("TITULO"));
                book.setAutoria(rsNav.getString("AUTORIA"));
                book.setAno(rsNav.getInt("ANO"));
                book.setGenero(rsNav.getString("GENERO"));
                book.setCitacao(rsNav.getString("CITACAO"));
                book.setCod(rsNav.getInt("COD"));

                return book;
            } else {
                return null;
            }
        }
        /**
        * Método para settar o registro no primeiro no ultimo registro
        * @throws java.sql.SQLException
        * @return Book
        */
        
        public Book proximo() throws SQLException {

        if (rsNav.isLast() != true) {

            rsNav.next();

            Book book = new Book();
            book.setTitulo(rsNav.getString("TITULO"));
            book.setAutoria(rsNav.getString("AUTORIA"));
            book.setAno(rsNav.getInt("ANO"));
            book.setGenero(rsNav.getString("GENERO"));
            book.setCitacao(rsNav.getString("CITACAO"));
            book.setCod(rsNav.getInt("COD"));

            return book;

        } else {
            return null;
        }
    }
        /**
        * Método para passar para o próximo registro
        * @throws java.sql.SQLException
        * @return Book
        */
        
        
        public Book anterior() throws SQLException {

        if (rsNav.isFirst() != true) {

            rsNav.previous();

            Book book = new Book();
            book.setTitulo(rsNav.getString("TITULO"));
            book.setAutoria(rsNav.getString("AUTORIA"));
            book.setAno(rsNav.getInt("ANO"));
            book.setGenero(rsNav.getString("GENERO"));
            book.setCitacao(rsNav.getString("CITACAO"));
            book.setCod(rsNav.getInt("COD"));

            return book;

        } else {
            return null;
        }
    }
        
        /**
        * Método para passar para o registro anterior
        * @throws java.sql.SQLException
        * @return Book
        */
        
    public Book pesquisar(int cod) throws SQLException {
        
        ResultSet rs = stmt.executeQuery("SELECT * FROM MYLIBRARY.BOOKS WHERE COD = "+cod);
        
        if(rs.next()){
            
            Book book = new Book();
            book.setTitulo(rs.getString("TITULO"));
            book.setAutoria(rs.getString("AUTORIA"));
            book.setAno(rs.getInt("ANO"));
            book.setGenero(rs.getString("GENERO"));
            book.setCitacao(rs.getString("CITACAO"));
            book.setCod(rs.getInt("COD"));
            
            return book;
            
        } else {
            
            return null;
        }
    }
    
    public ArrayList listarAllBooks() throws SQLException {
        
        Statement stmtListar = con.createStatement();
        ResultSet rsListar;
        rsListar = stmtListar.executeQuery("SELECT * FROM MYLIBRARY.BOOKS");
        
        ArrayList<Book> retorno = new ArrayList<Book>();
        
        while (rsListar.next()){
            
            int cod = rsListar.getInt("COD");
            String titulo = rsListar.getString("TITULO");
            String autoria = rsListar.getString("AUTORIA");
            int ano = rsListar.getInt("ANO");
            String genero = rsListar.getString("GENERO");
            String citacao = rsListar.getString("CITACAO");
            
            Book book = new Book();
            
            book.setTitulo(titulo);
            book.setAutoria(autoria);
            book.setAno(ano);
            book.setGenero(genero);
            book.setCitacao(citacao);
            book.setCod(cod);
            
            retorno.add(book);
            
        }
        
        return retorno;
    }
    
    public ArrayList pesquisar(String tipo_pesquisa, String palavra_chave) throws SQLException {
        
        Statement stmtListar = con.createStatement();
        ResultSet rsListar;
        rsListar = stmtListar.executeQuery("SELECT * FROM MYLIBRARY.BOOKS WHERE "+tipo_pesquisa+
                " LIKE '%"+palavra_chave+"%'");
        
        ArrayList<Book> retorno = new ArrayList<Book>();
        
        while (rsListar.next()){
            
            int cod = rsListar.getInt("COD");
            String titulo = rsListar.getString("TITULO");
            String autoria = rsListar.getString("AUTORIA");
            int ano = rsListar.getInt("ANO");
            String genero = rsListar.getString("GENERO");
            String citacao = rsListar.getString("CITACAO");
            
            Book book = new Book();
            
            book.setTitulo(titulo);
            book.setAutoria(autoria);
            book.setAno(ano);
            book.setGenero(genero);
            book.setCitacao(citacao);
            book.setCod(cod);
            
            retorno.add(book);
            
        }
        
        return retorno;
    }
        
        
}
