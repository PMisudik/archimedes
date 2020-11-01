package sk.misudik.archimedes.service;

import sk.misudik.archimedes.model.output.Outputs;

import java.io.IOException;

public interface ProcessService {

    Outputs process() throws IOException;

}
