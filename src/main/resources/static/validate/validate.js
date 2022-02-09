$(document).ready(function(){
	$("#form-login").validate({
		rule: {
			username: {
				required: true,
			},
			password: {
				required: true,
			}
		},
		messages: {
			username: {
				required: "please enter user name",
				maxlength: "user name should not be more than 28 characters"
			},
			password: {
				required: "Please enter password",
				maxlength: "Password should not be more than 28 characters"
			}
		},
	});
})