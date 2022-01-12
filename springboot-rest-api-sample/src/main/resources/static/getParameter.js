		jQuery(document).ready(function() {

			$.ajax({
				method :"GET",
				url : "http://localhost:8081/api/parametros/id",
				data : "id=" + 3,
				success : function(response) {
				console.log(response);
					$("#id").val(response.id);
					$('#siteTitle').text(response.sitetitle)       ;
					$('#subTitle').text(response.subtitle1)        ;
					$('#Txt').text(response.txt1)                  ;
					$('#album_title').text(response.title_album)   ;
					$('#video_title').text(response.title_video)   ;
					$('#parametro_145').text(response.parametro145);
					$('#parametro_152').text(response.parametro152);
					$('#parametro_190').text(response.parametro190);
					$('#parametro_547').text(response.parametro547);
					$('#parametro_567').text(response.parametro567);
					$('#parametro_765').text(response.parametro765);
					$('#parametro_786').text(response.parametro786);
					$('#parametro_789').text(response.parametro789);
					$('#parametro_899').text(response.parametro899);
					$('#parametro_988').text(response.parametro988);
				}
				
			}).fail(function(xhr, status, errorThrown) {
				alert("Erro ao Buscar Usuario por id: " + xhr.reponseText);

			})
		});
	