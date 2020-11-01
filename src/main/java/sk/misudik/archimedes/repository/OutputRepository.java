package sk.misudik.archimedes.repository;

import sk.misudik.archimedes.model.output.Output;

import java.io.IOException;

public interface OutputRepository {

    void save(Output output) throws IOException;

}
