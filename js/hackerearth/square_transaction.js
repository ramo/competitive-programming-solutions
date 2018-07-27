/**
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/square-transaction-20/
 */
"use strict"

function binary_search(ps, target) {
    var s = 0, e = ps.length-1;
    var result = -1;
    while (s <= e) {
        let mid = s + Math.floor((e-s) / 2);
        if (ps[mid] < target) {
            s = mid+1;
        } else { //if (ps[mid] >= target) 
            e = mid-1;
            result = mid+1;
        }
    }
    return result;
}

function main(args) {
    var n = Number(args.shift());
    var arr = args.shift().split(' ').map(Number);
    var q = Number(args.shift());
    var ps = [arr[0]];
    for (let i = 1; i < n; i++) {
        ps[i] = ps[i-1] + arr[i];
    }

    for (let i = 0; i < q; i++) {
        let t = Number(args[i]);
        /**
         * We can find the index using binary search as the ps list is 
         * increasing order (sorted).
         */
        console.log(binary_search(ps, t));
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