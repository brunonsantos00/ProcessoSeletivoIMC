package com.selecao;

import java.io.*;

public class App{
    public static void main(String[] args) {
        
        try {
            int error = 0;

            String line = null;

            BufferedReader file = new BufferedReader(new FileReader("./dataset.csv"));
            PrintWriter newFile = new PrintWriter("./BrunoNascimentoSantos.txt");

            //Read the first line(header).
            line = file.readLine();
            //Go to second line. 
            line = file.readLine();

            //Validate if line exist.
            while( line != null ){

                String[] value = line.split(";");
                String nome = value[0].toUpperCase().trim();
                String sobrenome = value[1].toUpperCase().trim();

                //If not have all columns count one error.
                if ( value.length == 4) { //Numero de itens do array
                    double peso = Double.parseDouble(value[2].replace(',', '.'));
                    double altura = Double.parseDouble(value[3].replace(',', '.'));

                    //Calculate imc.
                    Calculo obj = new Calculo(altura, peso);

                    double imc = obj.getImc();
                                                
                    //Print to final newFile.
                    newFile.println(nome + " " + sobrenome + " " + String.format("%.2f", imc));
                } else {
                    error += 1;
                }   

                //Go to next line.
                line = file.readLine();
            }

            //Close files;
            file.close();
            newFile.close();

            //Count error because has one line without data.
            if(error > 0){
                System.out.println(error + " linha(s) esta(ão) danificada(s) ou faltando dado");
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}