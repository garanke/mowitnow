package com.example.mowitnow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class TondeuseTasklet implements Tasklet {

    private static final Logger logger = LoggerFactory.getLogger(TondeuseTasklet.class);

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        try {
            File file = new File("src/main/resources/input");
            Scanner scanner = new Scanner(file);

            int maxX = scanner.nextInt();
            int maxY = scanner.nextInt();

            List<Tondeuse> tondeuses = new ArrayList<>();

            while (scanner.hasNext()) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                char orientation = scanner.next().charAt(0);
                String instructions = scanner.next();

                Tondeuse tondeuse = new Tondeuse(x, y, orientation, instructions, maxX, maxY);
                tondeuses.add(tondeuse);
            }

            for (Tondeuse tondeuse : tondeuses) {
                tondeuse.executeInstructions();
                System.out.println(tondeuse);
                logger.info(tondeuse.toString());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }

        return RepeatStatus.FINISHED;
    }
}