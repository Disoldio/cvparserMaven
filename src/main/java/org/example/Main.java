package org.example;

import org.example.model.Employee;
import org.example.model.Position;
import org.example.service.EmployeeService;
import org.example.service.extractor.PdfExtractor;
import org.example.service.extractor.RtfExtractor;
import org.example.storage.EmployeeStorage;
//import org.example.storage.PositionStorage;

import javax.swing.text.BadLocationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, BadLocationException {
        RtfExtractor rtf = new RtfExtractor();
        PdfExtractor pdf = new PdfExtractor();
        EmployeeStorage storage = new EmployeeStorage();
        Employee emp = new Employee();
        Position pos = new Position();
//        PositionStorage positionStorage = new PositionStorage();
        File file = new File("resumes/Сергеев Иван.rtf");
        EmployeeService employeeService = new EmployeeService();

//        pos.setTitle("PHP-разработчик");
//        positionStorage.save(pos);
//        String data = rtf.extract(file);
//        HhDataFiller hhdf = new HhDataFiller();
//        emp = hhdf.fillData(data);
//        storage.save(emp);

//        File file1 = new File("resumes");
//        employeeService.createEmployers(file1);
//        System.out.println();
//        System.out.println("done! :)");
        storage.getAll();
    }
}