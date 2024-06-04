package org.example.Login;

import java.io.*;
import java.util.ArrayList;

public class File1 {


        static public void writeToFile(String fileName, String content ) throws IOException {

            try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true)))
            {

                    writer.append(content);
                    writer.newLine();
                    writer.flush();
                    writer.close();
            }

            catch (IOException exception)
            {
                System.out.println("Ошибка при работе с файлом" + exception.getMessage());
            }
        }

    static public void writeToFile( String fileName, ArrayList<String[]> lst ) throws IOException {

        try{
            File myObj = new File( fileName );
            if( myObj.delete() ) {
                System.out.println("Deleted the file: " + myObj.getName());
                BufferedWriter writer = new BufferedWriter( new FileWriter(fileName,true) );

                for( String[] i: lst )
                {
                    String cntx = "";

                    for(int j=0;j<i.length;j++)
                    {
                        cntx += i[j];
                        if(j != (i.length-1) )
                            cntx += '|';
                    }

                    writer.append( cntx );
                    writer.newLine();
                    writer.flush();
                }

                writer.close();

            } else {
                System.out.println("Failed to delete the file.");
            }

        }

        catch (IOException exception)
        {
            System.out.println("Ошибка при работе с файлом" + exception.getMessage());
        }
    }

    static public ArrayList<String[]> readFromFile(String fileName) {

            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                ArrayList<String[]> r = new ArrayList<>();
                int i = 0;
                while ((line = reader.readLine()) != null) {
                    String a[] = line.split("\\|"); // чертовы слеши !!!
                    r.add(a);
                }
                return r;
            } catch (IOException exception) {
                System.out.println("Ошибка при работе с файлом" + exception.getMessage());
            }


            return null;
        }

    public static int getLineCountByReader(String fileName) throws IOException {
        try (var lnr = new LineNumberReader(new FileReader(fileName))) {
            while (lnr.readLine() != null) ;
            return lnr.getLineNumber();
        }
    }
    }


