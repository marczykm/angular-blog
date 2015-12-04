$(document).ready(function(){
    $('#editor').wysiwyg();
    $('#editor').cleanHtml();
    var content = $('#hiddenContent').text();
    $('#editor').html(content);

    $("#createButton").click(function(){
        var content = $("#editor").html();
        $('#content').val(content);
    })
});