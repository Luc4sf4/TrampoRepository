		jQuery(document).ready(function() {

			$.ajax({
				method :"GET",
				url : "http://localhost:8081/api/parametros/id",
				data : "id=" + 3,
				success : function(response) {
					$("#id").val(response.id);
					$('#siteTitle').text(response.sitetitle);
					$('#subTitle').text(response.subtitle1);
					$('#Txt').text(response.txt1);
					$('#album_title').text(response.title_album);
					$('#video_title').text(response.title_video);
					
				}

			}).fail(function(xhr, status, errorThrown) {
				alert("Erro ao Buscar Usuario por id: " + xhr.reponseText);

			})
		});
	