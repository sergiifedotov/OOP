/**
 * Created by stan on 15.03.15.
 */
function getxmlHttpRequest(servletName,formname,responsediv,responsemsg) {
    var xmlhttp = false;
    var x = this;
    if (window.XMLHttpRequest) {
        x.xmlhttp = new XMLHttpRequest();
    }

    x.xmlhttp.open('POST', servletName, true);
    x.xmlhttp.setRequestHeader('Content-Type', 'application');
    x.xmlhttp.onreadystatechange = function() {
        if (x.xmlhttp.readyState == 4)
        {
            updatepage(x.xmlhttp.responseText,responsediv);
        }
        else
        {
            updatepage(responsemsg,responsediv);

        }
    }
    x.xmlhttp.send(getquerystring(formname));
}

function getquerystring(formname) {
    var form = document.forms[formname];
    var qstr = "";

    function GetElemValue(name, value) {
        qstr += (qstr.length > 0 ? "&" : "")
        + escape(name).replace(/\+/g, "%2B") + "="
        + escape(value ? value : "").replace(/\+/g, "%2B");
    }

    var elemArray = form.elements;
    for (var i = 0; i < elemArray.length; i++) {
        var element = elemArray[i];
        var elemType = element.type.toUpperCase();
        var elemName = element.name;
        if (elemName) {
            if (elemType == "TEXT" || elemType == "PASSWORD")
            {
                GetElemValue(elemName, element.value);
                alert("welcome");
            }
            else if (elemType.indexOf("SELECT") != -1)
                for (var j = 0; j < element.options.length; j++) {
                    var option = element.options[j];
                    if (option.selected)
                        GetElemValue(elemName,
                            option.value ? option.value : option.text);
                }
        }
    }
    return qstr;
}
function updatepage(str,responsediv){
    document.getElementById(responsediv).innerHTML = str;
}
