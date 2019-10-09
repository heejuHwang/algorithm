"""
A : N*N크기의 배열 (배열의 방 번호는 1부터 시작) 
A[i][j] = i*j

A의 원소들을 일차원 배열 B에 넣고, (B의 크기는 N*N)
B를 오름차순 정렬해서 k번째 원소를 구하려고 한다.

N이 주어졌을 때, k번째 원소를 구하는 프로그램을 작성하시오.
"""
n = int(input())
k = int(input())

#일차원 배열 b
b = [0 for _ in range(0, n*n)]
for i in range(0, n*n):
    if (i+1)%n == 0:
        b[i] = ((i+1)//n)*n
    else:
        b[i] = (((i+1)//n)+1)*((i+1)%n)

b.sort()
print(b[k-1])

#메모리 초과로 틀렸습니다