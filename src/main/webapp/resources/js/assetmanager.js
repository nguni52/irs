$(document).ready(function(){
   $("#edit").click(function(){
        editAssetManager();
    });
    $("#delete").click(function(){
        if(confirm('Are you sure you want to delete this asset manager?')) {
            deleteAssetManager();
        }
    });
    
    // validate add asset manager
    $("#addassetmanager").validate();
    $("#editassetmanager").validate();
    
    
    $("#assetmanagers").dataTable({
        "bJQueryUI": true,
        "sPaginationType": "full_numbers"
    });
    
    
});

function deleteAssetManager() {
    // get the investor id
    var assetManagerId = $("#assetmanagerid").val(),
        contextpath = $("#contextpath").val();
    
    window.location.href=contextpath+"/admin/assetmanager/deleteassetmanager/"+assetManagerId;
}

function editAssetManager() {
    var assetManagerId = $("#assetmanagerid").val(),
        contextpath = $("#contextpath").val();

    window.location.href=contextpath+"/admin/assetmanager/editassetmanager/"+assetManagerId;
}