<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Trigger the modal with a button -->
<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal3">Naujas dalykas</button>
<!-- Modal -->
<div class="modal fade" id="myModal3" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h2>Dalyko pavadinimas</h2>
            </div>
            <div class="modal-body">
                <form method="post" action="/addSubjectList">
                    <div class="form-group">
                        <input type="text" placeholder="Dalyko pavadinimas" value="" class="form-control" name="name">
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