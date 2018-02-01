$(document).ready(
		function() {

			$("#form").submit(
					function(event) {

						event.preventDefault();

						var form = {}
						form["description"] = $("#description").val();
						form["date"] = $("#date").val();
						form["email"] = $("#email").val();

						$("#btn-save").prop("disabled", true);

						$.ajax({
							type : "POST",
							contentType : "application/json",
							url : "/api",
							data : JSON.stringify(form),
							cache : false,
							timeout : 600000,

							success : function(data) {

								var mes = "Data saved." + " The letter with"
										+ " the specified"
										+ " information will come"
										+ " to you at the"
										+ " specified email "
										+ " mail at the specified date.";
								var pos = location.toString()
										.indexOf("lang=ua");

								if (pos != -1)
									mes = "Дані збережено."
											+ " Лист з указаною"
											+ " інформацією прийде"
											+ " вам на вказану електрону"
											+ " пошту в указану дату.";

								var json = "<div class="
										+ "\"alert alert-success\">" + mes
										+ "</div>";

								$('#info-input').html(json);

								console.log("SUCCESS : ", data);
								$("#btn-save").prop("disabled", false);
								$("#form")[0].reset();
							},

							error : function(e) {

								var mes = "All fields must be filled.";
								var pos = location.toString()
										.indexOf("lang=ua");

								if (pos != -1)
									mes = "Усі поля повинні бути заповнені.";

								var json = "<div class="
										+ "\"alert alert-danger\">" + mes
										+ "</div>";

								$('#info-input').html(json);

								console.log("ERROR : ", e);
								$("#btn-save").prop("disabled", false);
							}

						});

					});
		});
