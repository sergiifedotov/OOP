/**
 * Created by tsv on 15.03.15.
 */
function getXMLHttpRequest() {
    var xmlHttpReq;
    if (window.XMLHttpRequest) {
        xmlHttpReq = new XMLHttpRequest();
    }
    return xmlHttpReq;
}

function request() {
    var xmlHttpRequest = getXMLHttpRequest();
    alert ("xmlHttpRequest=" + xmlHttpRequest);
    xmlHttpRequest.onreadystatechange = getReadyStateHandler(xmlHttpRequest);
    xmlHttpRequest.open("POST", "helloWorld.do", true);
    xmlHttpRequest.setRequestHandler("Content-Type", "application/x-www-form-urlencoded");
    alert("inside request()!");
    xmlHttpRequest.send(null);
    alert("sent!");
}

function getReadyStateHandler(xmlHttpRequest) {
    // an anonynous function returned
    // it listens to the XMLHttpRequest instance
    return function() {
        if (xmlHttpRequest.readyState == 4) {
            if (xmlHttpRequest.status == 200) {
                document.getElementById("hello").innerHTML = xmlHttpRequest.responseText;
            } else {
                alert("Http error " + xmlHttpRequest.status + ":" + xmlHttpRequest.statusText);
            }
        }
    };
}