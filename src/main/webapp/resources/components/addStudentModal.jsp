<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Trigger the modal with a button -->
<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal3">Naujas studentas</button>
<!-- Modal -->
<div class="modal fade" id="myModal3" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h2>Naujas studentas</h2>
            </div>
            <div class="modal-body">
                <form method="post" action="/addStudent">
                    <div class="form-group">
                        <input type="text" placeholder="Vardas" value="Jonas1" class="form-control" name="name">
                        <input type="text" placeholder="Pavardė" value="surname11" class="form-control" name="surname">
                        <input type="text" placeholder="Tėvų informacija" value="parent info1" class="form-control" name="parent_address">
                        <input type="text" placeholder="Klasė" value="2D" class="form-control" name="class_name">
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