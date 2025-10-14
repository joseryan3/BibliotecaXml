package org.example;

import java.io.File;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class BibliotecaManager {

    private final String nomeArquivo;


    public BibliotecaManager(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }


    /**
     * Carrega a bibliteca (com sua lista de livros) do arquivo XML.
     */
public Biblioteca carregar() {
    File arquivo = new File(nomeArquivo);
    if (!arquivo.exists()) {
        System.out.println("Arquivo não encontrado. Criando nova biblioteca.");
        return new Biblioteca(); //retirna um objeto novo se o arquivo não existe
    }
    try {
        JAXBContext context = JAXBContext.newInstance(Biblioteca.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();


        //Lê o XML do arquivo e o converte no objeto biblioteca
        Biblioteca biblioteca = (Biblioteca) unmarshaller.unmarshal(arquivo);
        return biblioteca;


    }catch (JAXBException e) {
        System.out.println("Erro ao ler o arquivo XML: " + e.getMessage());
        e.printStackTrace();
        return new Biblioteca(); //Retirn aum objeto vazio em caso de erro
    }
}


/**
 * Salvo o objeto Biblioteca 9com toda lista de livros) em um arquivo XML.
 */



public void salvar(Biblioteca biblioteca) {
    try {
        JAXBContext context = JAXBContext.newInstance(Biblioteca.class);
        Marshaller marshaller = context.createMarshaller();


        //Propiredade pra formatar o XML e torná-lo legível
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


        //Converte o objeto Java em XML e salva no arquivo
        marshaller.marshal(biblioteca, new File(nomeArquivo));
    } catch (JAXBException e) {
        System.err.println("Erro ao salvar o arquivo XML: " + e.getMessage());
        e.printStackTrace();
        }
    }
}
