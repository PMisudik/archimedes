package sk.misudik.archimedes.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import sk.misudik.archimedes.Main;
import sk.misudik.archimedes.model.input.calls.Calls;
import sk.misudik.archimedes.model.input.operators.Operators;

import java.io.IOException;
import java.util.Objects;

public class DataRepositoryImpl implements DataRepository {

    private final ObjectMapper mapper;

    DataRepositoryImpl() {
        this.mapper = new ObjectMapper();
    }

    @Override
    public Calls getCalls() throws IOException {
        return mapper.readValue(Objects.requireNonNull(Main.class.getClassLoader().getResource("calls.json")), Calls.class);
    }

    @Override
    public Operators getOperators() throws IOException {
        return mapper.readValue(Objects.requireNonNull(Main.class.getClassLoader().getResource("operators.json")), Operators.class);
    }
}
