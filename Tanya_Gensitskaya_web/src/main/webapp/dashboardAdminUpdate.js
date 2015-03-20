function readOperator(){
    var id = document.getElementById('operator_id').value;

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            var tableColumnName = ["OPERATOR_ID", "LOGIN", "PASSWORD", "CONF_PASSWORD", "ID_NUM", "IS_BLOCKED", "IS_ADMINISTRATOR"];
            var responseServlet = xhttp.responseText;
            var arr = responseServlet.split(' +');

            var tableColumn = 7;
            var tableRow = (arr.length - 1) / tableColumn;

            // Обьявление пустого двухмерного массива
            var table = new Array(tableRow);
            for (var i = 0; i < table.length; i++) {
                table[i] = new Array(tableColumn);
            }

            // Инициализация двухмерного массива
            var k = 0;
            for (var i = 0; i < table.length; i++) {
                for (var j = 0; j < table[i].length; j++) {
                    table[i][j] = arr[k];
                    k++;
                }
            }

            // Создание таблицы и добавление элем. из двухм.массива в таблицу
            var body = document.getElementsByTagName("body")[0];// get the reference for the body
            var tbl = document.createElement("table");          // creates a <table> element and a <tbody> element

            for (var i = 0; i < tableRow; i++) {
                if (i == 0) {
                    var row = document.createElement("tr");
                    for (var k = 0; k < tableColumnName.length; k++) {
                        var temp = tableColumnName[k];
                        var column = document.createElement("td");
                        column.style.background = "rgb(200,1,0)";
                        var columnText = document.createTextNode(temp);
                        column.appendChild(columnText);
                        row.appendChild(column);
                    }
                    tbl.appendChild(row);
                }
                var row = document.createElement("tr"); // creates a table row
                for (var j = 0; j < tableColumn; j++) {         // Create a <td> element and a text node
                    var temp = table[i][j];
                    var column = document.createElement("td");
                    var columnText = document.createTextNode(temp);
                    column.appendChild(columnText);
                    row.appendChild(column);                    //and put the <td> at the end of the table row
                }                                               // add the row to the end of the table body
                tbl.appendChild(row);
            }
            body.appendChild(tbl);
            // sets the border attribute of tbl to 2;
            tbl.setAttribute("border", "5");
        }

    }
    xhttp.open('GET', '/ajaxAdminFindOperator?id='+id, true);
    xhttp.send();
}

function updateOperator(){
    var id = document.getElementById('operator_id').value;
    var login = document.getElementById('login').value;
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('conf_password').value;
    var idNumber = document.getElementById('id_num').value;
    var isBlocked = document.getElementById('is_blocked').value;
    var isAdministrator = document.getElementById('is_administrator').value;

        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState == 4 && xhttp.status == 200) {
                    document.getElementById('updateOutput').innerHTML = xhttp.responseText;
            }
        }
        xhttp.open('GET', '/ajaxAdminUpdateOperator?id='+id+'&login='+login+'&password='+password+'&confirmPassword='+confirmPassword+'&idNumber='+idNumber+'&isBlocked='+isBlocked+'&isAdministrator='+isAdministrator, true);
        xhttp.send();

}


function backToMainMenu(){
    window.location.href = "dashboardAdmin.jsp";
}