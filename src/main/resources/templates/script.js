$(document).ready(function() {
    $('#myButton').click(function() {
        sendRequestToServer();
    });
});

function sendRequestToServer() {
    // URL, куда будет отправлен запрос
    var url = 'http://localhost:8080/user/login';

    // Опции для запроса (например, метод, данные и т.д.)
    var options = {
        method: 'POST',  // или 'GET' в зависимости от вашего API
        headers: {
            'Content-Type': 'application/json'  // или другой тип контента
        },
        body: JSON.stringify({
            "login": "evgen1",
            "password": "123"
        })  // данные для отправки
    };

    // Отправка запроса на сервер
    fetch(url, options)
        .then(function(response) {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(function(data) {
            console.log('Ответ от сервера:', data);
            // Обработка ответа от сервера здесь
        })
        .catch(function(error) {
            console.error('There has been a problem with your fetch operation:', error);
        });
}
