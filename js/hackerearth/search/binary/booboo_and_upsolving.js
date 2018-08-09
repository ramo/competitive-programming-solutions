/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/booboo-and-upsolving-circuits/
 */
"use strict"

function get_days(arr, t) {
    let days = 0;
    let bucket = 0;
    let i = 0;
    let n = arr.length;
    while (i < n) {
        if (bucket + arr[i] <= t) {
            bucket += arr[i];
            i++;
        } else {
            bucket = 0;
            ++days;
        }
    }

    if (bucket !== 0) {
        ++days;
    }

    return days;
}

function main(args) {
    var n = parseInt(args[0].split(" ")[0]);
    var m = parseInt(args[0].split(" ")[1]);
    var t_arr = args[1].split(" ").map(x => parseInt(x));
    var s = Math.max.apply(Math, t_arr);
    var e = t_arr.reduce((x, y) => x + y, 0);

    while (s <= e) {
        let mid = s + Math.floor((e - s) / 2);
        let days = get_days(t_arr, mid);
        if (days <= m) {
            e = mid - 1;
        } else {
            s = mid + 1;
        }
    }
    console.log(s);
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