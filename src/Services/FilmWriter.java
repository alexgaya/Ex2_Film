/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Film;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

/**
 *
 * @author m
 */
public class FilmWriter {
    private final ObjectOutputStream oos;

    public FilmWriter() throws FileNotFoundException, IOException {
        oos = new ObjectOutputStream(new FileOutputStream("Films.dat"));
    }
    
    public void post(Film film) throws IOException{
        oos.writeObject(film);
    }
    
    public void close() throws IOException {
        oos.close();
    }
    
//    public void readInput() {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        
//    }
}
