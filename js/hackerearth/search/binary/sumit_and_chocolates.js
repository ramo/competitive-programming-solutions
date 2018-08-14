/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/sumit-and-chocolates/
 */
"use strict"

function lower_bound(arr, key) {
    let s = 0;
    let e = arr.length - 1;
    while (s <= e) {
        let mid = s + Math.floor((e - s) / 2);
        if (arr[mid] >= key) {
            e = mid - 1;
        } else {
            s = mid + 1;
        }
    }
    return s + 1;
}

function main(args) {
    var nxt = 0;
    var n = parseInt(args[nxt++]);
    var cis = args[nxt++].split(" ").map(x => parseInt(x));
    var prefix_sum = [cis[0]];
    for (let i = 1; i < n; i++) {
        prefix_sum[i] = prefix_sum[i-1] + cis[i];
    }

    var q = parseInt(args[nxt++]);
    var result = [];
    while (q--) {
        let i = parseInt(args[nxt++]);
        result.push(lower_bound(prefix_sum, i));
    }
    console.log(result.join("\n"));
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