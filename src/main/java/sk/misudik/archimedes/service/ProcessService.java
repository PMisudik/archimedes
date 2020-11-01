package sk.misudik.archimedes.service;

import sk.misudik.archimedes.model.input.calls.Calls;
import sk.misudik.archimedes.model.input.operators.Operators;

public interface ProcessService {

    void process(Calls calls, Operators operators);

}
