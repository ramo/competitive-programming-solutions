/**
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/the-normal-type/
 */
"use strict"

    function get_dist_ints(arr) {
        var hash = {};
        var count = 0;
        for (let i = 0; i < arr.length; i++) {
            if (!hash[arr[i]]) {
                ++count;
                hash[arr[i]] = true;
            }
        }
        return count;
    }
     
function main(args) {
        var arr = args[1].split(" ");
        var n = arr.length;
        var dist_ints = get_dist_ints(arr);
        var count = 0;
        var i = 0;
        var j = -1;
        var c_ints = 0;
        var hash = {};
     
        while (j < n) {
            if (dist_ints === c_ints) {
                count += n-j;
                hash[arr[i]] -= 1;
                if (hash[arr[i]] === 0) {
                    --c_ints;
                }
                i++;
            } else {
                j++;
                if (!hash[arr[j]])
                    ++c_ints;
                hash[arr[j]] = (hash[arr[j]] || 0) + 1;
            }
        }
     
        console.log(count);
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