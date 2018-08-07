/**
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/holiday-season-ab957deb/
 */
"use strict"
    
function main(args) {
    var n = parseInt(args[0]);
    var str = args[1];
    var ans = 0;
    //brute force solution O(N^4), TLE solution
    // for (let a = 0; a < n; a++) {
    //     for (let b = a+1; b < n; b++) {
    //         for (let c = b+1; c < n; c++) {
    //             for (let d = c+1; d < n; d++) {
    //                 if (str.charAt(a) === str.charAt(c) && str.charAt(b) === str.charAt(d)) {
    //                     ++ans;
    //                 }
    //             }
    //         }
    //     }
    // }
    
    /**
     * Going for O(N^2) solution
     */
    var lookup = [];
    for (let i = 0; i < 26; i++) {
        lookup[i] = 0;
    }
    
    var cnt = 0;
    for (let b = 0; b < n; b++) {
        cnt = 0;
        for (let d = b+1; d < n; d++) {
            if (str[b] === str[d]) {
                ans += cnt;
            }
            cnt += lookup[str[d].charCodeAt(0) - 97];
        }
        ++lookup[str[b].charCodeAt(0) - 97];
    }
    console.log(ans);
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