/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/the-furious-five-69521576/
 */
"use strict"

function f5(x) {
    var cnt = 0;
    while (x) {
        let tmp = Math.floor(x / 5);
        cnt += tmp;
        x = tmp;
    }
    return cnt;
}

function lower_bound(n) {
    var s = 5;
    var e = 5 * n;
    while (s <= e) {
        let mid = s + Math.floor((e - s) / 2);
        if (f5(mid) >= n) {
            e = mid - 1;
        } else {
            s = mid + 1;
        }
    }
    return s;
}

function main(args) {
    var nxt = 0;
    var t = parseInt(args[nxt++]);
    while (t--) {
        let n = parseInt(args[nxt++]);
        console.log(lower_bound(n));
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