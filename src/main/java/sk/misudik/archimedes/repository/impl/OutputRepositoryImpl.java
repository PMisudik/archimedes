package sk.misudik.archimedes.repository.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import sk.misudik.archimedes.model.output.Outputs;
import sk.misudik.archimedes.repository.OutputRepository;

import java.io.File;
import java.io.IOException;

public class OutputRepositoryImpl implements OutputRepository {

    private final CsvMapper mapper;

    public OutputRepositoryImpl() {
        this.mapper = new CsvMapper();
    }

    @Override
    public Outputs save(Outputs outputs) throws IOException {
        ArrayNode arrayNode = mapper.createArrayNode();
        outputs.getData().forEach(arrayNode::addPOJO);
        mapper.writerFor(JsonNode.class).with(createSchema()).writeValue(new File(OUTPUT_PATH), arrayNode);
        return outputs;
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
