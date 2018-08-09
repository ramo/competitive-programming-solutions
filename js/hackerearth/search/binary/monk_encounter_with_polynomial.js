/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/monks-encounter-with-polynomial/
 */
"use strict"

function poly(a, b, c, x) {
    // ax^2 + bx + c
    return (a * x * x) + (b * x) + c;
}

/**
 * First element not less than key is called lower bound
 */

function lower_bound(a, b, c, k) {
    let s = 0;
    let e = Math.ceil(Math.sqrt(k));
    while (s <= e) {
        let mid = s + Math.floor((e - s) / 2);
        if (poly(a, b, c, mid) >= k) {
            e = mid - 1;
        } else {
            s = mid + 1;
        }
    }
    return s;
}

function main(args) {
    var t = parseInt(args[0]);
    var a, b, c, k, input;
    for (let i = 1; i <= t; i++) {
        input = args[i].split(" ");
        a = parseInt(input[0]);
        b = parseInt(input[1]);
        c = parseInt(input[2]);
        k = parseInt(input[3]);
        console.log(lower_bound(a, b, c, k));
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