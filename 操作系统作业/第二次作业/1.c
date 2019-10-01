#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    printf("My pid: %d\n", getpid());
    int x = 100;
    int child = fork();  // ! fork() 函数是在unistd.h 中的!
    if (child < 0) {  // fork失败
        printf("fork error !\n");
    } else if (child == 0) {  // fork成功, 子进程
        printf("child pid = %d, x = %d\n", getpid(), x);
        x--;
        printf("child pid = %d, x = %d\n", getpid(), x);
    } else {
        wait(NULL); // ! wait() 是在 <sys/wait.h> 中
        printf("parent pid = %d, x = %d\n", getpid(), x);
        x += 3;
        printf("parent pid = %d, x = %d\n", getpid(), x);
    }
}