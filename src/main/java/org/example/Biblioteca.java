package org.example;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

//Esta será a tag no nosso arquivo XML
@XmlRootElement(name = "biblioteca")
public class Biblioteca {



    private List<Livro> livros = new ArrayList<>();



    //@XmlElementWrapper cria uma tag "pai" para a lista.
    //@XmlElement define o nome de cada intem dentro da lista
    @XmlElementWrapper(name = "livros")
    @XmlElement(name = "livros")
    public List<Livro> getLivros() {
        return livros;
    }



    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
