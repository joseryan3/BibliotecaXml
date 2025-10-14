package org.example;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;



//@XmlRootElement diz que esta classe pode ser o elemento raiz de um documentoXML.
//@XmlType(proporder = {"tirulo", "autor", "ano"}) define a ordem das tags no XML.
@XmlRootElement(name = "livro")
@XmlType(propOrder = {"titulo", "autor", "ano"})
public class Livro {
    private String titulo;
    private String autor;
    private int ano;


    //Getters
    @XmlElement
    public String getTitulo() { return titulo; }
    @XmlElement
    public String getAutor() { return  autor; }
    @XmlElement
    public int getAno() { return  ano; }



    //Setters
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.titulo = autor; }
    public void setAno(String ano) { this.titulo = ano; }




    //Contrutor vazio é OBRIGATÓRIO para a JAXB funcionar
    public Livro() {}


    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }


    @Override
    public String toString() {
        return String.format("Titulo: %s, Autor: %s, Ano: %d", titulo, autor, ano );
    }
    }
