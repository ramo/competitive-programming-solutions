#!/bin/python3

"""
https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
"""

import math
import os
import random
import re
import sys

# Complete the minimumSwaps function below.
def minimumSwaps(arr):
    n = len(arr)
    sorted_arr = sorted(arr)
    pos = {}
    for i in range(n):
        pos[sorted_arr[i]] = i
    
    i = 0
    swaps = 0
    while i < n:
        j = pos[arr[i]]
        if i == j:
            i += 1
            continue
        else:
            arr[i], arr[j] = arr[j], arr[i]
            swaps += 1
    return swaps
    
        

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')
    n = int(input())
    arr = list(map(int, input().rstrip().split()))
    res = minimumSwaps(arr)
    fptr.write(str(res) + '\n')
    fptr.close()
