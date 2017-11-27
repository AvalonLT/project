package lt.jonas.project.service;

import lt.jonas.project.model.Class1;
import lt.jonas.project.repository.Class1Rep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Class1ServiceImpl implements Class1Service {
    @Autowired
    Class1Rep class1Rep;

    @Override
    public List<Class1> getClass1List() {
        return class1Rep.findAll();
    }
}
