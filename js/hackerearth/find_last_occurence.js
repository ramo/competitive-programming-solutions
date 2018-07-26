/**
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/tutorial/
 * Sample program to find the last occurrence of a given number in an array.
 */
process.stdin.resume();
process.stdin.setEncoding("utf-8");
var stdin_input = "";

process.stdin.on("data", function (input) {
    stdin_input += input;      
});                         

process.stdin.on("end", function () {
   main(stdin_input);
});

function convertInt(ns) {
    return parseInt(ns, 10);
}

function main(input) {
    var lines = input.split("\n");
    var s = lines[0].split(" ");
    var n = convertInt(s.shift());
    var m = convertInt(s.shift());
    var arr = lines[1].split(" ").map(convertInt);

    var ans = -1;
    for (var i=n-1; i>=0; i--) {
        if (arr[i] == m) {
            ans = i+1;
            break;
        }
    }  
    process.stdout.write("" + ans);
}