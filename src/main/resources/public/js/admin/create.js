$(document).ready(function(){
    $('#editor').wysiwyg();

    $( "#editor" ).keypress(function() {
        var content = $("#editor").html();
        $('#content').val(content);
        console.log(content);
    });
});