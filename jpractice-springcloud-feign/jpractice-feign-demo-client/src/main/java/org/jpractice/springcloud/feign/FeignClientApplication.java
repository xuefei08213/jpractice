/**
 * 
 */
package org.jpractice.springcloud.feign;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.io.ClassPathResource;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-12-03 17:30:39
 * @Description: TODO
 * @version V1.0
 */
@SpringBootApplication
@EnableFeignClients({ "org.jpractice" })
@EnableCaching
public class FeignClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FeignClientApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        String replaceScript = "";
        File entrypointsFile = new ClassPathResource("static/entrypoints").getFile();
        if (entrypointsFile.isDirectory()) {
            File[] files = entrypointsFile.listFiles();
            for (File file : files) {
                replaceScript = replaceScript + String.format(
                        "<script type=\"text/javascript\" src=\"../entrypoints/%s.js\"></script>\n", file.getName());
            }
        }

        modifyFile("static/portal/index.html", "<placeholder></placeholder>", replaceScript);
    }

    private void modifyFile(String filePath, String oldString, String newString) {

        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            File fileToBeModified = new ClassPathResource(filePath).getFile();
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String line = reader.readLine();
            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }
            String newContent = oldContent.replaceAll(oldString, newString);
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
