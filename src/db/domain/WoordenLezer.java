package db.domain;

import domain.DbException;
import domain.WoordenLijst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WoordenLezer {
    private File file;

    public WoordenLezer(File file) {
        if (file.getAbsolutePath().trim().isEmpty() || file.equals(null)) {
            throw new DbException("geef een geldige file path in",new IllegalArgumentException());
        }
        this.file = file;
    }

    public WoordenLijst lees() {
        try {
            Scanner fileScanner = new Scanner(file);
            //Scanner fileScanner = new Scanner(new File("C:\\Gip\\project\\projectweek-team7\\src\\db\\domain\\hangman(1).txt"));
            WoordenLijst woordenLijst = new WoordenLijst();
            while (fileScanner.hasNext()) {
                woordenLijst.voegToe(fileScanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       return null;
    }
}
