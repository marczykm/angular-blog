$(document).ready(function(){
    $('#editor').wysiwyg();
    $('#editor').cleanHtml();
    $('#editor').html($('#hiddenContent').text());

    $("#createButton").click(function(){
        $('#content').val($("#editor").html());
    });

    $(".drop-area-div").dmUploader({
        url: '/admin/upload',
        onUploadSuccess: function(id, data, file){
          if (data != "NOK"){
            $.get('/admin/addPhoto?photoPath=' + data)
                .success(function(){
                    location.reload();
                });
          }
        }
    });
});