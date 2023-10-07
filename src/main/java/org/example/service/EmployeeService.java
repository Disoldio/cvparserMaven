package org.example.service;

import org.example.model.Employee;
import org.example.model.SupportedType;
import org.example.service.extractor.DocXExtractor;
import org.example.service.extractor.FileDataExtractor;
import org.example.service.extractor.PdfExtractor;
import org.example.service.extractor.RtfExtractor;
import org.example.service.filler.DataFiller;
import org.example.service.filler.HhDataFiller;
import org.example.storage.EmployeeStorage;
import org.example.storage.Storage;
import org.apache.commons.io.FileUtils;

import javax.swing.text.BadLocationException;
import java.io.File;
import java.io.IOException;

public class EmployeeService {

    private final Storage employeeStorage;
    private final DataFiller dataFiller;
    public EmployeeService() {
        dataFiller = new HhDataFiller();
        employeeStorage = new EmployeeStorage();
    }

    public void createEmployee(File file) throws IOException, BadLocationException {
        FileDataExtractor extractor = this.obtainExtractor(file);
        String text = extractor.extract(file);

        Employee employee = dataFiller.fillData(text);

        employeeStorage.save(employee);
    }

    public void createEmployers (File folder) throws IOException, BadLocationException {

        for (int i = 0; i < folder.listFiles().length; i++) {
            File file = folder.listFiles()[i];
            createEmployee(file);
        }
    }

    private FileDataExtractor obtainExtractor(File file) {
        String fileName = file.getName();
        String extension = file.getName().substring(fileName.lastIndexOf(".") + 1, fileName.length());
        SupportedType type = SupportedType.getByString(extension);

        switch (type) {
            case PDF:
                return new PdfExtractor();
            case RTF:
            case DOC:
                return new RtfExtractor();
            case DOCX:
                return new DocXExtractor();
        }
        throw new RuntimeException("Can't obtain extractor for file " + fileName);
    }



}
