package demo.model.products;

import demo.exceptions.BuildException;
import demo.model.operations.checker;

public class PhysicalData {  
    protected double ancho;
    protected double largo;
    protected double alto;
    protected double peso;
    protected String fragil;


    private PhysicalData(){

    }

    public static PhysicalData getInstancePhysicalData(double ancho, double largo, double alto, double peso, String fragil) throws BuildException {
         String message = "";
        PhysicalData c = new PhysicalData();
         if ((c.setAncho(ancho) != 0)){
            message  += "This wide is not possible, ";
         }
         if ((c.setLargo(largo) != 0)){
            message  += "This large is not possible, ";
         }
         if ((c.setAlto(alto) != 0)){
            message  += "This high is not possible, ";
         }
         if ((c.setPeso(peso) != 0)){
            message  += "This weight is not possible, ";
         }
         if ((c.setFragil(fragil) != 0)){
            message  += "This fragil is not possible, ";
         }

         if (message.length() > 0) {
            c = null;
            throw new BuildException(message);
         }
         return c;
    }


    public double getAncho() {
        return ancho;
    }

    public int setAncho(double ancho) {
        if ((checker.nonZero(ancho)) != 0) return -3;
        if ((checker.nonNegative(ancho)) != 0) return -4;
        if ((checker.maxValue(ancho, 70.00)) != 0) return -5; 
        if ((checker.minValue(ancho, 5.00)) != 0) return -6;
        this.ancho = ancho;
        return 0;
    }

    public double getLargo() {
        return largo;
    }

    public int setLargo(double largo) {
        if ((checker.nonZero(largo)) != 0) return -3;
        if ((checker.nonNegative(largo)) != 0) return -4;
        if ((checker.maxValue(largo, 100.00)) != 0) return -5; 
        if ((checker.minValue(largo, 10.00)) != 0) return -6;
        this.largo = largo;
        return 0;
    }

    public double getAlto() {
        return alto;
    }

    public int setAlto(double alto) {
        if ((checker.nonZero(alto)) != 0) return -3;
        if ((checker.nonNegative(alto)) != 0) return -4;
        if ((checker.maxValue(alto, 40.00)) != 0) return -5; 
        if ((checker.minValue(alto, 3.00)) != 0) return -6;
        this.alto = alto;
        return 0;
    }

    public double getPeso() {
        return peso;
    }

    public int setPeso(double peso) {
        if ((checker.nonZero(peso)) != 0) return -3;
        if ((checker.nonNegative(peso)) != 0) return -4;
        if ((checker.maxValue(peso, 20.00)) != 0) return -5; 
        if ((checker.minValue(peso, 0.50)) != 0) return -6;
        this.peso = peso;
        return 0;
    }

    public String getFragil() {
        return fragil;
    }

    public int setFragil(String fragil) {
        if ((checker.isNull(fragil)) != 0) return -1;
        if ((checker.yesOrNo(fragil)) != 0) return -8;
        this.fragil = fragil;
        return 0;
    }

    public String getDimensions(){
        return "Tus medidas son: " + this.getAlto() + 'x' + this.getAncho() + 'x' +  this.getLargo();
    }
    
    public double getVolumen(){
        return (this.getAlto() * this.getAncho() * this.getLargo());
    }

    @Override
    public String toString() {
        return "PhysicalData [ancho=" + ancho + ", largo=" + largo + ", alto=" + alto + ", peso=" + peso + ", fragil="
                + fragil + "]";
    }

    

}
