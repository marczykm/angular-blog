$(document).ready(function(){
    $('#editor').wysiwyg();

    $("#createButton").click(function(){
        var content = $("#editor").html();
        $('#content').val(content);
    })
});