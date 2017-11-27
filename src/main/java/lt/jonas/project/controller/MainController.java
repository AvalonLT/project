package lt.jonas.project.controller;

import lt.jonas.project.model.*;
import lt.jonas.project.service.*;
import lt.jonas.project.util.StudentUtil;
import lt.jonas.project.util.TeacherUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    SubjectListService subjectListService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    TeacherUtil teacherUtil;
    @Autowired
    StudentUtil studentUtil;
    @Autowired
    StudentService studentService;
    @Autowired
    Class1Service class1Service;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView model = new ModelAndView("welcomepage");
        List<Teacher> teachersList = teacherService.findAll();
        model.addObject("teachersList", teachersList);
        return model;
    }

    @RequestMapping(value = "/subjectList", method = RequestMethod.GET)
    public ModelAndView subjectList() {
        ModelAndView model = new ModelAndView("subjectlist");
        List<SubjectList> subjectListList = subjectListService.findAll();
        model.addObject("subjectList", subjectListList);
        return model;
    }

    @RequestMapping(value = "/studentList", method = RequestMethod.GET)
    public ModelAndView studentList() {
        ModelAndView model = new ModelAndView("studentlist");
        List<Student> studentList = studentService.getStudentList();
        model.addObject("studentlist", studentList);
        return model;
    }

    @RequestMapping(value = "/class1List", method = RequestMethod.GET)
    public ModelAndView studentList3() {
        ModelAndView model = new ModelAndView("class1list");
        List<Student> studentList = studentService.getStudentList();
        model.addObject("studentlist", studentList);
        return model;
    }

//    @RequestMapping(value = "/class1List", method = RequestMethod.GET)
//    public ModelAndView class1List() {
//        ModelAndView model = new ModelAndView("class1list");
//        List<Class1> class1List = class1Service.getClass1List();
//        List<Student> studentList = studentService.getStudentList();
//        model.addObject("studentlist", studentList);
////        model.addObject("class1List", class1List);
//        return model;
//    }

    @RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
    public String addTeacher(@ModelAttribute Teacher teacher, @RequestParam String subject) {
        Teacher teacherWithId = teacherService.addTeacher(teacher);
        List<Subject> subjectList = new ArrayList<>();
        teacher.setSubjectList(subjectList);
        Subject subject1 = new Subject();
        subjectList.add(subject1);
        subject1.setName(subject);
        subject1.setTeacher(teacherWithId);
        teacherService.addSubject(subject1);
        return "redirect:main";
    }

    @RequestMapping(value = "/deleteTeacher", method = RequestMethod.POST)
    @ResponseBody
    public void deleteTeacher(@RequestParam long id) {

        teacherService.deleteTeacherById(id);
    }

    @RequestMapping(value = "/deleteSubjectsList", method = RequestMethod.POST)
    @ResponseBody
    public void deleteSubjectsList(@RequestParam long id) {
        subjectListService.deleteSubjectListById(id);
    }

    @RequestMapping(value = "/updateTeacher", method = RequestMethod.POST)
    public String updateTeacher(@ModelAttribute Teacher teacher, @RequestParam (value = "subjectlist") String subjectList) {
        subjectService.deleteAllSubjects(subjectService.findAllSubjectsByTeacherId(teacher.getId()));
        teacherService.updateTeacherById(teacher);
        subjectService.updateSubjectListByTeacher(teacherUtil.makeSubjectList(subjectList, teacher));
        return "redirect:main";
    }

    @RequestMapping(value = "/addSubjectList", method = RequestMethod.POST)
    public String updateTeacher(@ModelAttribute SubjectList subjectList) {
        subjectListService.addSubjectList(subjectList);
        return "redirect:subjectList";
    }

    @RequestMapping(value = "/getSubjectsListList", method = RequestMethod.GET)
    @ResponseBody
    public List<SubjectList> getSubjectListList() {
        return subjectListService.findAll();
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute Student student, @RequestParam String parent_address, @RequestParam String class_name) {
        Class1 class1 = studentService.addClass1WithNameAndReturnObjectWithId(class_name);
        Foster foster = studentService.addFosterWithAddressAndReturnObjectWithId(parent_address);
        studentService.addStudent(student, foster, class1);
        return "redirect:studentList";
    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
    @ResponseBody
    public void deleteStudent(@RequestParam long id) {
        studentService.deleteStudent(id);
    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    @ResponseBody
    public String updateStudent(@ModelAttribute Student student,@RequestParam long studentid, @RequestParam String parent_info, @RequestParam String class_name, @RequestParam long fosterid, @RequestParam long class1id) {
        Class1 class1 = studentService.updateClass1(class1id, class_name);
        Foster foster = studentService.updateFoster(fosterid, parent_info);
        studentService.updateStudent(studentid, student, foster, class1);
        return "redirect:studentList";
    }




//    @RequestMapping(value = "/updateTeacher", method = RequestMethod.GET)
//    @ResponseBody
//    public void updateTeacher(@RequestBody Teacher teacher) {
//        subjectListService.findAll();
//    }




}
