$(document).ready(function(){
   $("#edit").click(function(){
        editUser();
    });
    $("#delete").click(function(){
        if(confirm('Are you sure you want to delete this user?')) {
            deleteUser();
        }
    });
    
    // validate user
    $("#adduser").validate();
    $("#edituser").validate();
    $("#resetpassword").validate();
    
    $("#users").dataTable({
        "bJQueryUI": true,
        "sPaginationType": "full_numbers"
    });
});

function deleteUser() {
    // get the user id
    var userId = $("#userid").val(),
        contextpath = $("#contextpath").val();
    
    window.location.href=contextpath+"/admin/user/deleteuser/"+userId;
}

function editUser() {
    var userId = $("#userid").val(),
        contextpath = $("#contextpath").val();

    window.location.href=contextpath+"/admin/user/edituser/"+userId;
}