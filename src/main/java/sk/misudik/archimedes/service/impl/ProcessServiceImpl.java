package sk.misudik.archimedes.service.impl;

import sk.misudik.archimedes.model.output.Output;
import sk.misudik.archimedes.repository.DataRepository;
import sk.misudik.archimedes.repository.OutputRepository;
import sk.misudik.archimedes.service.ProcessService;

public class ProcessServiceImpl implements ProcessService {

    private final OutputRepository processRepository;
    private final DataRepository dataRepository;

    public ProcessServiceImpl(DataRepository dataRepository, OutputRepository processRepository) {
        this.dataRepository = dataRepository;
        this.processRepository = processRepository;
    }

    @Override
    public Output process() {
        throw new IllegalStateException();
    }
}
