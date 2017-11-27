function deleteStudent(id) {
    $.post("/deleteStudent?id="+id,
        function(data) {
            document.getElementById("student-row-"+id).innerHTML = "";
        });
}

function editStudent(studentId, class1Id, fosterId) {
    document.getElementById("student-name-"+studentId).setAttribute("contenteditable", "true");
    document.getElementById("student-surname-"+studentId).setAttribute("contenteditable", "true");
    document.getElementById("parent_info-address-"+studentId).setAttribute("contenteditable", "true");
    document.getElementById("class_name-"+studentId).setAttribute("contenteditable", "true");

    document.getElementById("student_button_edit-"+studentId).innerHTML = "<button class=\"btn btn-danger\" onclick=\"updateStudent("+studentId+","+class1Id+","+fosterId+")\">Atnaujinti</button>";
}

function updateStudent(studentId, class1Id, fosterId) {
    document.getElementById("student-name-"+studentId).setAttribute("contenteditable", "false");
    document.getElementById("student-surname-"+studentId).setAttribute("contenteditable", "false");
    document.getElementById("parent_info-address-"+studentId).setAttribute("contenteditable", "false");
    document.getElementById("class_name-"+studentId).setAttribute("contenteditable", "false");

    var name = document.getElementById("student-name-"+studentId).innerHTML;
    var surname = document.getElementById("student-surname-"+studentId).innerHTML;
    var parent_info = document.getElementById("parent_info-address-"+studentId).innerHTML;
    var class1_name = document.getElementById("class_name-"+studentId).innerHTML;

    document.getElementById("student_button_edit-"+studentId).innerHTML = "<button class=\"btn btn-success\" onclick=\"editStudent("+studentId+","+class1Id+","+fosterId+")\">Redaguoti</button>"

    $.post("/updateStudent?studentid="+studentId+"&name="+name+"&surname="+surname+"&parent_info="+parent_info+"&class_name="+class1_name+"&fosterid="+fosterId+"&class1id="+class1Id);
}