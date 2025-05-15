package demo.model.order;

import demo.exceptions.BuildException;

public class OperationObject extends Operation {

    protected OperationObject() {
        super(); // constructor protegido de Operation
    }

    public static OperationObject getInstance(String operationId, String orderDate, String finishDate, String information) throws BuildException {
        String message = "";
        OperationObject operation = new OperationObject();

        try {
            operation.checkDataOperation(operationId, orderDate, finishDate, information);
        } catch (BuildException e) {
            message = e.getMessage();
        }

        if (message.length() > 0) {
            operation = null;
            throw new BuildException(message);
        }

        return operation;
    }

    public String getSummary() {
        return "Operación: " + operationId + ", ordenada el " + getOrderDate() + ", finalizada el " + getFinishDate() + ", info: " + information;
    }
}
