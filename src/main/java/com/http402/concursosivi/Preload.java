package com.http402.concursosivi;

import com.http402.concursosivi.Entity.NecesidadDataEntity;
import com.http402.concursosivi.Service.NecesidadService;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Component
public class Preload implements CommandLineRunner {

    @Autowired
    private NecesidadService service; // Inject your service here

    @Override
    public void run(String... args) throws Exception {
        List<NecesidadDataEntity> entities = parseCSVFile("csv/data.csv");
        service.saveAll(entities);
    }

    private List<NecesidadDataEntity> parseCSVFile(String csvFilePath) throws IOException {
        List<NecesidadDataEntity> entities = new ArrayList<>();

        try (CSVReader reader = new CSVReaderBuilder(new FileReader(csvFilePath)).withSkipLines(1).build()) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                NecesidadDataEntity entity = new NecesidadDataEntity();
                entity.setColumn1(line[0]); // Adjust indices based on your CSV
                entity.setColumn2(line[1]);
                // Set other fields similarly
                entities.add(entity);
            }
        }

        return entities;
    }
}
