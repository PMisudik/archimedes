package sk.misudik.archimedes.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import sk.misudik.archimedes.Main;
import sk.misudik.archimedes.model.input.calls.Calls;
import sk.misudik.archimedes.model.input.operators.Operators;

import java.io.IOException;
import java.util.Objects;

public class DataRepositoryImpl implements DataRepository {

    private static final String CALLS_PATH = "data/calls.json";
    private static final String OPERATORS_PATH = "data/operators.json";

    private final ObjectMapper mapper;

    public DataRepositoryImpl() {
        this.mapper = new ObjectMapper();
    }

    @Override
    public Calls getCalls() throws IOException {
        return mapper.readValue(Objects.requireNonNull(Main.class.getClassLoader().getResource(CALLS_PATH)), Calls.class);
    }

    @Override
    public Operators getOperators() throws IOException {
        return mapper.readValue(Objects.requireNonNull(Main.class.getClassLoader().getResource(OPERATORS_PATH)), Operators.class);
    }
}
