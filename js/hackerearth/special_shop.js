/**
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/special-shop-69904c91/
 */
"use strict"

function main(args) {
    var li = 0;
    var t = parseInt(args[li++]);
    while (t--) {
        let inputs = args[li++].split(" ");
        let n = parseInt(inputs[0]);
        let a = parseInt(inputs[1]);
        let b = parseInt(inputs[2]);
        let x = Math.round((b * n) / (a + b));
        let y = n - x;
        let mn = Math.min(a, b);
        let mx = Math.max(a, b);
        let min_cost = (x < y) ? ((mx * x * x) + (mn * y * y)) : ((mn * x * x) + (mx * y * y));
        console.log(min_cost);
    }

}

process.stdin.resume();
process.stdin.setEncoding('utf-8');
var stdin_input = "";

process.stdin.on("data", function(input) {
 stdin_input += input;
});

process.stdin.on("end", function() {
 main(stdin_input.split("\n"));
});