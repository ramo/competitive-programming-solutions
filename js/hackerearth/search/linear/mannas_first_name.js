/**
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/mannas-first-name-4/
 */
"use strict"

function main(args) {
    args.shift();
    for (let i = 0; i < args.length; i++) {
        let s = args[i];
        let suvojit = (s.match(/SUVOJIT/g) || []).length;
        let suvo = (s.match(/SUVO/g) || []).length;
        console.log(`SUVO = ${suvo - suvojit}, SUVOJIT = ${suvojit}`);
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