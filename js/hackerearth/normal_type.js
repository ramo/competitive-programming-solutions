/**
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/the-normal-type/
 */
"use strict"

function main(args) {
    var n = Number(args.shift());
    var arr = args[0].split(" ").map(Number);
    var uSet = new Set(arr);
    console.log(Math.pow(2, (n-uSet.size)));
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