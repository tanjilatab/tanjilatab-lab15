public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        //TODO: should rotate one click clockwise & change String
        String clock = (rotorValues.substring(0, (rotorValues.length() -1)));

        char endChar = (rotorValues.charAt(rotorValues.length() - 1));

        rotorValues = endChar + clock;

        //checks if rotor's current char matches starting char
        if (rotorValues.charAt(0) == startChar) {
            return true;
        }
        return false;

               
    }
    

    public int indexOf(char c){
        //TODO: returns index in String at which a guven character appears
        return rotorValues.indexOf(c);
    }

    public char charAt(int idx){
        //TODO: return character at a given index
        return rotorValues.charAt(idx);
    }
}
    
