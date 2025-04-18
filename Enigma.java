public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        //TODO: same steps as encrypting, just in reverse
        String decrypted = "";
        for (int i = 0; i < message.length(); i++) {
            //find index of outer rotor character
            int outerIndex = rotors[2].indexOf(message.charAt(i));

            //find char in middle rotor at outer index
            char middle = rotors[1].charAt(outerIndex);

            //find aligned char index of middle rotor in outer
            int outerMid = rotors[2].indexOf(middle);
            
            char output = rotors[0].charAt(outerMid);

            decrypted += output;
            rotate();
        }
        return decrypted;
    }


    
    public String encrypt(String message){
        //TODO 
        String encrypted = "";

        //find character on inner rotor
        for (int i = 0; i < message.length(); i++) {
            int innerIndex = this.rotors[0].indexOf(message.charAt(i));

            //aligned character with it on outer rotor
            char outerChar = rotors[2].charAt(innerIndex);

            //find that character in middle rotor
            int outerIndex = rotors[1].indexOf(outerChar);

            //output the one aligned with it on the outer rotor
            char output = rotors[2].charAt(outerIndex);

            encrypted += output;
            rotate();
        }
        return encrypted;
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
