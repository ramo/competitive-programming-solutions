/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/monks-encounter-with-polynomial/
 */
"use strict"

/**
 * See monk_encounter_with_polynomial.js for the binary search solution.
 * Here, we would want to solve the problem using algebra.
 */


function main(args) {
    var t = parseInt(args[0]);
    var a, b, c, k, input, d, ans;
    for (let i = 1; i <= t; i++) {
        input = args[i].split(" ");
        a = parseInt(input[0]);
        b = parseInt(input[1]);
        c = parseInt(input[2]);
        k = parseInt(input[3]);

        /**
         * ax^2 + bx + c - k = 0
         */
        c = c - k;
        d = (b * b) - (4 * a * c);
        if (d <= 0) {
            ans = 0;
        } else {
            ans = Math.ceil((Math.sqrt(d) - b) / (2 * a));
        }
        console.log(Math.max(0, ans));
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