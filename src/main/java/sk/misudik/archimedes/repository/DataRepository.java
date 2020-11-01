package sk.misudik.archimedes.repository;

import sk.misudik.archimedes.model.input.calls.Calls;
import sk.misudik.archimedes.model.input.operators.Operators;

import java.io.IOException;

public interface DataRepository {

    Calls getCalls() throws IOException;

    Operators getOperators() throws IOException;
}
