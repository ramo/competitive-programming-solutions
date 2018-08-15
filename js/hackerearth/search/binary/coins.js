/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/bags-of-coins-7b1d612c/
 * Time complexity: O(N) + O(Log(N)); where N is the max number in the given array.
 */
"use strict"

function main(args) {
    // Get the inputs.
    var n = parseInt(args[0]);
    var arr = args[1].split(" ").map(x => parseInt(x));
    
    //find the max number in the array to set the upper limit.
    var mx = Math.max.apply(Math, arr);
    
    // To sort the array, let prepare a count array.
    var cs = [];
    for (let i = 0; i <= mx; i++) {
        cs[i] = 0;
    }

    var valid_bags = 0;

    // Perform count sort
    for (let i = 0; i < n; i++) {
        cs[arr[i]] += 1;
        if (cs[arr[i]] === 1) {
            ++valid_bags;
        }
    }

    var result = false;

    // We need at least 2 valid bags to proceed
    if (valid_bags >= 2) {

        // Prefix sum array
        var ps = [0];
        for (let i = 1; i <= mx; i++) {
            // sum of each element is its value * occurrence of the element
            ps[i] = ps[i-1] + (i * cs[i]);

        }

        // Perform binary search to get to the optimum mid point for the group split
        var s = 1;
        var e = mx;
        while (s <= e) {
            let mid = s + Math.floor((e - s) / 2);
            /**
             * Lets check for this mid point,
             *  d = leftside sum - right side sum
             *      d is zero - We are good
             *      d is negative - move binary search to right
             *      d is positive - move binary search to left
             */
            let d = ps[mid-1] - (ps[mx] - ps[mid]);
            if (d === 0) {
                result = true;
                break;
            } else if (d < 0) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
    }
    console.log(result ? "YES" : "NO");
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