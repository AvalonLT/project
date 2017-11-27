<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal2">Open Modal</button>
<%--<td id="subject-25" data-toggle="modal" data-target="#myModal2"> Lietuvių kalba </td>--%>

<div id="myModal2" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" align="left">Mokomieji dalykai</h4>
            </div>
            <div class="modal-body" name="change_subject_modal" id="change_subject_modal">
                <%--<div class="checkbox">--%>
                    <%--<label><input type="checkbox" value="">Lietuvių kalba</label>--%>
                <%--</div>--%>
                <%--<div class="checkbox">--%>
                    <%--<label><input type="checkbox" value="">Istorija</label>--%>
                <%--</div>--%>
                <%--<div class="checkbox">--%>
                    <%--<label><input type="checkbox" value="">matematika</label>--%>
                <%--</div>--%>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-primary" data-dismiss="modal" onclick="refreshSubjectNames()">Submit</button>
                <button type="button" class="btn btn-outline-primary" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>










