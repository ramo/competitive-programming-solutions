/**
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/rest-in-peace-21-1/
 */
"use strict"

function main(args) {
    args.shift();
    for (let i = 0; i < args.length; i++) {
        let res = false;
        if (args[i].match(/21/)) {
            res = true;
        } else {
            let n = Number(args[i])
            if (n % 21 === 0) {
                res = true;
            }
        }
        if (res) {
            console.log("The streak is broken!");
        } else {
            console.log("The streak lives still in our heart!")
        }
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