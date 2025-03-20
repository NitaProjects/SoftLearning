package demo.model.core.services;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class CatalanBookDTO {
    private String name, tematic, editorial, idioma, isbn, fechaDeLanzamiento, fechaDeDisponibilidad, fragil;
    private double price, ancho, largo, alto, peso;
    private int paginas, recordatoriosDias;


    public CatalanBookDTO(){
        
    }

    public CatalanBookDTO(double price, String name, String tematic, String editorial, String idioma, int paginas, String ISBN, 
    String fechaDeLanzamiento, String fechaDeDisponibilidad, int recordatoriosDias,
    double ancho, double largo, double alto, double peso, String fragil){
        this.name = name;
        this.tematic = tematic;
        this.idioma = idioma;
        this.editorial = editorial;
        this.isbn = ISBN;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
        this.fechaDeDisponibilidad = fechaDeDisponibilidad;
        this.fragil = fragil;
        this.price = price;
        this.ancho = ancho;
        this.alto = alto;
        this.peso = peso;
        this.paginas = paginas;
        this.largo = largo;
        this.recordatoriosDias = recordatoriosDias;
    }

    @JsonGetter("nom_llibre")
    public String getName() {
        return name;
    }

    @JsonGetter("tematica_llibre")
    public String getTematic() {
        return tematic;
    }

    @JsonGetter("editorial")
    public String getEditorial() {
        return editorial;
    }

    @JsonGetter("idioma")
    public String getIdioma() {
        return idioma;
    }

    @JsonGetter("isbn_llibre")
    public String getISBN() {
        return isbn;
    }

    @JsonGetter("data_de_llançament")
    public String getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    @JsonGetter("data_disponibilitat")
    public String getFechaDeDisponibilidad() {
        return fechaDeDisponibilidad;
    }

    @JsonGetter("es_fragil")
    public String getFragil() {
        return fragil;
    }

    @JsonGetter("preu")
    public double getPrice() {
        return price;
    }

    @JsonGetter("ample_llibre")
    public double getAncho() {
        return ancho;
    }

    @JsonGetter("llargada_llibre")
    public double getLargo() {
        return largo;
    }

    @JsonGetter("alçada_llibre")
    public double getAlto() {
        return alto;
    }

    @JsonGetter("pes_llibre")
    public double getPeso() {
        return peso;
    }

    @JsonGetter("pàgines")
    public int getPaginas() {
        return paginas;
    }

    @JsonGetter("recordatori_dies")
    public int getRecordatoriosDias() {
        return recordatoriosDias;
    }

    
//setters



    @JsonSetter("nom_llibre")
    public String setName() {
        return name;
    }

    @JsonSetter("tematica_llibre")
    public String setTematic() {
        return tematic;
    }

    @JsonSetter("editorial")
    public String setEditorial() {
        return editorial;
    }

    @JsonSetter("idioma")
    public String setIdioma() {
        return idioma;
    }

    @JsonSetter("isbn_llibre")
    public String setISBN() {
        return isbn;
    }

    @JsonSetter("data_de_llançament")
    public String setFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    @JsonSetter("data_disponibilitat")
    public String setFechaDeDisponibilidad() {
        return fechaDeDisponibilidad;
    }

    @JsonSetter("es_fragil")
    public String setFragil() {
        return fragil;
    }

    @JsonSetter("preu")
    public double setPrice() {
        return price;
    }

    @JsonSetter("ample_llibre")
    public double setAncho() {
        return ancho;
    }

    @JsonSetter("llargada_llibre")
    public double setLargo() {
        return largo;
    }

    @JsonSetter("alçada_llibre")
    public double setAlto() {
        return alto;
    }

    @JsonSetter("pes_llibre")
    public double setPeso() {
        return peso;
    }

    @JsonSetter("pàgines")
    public int setPaginas() {
        return paginas;
    }

    @JsonSetter("recordatori_dies")
    public int setRecordatoriosDias() {
        return recordatoriosDias;
    }

    @Override
    public String toString() {
        return "CatalanBookDTO [nom_llibre=" + name + ", tematica_llibre=" + tematic + ", editorial=" + editorial + ", idioma="
                + idioma + ", isbn_llibre=" + isbn + ", data_de_llançament=" + fechaDeLanzamiento + ", data_disponibilitat="
                + fechaDeDisponibilidad + ", fragil=" + fragil + ", preu=" + price + ", ample_llibre=" + ancho + ", llargada_llibre="
                + largo + ", alçada_llibre=" + alto + ", pes_llibre=" + peso + ", pàgines=" + paginas + ", recordatori_dies="
                + recordatoriosDias + "]";
    }





}
