package sk.misudik.archimedes.repository.impl;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import sk.misudik.archimedes.model.output.Output;
import sk.misudik.archimedes.repository.OutputRepository;

import java.io.File;
import java.io.IOException;

public class OutputRepositoryImpl implements OutputRepository {

    private final CsvMapper mapper;

    public OutputRepositoryImpl() {
        this.mapper = new CsvMapper();
    }

    @Override
    public void save(Output output) throws IOException {
        mapper.writerFor(Output.class).with(createSchema()).writeValue(new File("target/output.csv"), output);
    }

    private CsvSchema createSchema() {
        CsvSchema.Builder builder = CsvSchema.builder();
        builder.addColumn("id");
        builder.addColumn("date");
        builder.addColumn("number");
        builder.addColumn("operator");
        builder.addColumn("riskScore");
        return builder.build().withHeader();
    }
}
