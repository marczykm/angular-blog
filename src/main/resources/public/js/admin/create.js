$(document).ready(function(){
    $('#editor').wysiwyg();
    $('#editor').cleanHtml();
    var content = $('#hiddenContent').text();
    $('#editor').html(content);

    $("#createButton").click(function(){
        var content = $("#editor").html();
        $('#content').val(content);
    });

    $("#drop-area-div").dmUploader({
        url: '/admin/upload',
        onUploadSuccess: function(id, data, file){
          $('#uploadsList').val($('#uploadsList').val() + data + ",");
          console.log('Succefully upload #' + id);
          console.log('Server response was: ' + data);
        }
    });
});