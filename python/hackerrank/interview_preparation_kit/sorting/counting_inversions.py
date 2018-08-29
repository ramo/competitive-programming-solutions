"""
https://www.hackerrank.com/challenges/ctci-merge-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
"""
import os


# Complete the countInversions function below.
def count_inversions(arr, n):
    temp = [0] * n
    return merge_sort(arr, temp, 0, n-1)


def merge_sort(arr, temp, left, right):
    count = 0
    if right > left:
        mid = left + (right - left) // 2
        count += merge_sort(arr, temp, left, mid)
        count += merge_sort(arr, temp, mid+1, right)
        count += merge(arr, temp, left, mid, right)
    return count


def merge(arr, temp, left, mid, right):
    count = 0
    i = left
    j = mid+1
    k = left

    while i <= mid and j <= right:
        if arr[i] <= arr[j]:
            temp[k] = arr[i]
            i += 1
        else:
            temp[k] = arr[j]
            j += 1
            count += mid-i+1
        k += 1

    while i <= mid:
        temp[k] = arr[i]
        i += 1
        k += 1

    while j <= right:
        temp[k] = arr[j]
        j += 1
        k += 1

    for x in range(left, right+1):
        arr[x] = temp[x]

    return count


def main():
    t = int(input())
    results = []
    for t_itr in range(t):
        n = int(input())
        arr = list(map(int, input().rstrip().split()))
        result = count_inversions(arr, n)
        results.append(str(result))
    fptr = open(os.environ['OUTPUT_PATH'], 'w')
    fptr.write('\n'.join(results))
    fptr.close()


if __name__ == '__main__':
    main()
