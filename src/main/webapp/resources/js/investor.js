$(document).ready(function(){
   $("#edit").click(function(){
        editInvestor();
    });
    $("#delete").click(function(){
        if(confirm('Are you sure you want to delete this investor?')) {
            deleteInvestor();
        }
    });
    
    // validate add investor
    $("#addinvestor").validate();
    
    $("#investors").dataTable({
        "bJQueryUI": true,
        "sPaginationType": "full_numbers"
    });
});

function deleteInvestor() {
    // get the investor id
    var investorId = $("#investorid").val(),
        contextpath = $("#contextpath").val();
    
    window.location.href=contextpath+"/admin/investor/deleteinvestor/"+investorId;
}

function editInvestor() {
    var investorId = $("#investorid").val(),
        contextpath = $("#contextpath").val();

    window.location.href=contextpath+"/admin/investor/editinvestor/"+investorId;
}