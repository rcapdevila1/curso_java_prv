package com.privalia.dao.integration.test.StudentDao;

import com.privalia.dao.FileType;
import com.privalia.dao.StudentDao;
import com.privalia.model.Student;
import com.privalia.util.Config;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class StudentDaoCsvIntegrationTest extends StudentDaoGenericIntegrationTest{


    @Before
    public void setUp() throws IOException {

        filename = Config.getInstance().getFilename();

        subject = new StudentDao(filename, FileType.CSV);

        filename = filename +".csv";

        File f = new File(filename);
        if (f.exists()){
            f.delete();
        }
    }

    @After
    public void tearDown() throws IOException {
        super.tearDown();
    }

    @Test
    @Override
    public void testCreate() throws IOException {
        super.testCreate();
    }

    @Test
    @Override
    public void testAdd() throws IOException{
        super.testAdd();
    }

    public List<Student> loadFile() throws IOException {
        List<Student> r = new LinkedList<>();
        File f = new File(filename);

        assertTrue(f.exists());

       // comprovaciones 
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine())!=null){
                String[] data = line.split(",");
                Student st = new Student(data);
                r.add(st);
            }
        }  catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public String getSampleFile() {
        return "Lista_de_estudiantes.csv";
    }
}
