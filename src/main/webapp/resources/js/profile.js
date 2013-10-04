$(document).ready(function(){
   $("#edit").click(function(){
        editProfile();
    });
    $("#delete").click(function(){
        if(confirm('Are you sure you want to delete this user?')) {
            deleteUser();
        }
    });
});

function editProfile() {
    var userId = $("#userid").val(),
        contextpath = $("#contextpath").val();

    window.location.href=contextpath+"/admin/user/edituser/"+userId+"?profile=true";
}