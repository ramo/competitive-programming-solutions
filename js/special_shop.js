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
        let min_cost = Math.round((b * n * n * a) / (a+b))
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