/**
 * Created by tsv on 15.03.15.
 */
function loginCheck(){
    document.getElementById('passwordInfo').innerHTML = '';
    document.getElementById('loginInfo').innerHTML = '';
    var login = document.getElementById('login').value;
    var passwd = document.getElementById('password').value;
    if(login == ''){
        document.getElementById('loginInfo').innerHTML = 'login check failed';
        return false;
    }
    if(passwd == ''){
        document.getElementById('passwordInfo').innerHTML = 'password check failed';
        return false;
    }
}