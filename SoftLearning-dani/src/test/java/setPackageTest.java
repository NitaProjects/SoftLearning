


public class setPackageTest {
    public static void main(String[] args) {
        String packageDetails = "h:202.20,w:202.20,W:202.20,f:yes,d:202.20";
    
        // Split the string by commas
        String[] myArray = packageDetails.split(",");
    
        // Iterate over each key-value pair
        for (String s : myArray) {
            // Split each key-value pair by the colon (:)
            String[] keyValue = s.split(":");
            String key = keyValue[0]; 
            String value = keyValue[1]; 
    

            switch (key) {
                case "f": 
                    setFragile(value);
                    break;
                case "h":
                    setHeight(value); 
                    break;
                case "w":
                    setWidth(value);   
                    break;
                case "W":
                    setWeight(value);  
                    break;
                case "d":
                    setDepth(value);  
                    break;
                default:
                    break;
            }
        }
    }
    
    // Example methods
    public static void setFragile(String value) {
        System.out.println("Fragile: " + value);
    }
    
    public static void setHeight(String value) {
        System.out.println("Height: " + value);
    }
    
    public static void setWidth(String value) {
        System.out.println("Width: " + value);
    }
    
    public static void setWeight(String value) {
        System.out.println("Weight: " + value);
    }
    
    public static void setDepth(String value) {
        System.out.println("Depth: " + value);
    }
    
    
}

