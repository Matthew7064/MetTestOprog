import java.io.*;

class lab0 {
    public static void my_printf(String format_string, String param){
        for(int i=0;i<format_string.length();i++){
            if((format_string.charAt(i) == '#') && (format_string.charAt(i+1) == 'k')){
                //System.out.print(param);
                for(int j=0;j<param.length();j++) {
		    System.out.print(swapLetterCase(param.charAt(j)));                
                }
                i++;
            }else{
                System.out.print(format_string.charAt(i));
            }
        }
        System.out.println("");
    }
    
    private static char swapLetterCase(char letter) {
        if(Character.isUpperCase(letter)) {
            return Character.toLowerCase(letter);
        } else if (Character.isLowerCase(letter)) {
            return Character.toUpperCase(letter);
        }
        return letter;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferReader=new BufferedReader(new InputStreamReader(System.in));
        String format_string, param;
        while(bufferReader.ready()) {
            format_string=bufferReader.readLine();
            param=bufferReader.readLine();
            my_printf(format_string,param);
        }
    }
}
