package backend.controller;

import backend.dto.DRLFileDTO;
import org.drools.template.DataProvider;
import org.drools.template.DataProviderCompiler;
import org.drools.template.objects.ArrayDataProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("templates")
public class DroolsTemplateController {

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createDRLFile(@RequestBody DRLFileDTO dto) {

        InputStream template = DroolsTemplateController.class.getResourceAsStream("/templates/recipe-popularity-template.drt");

        DataProvider dataProvider = new ArrayDataProvider(new String[][]{
                new String[]{String.valueOf(dto.getLowMin()), String.valueOf(dto.getLowMax()), "LOW"},
                new String[]{String.valueOf(dto.getMediumMin()), String.valueOf(dto.getMediumMax()), "MEDIUM"},
                new String[]{String.valueOf(dto.getHighMin()), String.valueOf(dto.getHighMax()), "HIGH"},
        });

        DataProviderCompiler converter = new DataProviderCompiler();
        String drl = converter.compile(dataProvider, template);

        try {
        System.out.println(System.getProperty("user.dir")+"\\src\\main\\resources\\rules\\meals123-rules.drl");
        File myFoo = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\rules\\template-rules.drl");
        FileWriter fooWriter = null; // true to append
        fooWriter = new FileWriter(myFoo, false);
        // false to overwrite.
        fooWriter.write(drl);
        fooWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok("You have to restart the application for changes to apply!");
    }

}
