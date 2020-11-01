package sk.misudik.archimedes.service.impl;

import sk.misudik.archimedes.model.input.calls.Call;
import sk.misudik.archimedes.model.input.operators.Operator;
import sk.misudik.archimedes.model.input.operators.Operators;
import sk.misudik.archimedes.model.output.Output;
import sk.misudik.archimedes.model.output.Outputs;
import sk.misudik.archimedes.repository.DataRepository;
import sk.misudik.archimedes.repository.OutputRepository;
import sk.misudik.archimedes.service.ProcessService;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ProcessServiceImpl implements ProcessService {

    private final OutputRepository processRepository;
    private final DataRepository dataRepository;

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.0");

    public ProcessServiceImpl(DataRepository dataRepository, OutputRepository processRepository) {
        this.dataRepository = dataRepository;
        this.processRepository = processRepository;
    }

    @Override
    public Outputs process() throws IOException {
        var operators = operatorsMap(dataRepository.getOperators());
        List<Output> outputList = new ArrayList<>();
        for (Call call : dataRepository.getCalls().getData()) {
            outputList.add(processCall(call, operators));
        }
        return processRepository.save(createOutputs(outputList));
    }

    private Output processCall(Call call, Map<String, Operator> operators) {
        var output = new Output();
        output.setId(call.getId());
        output.setOperator(findOperator(call, operators));
        output.setNumber(parseNumber(call.getAttributes().getNumber()).substring(4, 8));
        output.setRiskScore(parseRiskScore(call));
        output.setDate(parseDate(call.getAttributes().getDate()));
        return output;
    }

    private float parseRiskScore(Call call) {
        if (call.getAttributes().isGreenList() || (call.getAttributes().isRedList() && call.getAttributes().isGreenList())) {
            return 0.0f;
        } else if (call.getAttributes().isRedList()) {
            return 1.0f;
        }
        return Float.parseFloat(DECIMAL_FORMAT.format(call.getAttributes().getRiskScore()));
    }

    private String parseDate(String date) {
        return date.substring(0, 10);
    }

    private String findOperator(Call call, Map<String, Operator> operators) {
        var operator = operators.get(call.getId());
        return operator == null ? "Unknown" : operator.getAttributes().getOperator();
    }

    private String parseNumber(String number) {
        return number == null || number.isEmpty() ? "Withheld" : number;
    }

    private Outputs createOutputs(List<Output> outputList) {
        var outputs = new Outputs();
        sortByDate(outputList);
        outputs.setData(outputList);
        return outputs;
    }

    private void sortByDate(List<Output> outputList) {
        outputList.sort((o1, o2) -> {
            try {
                return new SimpleDateFormat("YYYY-MM-DD").parse(o1.getDate())
                        .compareTo(new SimpleDateFormat("YYYY-MM-DD").parse(o2.getDate()));
            } catch (ParseException e) {
                throw new IllegalArgumentException("Date is invalid", e);
            }
        });
    }

    private Map<String, Operator> operatorsMap(Operators operators) {
        return operators.getData().stream().collect(Collectors.toMap(Operator::getId, operator -> operator));
    }
}
