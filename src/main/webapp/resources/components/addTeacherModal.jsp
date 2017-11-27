<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Trigger the modal with a button -->
<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" onclick="refreshSubjectList()">Naujas mokytojas</button>
    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h2>Naujas mokytojas</h2>
                </div>
                <div class="modal-body">

                    <form method="post" action="/addTeacher">
                        <div class="form-group">
                            <input type="text" placeholder="Name" value="Jonas" class="form-control" name="name">
                            <input type="text" placeholder="Surname" value="surname1" class="form-control" name="surname">
                            <input type="text" placeholder="Phone" value="4684734354" class="form-control" name="telephone">
                            <input type="text" placeholder="Email" value="fh45gh4354d" class="form-control" name="email">
                            <input type="text" placeholder="Class name" value="12A" class="form-control" name="class_name">
                            <select class="custom-select" name="subject" id="select_subject_list">
                                <%--<option value="Lietuvių kalba">Lietuvių kalba</option>--%>
                                <%--<option value="Matematika">Matematika</option>--%>
                                <%--<option value="Istorija">Istorija</option>--%>
                                <%--<option value="Fizika">Fizika</option>--%>
                                <%--<option value="Geografija">Geografija</option>--%>
                            </select>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary">Įrašyti</button>
                                <button type="button" class="btn btn-primary" data-dismiss="modal">Atšaukti</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>


