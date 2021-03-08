/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2_films;

import Helpers.InputSanitizer;
import Models.Film;
import Models.GenreType;
import Services.FilmReader;
import Services.FilmWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author m
 */
public class Exercise2_Films {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here
        
        
        menu();
    }
    
    public static void menu() throws IOException, ClassNotFoundException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce 1 to save 3 new films");
        System.out.println("Introduce 2 to read the stored films");
        System.out.println("Introduce 3 to quit");
        int i = -1;
        try{
            i = InputSanitizer.sanitizeNumber(in.readLine());
        } catch(NumberFormatException e) {
            System.out.println("You must write a number.");
        }
        switch(i) {
            case 1:
                postFilms(in);
                menu();
                break;
            case 2:
                getFilms();
                menu();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                menu();
                break;
        }
    }
    
    public static void getFilms() throws IOException, ClassNotFoundException {
        FilmReader fr = new FilmReader();
        Film f = fr.getFilm();
        while(!f.isSentinel()) {
            System.out.println(f);
            f = fr.getFilm();
        }
        fr.close();
    }
    
    public static void postFilms(BufferedReader in) throws IOException {
        FilmWriter fw = new FilmWriter();
        for (int i = 0; i < 3; i++){
            Film f = new Film(readInputString("Title: ", in), 
                    readInputString("Director: ", in), 
                    readInputInt("Year: ", in), 
                    readInputGenre("Genre: ", in));
            fw.post(f);
        }
        fw.post(Film.sentinel);
        fw.close();
    }
    
    public static String readInputString(String a, BufferedReader in) throws IOException{
        String s;
        
        System.out.print(a);
        s = in.readLine();
        return InputSanitizer.sanitizeString(s);
    }
    
    public static int readInputInt(String a, BufferedReader in) throws IOException {
        String s;
        System.out.print(a);
        s = in.readLine();
        return InputSanitizer.sanitizeNumber(s);
    }
    
    public static GenreType readInputGenre(String a, BufferedReader in) throws IOException {
        String s;
        System.out.print(a);
        s = in.readLine();
        s = InputSanitizer.sanitizeString(s);
        GenreType genre = null;
        
        for (GenreType g : GenreType.values()){
            if (s.equalsIgnoreCase(g.toString())) {
                genre = g;
                break;
            }
        }
        
        return genre != null ? genre : readInputGenre(a, in);
        
    }

    
}
