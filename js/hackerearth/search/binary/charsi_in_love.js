/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/charsi-in-love/
 */
"use strict"

function f(x) {
    return (x * (x+1)) / 2;
}

function binary_search(s, e, key) {
    let result = false;
    while (s <= e) {
        let mid = s + Math.floor((e - s) / 2);
        let fn = f(mid);
        if (fn == key) {
            result = true;
            break;
        } else if (fn > key) {
            e = mid - 1;
        } else {
            s = mid + 1;
        }
    }
    return result;
}

function main(args) {
    const n = parseInt(args[0]);
    const lt = 2 * Math.floor(Math.sqrt(n));

    var found = false;
    for (let i = 1; i <= lt; i++) {
        if (binary_search(1, lt, n - f(i))) {
            found = true;
            break;
        }
    }

    console.log(found ? "YES" : "NO");
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