var selectedRow = null;

function deleteTeacher(id) {
    $.post("/deleteTeacher?id="+id,
        function(data) {
        document.getElementById("row-"+id).innerHTML = "";
        // location.reload(true);
    });
}


function editTeacher(id) {
    selectedRow = id;

    setSubjectsListListToModal();

    var subject = document.getElementById("subject-"+id);
    var data_toggle_attribute = document.createAttribute("data-toggle");
    var data_target_attribute = document.createAttribute("data-target");
    data_toggle_attribute.value = "modal";
    data_target_attribute.value = "#myModal2";
    subject.setAttributeNode(data_toggle_attribute);
    subject.setAttributeNode(data_target_attribute);

    var row = document.getElementById("row-"+id);
    var style_attribute = document.createAttribute("style");

    document.getElementById("name&surname-"+id).setAttribute("contenteditable", "true");
    document.getElementById("phone-"+id).setAttribute("contenteditable", "true");
    document.getElementById("email-"+id).setAttribute("contenteditable", "true");
    document.getElementById("class_name-"+id).setAttribute("contenteditable", "true");
    document.getElementById("button_edit-"+id).innerHTML = "<button class=\"btn btn-danger\" onclick=\"updateTeacher("+id+")\">Atnaujinti</button>";
}

function setSubjectsListListToModal() {
    $.get("/getSubjectsListList",
        function(data) {
            for(i = 0; i <= data.length; i++) {
                document.getElementById("change_subject_modal").innerHTML += "<div class=\"checkbox\">\n" +
                    "                    <label><input class=\"messageCheckbox\" type=\"checkbox\" value=\""+data[i].name+"\" id=\"subject_list_checkbox_option-"+i+"\">" + data[i].name + "</label>\n" +
                    "                </div>"
            }
        });
}


function updateTeacher(id) {
    selectedRow = null;

    document.getElementById("change_subject_modal").innerHTML = "";

    var subject = document.getElementById("subject-"+id);
    subject.removeAttribute("data-toggle");
    subject.removeAttribute("data-target");

    document.getElementById("name&surname-"+id).setAttribute("contenteditable", "false");
    document.getElementById("phone-"+id).setAttribute("contenteditable", "false");
    document.getElementById("email-"+id).setAttribute("contenteditable", "false");
    document.getElementById("class_name-"+id).setAttribute("contenteditable", "false");
    document.getElementById("button_edit-"+id).innerHTML = "<button class=\"btn btn-success\" onclick=\"editTeacher("+id+")\">Redaguoti</button>";

    var nameAndSurname = document.getElementById("name&surname-"+id).innerHTML;
    var nameAndSurnameArray = nameAndSurname.split(" ");
    var surname = nameAndSurnameArray[0];
    var name = nameAndSurnameArray[1];

    var phone = document.getElementById("phone-"+id).innerHTML;
    var email = document.getElementById("email-"+id).innerHTML;
    var className = document.getElementById("class_name-"+id).innerHTML;
    var subject = document.getElementById("subject-"+id).innerHTML;
    alert(subject);
    var subjectList = subject.split(" ");
    // alert(subjectList);


    $.post("/updateTeacher?id="+id+"&name="+name+"&surname="+surname+"&telephone="+phone+"&email="+email+"&class_name="+className+"&subjectlist="+subject,
        function(data) {
        });
}


function deleteSubjectsList(id) {
    $.post("/deleteSubjectsList?id="+id,
        function(data) {
            document.getElementById("subject-row-"+id).innerHTML = "";
        });
}


function refreshSubjectList() {
    document.getElementById("select_subject_list").innerHTML = "";
    $.get("/getSubjectsListList",
        function(data) {
            for(i = 0; i <= data.length; i++) {
                document.getElementById("select_subject_list").innerHTML += "<option value=\""+data[i].name+"\">"+data[i].name+"</option>\n"
            }
        });
}

function refreshSubjectNames() {
    var checkedValue = [];
    var inputElements = document.getElementsByClassName('messageCheckbox');
    for(var i=0; inputElements[i]; ++i){
        if(inputElements[i].checked){
            checkedValue.push(inputElements[i].value);
        }
    }

    var subjects = "";
    for(i = 0; i < checkedValue.length; i++){
        subjects += checkedValue[i] + " ";
    }

    document.getElementById("subject-"+selectedRow).innerHTML = subjects;
}