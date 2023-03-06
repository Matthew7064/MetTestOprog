import java.io.*;

class lab2 {
    public static void my_printf(String format_string, String param){
        for(int i=0;i<format_string.length();i++) {
            if((format_string.charAt(i) == '#') && (format_string.charAt(i+1) == 'k')) {
                for(int j=0;j<param.length();j++) {
                    System.out.print(swapLetterCase(param.charAt(j)));
                }
                i++;
            } else if((format_string.charAt(i) == '#') && (format_string.charAt(i+1) == '.')) {
                String stringNumber = format_string.substring(i+2);
                int number = getNumber(stringNumber);
                int length = String.valueOf(number).length();
                if(number == -1) {
                    System.out.print(format_string.charAt(i));
                } else {
                    //System.out.print("{number: " + number + ", length: " + length + "}");
                    if(format_string.charAt(i+2+length) == 'k') {
                        for (int j = 0; j < number; j++) {
                            System.out.print(swapLetterCase(param.charAt(j)));
                        }
                        i = i + 2 + length;
                    } else {
                        System.out.print(format_string.charAt(i));
                    }
                }
            }
            else{
                System.out.print(format_string.charAt(i));
            }
        }
        System.out.println();
    }

    private static char swapLetterCase(char letter) {
        if(Character.isUpperCase(letter)) {
            return Character.toLowerCase(letter);
        } else if (Character.isLowerCase(letter)) {
            return Character.toUpperCase(letter);
        }
        return letter;
    }

    private static int getNumber(String argument) {
        int number = -1;
        for(int i=0;i<argument.length();i++) {
            if(i==0) number = 0;
            if(Character.isDigit(argument.charAt(i))) {
                number *= 10;
                number += Character.digit(argument.charAt(i), 10);
            } else {
                break;
            }
        }
        return number;
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
