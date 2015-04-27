package org;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//@ComponentScan
@EnableAutoConfiguration
public class Application {

    private final Logger log = LoggerFactory.getLogger(Application.class);

    /**
     * Main method, used to run the application.
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setShowBanner(true);
        createFiles(66000);
        app.run(args);
    }

    private static void createFiles(int numberOfFiles) {
        try {

            for (int i = 1; i < numberOfFiles; i++) {
                System.out.println(i);
                String name = "J" + String.format("%05d", i);

                String content = "package files; public class " + name + " {}";

                File file = new File("src/main/resources/" + name);

                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content);
                bw.close();

                // System.out.println("Done");


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
