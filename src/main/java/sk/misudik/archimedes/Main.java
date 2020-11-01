package sk.misudik.archimedes;

import sk.misudik.archimedes.repository.impl.DataRepositoryImpl;
import sk.misudik.archimedes.repository.impl.OutputRepositoryImpl;
import sk.misudik.archimedes.service.impl.ProcessServiceImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        new ProcessServiceImpl(new DataRepositoryImpl(), new OutputRepositoryImpl()).process();
    }
}
