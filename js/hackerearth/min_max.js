/**
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/min-max-8/
 */
"use strict"

function main(args) {
    var n = args.shift();
    var arr = args.map(Number);
    var mx = Number.NEGATIVE_INFINITY;
    var mn = Number.POSITIVE_INFINITY;
    var s = 0;
    for (let i = 0; i < n; i++) {
        s += arr[i];
        mx = Math.max(mx, arr[i]);
        mn = Math.min(mn, arr[i]);
    }
    var max_sum = s - mn;
    var min_sum = s - mx;
    process.stdout.write(min_sum + " " + max_sum);
}

process.stdin.resume();
process.stdin.setEncoding('utf-8');
var stdin_input = "";

process.stdin.on("data", function(input) {
    stdin_input += input;
});

process.stdin.on("end", function() {
    main(stdin_input.split(/\s+/));
});