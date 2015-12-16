$(document).ready(function(){
    $('#editor').wysiwyg();
    $('#editor').cleanHtml();
    $('#editor').html($('#hiddenContent').text());

    $("#createButton").click(function(){
        $('#content').val($("#editor").html());
    });

    $("#drop-area-div").dmUploader({
        url: '/admin/upload',
        onUploadSuccess: function(id, data, file){
          if (data != "NOK"){
            $('#uploadsList').val($('#uploadsList').val() + data + ",");
          }
        }
    });
});