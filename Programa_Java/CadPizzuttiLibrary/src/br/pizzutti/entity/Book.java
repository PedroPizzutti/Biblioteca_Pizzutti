package br.pizzutti.entity;

/**
 *
 * @author Pedro
 * classe destinada a criação da entidade Book
 */
public class Book {
    
    private int cod;
    private String titulo;
    private String autoria;
    private int ano;
    private String genero;
    private String citacao;
    
    public int getCod(){
        return cod;
    }
    
    public void setCod(int cod){
        this.cod = cod;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutoria() {
        return autoria;
    }

    public void setAutoria(String autoria) {
        this.autoria = autoria;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCitacao() {
        return citacao;
    }

    public void setCitacao(String citacao) {
        this.citacao = citacao;
    }
     
}
