/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzutti.gui;

import br.pizzutti.dao.BookDao;
import br.pizzutti.entity.Book;
import br.pizzutti.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pedro
 */
public class CatalogPage extends javax.swing.JDialog {

    /**
     * Creates new form CatalogPage
     */
    public CatalogPage(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        iniciarBD();
        montarTabela();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBooks = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfPesquisa = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Consulta ao Catálogo de Livros");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tbBooks.setAutoCreateRowSorter(true);
        tbBooks.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod.", "Título", "Autor(a)", "Ano", "Gênero", "Citação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbBooks.setRowHeight(20);
        tbBooks.setRowMargin(2);
        jScrollPane1.setViewportView(tbBooks);
        if (tbBooks.getColumnModel().getColumnCount() > 0) {
            tbBooks.getColumnModel().getColumn(0).setMinWidth(10);
            tbBooks.getColumnModel().getColumn(0).setPreferredWidth(5);
            tbBooks.getColumnModel().getColumn(3).setMinWidth(15);
            tbBooks.getColumnModel().getColumn(3).setPreferredWidth(5);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Insira o código para ver em detalhe:");

        tfPesquisa.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btPesquisar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/pesquisa-de-lupa.png"))); // NOI18N
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(195, 195, 195))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        // TODO add your handling code here:
        pesquisar();
    }//GEN-LAST:event_btPesquisarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbBooks;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables
    private br.pizzutti.dao.BookDao bookDao;
    private java.sql.Connection con;
    private java.sql.Statement stmtListar;
    private java.sql.ResultSet rsListar;
    private List<Book> listOfBooks;
    
    public void iniciarBD(){
        
        try{
            
            bookDao = new BookDao();
            
            ConnectionFactory connection = new ConnectionFactory();
            con = connection.getConnection();
            stmtListar = con.createStatement();
            rsListar = stmtListar.executeQuery("SELECT * FROM MYLIBRARY.BOOKS");
            
           
        } catch (Exception e){
            
            JOptionPane.showMessageDialog(this, "Conexão com o servidor falhou!");
        }
    }
    
    private void montarTabela(){
        
        try{
            DefaultTableModel dtm = (DefaultTableModel) tbBooks.getModel();
                    
            ArrayList<Book> books = bookDao.listarAllBooks();
        
            int linha = 0;
            
            for(Book book : books){
                
                dtm.addRow(new Object[]{1, 2, 3, 4, 5, 6});
                
                int cod = book.getCod();
                String titulo = book.getTitulo();
                String autoria = book.getAutoria();
                int ano = book.getAno();
                String genero = book.getGenero();
                String citacao = book.getCitacao();
                
                tbBooks.getModel().setValueAt(cod, linha, 0);
                tbBooks.getModel().setValueAt(titulo, linha, 1);
                tbBooks.getModel().setValueAt(autoria, linha, 2);
                tbBooks.getModel().setValueAt(ano, linha, 3);
                tbBooks.getModel().setValueAt(genero, linha, 4);
                tbBooks.getModel().setValueAt(citacao, linha, 5);
                
                linha++;
                
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, "Erro: " +  e.getMessage());
            
        }
    }
    
    public void pesquisar(){
        
        int cod = Integer.parseInt(tfPesquisa.getText());
        
        try {
            
            Book book = bookDao.pesquisar(cod);
            
            if(book != null){
                
                JOptionPane.showMessageDialog(this, "Registro encontrado!"
                        + "\n\nNúmero de Registro: " + book.getCod()
                        + "\nTítulo: " + book.getTitulo()
                        + "\nAutoria: " + book.getAutoria()
                        + "\nGênero: " + book.getGenero()
                        + "\nCitação: " + book.getCitacao()
                        
                        );
                
            } else {
                
                JOptionPane.showMessageDialog(this, "Registro não encontrado!");
                
            }
            
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            
        }
    }
}
