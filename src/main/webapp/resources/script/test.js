// $("#registration_form").submit(function (event) {
//     event.preventDefault();
//     alert("forma");
//     var url = '/SPRING_SECURITY_war_exploded/registration';
//     var email = $('#email').val();
//     var username = $('#username').val();
//     var name = $('#name').val();
//     var lastName = $('#lastName').val();
//     var password = $('#password').val();
//
//
//     var user = {
//         email: email,
//         username: username,
//         name: name,
//         lastName: lastName,
//         password: password
//     };
//
//     alert(name);
//
//     $.ajax({
//         type: 'POST',
//         url: url,
//         contentType: 'application/json',
//         dataType: "json",
//         data: JSON.stringify(user),
//         async: true,
//         success: function () {
//             alert(true);
//             console.log("successfully");
//         },
//         error: function (xhr, status, error) {
//             alert(false);
//             console.log(error);
//         }
//     });
// });