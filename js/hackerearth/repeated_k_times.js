/**
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/repeated-k-times/
 */
"use strict"

function main(args) {
    var n = parseInt(args.shift());
    var arr = args.shift().split(" ").map(el => parseInt(el));
    var k = parseInt(args.shift());

    var wf = arr.reduce((acc, cv) => {
        acc[cv] = (acc[cv] || 0) + 1;
        return acc;
    }, {});

    var ql = [];
    for (let key in wf) {
        if (wf[key] === k) {
            ql.push(key);
        }
    }

    console.log(Math.min.apply(Math, ql));
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