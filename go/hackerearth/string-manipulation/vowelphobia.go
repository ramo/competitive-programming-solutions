// https://www.hackerearth.com/practice/algorithms/string-algorithm/basics-of-string-manipulation/practice-problems/algorithm/vowels/

package main

import "fmt"

func main() {
    var t int
    fmt.Scanln(&t)
    for t > 0 {
        var s string
        fmt.Scanln(&s)
        cnt := 0
        for i := 0; i < len(s); i++ {
            if s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' {
                cnt++
            }
        }
        fmt.Println(cnt)
        t--
    }
}
