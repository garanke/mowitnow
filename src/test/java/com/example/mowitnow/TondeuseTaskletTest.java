package com.example.mowitnow;

import org.junit.jupiter.api.Test;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;

import java.io.File;
import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.*;

public class TondeuseTaskletTest {

    @Test
    public void testTaskletExecution() throws Exception {
        File inputFile = File.createTempFile("input", ".txt");
        try (FileWriter writer = new FileWriter(inputFile)) {
            writer.write("5 5\n");
            writer.write("1 2 N\n");
            writer.write("GAGAGAGAA\n");
            writer.write("3 3 E\n");
            writer.write("AADAADADDA\n");
        }

        // Remplacer le fichier d'entrée par le fichier temporaire
        System.setProperty("input.file", inputFile.getAbsolutePath());

        TondeuseTasklet tasklet = new TondeuseTasklet();
        StepContribution contribution = null;
        ChunkContext chunkContext = null;

        RepeatStatus status = tasklet.execute(contribution, chunkContext);
        assertEquals(RepeatStatus.FINISHED, status);
        inputFile.delete();
    }
}