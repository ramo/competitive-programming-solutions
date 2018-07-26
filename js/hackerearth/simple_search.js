/**
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/simple-search-4/
 */
"use strict"

function main(args) {
    var lines = args.split("\n");
    var k = parseInt(lines[2], 10);
    var arr = lines[1].split(" ").map(Number);
    var idx = -1;
    for (let i = 0; i < arr.length; i++) {
        if (k === arr[i]) {
            idx = i;
            break;
        }
    }
    process.stdout.write("" + idx);
}

process.stdin.resume();
process.stdin.setEncoding('utf-8');
var stdin_input = "";

process.stdin.on("data", function(input) {
    stdin_input += input;
});

process.stdin.on("end", function() {
    main(stdin_input);
});