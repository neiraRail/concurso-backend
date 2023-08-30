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
        List<NecesidadDataEntity> entities = parseCSVFile("DATACONCURSO.csv");
        service.saveAll(entities);
    }

    private List<NecesidadDataEntity> parseCSVFile(String csvFilePath) throws IOException {
        List<NecesidadDataEntity> entities = new ArrayList<>();

        try (CSVReader reader = new CSVReaderBuilder(new FileReader(csvFilePath)).withSkipLines(1).build()) {
            String[] line;
            while ((line = reader.readNext()) != null) {

                NecesidadDataEntity entity = new NecesidadDataEntity();
                entity.setNombreSolicitante(line[0]); // Adjust indices based on your CSV
                entity.setRutSolicitante(line[1]);
                entity.setCorreo(line[2]);
                entity.setTituloNecesidad(line[3]);
                entity.setDescripcionNecesidad(line[4]);
                entity.setCategoria(line[5]);
                entity.setTipoEntidad(line[6]);
                entity.setComuna(line[7]);
                entity.setPalabrasClave(line[8]);
                entity.setObjetivosDS(line[9]);
                entity.setImagen(line[10]);
                entities.add(entity);
            }
        }

        return entities;
    }
}
