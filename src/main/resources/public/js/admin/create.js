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
            console.log(id);
//            $('#uploadsList').val($('#uploadsList').val() + data + ",");
            $.get('/admin/addPhoto/' + data);
          }
        }
    });
});