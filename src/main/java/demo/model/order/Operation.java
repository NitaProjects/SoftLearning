package demo.model.order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import demo.model.operations.checker;
import demo.exceptions.BuildException;

public abstract class Operation {
    protected String operationId;
    protected LocalDateTime orderDate;
    protected LocalDateTime finishDate;
    protected String information;

    protected Operation(String operationId, String orderDate, String finishDate, String information) throws BuildException {
        checkDataOperation(operationId, orderDate, finishDate, information);
    }

    protected Operation(){

    }



    protected void checkDataOperation(String operationId, String orderDate, String finishDate, String information) throws BuildException {
        String message = "";

        if ((setOperationId(operationId)!=0)){
            message += "This operation ID is not correctly, ";
        }

        // 

        // if ((setOrderDate(orderDate)!=0)){
        //     message += "This order date is not correctly, ";
        // }
        // if ((setFinishDateFromString(finishDate)!=0)){
        //     message += "This finish date is not correctly, ";
        // }

        this.information = information;

        if (message.length() > 0) {
            throw new BuildException(message);
        }

    }


    public String getOperationId() {
        return operationId;
    }
    public int setOperationId(String operationId) {
        if ((checker.isNull(operationId)) != 0)
            return -1;
        if ((checker.minLength(9, operationId)) != 0)
            return -2;
        if ((checker.maxLenght(11, operationId)) != 0)
            return -10;
        this.operationId = operationId;
        return 0;
    }
    
    public String getOrderDate() {
        return orderDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }
    public int setOrderDate(String orderDate) {
        try {
            this.orderDate = checker.checkDateAndTime(orderDate);
        } catch (BuildException e) {
            return -21;
        }
        return 0;
    }
    public String getFinishDate() {
        return finishDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }
    public int setFinishDateFromString(String finishDate) {
        try {
            this.finishDate = checker.checkDateAndTime(finishDate);
        } catch (BuildException e) {
            return -21;
        }
        return 0;
    }

    public String getInformation() {
        return information;
    }
    


    

}
