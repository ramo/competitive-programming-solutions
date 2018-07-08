"""
https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/practice-problems/algorithm/a-game-of-numbers-1-5d3a8cb3/
"""
from sys import stdin


def main():
    n = int(input())
    lines = stdin.readlines()
    arr = [int(line.strip()) for line in lines]
    max_arr = [-1] * n
    min_arr = [-1] * n

    stack = []
    for i in range(0, n):
        while stack and arr[stack[-1]] <= arr[n-i-1]:
            stack.pop()
        if stack:
            max_arr[n-i-1] = stack[-1]
        stack.append(n-i-1)

    stack = []
    for i in range(0, n):
        while stack and arr[stack[-1]] >= arr[n-i-1]:
            stack.pop()
        if stack:
            min_arr[n-i-1] = stack[-1]
        stack.append(n-i-1)

    ans = [-1] * n
    for i in range(n):
        if max_arr[i] != -1 and min_arr[max_arr[i]] != -1:
            ans[i] = arr[min_arr[max_arr[i]]]

    print(' '.join([str(x) for x in ans]))


if __name__ == '__main__':
    main()
