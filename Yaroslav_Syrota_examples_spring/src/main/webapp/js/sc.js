function showConsole(val) {
    console.log(val);
}

function sum(vector) {
    var sum = 0;
    for (var i=0; i<vector.length; i++) {
        sum = sum + vector[i];
    }
    return sum;
}