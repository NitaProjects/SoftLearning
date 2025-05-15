package demo.model.core.services;

import demo.exceptions.BuildException;
import demo.model.products.Book;

public class BookMapper {

    public static Book bookFromDTO (BookDTO cdto) throws BuildException{
        return Book.getInstanceBook(
            cdto.getPrice(), 
            cdto.getName(), 
            cdto.getTematic(), 
            cdto.getEditorial(), 
            cdto.getIdioma(),
            cdto.getPaginas(), 
            cdto.getISBN(),
            cdto.getFechaDeLanzamiento(), 
            cdto.getFechaDeDisponibilidad(), 
            cdto.getRecordatoriosDias(), 
            cdto.getAncho(), 
            cdto.getLargo(), 
            cdto.getAlto(),
            cdto.getPeso(), 
            cdto.getFragil()
            );
    }


    public static BookDTO dtoFromBook (Book b){
        return new BookDTO(
        b.getPrice(), 
        b.getName(),
        b.getTematic(),
        b.getEditorial(),
        b.getIdioma(),
        b.getPaginas(),
        b.getISBN(),
        b.getFechaDeLanzamiento(),
        b.getFechaDeDisponibilidad(),
        b.getRecordatoriosDias(),
        b.getAncho(),
        b.getLargo(),
        b.getAlto(),
        b.getPeso(),
        b.getFragil()
        );
    }


}
