/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/gaurav-and-subarray-3-787fb90a/
 */
"use strict"

function onesCount(n) {
    let c = 0;
    while (n) {
        n = n & (n-1);
        ++c;
    }
    return c;
}

function check(arr, n, k, lt) {
    let result = false;
    for (let i = 0; i <= n; i++) {
        if (arr[lt + i] - arr[i] >= k) {
            result = true;
            break;
        }
    }
    return result;
}

function lower_bound(arr, n, key) {
    var s = 1;
    var e = n;
    var ans = -1;
    while (s <= e) {
        let mid = s + Math.floor((e - s) / 2);
        if (check(arr, n, key, mid)) {
            e = mid - 1;
            ans = mid;
        } else {
            s = mid + 1;
        }
    }
    return ans;
}

function main(args) {
    var next = 0;
    var q = parseInt(args[next++].split(" ")[1]);
    var arr = args[next++].split(" ").map(x => parseInt(x));
    var ba = [0];
    var n = arr.length;
    for (let i = 0; i < n; i++) {
        ba.push(onesCount(arr[i]));
    }

    var ca = [0];
    for (let i = 1; i <= n; i++) {
        ca[i] = ca[i-1] + ba[i];
    }

    while (q--) {
        let k = parseInt(args[next++]);
        console.log(lower_bound(ca, n, k));
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