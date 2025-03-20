package demo.model.core.services;

public class BookDTO {

    private String name, tematic, editorial, idioma, isbn, fechaDeLanzamiento, fechaDeDisponibilidad, fragil;
    private double price, ancho, largo, alto, peso;
    private int paginas, recordatoriosDias;


    public BookDTO(){
        
    }

    public BookDTO(double price, String name, String tematic, String editorial, String idioma, int paginas, String ISBN, 
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

    public String getName() {
        return name;
    }

    public String getTematic() {
        return tematic;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getISBN() {
        return isbn;
    }

    public String getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public String getFechaDeDisponibilidad() {
        return fechaDeDisponibilidad;
    }

    public String getFragil() {
        return fragil;
    }

    public double getPrice() {
        return price;
    }

    public double getAncho() {
        return ancho;
    }

    public double getLargo() {
        return largo;
    }

    public double getAlto() {
        return alto;
    }

    public double getPeso() {
        return peso;
    }

    public int getPaginas() {
        return paginas;
    }

    public int getRecordatoriosDias() {
        return recordatoriosDias;
    }

    @Override
    public String toString() {
        return "BookDTO [name=" + name + ", tematic=" + tematic + ", editorial=" + editorial + ", idioma=" + idioma
                + ", isbn=" + isbn + ", fechaDeLanzamiento=" + fechaDeLanzamiento + ", fechaDeDisponibilidad="
                + fechaDeDisponibilidad + ", fragil=" + fragil + ", price=" + price + ", ancho=" + ancho + ", largo="
                + largo + ", alto=" + alto + ", peso=" + peso + ", paginas=" + paginas + ", recordatoriosDias="
                + recordatoriosDias + "]";
    }

    

    
}
