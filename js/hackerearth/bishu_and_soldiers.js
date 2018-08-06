/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/bishu-and-soldiers/
 * Yet to be done.
 */
"use strict"

function binarySearch(arr, key) {
    let s = 0;
    let e = arr.length-1;
    let ans = -1;
    while (s <= e) {
        let mid = s + Math.floor((e - s) / 2);
        if (arr[mid] == key) {
            ans = mid;
            break;
        } else if (arr[mid] < key) {
            ans = mid;
            s = mid+1;
        } else {
            e = mid-1;
        }
    }
    return ans;
}

function main(args) {
    args = args.map(x => parseInt(x));
    var n = args.shift();
    var soldiers = args.splice(0, n);
    soldiers.sort((a, b) => a - b);
    var powers = [soldiers[0]];
    for (let i = 1; i < n; i++) {
        powers[i] = powers[i-1] + soldiers[i];
    }
    var q = parseInt(args.shift());
    while (q--) {
        let m = parseInt(args.shift());
        let ans = binarySearch(soldiers, m);
        if (ans == -1) {
            console.log("0 0");
        } else {
            console.log(ans+1 + " " + powers[ans]);
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