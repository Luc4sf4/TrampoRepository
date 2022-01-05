
function getParameter(id) {
		$.ajax({
			method : "GET",
			url : "parametros/id",
			data : "id=" + id,
			success : function(response) {
				$("#id").val(response.id);
				$('#parametro1H').text(response.parametro1);
				$('#parametro2H').text(response.parametro2);
			}

		}).fail(function(xhr, status, errorThrown) {
			alert("Erro ao Buscar Usuário por id: " + xhr.reponseText);

		})
	}

