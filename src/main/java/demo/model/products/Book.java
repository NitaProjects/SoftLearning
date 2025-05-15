package demo.model.products;

import java.time.LocalDateTime;
import java.time.LocalDate;
import demo.model.operations.checker;
import demo.exceptions.BuildException;
import demo.interfaces.Storable;


import java.time.format.DateTimeFormatter;

public class Book extends Product implements Storable {

    protected String editorial;
    protected String idioma;
    protected int paginas;
    protected String ISBN;
    protected LocalDateTime fechaDeLanzamiento;
    protected LocalDate fechaDeDisponibilidad;
    protected int recordatoriosDias;
    protected PhysicalData fisico;

    protected Book() {
    }


    //mirar si en el book de php tengo en el get Instance solo fisico o tambien double ancho, double largo, etc
    public static Book getInstanceBook(double price, String name, String tematic, String editorial, String idioma,
            int paginas, String ISBN, String fechaDeLanzamiento, String fechaDeDisponibilidad, int recordatoriosDias, double ancho, double largo, double alto, double peso, String fragil)
            throws BuildException {
        String message = "";

        Book a = new Book();
        try {
            a.checkDataProduct(price, name, tematic);
        }catch (BuildException e){
            message = e.getMessage();
        }

        if ((a.setEditorial(editorial) != 0)) {
            message += "This editorial is not possible, ";
        }

        if ((a.setIdioma(idioma) != 0)) {
            message += "This idioma is not possible, ";
        }

        if ((a.setPaginas(paginas) != 0)) {
            message += "This pages is not possible, ";
        }

        if ((a.setISBN(ISBN) != 0)) {
            message += "This ISBN is not possible, ";
        }

        if ((a.setFechaDeLanzamiento(fechaDeLanzamiento) != 0)) {
            message += "This fechaDeLanzamiento is not possible, ";
        }

        if ((a.setFechaDeDisponibilidad(fechaDeDisponibilidad) != 0)) {
            message += "This fechaDeDisponibilidad is not possible, ";
        }

        if ((a.setRecordatoriosDias(recordatoriosDias) != 0)) {
            message += "This recordatoriosDias is not possible, ";
        }

        try {
            a.fisico = PhysicalData.getInstancePhysicalData(ancho, largo, alto, peso, fragil);
        } catch (BuildException ex) {
            message += ex.getMessage();
        }
        

        if (message.length() > 0) {
            a = null;
            throw new BuildException(message);
        }
        return a;
    }

    public String getEditorial() {
        return editorial;
    }

    public int setEditorial(String editorial) {
        if ((checker.isNull(editorial)) != 0)
            return -1;
        if ((checker.minLength(5, editorial)) != 0)
            return -2;
        if ((checker.maxLenght(30, editorial)) != 0)
            return -10;
        this.editorial = editorial;
        return 0;
    }

    public String getIdioma() {
        return idioma;
    }

    public int setIdioma(String idioma) {
        if ((checker.isNull(idioma)) != 0)
            return -1;
        if ((checker.minLength(5, idioma)) != 0)
            return -2;
        if ((checker.maxLenght(20, idioma)) != 0)
            return -10;
        this.idioma = idioma;
        return 0;
    }

    public int getPaginas() {
        return paginas;
    }

    public int setPaginas(int paginas) {
        if ((checker.nonZero(paginas)) != 0)
            return -3;
        if ((checker.nonNegative(paginas)) != 0)
            return -4;
        if ((checker.minValue(paginas, 10)) != 0)
            return -6;
        this.paginas = paginas;
        return 0;
    }

    public String getISBN() {
        return ISBN;
    }

    public int setISBN(String ISBN) {
        if ((checker.isNull(ISBN)) != 0) return -1;
        if ((checker.validateISBN13(ISBN)) != 0) return -24;
        this.ISBN = ISBN;
        return 0;
    }

    public String getFechaDeLanzamiento() {
        return fechaDeLanzamiento.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    public int setFechaDeLanzamiento(String fechaDeLanzamiento) {
        try {
            this.fechaDeLanzamiento = checker.checkDateAndTime(fechaDeLanzamiento);
        } catch (BuildException e) {
            return -22;
        }
        return 0;
    }

    public String getFechaDeDisponibilidad() {
        return fechaDeDisponibilidad.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public int setFechaDeDisponibilidad(String fechaDeDisponibilidad) {
        try {
            this.fechaDeDisponibilidad = checker.checkDate2(fechaDeDisponibilidad);
        } catch (BuildException e) {
            return -21;
        }
        return 0;
    }

    public int getRecordatoriosDias() {
        return recordatoriosDias;
    }

    public int setRecordatoriosDias(int recordatoriosDias) {
        if ((checker.nonZero(recordatoriosDias)) != 0)
            return -3;
        if ((checker.nonNegative(recordatoriosDias)) != 0)
            return -4;
        if ((checker.maxValue(recordatoriosDias, 366)) != 0)
            return -5;
        this.recordatoriosDias = recordatoriosDias;
        return 0;
    }

    //-----------------------------------------------------------------

    public double getAncho() {
        return fisico.getAncho();
    }
    
    public double getAlto() {
        return fisico.getAlto();
    }
    
    public double getLargo() {
        return fisico.getLargo();
    }
    
    public double getPeso() {
        return fisico.getPeso();
    }
    
    public String getFragil() {
        return fisico.getFragil();
    }
    
    public int setAncho(double ancho) {
        return fisico.setAncho(ancho);
    }
    
    public int setLargo(double largo) {
        return fisico.setLargo(largo);
    }
    
    public int setAlto(double alto) {
        return fisico.setAlto(alto);
    }
    
    public int setPeso(double peso) {
        return fisico.setPeso(peso);
    }
    
    public int setFragil(String fragil) {
        return fisico.setFragil(fragil);
    }
    
    public String getDimensions() {
        return fisico.getDimensions();
    }
    
    public double getVolumen() {
        return fisico.getVolumen();
    }


    @Override
    public String getDetails() {
        return "Este libro tiene el titulo de " + name + " y es de la editorial " + editorial + "\n" +
               "Este libro tiene " + paginas + " paginas y esta en el idioma " + idioma + "\n" +
               "Este libro tiene la tematica de " + tematic + "\n" +
               "El precio de este libro es " + price + " euros \n" +
               "Este libro mide de ancho " + getAncho() + "cm, de largo " + getLargo() + "cm, y de alto " + getAlto() + "cm.\n" +
               "Este libro " + getFragil() + " es fragil y pesa un total de " + getPeso() + "g.";
    }


    @Override
    public String toString() {
        return "Book [price=" + price + ", name=" + name + ", tematic=" + tematic + ", editorial=" + editorial
                + ", idioma=" + idioma + ", paginas=" + paginas + ", ISBN=" + ISBN + ", fechaDeLanzamiento="
                + fechaDeLanzamiento + ", fechaDeDisponibilidad=" + fechaDeDisponibilidad + ", recordatoriosDias="
                + recordatoriosDias + ", getAncho()=" + getAncho() + ", getAlto()=" + getAlto()
                + ", getLargo()=" + getLargo() + ", getPeso()=" + getPeso() + ", getFragil()=" + getFragil()
                + ", getDimensions()=" + getDimensions() + ", getVolumen()=" + getVolumen() + "]";
    }


    

    /*public int setAncho(int ancho) {
    // Asegúrate de que `fisico` no es nulo antes de intentar usarlo
    if (fisico != null) {
        return fisico.setAncho(ancho); // Llama al método `setAncho` del objeto fisico
    } else {
        return -1; // Retorna un valor de error si `fisico` no está inicializado
    }
}
 */


}
